package com.codex.core.c_exceptions;

public class ExceptionExample {
    public static void main(String[] args) {
        try {
            int a = 10 / 0;  // This will throw ArithmeticException
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero!");
        } finally {
            System.out.println("This always runs.");
        }
    }
}

