package com.yl.common.parse;

public interface Parser<T, R> {
    R parse(T parsed);
}
