package com.codex.core.fundamentals;

/**
 * This class demonstrates control flow statements in Java:
 * - if-else statements
 * - switch statements
 * - loops (for, while, do-while)
 * - break and continue
 * - return statements
 */
public class ControlFlow {
    public static void main(String[] args) {
        // 1. if-else Statements
        System.out.println("=== If-Else Statements ===");
        int number = 10;
        
        // Simple if
        if (number > 0) {
            System.out.println(number + " is positive");
        }
        
        // if-else
        if (number % 2 == 0) {
            System.out.println(number + " is even");
        } else {
            System.out.println(number + " is odd");
        }
        
        // if-else-if ladder
        if (number > 0) {
            System.out.println(number + " is positive");
        } else if (number < 0) {
            System.out.println(number + " is negative");
        } else {
            System.out.println(number + " is zero");
        }
        
        // Nested if
        if (number > 0) {
            if (number % 2 == 0) {
                System.out.println(number + " is positive and even");
            }
        }

        // 2. Switch Statement
        System.out.println("\n=== Switch Statement ===");
        int day = 4;
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
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
            case 7:
                System.out.println("Weekend");
                break;
            default:
                System.out.println("Invalid day");
        }

        // 3. For Loops
        System.out.println("\n=== For Loops ===");
        // Simple for loop
        System.out.print("Simple for loop: ");
        for (int i = 1; i <= 5; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        // Enhanced for loop (for-each)
        System.out.print("Enhanced for loop: ");
        int[] numbers = {1, 2, 3, 4, 5};
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println();

        // 4. While Loop
        System.out.println("\n=== While Loop ===");
        int count = 1;
        System.out.print("While loop: ");
        while (count <= 5) {
            System.out.print(count + " ");
            count++;
        }
        System.out.println();

        // 5. Do-While Loop
        System.out.println("\n=== Do-While Loop ===");
        count = 1;
        System.out.print("Do-while loop: ");
        do {
            System.out.print(count + " ");
            count++;
        } while (count <= 5);
        System.out.println();

        // 6. Break and Continue
        System.out.println("\n=== Break and Continue ===");
        // Break example
        System.out.print("Break example: ");
        for (int i = 1; i <= 10; i++) {
            if (i == 6) break;
            System.out.print(i + " ");
        }
        System.out.println();

        // Continue example
        System.out.print("Continue example: ");
        for (int i = 1; i <= 5; i++) {
            if (i == 3) continue;
            System.out.print(i + " ");
        }
        System.out.println();

        // 7. Labeled Statements
        System.out.println("\n=== Labeled Statements ===");
        outerLoop: for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                if (i == 2 && j == 2) {
                    System.out.println("Breaking outer loop when i=" + i + " and j=" + j);
                    break outerLoop;
                }
                System.out.println("i=" + i + ", j=" + j);
            }
        }

        // 8. Return Statement
        System.out.println("\n=== Return Statement ===");
        System.out.println("Sum of 5 and 3 is: " + sum(5, 3));
    }

    // Method demonstrating return statement
    private static int sum(int a, int b) {
        return a + b;
    }
} 