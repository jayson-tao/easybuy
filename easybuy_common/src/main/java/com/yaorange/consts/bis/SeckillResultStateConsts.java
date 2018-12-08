package com.yaorange.consts.bis;

import com.yaorange.consts.ConstName;

/**
 * 支付状态
 * @author nixianhua
 * 0-待确认 1-已确认 2-已取消（过期或主动放弃）
 */
public interface SeckillResultStateConsts {
	@ConstName("待确认")
	public static byte WAIT_CONFIRM  =  0;
	@ConstName("已确认")
	public static byte CONFIRMED  =  1;
	@ConstName("已取消")
	public static byte FAIL  =  2;
}
