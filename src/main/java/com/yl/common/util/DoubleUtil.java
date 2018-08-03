package com.yl.common.util;

import java.util.List;

/**
 * Double工具
 * @author YuanLi
 */
public class DoubleUtil {

	/**
	 * 给定数组转ArrayList
	 * @param doubles 给定数组
	 * @return ArrayList
	 */
	public static List<Double> transformToList(Double...doubles) {
		return ObjectUtil.transformToList(doubles);
	}
	
	public static double max(double[] arr) {
		if(arr == null) {
			throw new NullPointerException();
		}
		else if(arr.length == 1) {
			return arr[0];
		}
		
		double max = arr[0];
		for(int i = 1; i < arr.length; i++) {
			if(max < arr[i]) {
				max = arr[i];
			}
		}
		return max;
	}
	
}
