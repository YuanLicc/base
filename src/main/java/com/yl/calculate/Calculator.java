package com.yl.calculate;

/**
 * 计算器
 * @author YuanLi
 */
public interface Calculator {

    /**
     * 给定可计算对象进行计算
     * @param calculable 给定可计算对象
     * @return {@link Number}
     */
    Number calculate(Calculable calculable);

}
