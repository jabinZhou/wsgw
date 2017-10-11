package com.zzb.shop.util;

import java.util.UUID;

/**
 * 编号构造类
 *
 */
public class SnUtils {
	
	/**
	 * 订单编号前缀
	 */
	private static final String ORDER_PREFIX="o";
	public static final String ORDER_TYPE="o";
	
	public synchronized static String getSn(String type){
		String prefix="";
		if(ORDER_TYPE.equals(type)){
			prefix=ORDER_PREFIX;
		}
		
		int hashCode=UUID.randomUUID().toString().hashCode();
		if(hashCode<0){
			hashCode=-hashCode;
		}
		return prefix+String.format("%015d", hashCode);
	}
	
}
