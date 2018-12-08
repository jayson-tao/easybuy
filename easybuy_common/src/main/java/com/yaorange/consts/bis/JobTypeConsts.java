package com.yaorange.consts.bis;

import com.yaorange.consts.ConstName;

/**
 * 定时任务类型
 * @author nixianhua
 *
 */
public interface JobTypeConsts {
	
	@ConstName("待支付订单取消任务")
	public static byte WAIT_ORDER_PAY_CANCEL_JOB  =  0;
	@ConstName("待收货确认任务")
	public static byte WAIT_ORDER_CONFIRM_SHIP_JOB  =  1;
	
	@ConstName("秒杀活动预处理任务")
	public static byte SECKILL_PRE_JOB  =  2;
	@ConstName("秒杀活动开始任务")
	public static byte SECKILL_BEGIN_JOB  =  3;
	@ConstName("秒杀活动结束任务")
	public static byte SECKILL_END_JOB  =  4;
	@ConstName("秒杀结果确认过期处理")
	public static byte SECKILL_CONFIRM_EXPIRE_JOB  =  5;
	
	
}
