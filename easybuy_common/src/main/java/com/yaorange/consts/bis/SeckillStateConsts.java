package com.yaorange.consts.bis;

import com.yaorange.consts.ConstName;

/**
 * 抢购活动状态
 * @author nixianhua
 * 0-待发布 1-待启动 2-进行中 3-已结束
 */
public interface SeckillStateConsts {
	@ConstName("待发布")
	public static byte WAIT_PUBLSH  =  0;
	@ConstName("待启动")
	public static byte WAIT_BEGIN = 1;
	@ConstName("进行中")
	public static byte DOING = 2;
	@ConstName("已结束")
	public static byte END = 3;
}
