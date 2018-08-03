package com.yl.common.string.number;

import com.yl.common.builder.Builder;

import java.io.Serializable;

public class StringNumber implements Serializable {

    public static final String NUMBER_SIGN = "numberSign";
    public static final String NUMBER_PREFIX = "numberPrefix";
    public static final String NUMBER_INTEGRAL = "numberIntegral";
    public static final String NUMBER_FRACTIONAL = "numberFractional";

    private String numberSign;

    private String numberPrefix;

    private String numberIntegral;

    private String numberFractional;

    private String number;

    private StringNumber(String number) {
        this.number = number;
    }

    public class StringNumberBuilder implements Builder<StringNumber> {

        private final StringNumber stringNumber;

        public StringNumberBuilder(String number) {
            stringNumber = new StringNumber(number);
        }

        @Override
        public Builder<StringNumber> buildAll() {
            return null;
        }

        @Override
        public StringNumber build() {
            return stringNumber;
        }
    }
}
