package com.yaorange.controller;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.response.AlipayTradeQueryResponse;
import com.yaorange.consts.ICodes;
import com.yaorange.consts.bis.PayChannelConsts;
import com.yaorange.consts.bis.PayStateConsts;
import com.yaorange.exception.BisException;
import com.yaorange.pojo.TPayBill;
import com.yaorange.service.PayService;
import com.yaorange.util.GlobalSetting;
import com.yaorange.utils.AliPayUtils;

@Controller
public class PayController {
    @Autowired
    private PayService payService;

    @RequestMapping("/gateway")
    public String gateway(String sn, Model model) {
        //根据支付单号去查询支付单信息
        TPayBill payBill = payService.queryPayBillBySn(sn);
        // 支付方式
        byte payChannel = payBill.getPayChannel();
        String payChannelView = "";
        switch (payChannel) {
            //支付宝
            case PayChannelConsts.ALIPAY:
                payChannelView = "alipay";
                String htmlData = AliPayUtils.generatePayData(payBill);
                model.addAttribute("data", htmlData);
                break;
            case PayChannelConsts.WECHAT:
                break;
            case PayChannelConsts.ACCOUNT:
                break;
            case PayChannelConsts.UNION:
                break;
            default:
                throw BisException.me().setCode(ICodes.ILLEGAL_ACCESS);
        }
        return "gateway/" + payChannelView;
    }

    /**
     * 用户付款后同步通知 --》修改支付单状态 --修改订单状态
     * 同步通知
     *
     * @param sn 支付单号
     */
    @RequestMapping("/payResult")
    public String payResult(String sn, Model model) {
        TPayBill payBill = payService.queryPayBillBySn(sn);
        //判断该支付单是不是未支付 -》0
        if (payBill.getState() == PayStateConsts.WAIT_PAY) {
            //去支付宝查询支付的结果
            AlipayTradeQueryResponse response = AliPayUtils.queryAlipayResult(sn);
            // 付款的钱
            String totalAmount = response.getTotalAmount();
            // 流水号
            String tradeNo = response.getTradeNo();
            Map<String, String> params = response.getParams();
            // 修改支付单的状态 还有记录一些信息
            payBill = payService.changePayBillStatus(sn, totalAmount, tradeNo, params);
            if (payBill.getState() == PayStateConsts.PAYED) {
                payService.changeOrderState(payBill);
            }
        }
        model.addAttribute("payBill", payBill);
        return "payResult";
    }

    /**
     * 异步通知
     */
    @RequestMapping("/alipayNotify")
    public String notifyUrl(HttpServletRequest request, HttpServletResponse response) {
        try {
            PrintWriter out = response.getWriter();
            // 获取支付宝POST过来反馈信息
            Map<String, String> params = new HashMap<String, String>();
            Map<String, String[]> requestParams = request.getParameterMap();
            for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
                String name = iter.next();
                String[] values = requestParams.get(name);
                String valueStr = "";
                for (int i = 0; i < values.length; i++) {
                    valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
                }
                // 乱码解决，这段代码在出现乱码时使用
                // valueStr = new String(valueStr.getBytes("ISO-8859-1"),
                // "utf-8");
                params.put(name, valueStr);
            }

            String aliPubKey = GlobalSetting.get("ALIPAY_RSA256_PUBKEY");
            String charset = GlobalSetting.get("ALIPAY_CHARSET");
            String signType = GlobalSetting.get("ALIPAY_SIGN_TYPE");
            // 验证签名
            boolean signVerified = AlipaySignature.rsaCheckV1(params, aliPubKey, charset, signType);

            // ——请在这里编写您的程序（以下代码仅作参考）——

            /*
             * 实际验证过程建议商户务必添加以下校验： 1、需要验证该通知数据中的out_trade_no是否为商户系统中创建的订单号，
             * 2、判断total_amount是否确实为该订单的实际金额（即商户订单创建时的金额），
             * 3、校验通知中的seller_id（或者seller_email)
             * 是否为out_trade_no这笔单据的对应的操作方（有的时候，一个商户可能有多个seller_id/seller_email）
             * 4、验证app_id是否为该商户本身。
             */
            // AppID
            String appId = request.getParameter("app_id");
            if (AliPayUtils.validateNotifyParams(appId)) {
                if (signVerified) {// 验证成功
                    // 支付单号
                    String out_trade_no = request.getParameter("out_trade_no");
                    // 支付宝交易号
                    String trade_no = request.getParameter("trade_no");
                    // 交易状态
                    String trade_status = request.getParameter("trade_status");
                    // 交易金额
                    String total_amount = request.getParameter("total_amount");

                    if (trade_status.equals("TRADE_FINISHED")) {
                        out.println("success");
                    } else if (trade_status.equals("TRADE_SUCCESS")) {
                        //网站需要记录的信息
                        payService.changePayBillStatus(out_trade_no, total_amount, trade_no, request.getParameterMap());
                        out.println("success");
                    }
                } else {// 验证失败
                    out.println("fail");
                    // 调试用，写文本函数记录程序运行情况是否正常
                    // String sWord =
                    // AlipaySignature.getSignCheckContentV1(params);
                    // AlipayConfig.logResult(sWord);
                }
            }

            out.println("fail");
            // ——请在这里编写您的程序（以上代码仅作参考）——

        } catch (Exception e) {
            // TODO: handle exception
        }
        return null;
    }

}
