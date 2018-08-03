package com.yl.common.util;

/**
 * char 工具类
 * @author YuanLi
 */
public class CharUtil {

    public static char[] swap(char[] chars, int swapIndex1, int swapIndex2) {
        if(chars == null) return null;

        int length = chars.length;

        if(length == 0) return chars;

        if(swapIndex1 < 0 || swapIndex1 >= length || swapIndex2 < 0 || swapIndex2 >= length) {
            throw new ArrayIndexOutOfBoundsException();
        }

        char temp = chars[swapIndex1];
        chars[swapIndex1] = chars[swapIndex2];
        chars[swapIndex2] = temp;

        return chars;
    }

}
