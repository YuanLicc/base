package com.yl.expection;

public class IllegalExpressionException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public IllegalExpressionException() {
        super();
    }

    public IllegalExpressionException(String message) {
        super(message);
    }

    public IllegalExpressionException(Throwable cause) {
        super(cause);
    }

    public IllegalExpressionException(String message, Throwable cause) {
        super(message, cause);
    }
}
