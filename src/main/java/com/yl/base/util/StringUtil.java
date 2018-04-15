package com.yl.base.util;

import com.yl.base.entity.number.NumberDescription;
import com.yl.base.entity.number.NumberType;
import com.yl.base.entity.point.Point;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

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
			//加入缓存
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

    public static boolean isInteger(NumberDescription description) {
        if(description == null || description.isIllegal() == false) {
            return false;
        }
        else {
            NumberType type = description.getType();
            if(type.equals(NumberType.intType) || type.equals(NumberType.intEType) || type.equals(NumberType.octalType) || type.equals(NumberType.hexType)){
                return true;
            }
            return false;
        }
    }

    public static boolean isFloat(NumberDescription description) {
        if(description == null || description.isIllegal() == false) {
            return false;
        }
        else {
            NumberType type = description.getType();
            if(type.equals(type.equals(NumberType.floatType) || type.equals(NumberType.floatEType))){
                return true;
            }
            return false;
        }
    }

    public static boolean isfloat(NumberDescription description) {
        if(description == null || description.isIllegal() == false) {
            return false;
        }
        else {
            NumberType type = description.getType();
            if(type.equals(NumberType.intType) || type.equals(NumberType.floatType) || type.equals(NumberType.floatEType) || type.equals(NumberType.octalType) || type.equals(NumberType.hexType)){
                return true;
            }
            return false;
        }
    }

    public static boolean isdouble(NumberDescription description) {
        if(description == null || description.isIllegal() == false) {
            return false;
        }
        else {
            return true;
        }
    }

	public static boolean isDouble(NumberDescription description) {
        if(description == null || description.isIllegal() == false) {
            return false;
        }
        else {
            NumberType type = description.getType();
            if(type.equals(NumberType.doubleEType) || type.equals(NumberType.doubleType)){
                return true;
            }
            return false;
        }
    }

	public static NumberDescription isNumber(String number) {
		String temp = number.trim();
		if(isEmpty(temp)) {
			return null;
		}
		NumberDescription result = new NumberDescription();
		//获取正负号
		Character sign = getNumberSign(number);
		if(sign != null) {
			temp = number.substring(1, number.length());
			result.setSign(sign);
			if(temp.length() == 0) {
				result.setIllegal(false);
				return result;
			}
		}
		//获取进制标识符（0、0x、0X）
		String prefix = numberPrefix(temp);
		if(prefix != null) {
			temp = temp.substring(prefix.length(), temp.length());
			if(temp.length() == 0) {
				result.setIllegal(false);
				return result;
			}
		}
		//获取数值类型符（f、F、d、D、l、L）
		Character suffix = numberSuffix(temp);
		if(suffix != null) {
			temp = temp.substring(0, temp.length() - 1);
			if(temp.length() == 0) {
				result.setIllegal(false);
				return result;
			}
		}
		//获取科学计数法表达式（(e|E)[+|-](num)）
		String eNotation = numberENotation(temp);
		if(eNotation != null) {//科学计数法
			temp = temp.substring(0,temp.length() - eNotation.length());
			if(temp.length() == 0) {//数值表达式为空、科学计数法
				if(prefix != null && (prefix.equals("0x") || prefix.equals("0X"))) {//科学计数法、十六进制标识符、数值表达式为空，意味着只能是16进制数、错数
					result.setIllegal(true);
					result.setType(NumberType.hexType);
					return result;
				}
				else if(prefix != null && prefix.equals("0")){//科学计数法、八进制标识符、数值表达式为空，
                    if(suffix == null || (suffix != null && (suffix == 'd' || suffix == 'D'))) {//科学计数法、八进制标识符、数值表达式为空、类型符为空，意味着小数类型
                        result.setIllegal(true);
                        result.setType(NumberType.doubleEType);
                        return result;
                    }
                    else if(suffix != null && (suffix == 'f' || suffix == 'F')) {//科学计数法、八进制标识符、数值表达式为空、类型符为f、F，意味着浮点类型
                        result.setIllegal(true);
                        result.setType(NumberType.floatEType);
                        return result;
                    }
                    else {//科学计数法、八进制标识符、数值表达式为空、类型符为l、L，首先是小数，但类型为long，错误
                        result.setIllegal(false);
                        result.setType(NumberType.longEType);
                        return result;
                    }
                }
                else {//科学计数法、无进制标识符、数值表达式为空，
				    result.setIllegal(false);
				    result.setType(NumberType.intEType);
				    return result;
                }
			}
			else {//数值表达式不为空、科学计数法
                if(temp.equals(".")) {//科学计数法、数值表达式为.符号
                    if(prefix != null && prefix.equals("0")) {//科学计数法、数值表达式为.符号、八进制标识符，意味着小数
                        return dealDecimalNumberWithESuffix(result, suffix, eNotation);
                    }
                    else {//科学计数法、数值表达式为.符号、十六进制标识符或无标识符，错误
                        result.setIllegal(false);
                        result.setType(NumberType.doubleEType);
                        return result;
                    }
                }
                else {//科学计数法、数值表达式
                    if(isContainAndIllegalPoint(temp)) {//科学计数法、数值表达式含一个小数点
                        if(prefix != null && (prefix.equals("0x") || prefix.equals("0X"))){//科学计数法、数值表达式含一个小数点、十六进制标识符，错误
                            result.setIllegal(false);
                            result.setType(NumberType.hexType);
                            return result;
                        }
                        else if(prefix != null && prefix.equals("0")) {//科学计数法、数值表达式含一个小数点、八进制标识符，以小数来判断，不可能为八进制
                            return judgeDecimalNumberAndDealSuffix(result, suffix, temp, eNotation);
                        }
                        else {//科学计数法、数值表达式含一个小数点、无标识符，以小数来判断
                            return judgeDecimalNumberAndDealSuffix(result, suffix, temp, eNotation);
                        }
                    }
                    else if(isContainPoint(temp)){//科学计数法、数值表达式含多个小数点，错误
                        result.setIllegal(false);
                        result.setType(NumberType.doubleEType);
                        return result;
                    }
                    //科学计数法、数值表达式不含小数点
                    else {
                        if(prefix != null && (prefix.equals("0x") || prefix.equals("0X"))){//科学计数法、数值表达式不含小数点、十六进制标识符，判断十六进制
                            return dealHexNumber(result, temp);
                        }
                        else {//科学计数法、数值表达式不含小数点、其它标识符或无标识符，以小数判断
                            return judgeDecimalNumberAndDealSuffix(result, suffix, temp, eNotation);
                        }
                    }
                }
            }
		}
        //非科学计数法
		else {
		    if (temp.equals(".")) {//非科学计数法、数值表达式为.符号
                if(prefix != null && prefix.equals("0")) {//非科学计数法、数值表达式为.符号、八进制标识符，分析为小数
                    return judgeDecimalNumberAndDealSuffix(result, suffix, temp, eNotation);
                }
                else {//非科学计数法、数值表达式为.符号、十六进制标识符或无标识符，错误
                    result.setIllegal(false);
                    result.setType(NumberType.doubleType);
                }
                return result;
            }
            else {//非科学计数法、数值表达式
                if(isContainAndIllegalPoint(temp)) {//非科学计数法、数值表达式含一个有效点符号
                    if(prefix != null && (prefix.equals("0x") || prefix.equals("0X"))) {//非科学计数法、数值表达式含一个有效点符号、十六进制标识符，错误
                        result.setIllegal(false);
                        result.setType(NumberType.hexType);
                    }
                    else if(prefix != null && prefix.equals("0")) {//非科学计数法、数值表达式含一个小数点、八进制标识符，以小数来判断，不可能为八进制
                        return judgeDecimalNumberAndDealSuffix(result, suffix, temp, eNotation);
                    }
                    else {//非科学计数法、数值表达式含一个小数点、无进制标识符，以小数来判断
                        return judgeDecimalNumberAndDealSuffix(result, suffix, temp, eNotation);
                    }
                    return result;
                }
                else if(isContainPoint(temp)) {//非科学计数法、数值表达式含多个点符号，错误
                    result.setIllegal(false);
                    result.setType(NumberType.doubleEType);
                    return result;
                }
                else {//非科学计数法、数值表达式不含点符号，
                    if(prefix != null && (prefix.equals("0x") || prefix.equals("0X"))) {//非科学计数法、数值表达式不含点符号、十六进制标识符，
                        return dealHexNumber(result, temp);
                    }
                    else if(prefix != null && prefix.equals("0")) {//非科学计数法、数值表达式不含点符号、八进制标识符，
                        if(judgeOctalNumber(temp)) {//非科学计数法、数值表达式不含点符号、八进制标识符、满足八进制，以八进制处理
                            return dealOctalNumber(result, suffix);
                        }
                        else if(isAllNumber(temp)) {//非科学计数法、数值表达式不含点符号、八进制标识符、不满足八进制但是满足数字，整数数字处理
                            return dealIntegerNumber(result, suffix);
                        }
                        else {
                            result.setIllegal(false);
                            result.setType(NumberType.octalType);
                            return result;
                        }
                    }
                    else {//非科学计数法、数值表达式不含点符号、无进制标识符，整数数字处理
                        return dealIntegerNumber(result, suffix);
                    }
                }
            }
        }
	}

    private static NumberDescription dealIntegerNumber(NumberDescription description, Character suffix) {
        if(suffix != null && (suffix == 'd' || suffix == 'D')) {
            description.setIllegal(true);
            description.setType(NumberType.doubleType);
        }
        else if(suffix != null && (suffix == 'f' || suffix == 'F')) {
            description.setIllegal(true);
            description.setType(NumberType.floatType);
        }
        else if(suffix != null && (suffix == 'l' || suffix == 'l')) {
            description.setIllegal(true);
            description.setType(NumberType.longType);
        }
        else {
            description.setType(NumberType.intType);
            description.setIllegal(true);
        }
        return description;
    }

    private static NumberDescription dealOctalNumber(NumberDescription description, Character suffix) {
        if(suffix != null && (suffix == 'd' || suffix == 'D')) {
            description.setIllegal(true);
            description.setType(NumberType.doubleType);
        }
        else if(suffix != null && (suffix == 'f' || suffix == 'F')) {
            description.setIllegal(true);
            description.setType(NumberType.floatType);
        }
        else if(suffix != null && (suffix == 'l' || suffix == 'l')) {
            description.setIllegal(true);
            description.setType(NumberType.doubleType);
        }
        else {
            description.setType(NumberType.octalType);
            description.setIllegal(true);
        }
        return description;
    }

	private static NumberDescription dealHexNumber(NumberDescription description, String number) {
        if(judgeHexNumber(number)) {
            description.setIllegal(true);
            description.setType(NumberType.hexType);
        }
        else {
            description.setIllegal(false);
            description.setType(NumberType.hexType);
        }
        return description;
    }

    /**
     * 仅判断字符串的字符是否满足十六进制中的取值，不对十六进制数的格式做判断，也就是不能判断十六进制数是否表示正确。
     * @param number 字符串
     * @return 遇见点符号跳过，遇见数字判断是否满足十六进制，遇见其它字符返回false
     */
	private static boolean judgeHexNumber(String number) {
        if(isEmpty(number)) {
            return false;
        }
        else {
            for(int i = 0; i < number.length(); i++) {
                char iChar = number.charAt(i);
                if(!((iChar >= '0' && iChar <= '9' ) || iChar == '.' || (iChar >= 'a' && iChar <= 'f' ) || (iChar >= 'A' && iChar <= 'F' ))) {
                    return false;
                }
            }
            return true;
        }
    }

    /**
     * 仅判断字符串的字符是否满足八进制中的取值，不对八进制数的格式做判断，也就是不能判断八进制数是否表示正确。
     * @param number 字符串
     * @return 遇见点符号跳过，遇见数字判断是否满足八进制，遇见其它字符返回false
     */
	private static boolean judgeOctalNumber(String number) {
        if(isEmpty(number)) {
            return false;
        }
        else {
            for(int i = 0; i < number.length(); i++) {
                char iChar = number.charAt(i);
                if(!((iChar >= '0' && iChar <= '7') || iChar == '.')) {
                    return false;
                }
            }
            return true;
        }
    }

    public static  boolean isContainPoint(String str) {
	    if(isEmpty(str)) {
	        return false;
        }
        for(int i = 0; i < str.length(); i++) {
	        char iChar = str.charAt(i);
	        if(iChar == '.') {
                return  true;
            }
        }
        return false;
    }

	private static NumberDescription judgeDecimalNumberAndDealSuffix(NumberDescription description, Character suffix, String number, String eNotation) {
        if(isAllNumber(number)) {
            return dealDecimalNumberWithESuffix(description, suffix, eNotation);
        }
        else {
            description.setIllegal(false);
            description = setDoubleType(description, eNotation);
            return description;
        }
    }

    private static NumberDescription setFloatType(NumberDescription description, String eNotation) {
        if(eNotation == null) {
            description.setType(NumberType.floatType);
        }
        else {
            description.setType(NumberType.floatEType);
        }
        return description;
    }

    private static NumberDescription setDoubleType(NumberDescription description, String eNotation) {
        if(eNotation == null) {
            description.setType(NumberType.doubleType);
        }
        else {
            description.setType(NumberType.doubleEType);
        }
        return description;
    }

    /**
     * 处理指定小数、科学计数数字描述对象的后缀（d、D、f、F、l、L）
     * @param description 指定小数、科学计数数字
     * @param suffix 后缀（d、D、f、F、l、L）
     * @return
     */
	private static NumberDescription dealDecimalNumberWithESuffix(NumberDescription description, Character suffix, String eNotation) {
        if(suffix != null && (suffix == 'L' || suffix == 'l')) {
            description.setIllegal(false);
            description = setDoubleType(description, eNotation);
        }
        else if(suffix != null && (suffix == 'f' || suffix == 'F')) {
            description.setIllegal(true);
            description = setFloatType(description, eNotation);
        }
        else {
            description.setIllegal(true);
            description = setDoubleType(description, eNotation);
        }
        return description;
    }

    /**
     * 判断指定串的所有字符都是数字或者点符号
     * @param number 指定串
     * @return true or false
     */
	public static boolean isAllNumber(String number) {
        if(isEmpty(number)) {
            return false;
        }
        else {
            for(int i = 0; i < number.length(); i++) {
                char iChar = number.charAt(i);
                if(!(Character.isDigit(iChar) || iChar == '.')) {
                    return false;
                }
            }
            return true;
        }
    }

    /**
     * 只判断指定串是否包含点符号
     * @param number 指定串
     * @return 若包含点符号，且只含一个点符号，则返回true(原因是Java数值表示中点符号可以出现在任意位置)，其余返回false
     */
	public static boolean isContainAndIllegalPoint(String number) {
        if (isEmpty(number)) {
            return false;
        } else {
            int pointCount = 0;
            for(int i = 0; i < number.length(); i++) {
                char iChar = number.charAt(i);
                if(iChar == '.') {
                    pointCount += 1;
                }
            }
            if(pointCount == 1) {
                return true;
            }
            else {
                return false;
            }
        }
    }

	private static NumberDescription setNumberType(NumberDescription description, Character suffix, boolean isENotation) {
        if(description == null || suffix == null) {
            return description;
        }
        else {
            if(isENotation) {
                if(suffix == 'd' || suffix == 'D') {
                    description.setType(NumberType.doubleEType);
                }
                else if(suffix == 'l' || suffix == 'L') {
                    description.setType(NumberType.longEType);
                }
                else if(suffix == 'f' || suffix == 'F') {
                    description.setType(NumberType.floatEType);
                }
                else {
                    return description;
                }
            }
            else {
                if(suffix == 'd' || suffix == 'D') {
                    description.setType(NumberType.doubleType);
                }
                else if(suffix == 'l' || suffix == 'L') {
                    description.setType(NumberType.longType);
                }
                else if(suffix == 'f' || suffix == 'F') {
                    description.setType(NumberType.floatType);
                }
                else {
                    return description;
                }
            }
            return description;
        }
    }

	public static String numberENotation(String number) {
		if(isEmpty(number)) {
			return null;
		}
		String result = "";
		for(int i = number.length() - 1; i >= 0; i--) {
			char iChar = number.charAt(i);
			if(Character.isDigit(iChar)) {
				result += iChar;
			}
			else if(iChar == 'e' || iChar =='E') {
				if(result.length() > 0) {
					result += iChar;
					return result;
				}
				else{
					return null;
				}
			}
			else if(iChar == '+') {
                Character upChar = upChar(number, i);
                if(upChar != null && (upChar == 'e' || upChar == 'E')) {
                    result += iChar;
                    result += upChar;
                    return result;
                }
                else{
                    return null;
                }
			}
			else{
			    return null;
            }
		}
		return null;
	}

	public static Character upChar (String str, int index) {
		if(isEmpty(str) || str.length()  <= index - 1 || index <= 0) {
			return null;
		}
		else {
			return str.charAt(index - 1);
		}
	}

	/**
	 * 获取自定数字串的数字类型标识符（D、d、f、F、l、L）
	 * @param number 指定数字串
	 * @return 若数字串最后一个字符为D、d、f、F、l、L，则返回，否则返回空。
	 */
	public static Character numberSuffix(String number) {
		if(isEmpty(number)) {
			return null;
		}

		char lastChar = number.charAt(number.length() - 1);
		if(lastChar == 'D' || lastChar == 'd' || lastChar == 'f' || lastChar == 'F' || lastChar == 'l' || lastChar == 'L') {
			return lastChar;
		}
		else{
			return null;
		}
	}

	/**
	 * 截取指定数字串前缀（0或0x、0X，其余返回空）
	 * @param number 指定数字串
	 * @return null、0x、0、0X
	 */
	public static String numberPrefix(String number) {
		if(isEmpty(number)) {
			return null;
		}
		char firstChar = number.charAt(0);
		if(firstChar == '0') {
			Character nexChar = nextChar(number, 0);
			if(nexChar == 'x' || nexChar == 'X') {
				return "0" + nexChar;
			}
			else {
				return "0";
			}
		}
		else {
			return null;
		}
	}

	/**
	 * 指定串的指定下标的下一个字符
	 * @param str 指定串
	 * @param index 指定下标
	 * @return 指定串存在下一个字符则返回，不存在则返回null
	 */
	public static Character nextChar (String str, int index) {
		if(isEmpty(str) || str.length() <= index + 1) {
			return null;
		}
		return str.charAt(index + 1);
	}

	/**
	 * 获取指定数字串的符号（+、-）
	 * @param number 指定数字串
	 * @return 存在符号则返回，不存在则返回null
	 */
	public static Character getNumberSign(String number) {
		if(isEmpty(number)) {
			return null;
		}
		else {
			Character sign = number.charAt(0);
			if(sign == '+' || sign == '+'){
				return sign;
			}
			else{
				return null;
			}
		}
	}

}
