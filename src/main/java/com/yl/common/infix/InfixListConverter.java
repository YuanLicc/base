package com.yl.common.infix;

import com.yl.common.converter.Converter;
import com.yl.common.validate.Validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 中缀四则运算式转为List<Object>（是一个数字与字符的有序列表）
 */
public class InfixListConverter implements Converter<String, List<Object>> {

    private Validator<String> infixValidator;

    public InfixListConverter(Validator<String> infixValidator) {
        Objects.requireNonNull(infixValidator);

        this.infixValidator = infixValidator;
    }

    @Override
    public List<Object> convert(String infix) {
        if(!infixValidator.validate(infix)) {
            return null;
        }
        List<Object> objects = new ArrayList<>();
        String[] elements = infix.split(" ");

        for(String element : elements) {

        }
        return null;
    }

    public boolean isDigit(String element) {
        if(Character.isDigit(element.charAt(0))) {
            return true;
        }
        else {
            return false;
        }
    }

}
