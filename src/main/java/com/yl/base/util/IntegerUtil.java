package com.yl.base.util;

import java.util.HashMap;
import java.util.Map;

/**
 * Integer工具
 * @author YuanLi
 */
public class IntegerUtil {

	public static Integer[] randomWithoutRepeat(int n) {
		return randomWithoutRepeat(n, 0, n * 10);
	}
	
	public static Integer[] randomWithoutRepeat(int n, int upBound, int downBound) {
		if(upBound - downBound < n || n <= 0) {
			throw new IllegalArgumentException("上界应该大于下界与n的和，且n不能小于1");
		}
		Integer[] randomArr = new Integer[n];
		Map<Integer, Integer> randomMap = new HashMap<Integer, Integer>(n);
		
		while(randomMap.size() == n) {
			int randomIndex = (int) (Math.random() * (upBound - downBound));
			if(randomMap.get(randomIndex) != null) {
				randomArr[randomMap.size()] = downBound + randomIndex;
				randomMap.put(randomIndex, randomIndex);
			}
		}
		return randomArr;
	}
	
}
