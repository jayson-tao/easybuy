package com.yaorange.consts;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * 
 * 常量注解
 * 2017年2月16日
 * @author nixianhua
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD )
public @interface ConstName {
	public String value() default "";
}
