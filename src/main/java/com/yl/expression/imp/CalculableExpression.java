package com.yl.expression.imp;

import com.yl.calculate.Calculable;
import com.yl.calculate.Calculator;
import com.yl.string.exception.StringEmptyException;
import com.yl.expression.Expression;

import java.util.Objects;

/**
 * 可计算表达式，约束表达式的可计算性
 * @see Calculable
 * @author YuanLi
 */
public class CalculableExpression extends Expression implements Calculable {

    /**
     * 计算器，将计算的实现延迟到{@link Calculable}的具体实现类中去
     */
    private Calculator calculator;

    /**
     * 构造实例
     * @param expression 表达式字符串（不能为空）
     * @param calculator 表达式对应的计算器（不能为空）
     * @throws NullPointerException 当参数为空时抛出此异常
     * @throws StringEmptyException 由父类（{@link Exception}）抛出：当{@code expression.trim()}为空串时
     * ，抛出此异常
     */
    public CalculableExpression(String expression, Calculator calculator) {
        super(expression);
        Objects.requireNonNull(calculator);
        this.calculator = calculator;
    }

    @Override
    public Number calculate() {
        return calculator.calculate(this);
    }

}
