package com.yl.builder;

public interface Builder<T> {

    Builder<T> buildAll();

    T build();

}
