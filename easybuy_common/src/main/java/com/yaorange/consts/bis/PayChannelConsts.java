package com.yaorange.consts.bis;

import com.yaorange.consts.ConstName;

/**
 * 支付渠道
 * @author nixianhua
 * 支付方式：0-账户余额 1-支付宝 2-微信 3-银联在线
 */
public interface PayChannelConsts {
	@ConstName("账户余额")
	public static byte ACCOUNT  =  0;
	@ConstName("支付宝")
	public static byte ALIPAY  =  1;
	@ConstName("微信")
	public static byte WECHAT  =  2;
	@ConstName("银联在线")
	public static byte UNION  =  3;
}
