package com.yaorange.consts.bis;

import com.yaorange.consts.ConstName;
/**
 * 演示业务常量（文章发布状态常量）
 * 
 * 2017年2月16日
 * @author nixianhua
 */
public interface RegChannelConsts {
	@ConstName("手机")
	public static byte PHONE  =  0;
	@ConstName("邮箱")
	public static byte EMAIL = 1;
	@ConstName("三方")
	public static byte THIRD = 2;
}
