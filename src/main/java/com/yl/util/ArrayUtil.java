package com.yl.util;

import java.util.ArrayList;

/**
 * 数组工具
 * @author YuanLi
 */
public class ArrayUtil {

	public static <E> ArrayList<E>[] arrayToList(E[][] array) {
		if(array == null || array.length == 0) {
			return null;
		}
		
		@SuppressWarnings("unchecked")
		ArrayList<E>[] list = new ArrayList[array.length];
		
		for(int i = 0; i < array.length; i++) {
			ArrayList<E> ele = new ArrayList<E>();
			for(int j = 0; j < array[i].length; j++) {
				ele.add(array[i][j]);
			}
			list[i] = ele;
		}
		return list;
	}
	
	public static Integer[][] intToInteger(int[][] array) {
		if(array == null || array.length == 0) {
			return null;
		}
		Integer[][] result = new Integer[array.length][array[0].length];
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[i].length; j++) {
				result[i][j] = array[i][j];
			}
		}
		return result;
	}
	
	public static <T extends Comparable<T>> boolean isRepeat(T[] array) {
		if(array == null || array.length <= 1) {
			return false;
		}
		
		for(int i = 0; i < array.length; i++) {
			for(int j = i; j < array.length; j++) {
				if(i != j) {
					if(array[i].compareTo(array[j]) == 0) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
}
