package com.yaorange.consts.bis;

import com.yaorange.consts.ConstName;
/**
 * 输入类型
 * @author nixianhua
 *
 */
public interface PropertyInputTypeConsts {
	@ConstName("文本")
	public static byte PROPERTY_INPUTTYPE_TEXT  =  0;
	@ConstName("数字")
	public static byte PROPERTY_INPUTTYPE_NUMBER = 1;
	@ConstName("日期")
	public static byte PROPERTY_INPUTTYPE_DATE = 2;
}
