package com.yl.common.util;

import com.yl.common.function.VoidNoParamsFunction;

/**
 * 控制台输出工具类
 * @author YuanLi
 */
public class PrintUtil {

    public static final int DEFAULT_LINE_COLUMN = 70;

    public static final char LINE_ELEMENT = '-';

    public static final char LINE_FEED = '\n';

    public static void print(Object o) {
        System.out.print(ObjectUtil.nullToString(o));
    }

    public static void print(Object o, String prefix, String suffix) {
        System.out.print(StringUtil.nullToEmpty(prefix)
                + ObjectUtil.nullToString(o) + StringUtil.nullToEmpty(suffix));
    }

    public static void printWithNaoTime(Object o, Timer timer) {
        System.out.print(ObjectUtil.nullToString(o) + ", nao time: " + nullToTime(timer));
    }

    public static void printWithNaoTime(Object o, Timer timer, String delimiter) {
        System.out.print(ObjectUtil.nullToString(o) + StringUtil.nullToEmpty(delimiter) + nullToTime(timer));
    }

    public static void printWithNaoTime(Object o, Timer timer, String prefix, String delimiter, String suffix) {
        System.out.print(StringUtil.nullToEmpty(prefix) + ObjectUtil.nullToString(o)
                + StringUtil.nullToEmpty(delimiter) + nullToTime(timer) + StringUtil.nullToEmpty(suffix));
    }

    public static void println() {
        System.out.println();
    }

    public static void println(Object o) {
        System.out.println(ObjectUtil.nullToString(o));
    }

    public static void println(Object o, String prefix, String suffix) {
        System.out.println(StringUtil.nullToEmpty(prefix)
                + ObjectUtil.nullToString(o) + StringUtil.nullToEmpty(suffix));
    }

    public static void printlnWithNaoTime(Object o, Timer timer) {
        System.out.println(ObjectUtil.nullToString(o) + ", nao time: " + nullToTime(timer));
    }

    public static void printlnWithNaoTime(Object o, String delimiter, Timer timer) {
        System.out.println(ObjectUtil.nullToString(o)
                + StringUtil.nullToEmpty(delimiter) + nullToTime(timer));
    }

    public static void printlnWithNaoTime(Object o, Timer timer, String prefix, String delimiter, String suffix) {
        System.out.println(StringUtil.nullToEmpty(prefix) + ObjectUtil.nullToString(o)
                + StringUtil.nullToEmpty(delimiter) + nullToTime(timer) + StringUtil.nullToEmpty(suffix));
    }


    // LINE
    public static void printlnLine() {
        printlnLine(DEFAULT_LINE_COLUMN);
    }

    public static void printlnLine(String prefix, String suffix) {
        printLine(DEFAULT_LINE_COLUMN, 1, prefix, String.valueOf(suffix) + LINE_FEED);
    }

    public static void printlnLine(int column, int row) {
        printLine(column, row, null, String.valueOf(LINE_FEED));
    }

    public static void printlnLine(int column, int row, String prefix, String suffix) {
        printLine(column, row, prefix, StringUtil.nullToEmpty(suffix) + LINE_FEED);
    }

    public static void printlnLine(int column) {
        printLine(column, 1, null, String.valueOf(LINE_FEED));
    }

    public static void printlnLine(int column, String prefix, String suffix) {
        printLine(column, 1, prefix, StringUtil.nullToEmpty(suffix) + LINE_FEED);
    }

    public static void printLine() {
        printLine(DEFAULT_LINE_COLUMN);
    }

    public static void printLine(String prefix, String suffix) {
        printLine(DEFAULT_LINE_COLUMN, 1, prefix, suffix);
    }

    public static void printLine(int column, int row) {
        printLine(column, row, null, null);
    }

    public static void printLine(int column) {
        printLine(column, 1, null, null);
    }

    public static void printLine(int column, String prefix, String suffix) {
        printLine(column, 1, prefix, suffix);
    }

    public static void printLine(int column, int row,  String prefix, String suffix) {
        column = column > 0 ? column : DEFAULT_LINE_COLUMN;
        row = row > 0 ? row : 1;

        String s = StringUtil.newString(LINE_ELEMENT, column);

        for (int i = 0; i < row; i++) {
            print(StringUtil.nullToEmpty(prefix) + s + StringUtil.nullToEmpty(suffix));
        }
    }

    private static String nullToTime(Timer timer) {
        return timer == null ? ObjectUtil.NULL : timer.end().toString();
    }

    public static void template(String title, VoidNoParamsFunction contentAction) {

        PrintUtil.printlnLine();
        PrintUtil.println(StringUtil.nullToEmpty(title));
        contentAction.action();
    }
}
