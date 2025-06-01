package com.codex.core.a_basics;

public class SyntaxAndBasics {
    public static void main(String[] args) {
        // Variables
        int age = 25;
        double price = 19.99;
        String name = "Alice";
        boolean isStudent = true;

        // Conditional
        if (age >= 18) {
            System.out.println(name + " is an adult.");
        }

        // Loops
        for (int i = 0; i < 3; i++) {
            System.out.println("Loop #" + i);
        }

        // Array
        int[] numbers = {1, 2, 3};
        for (int n : numbers) {
            System.out.println("Number: " + n);
        }
    }
}

