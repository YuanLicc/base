package com.yl.base.util;

import java.util.ArrayList;

/**
 * Object工具
 * @author YuanLi
 */
public class ObjectUtil {

	/**
	 * 数组转ArrayList
	 * @param objects 数组
	 * @return 参数无效返回一个空的list
	 */
	public static <E> ArrayList<E> transformToList(@SuppressWarnings("unchecked") E...objects) {
		ArrayList<E> list = new ArrayList<E>();
		
		if(objects == null || objects.length == 0) {
			return list;
		}
		
		for(E object : objects) {
			list.add(object);
		}
		return list;
	}
	
	/**
	 * 1. ==成立返回true</br>
	 * 2. 只要有null则返回false</br>
	 * 3. 上诉均不成立，返回o1.equals(o2)
	 */
	public static boolean equals(Object o1, Object o2){
		if(o1 == o2) {
			return true;
		}
		
		if(o1 == null || o2 == null) {
			return false;
		}
		
		return o1.equals(o2);
		
	}
	
	/**
	 * 1. 为空返回"null"</br>
	 * 2. 不为空返回o.toString()
	 */
	public static String nullToString(Object o) {
		return o == null ? "null" : o.toString();
	}
	
}
