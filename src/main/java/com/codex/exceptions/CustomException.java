package com.codex.exceptions;

/**
 * Custom exception class demonstrating:
 * - Creating custom exceptions
 * - Extending Exception class
 */
public class CustomException extends Exception {
    public CustomException(String message) {
        super(message);
    }

    public CustomException(String message, Throwable cause) {
        super(message, cause);
    }
} 