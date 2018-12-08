package com.yaorange.consts.bis;

import com.yaorange.consts.ConstName;

/**
 * 支付状态
 * @author nixianhua
 * 0-待支付 1-已支付 2-支付失败
 */
public interface PayStateConsts {
	@ConstName("待支付")
	public static byte WAIT_PAY  =  0;
	@ConstName("已支付")
	public static byte PAYED  =  1;
	@ConstName("支付失败")
	public static byte FAIL  =  2;
}
