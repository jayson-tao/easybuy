package com.yaorange.service;

import java.util.Map;

import com.yaorange.pojo.TPayBill;

public interface PayService {
	TPayBill queryPayBillBySn(String sn);
	TPayBill changePayBillStatus(String sn, String totalAmount, String tradeNo, Map<String, String> params);

	void changeOrderState(TPayBill payBill);

    TPayBill queryPayBillByOrderId(long orderId);
}
