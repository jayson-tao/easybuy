package com.yaorange.consts.bis;

import com.yaorange.consts.ConstName;

/**
 * 支付单业务类型
 * @author nixianhua
 * 0-商品订单支付 1-充值订单支付 2-退货退款单支付 3-取消订单退款
 */
public interface PayBillBusinessTypeConsts {
	@ConstName("商品订单支付")
	public static byte ORDER_WAIT_PAY  =  0;
	
	@ConstName("充值订单支付 ")
	public static byte ORDER_RECHARGE  =  1;
	
	@ConstName("退货退款单支付")
	public static byte ORDER_REFUND  =  2;
	
	@ConstName("取消订单退款")
	public static byte ORDER_CANCEL  =  3;
	
}
