package com.yaorange.utils;

import java.math.BigDecimal;

import org.apache.commons.lang.StringUtils;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradeCloseRequest;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.request.AlipayTradeQueryRequest;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.alipay.api.response.AlipayTradeCloseResponse;
import com.alipay.api.response.AlipayTradeQueryResponse;
import com.alipay.api.response.AlipayTradeRefundResponse;
import com.yaorange.pojo.TPayBill;
import com.yaorange.util.GlobalSetting;

/**
 * 支付宝工具类
 */
public class AliPayUtils {
	private static AlipayClient instance = null;

	private static String gateway = "";
	private static String appId = "";
	private static String privateKey = "";
	private static String format = "json";
	private static String charset = "";
	private static String alipayPulicKey = "";
	private static String signType = "";

	/**
	 * 获取支付宝SDK API客户端
	 *
	 * @return
	 */
	public static AlipayClient getClient() {
		if (null == instance) {
			gateway = GlobalSetting.get("ALIPAY_GATEWAY");
			appId = GlobalSetting.get("ALIPAY_APPID");
			privateKey = GlobalSetting.get("ALIPAY_MY_RSA256_PRIKEY");
			charset = GlobalSetting.get("ALIPAY_CHARSET");
			alipayPulicKey = GlobalSetting.get("ALIPAY_RSA256_PUBKEY");
			signType = GlobalSetting.get("ALIPAY_SIGN_TYPE");
			instance = new DefaultAlipayClient(gateway, appId, privateKey, format, charset, alipayPulicKey, signType);
		}
		return instance;
	}

	/**
	 * 根据支付单生成支付宝支付数据网页
	 *
	 * @param payBill
	 * @return
	 */
	public static String generatePayData(TPayBill payBill) {
		String payHtmlContent = "";
		AlipayClient client = getClient();
		AlipayTradePagePayRequest tradePageRequest = new AlipayTradePagePayRequest();
		// 异步通知
		tradePageRequest.setNotifyUrl("http://jayson.tunnel.qydev.com/alipayNotify");
		// 同步通知
		tradePageRequest.setReturnUrl("http://127.0.0.1:8080/payResult?sn="+ payBill.getUnionPaySn());
		try {
			// 商户订单号，商户网站订单系统中唯一订单号，必填
			String out_trade_no = payBill.getUnionPaySn();
			// 付款金额，必填
			String total_amount = ((payBill.getMoney() * 0.01) + "");
			// 订单名称，必填
			String subject = "易购网商品订单支付";
			// 商品描述，可空
			String body = payBill.getNote();

			tradePageRequest.setBizContent("{\"out_trade_no\":\"" + out_trade_no + "\"," + "\"total_amount\":\"" + total_amount + "\"," + "\"subject\":\"" + subject + "\"," + "\"body\":\"" + body
					+ "\"," + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
			// 请求
			payHtmlContent = client.pageExecute(tradePageRequest).getBody();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return payHtmlContent;
	}

	/**
	 * 验证通知参数是否和发起通知的部分参数匹配
	 *
	 * @param appId
	 * @return
	 */
	public static boolean validateNotifyParams(String appId) {

		return GlobalSetting.get("ALIPAY_APPID").equals(appId);
	}

	/**
	 * 主动查询支付宝支付单交易是否支付
	 *
	 * @return
	 */
	public static AlipayTradeQueryResponse queryAlipayResult(String unionPaySn) {
		try {
			// 获得初始化的AlipayClient
			AlipayClient alipayClient = getClient();

			// 设置请求参数
			AlipayTradeQueryRequest alipayRequest = new AlipayTradeQueryRequest();

			// 商户订单号，商户网站订单系统中唯一订单号
			String out_trade_no = unionPaySn;

			alipayRequest.setBizContent("{\"out_trade_no\":\"" + out_trade_no + "\"}");
			// 请求
			AlipayTradeQueryResponse response = alipayClient.execute(alipayRequest);
			if (response.isSuccess() && (response.getTradeStatus().equals("TRADE_SUCCESS") || response.getTradeStatus().equals("TRADE_FINISHED"))) {
				return response;
			}
		} catch (Exception e) {
		}
		return null;
	}

	/**
	 * 关闭交易
	 *
	 * @param unionPaySn
	 *            原支付单号
	 * @return
	 */
	public static boolean closeTrade(String unionPaySn) {
		// 获得初始化的AlipayClient
		AlipayClient alipayClient = getClient();
		try {
			// 设置请求参数
			AlipayTradeCloseRequest alipayRequest = new AlipayTradeCloseRequest();
			// 商户订单号，商户网站订单系统中唯一订单号
			String out_trade_no = unionPaySn;
			alipayRequest.setBizContent("{\"out_trade_no\":\"" + out_trade_no + "\"}");
			AlipayTradeCloseResponse response = alipayClient.execute(alipayRequest);
			System.out.println("response.isSuccess()=" + response.isSuccess());
			System.out.println("response.getOutTradeNo()=" + response.getOutTradeNo());
			System.out.println("unionPaySn=" + unionPaySn);
			if (response.isSuccess() && response.getOutTradeNo().equals(unionPaySn)) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 退款
	 *
	 * @param unionPaySn
	 *            原支付单号 必须
	 * @param refundMoney
	 *            退款金额 必 须
	 *            退款原因 可选
	 * @param refundBatchNo
	 *            如果多次退款，需要批次退款标识号 可选
	 */
	public static boolean refund(String unionPaySn, Integer refundMoney, String refundReason, String refundBatchNo) {
		// 获得初始化的AlipayClient
		AlipayClient alipayClient = getClient();

		// 设置请求参数
		AlipayTradeRefundRequest alipayRequest = new AlipayTradeRefundRequest();

		// 商户订单号，商户网站订单系统中唯一订单号
		String out_trade_no = unionPaySn;

		// 支付宝订单号
		String trade_no = "";

		// 需要退款的金额，该金额不能大于订单金额，必填
		String refund_amount = (refundMoney * 0.01) + "";
		// 退款的原因说明
		String refund_reason = refundReason;
		if (StringUtils.isBlank(refund_reason)) {
			refund_reason = "正常退款";
		}

		// 标识一次退款请求，同一笔交易多次退款需要保证唯一，如需部分退款，则此参数必传
		String out_request_no = refundBatchNo;
		if (StringUtils.isBlank(out_request_no)) {
			out_request_no = unionPaySn;
		}

		alipayRequest.setBizContent("{\"out_trade_no\":\"" + out_trade_no + "\"," + "\"trade_no\":\"" + trade_no + "\"," + "\"refund_amount\":\"" + refund_amount + "\"," + "\"refund_reason\":\""
				+ refund_reason + "\"," + "\"out_request_no\":\"" + out_request_no + "\"}");

		// 请求
		try {
			AlipayTradeRefundResponse response = alipayClient.execute(alipayRequest);
			System.out.println(response);

			if (response.isSuccess() && refundMoney == new BigDecimal(response.getRefundFee()).multiply(BigDecimal.valueOf(100L)).intValue()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
