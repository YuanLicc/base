package com.yl.parse;

public interface Parser<T, R> {
    R parse(T parsed);
}
