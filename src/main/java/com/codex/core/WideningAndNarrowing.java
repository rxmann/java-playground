package com.codex.core;

public class WideningAndNarrowing {

    public static void main(String[] args) {

        // widening: Converting a smaller data type to a larger data type, usually automatically by the compiler.
        // Example: byte to short, int to long, float to double.
        // UP
        // CASTING
        byte byteVal = 2; // 1 byte
        short shortVal = byteVal; // 2 bytes

        System.out.println(shortVal + " : " + byteVal);

        // narrowing: Converting a larger data type to a smaller data type, often requires explicit casting.
        // Example: double to float, long to int, or int to byte.
        // DOWN CASTING
        double doubleVal = 12.90; // 8 bytes
        float floatVal = (float) doubleVal; // 4 bytes

        System.out.println(floatVal + " : " + doubleVal);

    }

}
