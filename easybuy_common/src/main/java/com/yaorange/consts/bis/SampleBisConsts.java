package com.yaorange.consts.bis;

import com.yaorange.consts.ConstName;
/**
 * 演示业务常量（文章发布状态常量）
 * 
 * 2017年2月16日
 * @author nixianhua
 */
public interface SampleBisConsts {
	@ConstName("已发布")
	public static byte PUBLISHED  =  0;
	@ConstName("未发布")
	public static byte NOT_PUBLISHED = 1;
	@ConstName("待发布")
	public static byte WAIT_PUBLISHED = 2;
}
