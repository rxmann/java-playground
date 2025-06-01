package com.codex.core.fundamentals;

/**
 * This class demonstrates core Java fundamentals including:
 * - Data types and variables
 * - Operators
 * - Control flow statements
 */
public class JavaFundamentals {
    public static void main(String[] args) {
        // Data Types and Variables
        // Primitive Types
        byte byteVar = 127;
        short shortVar = 32767;
        int intVar = 2147483647;
        long longVar = 9223372036854775807L;
        float floatVar = 3.14f;
        double doubleVar = 3.14159265359;
        char charVar = 'A';
        boolean boolVar = true;

        System.out.println("=== Primitive Types ===");
        System.out.println("byte: " + byteVar);
        System.out.println("short: " + shortVar);
        System.out.println("int: " + intVar);
        System.out.println("long: " + longVar);
        System.out.println("float: " + floatVar);
        System.out.println("double: " + doubleVar);
        System.out.println("char: " + charVar);
        System.out.println("boolean: " + boolVar);

        // Operators
        System.out.println("\n=== Operators ===");
        // Arithmetic operators
        int a = 10, b = 3;
        System.out.println("Arithmetic: " + a + " + " + b + " = " + (a + b));
        System.out.println("Arithmetic: " + a + " - " + b + " = " + (a - b));
        System.out.println("Arithmetic: " + a + " * " + b + " = " + (a * b));
        System.out.println("Arithmetic: " + a + " / " + b + " = " + (a / b));
        System.out.println("Arithmetic: " + a + " % " + b + " = " + (a % b));

        // Logical operators
        boolean x = true, y = false;
        System.out.println("Logical: " + x + " && " + y + " = " + (x && y));
        System.out.println("Logical: " + x + " || " + y + " = " + (x || y));
        System.out.println("Logical: !" + x + " = " + (!x));

        // Control Flow Statements
        System.out.println("\n=== Control Flow ===");
        // if-else
        int number = 7;
        if (number > 0) {
            System.out.println(number + " is positive");
        } else if (number < 0) {
            System.out.println(number + " is negative");
        } else {
            System.out.println(number + " is zero");
        }

        // switch-case
        int day = 3;
        switch (day) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            default:
                System.out.println("Other day");
        }

        // Loops
        System.out.println("\n=== Basic Loops ===");
        // for loop example
        System.out.print("Counting: ");
        for (int i = 1; i <= 5; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
} 