package com.yl.common.builder;

public interface Builder<T> {

    Builder<T> buildAll();

    T build();

}
