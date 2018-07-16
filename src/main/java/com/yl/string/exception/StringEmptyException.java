package com.yl.string.exception;

/**
 * 字符串为空异常，这里的空不是{@link NullPointerException}，而是指
 * {@code string.trim().equals("")}
 *
 * @author YuanLi
 */
public class StringEmptyException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public StringEmptyException() {
        super();
    }

    public StringEmptyException(String message) {
        super(message);
    }

    public StringEmptyException(Throwable cause) {
        super(cause);
    }

    public StringEmptyException(String message, Throwable cause) {
        super(message, cause);
    }
}
