package com.yaorange.util;

import java.util.Random;

public class StrUtils {
	public static Long[] splitToLong(String str) {
		return splitToLong(str, ",");
	}

	public static Long[] splitToLong(String str, String separator) {
		if (null == str || "".equals(str))
			return null;
		String[] strArr = str.split(separator);
		Long[] longArr = new Long[strArr.length];
		for (int i = 0; i < strArr.length; i++) {
			longArr[i] = Long.parseLong(strArr[i]);
		}
		return longArr;
	}

	public static String getRandomString(int length) {
		String str = "0123456789";
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int number = random.nextInt(10);
			sb.append(str.charAt(number));
		}
		return sb.toString();

	}

	public static String getComplexRandomString(int length) {
		String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int number = random.nextInt(62);
			sb.append(str.charAt(number));
		}
		return sb.toString();
	}
	
	public static String changePropertyStyle(String properties){
		//1:容量:6:32GB_4:样式:12:塑料壳
		StringBuilder sBuilder = new StringBuilder();
		String[] propArr = properties.split("_");
		for (String props : propArr) {
			String[] valueArr = props.split(":");
			sBuilder.append(valueArr[1]).append(":").append(valueArr[3]).append("<br>");
		}
		return sBuilder.toString();
	}
}
