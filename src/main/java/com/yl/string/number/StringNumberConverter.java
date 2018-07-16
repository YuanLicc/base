package com.yl.string.number;

import com.yl.converter.Converter;
import com.yl.validate.Validator;

public class StringNumberConverter implements Converter<String, Number> {

    private Validator<String> isNumberStringValidator;

    public StringNumberConverter(Validator<String> isNumberStringValidator) {
        this.isNumberStringValidator = isNumberStringValidator;
    }

    @Override
    public Number convert(String converted) {
        return null;
    }

}
