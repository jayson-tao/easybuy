package com.yaorange.consts.bis;

import com.yaorange.consts.ConstName;

/**
 * 账户流水类型
 * @author nixianhua
 * 0-支出 1-收入
 */
public interface AccountFlowConsts {
	@ConstName("支出")
	public static byte OUTCOME  =  0;
	@ConstName("收入")
	public static byte INCOME = 1;
}
