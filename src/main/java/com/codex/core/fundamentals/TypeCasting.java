package com.codex.core.fundamentals;

/**
 * This class demonstrates type casting in Java:
 * - Widening (Automatic) Type Casting
 * - Narrowing (Manual) Type Casting
 * - Type Promotion in Expressions
 * - Object Type Casting
 */
public class TypeCasting {
    public static void main(String[] args) {
        // Widening Type Casting (Automatic)
        System.out.println("=== Widening Type Casting ===");
        byte byteValue = 100;
        short shortValue = byteValue;      // byte to short
        int intValue = shortValue;         // short to int
        long longValue = intValue;         // int to long
        float floatValue = longValue;      // long to float
        double doubleValue = floatValue;   // float to double

        System.out.println("Byte value: " + byteValue);
        System.out.println("Short value: " + shortValue);
        System.out.println("Int value: " + intValue);
        System.out.println("Long value: " + longValue);
        System.out.println("Float value: " + floatValue);
        System.out.println("Double value: " + doubleValue);

        // Narrowing Type Casting (Manual)
        System.out.println("\n=== Narrowing Type Casting ===");
        double doubleNum = 123.456;
        float floatNum = (float) doubleNum;    // double to float
        long longNum = (long) floatNum;        // float to long
        int intNum = (int) longNum;            // long to int
        short shortNum = (short) intNum;       // int to short
        byte byteNum = (byte) shortNum;        // short to byte

        System.out.println("Double number: " + doubleNum);
        System.out.println("Float number: " + floatNum);
        System.out.println("Long number: " + longNum);
        System.out.println("Int number: " + intNum);
        System.out.println("Short number: " + shortNum);
        System.out.println("Byte number: " + byteNum);

        // Type Promotion in Expressions
        System.out.println("\n=== Type Promotion in Expressions ===");
        byte b1 = 50;
        byte b2 = 100;
        int result = b1 * b2;  // bytes are promoted to int in arithmetic operations
        System.out.println("Byte multiplication result (promoted to int): " + result);

        // Potential Data Loss Example
        System.out.println("\n=== Potential Data Loss Examples ===");
        int largeInt = 130;
        byte smallByte = (byte) largeInt;  // Possible data loss
        System.out.println("Original int value: " + largeInt);
        System.out.println("After casting to byte: " + smallByte);

        double pi = 3.14159;
        int roundedPi = (int) pi;  // Loses decimal part
        System.out.println("Original double value: " + pi);
        System.out.println("After casting to int: " + roundedPi);

        // Character and Number Type Casting
        System.out.println("\n=== Character and Number Type Casting ===");
        char ch = 'A';
        int asciiValue = ch;  // char to int (gets ASCII value)
        System.out.println("Character: " + ch);
        System.out.println("ASCII value: " + asciiValue);

        int number = 66;
        char character = (char) number;  // int to char
        System.out.println("Number: " + number);
        System.out.println("Character: " + character);

        // String Conversion
        System.out.println("\n=== String Conversion ===");
        String strNumber = "123";
        int convertedInt = Integer.parseInt(strNumber);
        double convertedDouble = Double.parseDouble("123.456");
        
        System.out.println("String to int: " + convertedInt);
        System.out.println("String to double: " + convertedDouble);
        
        // Converting back to String
        String backToString = String.valueOf(convertedInt);
        String doubleString = String.valueOf(convertedDouble);
        
        System.out.println("Back to String from int: " + backToString);
        System.out.println("Back to String from double: " + doubleString);
    }
} 