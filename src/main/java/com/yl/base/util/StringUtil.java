package com.yl.base.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.yl.base.entity.point.Point;

/**
 * String工具
 * @author YuanLi
 */
public class StringUtil {

	/**
	 * <ul><strong>字符串trim函数</strong>
	 * <li>为null返回null
	 * <li>不为空但trim后为""返回null
	 * <li>上诉均不成立返回trim
	 */
	public static String trimToNull(String str){
		if(str == null) {
			return null;
		}
		
		String trimStr = str.trim();
		
		return "".equals(trimStr) ? null : trimStr;
	}
	
	/**
	 * <ul><strong>判断空串</strong>
	 * <li>为null返回true
	 * <li>不为空但str.trim().equals("")返回true
	 * <li>上诉均不成立返回false
	 */
	public static boolean isEmpty(String str){
		return str == null || str.trim().equals("");
	}
	
	/**
	 * 给定字符串的每一行前加固定字符串
	 * @param aimStr 给定字符串
	 * @param addStr 要加的固定字符串
	 * @return 给定字符串的每一行前加固定字符串
	 */
	public static String addStrPerline(String aimStr, String addStr) {
		if(isEmpty(aimStr) || addStr == null) {
			return "";
		}
		String[] strs = aimStr.split("\\n");
		String result = addStr;
		for(String string : strs) {
			result += string + "\n" + addStr; 
		}
		return result;
	}
	
	/**
	 * 给定字符串最长回文子序列
	 * @param str 给定字符串
	 * @return 给定字符串最长回文子序列
	 */
	public static String longestPalindromeSubsequence(String str) {
		return longestPalindromeSubsequence(str, 0, str.length() - 1, new HashMap<Point<Integer,Integer>, String>(10));
	}
	
	/**
	 * 给定字符串的子串的最长回文子序列
	 * @param str 给定字符串
	 * @param i 字符串子串起始下标
	 * @param j 字符串子串终止下标
	 * @return 给定字符串的子串的最长回文子序列
	 */
	public static String longestPalindromeSubsequence(String str, int i, int j) {
		if(str == null || i < 0 || j >= str.length() || i > j) {
			throw new IllegalArgumentException("非法参数，子串的最长回文子序列中,要确保子串有效！");
		}
		return longestPalindromeSubsequence(str, i, j, new HashMap<Point<Integer,Integer>, String>(10));
	}
	
	/**
	 * 给定字符串的子串的最长回文子序列
	 * @param str 给定字符串
	 * @param i 字符串子串起始下标
	 * @param j 字符串子串终止下标
	 * @param memory 缓存
	 * @return 给定字符串的子串的最长回文子序列
	 */
	private static String longestPalindromeSubsequence(String str, int i, int j, Map<Point<Integer,Integer>, String> memory) {
		
		if(i > j) {
			return "";
		}
		else if(i == j) {
			return str.substring(i, i + 1);
		}
		/**查看是否有缓存，有则返回*/
		String cache = getStringByMap(i, j, memory);
		if(!"".equals(cache)) {
			return cache;
		}
		else {
			memory.put(new Point<Integer,Integer>(i, j), "");
		}
		/**判断下标下的字符是否相等*/
		if(str.charAt(i) == str.charAt(j)) {
			/**两端加上相等的字符*/
			String currentStr = str.charAt(i) + longestPalindromeSubsequence(str, i + 1, j - 1, memory) + str.charAt(j);
			/**加入缓存*/
			memory = setString(i, j, memory, currentStr);
			return currentStr;
		}
		else {
			String str1 = longestPalindromeSubsequence(str, i + 1, j, memory);
			String str2 = longestPalindromeSubsequence(str, i, j - 1, memory);
			String max = str1.length() > str2.length() ? str1 : str2;
			/**加入缓存*/
			memory = setString(i, j, memory, max);
			return max;
		}
	}
	
	/**
	 * 给定map设置value。
	 * @param i 与j确定一个对象Point({@link com.yl.base.entity.Point})，确定map的key。
	 * @param j 与i确定一个对象Point({@link com.yl.base.entity.Point})，确定map的key。
	 * @param memory 给定map
	 * @param str value
	 * @return 经设置value后的给定map
	 */
	private static Map<Point<Integer,Integer>, String> setString(int i, Integer j, Map<Point<Integer,Integer>, String> memory, String str) {
		for(Entry<Point<Integer,Integer>, String> mEntry : memory.entrySet()) {
			Point<Integer,Integer> point = mEntry.getKey();
			if(point.getColumn() == i && point.getRow() == j) {
				mEntry.setValue(str);
				return memory;
			}
		}
		return null;
	}
	
	/**
	 * 获取给定map的value
	 * @param i 与j确定一个对象Point({@link com.yl.base.entity.Point})，确定map的key。
	 * @param j 与i确定一个对象Point({@link com.yl.base.entity.Point})，确定map的key。
	 * @param memory 给定map
	 * @return 给定map的value
	 */
	private static String getStringByMap(int i, int j, Map<Point<Integer,Integer>, String> memory) {
		if(memory == null || memory.size() == 0) {
			return "";
		}
		for(Entry<Point<Integer,Integer>, String> mEntry : memory.entrySet()) {
			Point<Integer,Integer> point = mEntry.getKey();
			if(point.getColumn() == i && point.getRow() == j) {
				return mEntry.getValue();
			}
		}
		return "";
	}
	
	/**
	 * 复制指定串指定次数的连接串
	 * @param acount 复制次数
	 * @param copied 待复制串
	 */
	public static String copyStringWithAcount(int acount, String copied) {
		if(acount <= 0 || copied == null || copied.equals("")) {
			throw new IllegalArgumentException("非法参数，进行复制的串和复制次数必须合法！"); 
		}
		String result = "";
		for(int i = 0;i < acount; i++) {
			result += copied;
		}
		return result;
	}
	
	/**
	 * 去除字符串中的空格
	 */
	public static String clearSpace(String str) {
		StringBuffer sBuffer = new StringBuffer("");
		for(int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if(c != ' ') {
				sBuffer.append(c);
			}
		}
		return sBuffer.toString();
	}
	
	public static void main(String[] args) {
		System.out.print(clearSpace("现实 中， 攻击者 可以 采用 XSS 攻击， 偷取 用户 Cookie、 密码 等 重要 数据， 进而 伪造 交易、 盗窃 用户 财产、 窃取 情报。"));
	}
	
}
