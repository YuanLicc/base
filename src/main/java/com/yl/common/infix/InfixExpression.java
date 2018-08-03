package com.yl.common.infix;

import com.yl.common.calculate.Calculator;
import com.yl.common.expression.imp.CalculableExpression;

public class InfixExpression extends CalculableExpression {

    public InfixExpression(String expression, Calculator calculator) {
        super(expression, calculator);
    }
}
