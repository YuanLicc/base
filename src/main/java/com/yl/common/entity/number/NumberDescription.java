package com.yl.common.entity.number;

import com.yl.common.number.NumberType;

/**
 * @author YuanLi
 * Java数值描述
 */
public class NumberDescription {

    private NumberType type;

    private Character sign;

    private boolean isIllegal;

    private Number value;

    public NumberType getType() {
        return type;
    }

    public void setType(NumberType type) {
        this.type = type;
    }

    public boolean isIllegal() {
        return isIllegal;
    }

    public Character getSign() {
        return sign;
    }

    public void setSign(Character sign) {
        this.sign = sign;
    }

    public Number getValue() {
        return value;
    }

    public void setValue(Number value) {
        this.value = value;
    }

    public void setIllegal(boolean illegal) {
        isIllegal = illegal;
    }
}
