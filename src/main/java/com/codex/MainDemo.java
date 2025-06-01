package com.codex;

import com.codex.core.fundamentals.JavaFundamentals;
import com.codex.exceptions.ExceptionHandlingDemo;

/**
 * Main demonstration class that shows how to use all implemented concepts
 */
public class MainDemo {
    public static void main(String[] args) {
        System.out.println("=== Java Core Concepts Demo ===\n");

        // 1. Java Fundamentals
        System.out.println("1. Running Java Fundamentals Demo:");
        System.out.println("--------------------------------");
        JavaFundamentals.main(args);

        // 2. OOP Concepts
        System.out.println("\n2. Running OOP Concepts Demo:");
        System.out.println("----------------------------");

        // 3. Exception Handling
        System.out.println("\n3. Running Exception Handling Demo:");
        System.out.println("---------------------------------");
        ExceptionHandlingDemo.main(args);

        System.out.println("\n=== Demo Complete ===");
    }
} 