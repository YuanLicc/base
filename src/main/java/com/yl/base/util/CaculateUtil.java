package com.yl.base.util;

/**
 * 计算工具类
 * @author YuanLi
 */
public class CaculateUtil {

	public static double factorial(int n) {
		if(n < 0) {
			throw new IllegalArgumentException("阶乘参数不应该小于0！");
		}
		
		if(n == 0 || n == 1) {
			return 1;
		}
		
		int result = 1;
		
		for(int i = 1; i <= n; i++) {
			result *= i;
		}
		
		return result;
	}
	
	public static double factorial(int n, int k) {
		if(n < 0 || k < 0 || k >= n) {
			throw new IllegalArgumentException("阶乘参数不应该小于0！");
		}
		
		if(n == 0 || n == 1) {
			return 1;
		}
		
		int result = 1;
		
		for(int i = k + 1; i <= n; i++) {
			result *= i;
		}
		
		return result;
	}
	
	public static int factorialTime(int n) {
		if(n < 0) {
			throw new IllegalArgumentException("阶乘参数不应该小于0！");
		}
		
		if(n == 0 || n == 1) {
			return 1;
		}
		
		return n;
	}
	
}
