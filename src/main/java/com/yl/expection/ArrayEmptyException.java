package com.yl.expection;

public class ArrayEmptyException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ArrayEmptyException() {
        super();
    }

    public ArrayEmptyException(String message) {
        super(message);
    }

    public ArrayEmptyException(Throwable cause) {
        super(cause);
    }

    public ArrayEmptyException(String message, Throwable cause) {
        super(message, cause);
    }
}
