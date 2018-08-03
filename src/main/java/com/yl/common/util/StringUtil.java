package com.yl.common.util;

/**
 * String 工具类
 * @author YuanLi
 */
public class StringUtil {

    public static final String EMPTY = "";

    /**
     * 判断给定字符串是否为 null，是则返回{@link #EMPTY}，否则返回字符串本身。
     * @param str 给定字符串
     * @return 非 null 字符串
     */
    public static String nullToEmpty(String str) {
        return str == null ? EMPTY : str;
    }

    /**
     * 构造一个 String，通过给定重复字符及重复的次数
     * @param repeated 被重复字符
     * @param repeatedCount 被重复次数
     * @return String
     */
    public static String newString(char repeated, int repeatedCount) {
        if(repeatedCount <= 0) {
            return EMPTY;
        }

        StringBuffer buffer = new StringBuffer();

        for(int i = 0; i < repeatedCount; i++) {

            buffer.append(repeated);
        }

        return buffer.toString();
    }

    public static String swap(String source, int index1, int index2) {
        if(source == null || source.equals(EMPTY)) {
            return EMPTY;
        }

        char[] sourceChars = CharUtil.swap(source.toCharArray(), index1, index2);

        return String.valueOf(sourceChars);
    }

}
