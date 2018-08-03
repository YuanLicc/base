package com.yl.common.calculate;

/**
 * 可计算的，抽象接口</br>
 * 对于代表数学表达式的类应该实现此接口
 * @author YuanLi
 */
public interface Calculable {

    /**
     * 进行计算
     * @return {@link Number}
     */
    Number calculate();
}
