package com.codex.exceptions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Class demonstrating exception handling concepts:
 * - try-catch blocks
 * - multiple catch blocks
 * - finally block
 * - try-with-resources
 * - throws keyword
 * - custom exceptions
 */
public class ExceptionHandlingDemo {
    public static void main(String[] args) {
        ExceptionHandlingDemo demo = new ExceptionHandlingDemo();

        // Basic try-catch
        try {
            demo.divideNumbers(10, 0);
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic Exception caught: " + e.getMessage());
        }

        // Multiple catch blocks
        try {
            int[] arr = new int[5];
            arr[10] = 50; // ArrayIndexOutOfBoundsException
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array index out of bounds: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Generic exception: " + e.getMessage());
        }

        // try-catch-finally
        try {
            demo.checkAge(15);
        } catch (CustomException e) {
            System.out.println("Custom Exception: " + e.getMessage());
        } finally {
            System.out.println("Finally block always executes");
        }

        // try-with-resources
        try {
            demo.readFile("example.txt");
        } catch (IOException e) {
            System.out.println("IO Exception: " + e.getMessage());
        }
    }

    // Method that throws an arithmetic exception
    private int divideNumbers(int a, int b) {
        return a / b;
    }

    // Method that throws custom exception
    private void checkAge(int age) throws CustomException {
        if (age < 18) {
            throw new CustomException("Person is not eligible to vote");
        }
        System.out.println("Person is eligible to vote!!");
    }

    // Method demonstrating try-with-resources
    private void readFile(String filename) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                line = reader.readLine();
            }
        }
    }
} 