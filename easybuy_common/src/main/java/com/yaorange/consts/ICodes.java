package com.yaorange.consts;
/**
 * 
 * 通用消息状态码常量
 * 所有业务消息需继承该接口，参考SampleMsgConsts
 * 2017年2月16日
 * @author nixianhua
 */
public interface ICodes {
	@ConstName("成功")
	public static final int SUCCESS = 0;
	@ConstName("失败")
	public static final int FAILED = 1;
	@ConstName("需要登录")
	public static final int UNAUTHED = 2;
	@ConstName("非法访问")
	public static final int ILLEGAL_ACCESS = 3;
}
