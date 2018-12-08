package com.yaorange.consts.bis;

import com.yaorange.consts.ConstName;

/**
 * 订单状态
 * @author nixianhua
 * 0-待付款 1-待发货 2-待收货 3-已完成 4-取消申请 5-交易关闭 9-删除
 */
public interface OrderStateConsts {
	@ConstName("待付款")
	public static byte WAIT_PAY  =  0;
	
	@ConstName("待发货")
	public static byte WAIT_SHIP_SEND  =  1;
	
	@ConstName("待收货")
	public static byte WAIT_SHIP_TAKE  =  2;
	
	@ConstName("已完成")
	public static byte FINISHED  =  3;
	
	@ConstName("取消申请")
	public static byte CANCEL_APPLY  =  4;
	
	@ConstName("交易关闭")
	public static byte CLOSED  =  5;
	
	@ConstName("删除")
	public static byte DELETED  =  9;
	
}
