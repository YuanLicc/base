package com.yl.common.string.exception;

/**
 * {@code String} 转换为Number异常
 * @see String
 * @see Number
 *
 * @author YuanLi
 */
public class StringConvertToNumberException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public StringConvertToNumberException() {
        super();
    }

    public StringConvertToNumberException(String message) {
        super(message);
    }

    public StringConvertToNumberException(Throwable cause) {
        super(cause);
    }

    public StringConvertToNumberException(String message, Throwable cause) {
        super(message, cause);
    }
}
