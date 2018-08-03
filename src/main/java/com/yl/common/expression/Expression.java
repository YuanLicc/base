package com.yl.common.expression;

import com.yl.common.string.exception.StringEmptyException;
import com.yl.common.expression.imp.CalculableExpression;

import java.io.Serializable;
import java.util.Objects;

/**
 * 字符串表达式抽象类，不管是什么表达式（数学表达式、正则等），
 * 都应该通过继承自此抽象类来实现。
 * 此抽象类中没有任何抽象方法，避免产生此类的实例，因为此类的实例无任何意义。
 * 在对此类进行扩展时，请通过实现行为型接口的方式进行扩展，例如{@link CalculableExpression}
 * @author YuanLi
 */
public abstract class Expression implements Serializable {

    /**
     * 表达式
     */
    protected String expression;

    /**
     * @param expression 表达式串
     * @throws NullPointerException 为空时抛出
     * @throws StringEmptyException {@code expression.trim().equals("")}抛出此异常
     */
    public Expression(String expression){
        Objects.requireNonNull(expression);
        String trimExpression = expression.trim();
        if(trimExpression.equals("")) {
            throw new StringEmptyException("参数：expression 为空串，不合法");
        }
        else{
            this.expression = expression;
        }
    }
    /**
     * 获取表达式
     * @return 返回表达式字符串
     */
    public String getExpression() {
        return expression;
    }

}
