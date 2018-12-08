package com.yaorange.consts.bis;

import com.yaorange.consts.ConstName;

/**
 * 接口通知状态
 * @author nixianhua
 * 0-等待通知 1-已通知
 */
public interface PayInteractionStateConsts {
	@ConstName("等待通知")
	public static byte WAIT  =  0;
	@ConstName("已通知")
	public static byte NOTIFIED = 1;
}
