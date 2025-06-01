package com.codex.core;

public class Conditionals01 {

    public static String reverse(int num) {
        String reversed = "";
        while (num != 0) {
            int digit = num % 10;  // Extract the last digit
            reversed += digit;  // Add it to the reversed number
            num /= 10;  // Remove the last digit from the number
        }
        return reversed;
    }

    public static void calculateFibonacci(int n) {
        int a = 0, b = 1;

        for (int i = 1; i < n; i++) {
            System.out.print(a + " ");
            a = a + b;
            b = a - b;
        }
    }


    public static void main(String[] args) {
        int num = 1280900;
        String reversed =  reverse (num);
        System.out.println("Reversed: " + reversed);


        calculateFibonacci(10);


    }
}
