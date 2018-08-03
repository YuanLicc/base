package com.yl.common.util;

public class Timer {

    private static Long TIME;

    private Timer(){}

    public static Timer start() {
        Timer instance = new Timer();
        instance.TIME = System.nanoTime();
        return instance;
    }

    public void reset() {
        TIME = System.nanoTime();
    }

    public Long end() {
        return System.nanoTime() - TIME;
    }

}
