package com.yl.validate;

/**
 * 验证器接口，抽象了验证器的行为
 * @param <T> 验证的对象的类型
 */
public interface Validator<T> {

    /**
     * 验证，不应该在此方法内抛出异常
     * @param validated 被验证对象
     * @return 验证通过返回true，否则返回false
     */
    boolean validate(T validated);

}
