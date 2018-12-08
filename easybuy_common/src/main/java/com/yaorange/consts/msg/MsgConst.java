package com.yaorange.consts.msg;

import com.yaorange.consts.ConstName;
import com.yaorange.consts.ICodes;
/**
 * 演示消息码常量（文章管理相关消息常量）
 * 2017年2月16日
 *
 */
public interface MsgConst extends ICodes{
	public static final int BASECODE = 20000;//基准常量码
	
	@ConstName("手机号码已被注册")
	public static final int PHONE_NUMBER_EXISTS = 0+BASECODE;
	
	@ConstName("图形验证码不正确")
	public static final int INVALIDE_CAPTCHA = 1+BASECODE;
	
	@ConstName("短信验证码不正确")
	public static final int SMS_CODE_INVALIDE = 2+BASECODE;
	
	@ConstName("短信验证码不存在或已过期")
	public static final int SMSCODE_EXPIRED = 3+BASECODE;
	
	@ConstName("未过重发时间（60s）")
	public static final int SMSCODE_ERR_FREQUNCE = 4+BASECODE;
	
	@ConstName("用户名或密码不正确")
	public static final int INVALIDE_USER_PASSWORD = 5+BASECODE;
	
	@ConstName("库存不足")
	public static final int ORDER_STOCK_NOT_ENOUGH = 6+BASECODE;
	
	@ConstName("该订单不允许删除")
	public static final int ORDER_CANCEL_FORBIDDEN = 7+BASECODE;
	
	public static final int SMS_CODE_VALID_SECONDS = 300;
	
	
	
}
