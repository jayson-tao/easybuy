package com.yaorange.consts;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.yaorange.util.ClassUtils;
import com.yaorange.util.KV;


/**
 * 常量工具类
 * 2017年2月16日
 * @author nixianhua
 *
 */
public class ConstUtils {
	public static final String SCAN_PACKAGE_NAME = "com.yaorange.consts";
	public static Map<Integer, String> CODESMAP = null;
	/**
	 * 初始化代码表
	 */
	private static void initCodesMap(){
		CODESMAP = new HashMap<Integer,String>();
		List<Class<?>> constClassList = null;
		constClassList = ClassUtils.getClassList(SCAN_PACKAGE_NAME, true);
		for(Class<?> c:constClassList){
			if(ICodes.class.isAssignableFrom(c)){
				List<KV<Integer,String>> kvList = getKvList(c);
				for(KV<Integer,String> kv:kvList){
					CODESMAP.put(kv.getK(), kv.getV());
				}
			}
		}
	}

	/**
	 * @param clazz 常量类
	 * @return 返回 常量<值,显示名字>键值对列表
	 */
	public static List<KV<Integer,String>> getKvList(Class<?> clazz){
		Field fields[]=clazz.getDeclaredFields();
		List<KV<Integer,String>> constList = new ArrayList<KV<Integer,String>>();
		for(Field f:fields){
			try {
				Integer k = new Integer(f.getInt(null));
				ConstName cn = f.getAnnotation(ConstName.class);
				if(null!=cn){
					String value = cn.value();
					KV<Integer,String> kv = new KV<Integer, String>(k,value);
					constList.add(kv);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return constList;

	}


	/**
	 * 读取指定消息代码的消息文本
	 * @param code 消息代码
	 * @return 返回消息文本
	 */
	public static String getMsgConstName(int code){
		if(null==CODESMAP) {
			ConstUtils.initCodesMap();
		}
		return CODESMAP.get(code);
	}

	/**
	 * 获取业务常量文本
	 * @param clazz 常量接口/类
	 * @param code 代码
	 * @return 常量文本
	 */
	public static String getBisConstName(Class<?> clazz,int code){
		Field fields[]=clazz.getDeclaredFields();
		for(Field f:fields){
			try {
				Integer k = new Integer(f.getInt(null));
				ConstName cn = f.getAnnotation(ConstName.class);
				if(null!=cn){
					String value = cn.value();
					if(k.intValue() == code) return value;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "";
	}
}
