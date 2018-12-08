package com.yaorange.consts.bis;

import com.yaorange.consts.ConstName;

/**
 * 用户账号安全等级
 * 
 * 2017年2月16日
 * @author nixianhua
 */
public interface AccountSecrityLevelConsts {
	@ConstName("低")
	public static byte LOWER  =  0;
	@ConstName("中")
	public static byte NORMAL = 1;
	@ConstName("高")
	public static byte HIGH = 2;
}
