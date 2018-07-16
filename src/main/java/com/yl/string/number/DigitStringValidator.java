package com.yl.string.number;

import com.yl.validate.Validator;

import java.util.Objects;

public class DigitStringValidator implements Validator<String> {

    @Override
    public boolean validate(String validated) {
        Objects.requireNonNull(validated);

        String temp = validated.trim();

        if(temp.equals("")) {
            return false;
        }
        else {
            return realValidate(temp);
        }
    }

    private boolean realValidate(String validated) {
        return false;
    }
}
