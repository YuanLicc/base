package com.yl.common.converter;

/**
 * 单向转换器抽象接口，将源对象转换为目标对象
 * @param <A> 目标对象
 * @param <S> 被转换对象
 */
public interface Converter<S, A> {

    /**
     * 转换
     * @param source 源对象
     * @return 目标对象
     */
    A convert(S converted);

}
