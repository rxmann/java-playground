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
public class A_Variables {
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

    public A_Variables(String name) {
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
        System.out.println();
        A_Variables vars = new A_Variables("Instance");
        System.out.println("Instance variable: " + vars.instanceVar);
        System.out.println();

        // Demonstrating variable scope
        vars.demonstrateVariableScope();
        System.out.println();
        
        // Demonstrating naming conventions
        vars.demonstrateNamingConventions();
        
        // Variable declaration styles
        int a, b, c;           // multiple declarations
        int d = 1, e = 2;      // multiple declarations with initialization

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


        System.out.println();
        System.out.println("=== Primitive Types ===");
        System.out.println("byte: " + byteVar);
        System.out.println("short: " + shortVar);
        System.out.println("int: " + intVar);
        System.out.println("long: " + longVar);
        System.out.println("float: " + floatVar);
        System.out.println("double: " + doubleVar);
        System.out.println("char: " + charVar);
        System.out.println("boolean: " + boolVar);
        
        // Type inference with var (Java 10+)
        // var number = 42;     // type inference
        // var message = "Hello"; // type inference

    }
} 