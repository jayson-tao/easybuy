package com.yaorange.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yaorange.mapper.TVipAddressMapper;
import com.yaorange.pojo.TOrder;
import com.yaorange.pojo.TPayBill;
import com.yaorange.pojo.TVipAddress;
import com.yaorange.pojo.TVipAddressExample;
import com.yaorange.pojo.TVipAddressExample.Criteria;
import com.yaorange.service.OrderService;
import com.yaorange.util.Ret;
import com.yaorange.utils.SsoContext;

/**
 * 订单控制器
 */
@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private TVipAddressMapper addressMapper;
    @Value("${URL_PAY}")
    private String URL_PAY; //域名
    @Value("${URL_PAY_GATEWAY}")
    private String URL_PAY_GATEWAY; //请求的接口


    /**
     * 确定订单页面
     *
     * @param model
     * @return
     */
    @RequestMapping("/confirm")
    public String confirm(Model model) {
        TVipAddressExample example = new TVipAddressExample();
        Criteria criteria = example.createCriteria();
        criteria.andSsoIdEqualTo(SsoContext.getSsoId());
        //查询当前用户的地址
        List<TVipAddress> addresses = addressMapper.selectByExample(example);
        model.addAttribute("addrList", addresses);
        //商品清单
        orderService.orderConfirm(model);
        return "order.confirm";
    }

    /**
     * 确认交易
     *
     * @param formOrder
     * @param addressId 收货地址id
     * @return
     */
    @RequestMapping("/submit")
    @ResponseBody
    public Ret submit(TOrder formOrder, long addressId) {
        //创建订单
        Ret ret = orderService.createOrder(formOrder, addressId);
        if (!ret.isSuccess()) {
            return ret;
        }
        //创建支付单
        TOrder order = (TOrder) ret.getData();
        TPayBill payBill = orderService.createPayBillOrder(order);
        /**
         * 跳转支付宝 返回url给前端 前端重定向到支付页面
         */
        //获取支付打单号
        String paySn = payBill.getUnionPaySn();
        String payUrl = URL_PAY + URL_PAY_GATEWAY + "?sn=" + paySn;
        return Ret.me().setData(payUrl);

    }

    @RequestMapping("/cancel")
    @ResponseBody
    public Ret cancelOrder(Long orderId){
        Ret ret = orderService.cancel(orderId);
        return ret;
    }
}
