package com.yl.infix;

import com.yl.calculate.Calculator;
import com.yl.expression.imp.CalculableExpression;

public class InfixExpression extends CalculableExpression {

    public InfixExpression(String expression, Calculator calculator) {
        super(expression, calculator);
    }
}
