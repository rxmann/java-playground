package com.codex.core.fundamentals;

import java.util.Scanner;

/**
 * This class demonstrates keyboard input handling in Java:
 * - Using Scanner class
 * - Reading different data types
 * - Input validation
 * - Handling input errors
 */
public class KeyboardInput {
    public static void main(String[] args) {
        // Create Scanner object for reading input
        Scanner scanner = new Scanner(System.in);

        // 1. Reading Strings
        System.out.println("=== Reading Strings ===");
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.println("Hello, " + name + "!");

        // 2. Reading Numbers
        System.out.println("\n=== Reading Numbers ===");
        
        // Reading integer
        System.out.print("Enter your age: ");
        try {
            int age = scanner.nextInt();
            System.out.println("You are " + age + " years old.");
        } catch (Exception e) {
            System.out.println("Invalid age input!");
            scanner.nextLine(); // Clear the invalid input
        }

        // Reading double
        System.out.print("Enter your height in meters: ");
        try {
            double height = scanner.nextDouble();
            System.out.printf("Your height is %.2f meters%n", height);
        } catch (Exception e) {
            System.out.println("Invalid height input!");
            scanner.nextLine(); // Clear the invalid input
        }

        // Note: After reading a number, we need to consume the newline
        scanner.nextLine();

        // 3. Reading with Validation
        System.out.println("\n=== Reading with Validation ===");
        
        // Reading a positive number
        int positiveNumber = 0;
        boolean validInput = false;
        
        while (!validInput) {
            System.out.print("Enter a positive number: ");
            try {
                positiveNumber = Integer.parseInt(scanner.nextLine());
                if (positiveNumber > 0) {
                    validInput = true;
                } else {
                    System.out.println("Please enter a number greater than 0!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid number.");
            }
        }
        System.out.println("You entered: " + positiveNumber);

        // 4. Reading Multiple Values
        System.out.println("\n=== Reading Multiple Values ===");
        System.out.print("Enter three numbers separated by spaces: ");
        try {
            int num1 = scanner.nextInt();
            int num2 = scanner.nextInt();
            int num3 = scanner.nextInt();
            System.out.printf("You entered: %d, %d, and %d%n", num1, num2, num3);
        } catch (Exception e) {
            System.out.println("Invalid input! Please enter three valid numbers.");
            scanner.nextLine(); // Clear the invalid input
        }

        // 5. Reading Until a Sentinel Value
        System.out.println("\n=== Reading Until Sentinel Value ===");
        System.out.println("Enter words (type 'quit' to stop):");
        
        String input;
        while (true) {
            input = scanner.nextLine();
            if (input.equalsIgnoreCase("quit")) {
                break;
            }
            System.out.println("You entered: " + input);
        }

        // 6. Reading with Pattern Matching
        System.out.println("\n=== Reading with Pattern Matching ===");
        System.out.print("Enter a date (MM/DD/YYYY): ");
        String date = scanner.nextLine();
        if (date.matches("\\d{2}/\\d{2}/\\d{4}")) {
            System.out.println("Valid date format!");
        } else {
            System.out.println("Invalid date format! Use MM/DD/YYYY");
        }

        // 7. Reading Characters
        System.out.println("\n=== Reading Characters ===");
        System.out.print("Enter a single character: ");
        String charInput = scanner.nextLine();
        if (charInput.length() == 1) {
            char ch = charInput.charAt(0);
            System.out.println("You entered: " + ch);
        } else {
            System.out.println("Please enter only one character!");
        }

        // Close the scanner
        scanner.close();
        
        // Note: After closing the scanner, you cannot use it again
        System.out.println("\nInput demonstration completed!");
    }
}
