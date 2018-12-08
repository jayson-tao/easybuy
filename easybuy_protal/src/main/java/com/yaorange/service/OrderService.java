package com.yaorange.service;

import java.util.Map;

import org.springframework.ui.Model;

import com.yaorange.pojo.TOrder;
import com.yaorange.pojo.TPayBill;
import com.yaorange.util.Ret;

public interface OrderService {

	void orderConfirm(Model model);

	Ret createOrder(TOrder formOrder, long addressId);

	TPayBill createPayBillOrder(TOrder order);
	void savePayInteraction(TPayBill payBill);
	Map<String, Integer> allKindsOfNum(long ssoId);

	Ret cancel(long orderId);


}
