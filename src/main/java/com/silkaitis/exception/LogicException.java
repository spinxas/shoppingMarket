package com.silkaitis.exception;

/**
 * Defined exception.
 */
public class LogicException extends Exception {

    public LogicException(String message, Throwable cause) {
        super(message, cause);
    }

    public LogicException(String message) {
        super(message);
    }
}
