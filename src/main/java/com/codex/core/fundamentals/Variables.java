package com.codex.core.fundamentals;

/**
 * This class demonstrates variables in Java:
 * - Variable types (instance, static, local)
 * - Variable scope
 * - Naming conventions
 * - Constants
 * - Variable initialization
 * - Variable shadowing
 */
public class Variables {
    // Instance variables (non-static fields)
    private int instanceVar = 1;            // instance variable
    private String name;                    // instance variable with default value (null)
    
    // Static variables (class variables)
    private static int staticVar = 2;       // static variable
    
    // Constants (static final variables)
    public static final double PI = 3.14159;  // constant
    public static final String APP_NAME = "Demo";
    
    // Static initialization block
    static {
        System.out.println("Static initialization block");
        staticVar = 10;
    }
    
    // Instance initialization block
    {
        System.out.println("Instance initialization block");
        instanceVar = 5;
    }

    public Variables(String name) {
        this.name = name;  // 'this' refers to instance variable
    }

    public void demonstrateVariableScope() {
        // Local variable
        int localVar = 3;  // must be initialized before use
        
        // Block scope
        {
            int blockVar = 4;  // only accessible within this block
            System.out.println("Block variable: " + blockVar);
        }
        // blockVar is not accessible here
        
        // Variable shadowing
        String name = "Local";  // shadows instance variable 'name'
        System.out.println("Local name: " + name);
        System.out.println("Instance name: " + this.name);
        
        // Loop variable scope
        for (int i = 0; i < 3; i++) {
            System.out.println("Loop variable i: " + i);
        }
        // i is not accessible here
    }

    public void demonstrateNamingConventions() {
        // Camel case for variables
        String firstName = "John";
        String lastName = "Doe";
        
        // Underscore in numeric literals (Java 7+)
        int million = 1_000_000;
        
        // Valid but not recommended
        int _;  // single underscore (not recommended)
        int $price;  // dollar sign
        
        // Constants in method
        final int MAX_SIZE = 100;
        final String ERROR_MESSAGE = "Error occurred";
        
        System.out.println("Naming conventions demonstration:");
        System.out.println("Full name: " + firstName + " " + lastName);
        System.out.println("Million: " + million);
    }

    public static void main(String[] args) {
        System.out.println("=== Variable Types and Scope ===");
        
        // Accessing static variable
        System.out.println("Static variable: " + staticVar);
        System.out.println("Constant PI: " + PI);
        
        // Creating instance
        Variables vars = new Variables("Instance");
        System.out.println("Instance variable: " + vars.instanceVar);
        
        // Demonstrating variable scope
        vars.demonstrateVariableScope();
        
        // Demonstrating naming conventions
        vars.demonstrateNamingConventions();
        
        // Variable declaration styles
        int a, b, c;           // multiple declarations
        int d = 1, e = 2;      // multiple declarations with initialization
        
        // Type inference with var (Java 10+)
        // var number = 42;     // type inference
        // var message = "Hello"; // type inference
        
        // Array declaration styles
        int[] numbers = new int[5];
        String[] names = {"Alice", "Bob", "Charlie"};
        
        System.out.println("\n=== Array Initialization ===");
        for (String n : names) {
            System.out.println(n);
        }
    }
} 