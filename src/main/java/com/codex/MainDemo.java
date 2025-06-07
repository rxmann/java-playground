package com.codex;

import com.codex.exceptions.ExceptionHandlingDemo;

/**
 * Main demonstration class that shows how to use all implemented concepts
 */
public class MainDemo {
    public static void main(String[] args) {
        System.out.println("=== Java Core Concepts Demo ===\n");

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