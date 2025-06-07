package com.codex.core.fundamentals;

/**
 * This class demonstrates all types of operators in Java:
 * - Arithmetic Operators
 * - Relational Operators
 * - Logical Operators
 * - Bitwise Operators
 * - Assignment Operators
 * - Unary Operators
 * - Ternary Operator
 */
public class D_Operators {
    public static void main(String[] args) {
        // 1. Arithmetic Operators
        System.out.println("=== Arithmetic Operators ===");
        int a = 10, b = 3;
        System.out.println("a = " + a + ", b = " + b);
        System.out.println("Addition: a + b = " + (a + b));
        System.out.println("Subtraction: a - b = " + (a - b));
        System.out.println("Multiplication: a * b = " + (a * b));
        System.out.println("Division: a / b = " + (a / b));
        System.out.println("Modulus: a % b = " + (a % b));

        // 2. Relational Operators
        System.out.println("\n=== Relational Operators ===");
        System.out.println("Equal to: a == b is " + (a == b));
        System.out.println("Not equal to: a != b is " + (a != b));
        System.out.println("Greater than: a > b is " + (a > b));
        System.out.println("Less than: a < b is " + (a < b));
        System.out.println("Greater than or equal to: a >= b is " + (a >= b));
        System.out.println("Less than or equal to: a <= b is " + (a <= b));

        // 3. Logical Operators
        System.out.println("\n=== Logical Operators ===");
        boolean x = true, y = false;
        System.out.println("x = " + x + ", y = " + y);
        System.out.println("Logical AND: x && y = " + (x && y));
        System.out.println("Logical OR: x || y = " + (x || y));
        System.out.println("Logical NOT: !x = " + (!x));

        // 4. Bitwise Operators
        System.out.println("\n=== Bitwise Operators ===");
        int num1 = 5;  // 101 in binary
        int num2 = 3;  // 011 in binary
        System.out.println("num1 = " + num1 + " (binary: " + Integer.toBinaryString(num1) + ")");
        System.out.println("num2 = " + num2 + " (binary: " + Integer.toBinaryString(num2) + ")");
        System.out.println("Bitwise AND: num1 & num2 = " + (num1 & num2));
        System.out.println("Bitwise OR: num1 | num2 = " + (num1 | num2));
        System.out.println("Bitwise XOR: num1 ^ num2 = " + (num1 ^ num2));
        System.out.println("Bitwise NOT: ~num1 = " + (~num1));
        System.out.println("Left shift: num1 << 1 = " + (num1 << 1));
        System.out.println("Right shift: num1 >> 1 = " + (num1 >> 1));
        System.out.println("Unsigned right shift: num1 >>> 1 = " + (num1 >>> 1));

        // 5. Assignment Operators
        System.out.println("\n=== Assignment Operators ===");
        int c = 10;
        System.out.println("Original value: c = " + c);
        c += 5;  // c = c + 5
        System.out.println("After c += 5: c = " + c);
        c -= 3;  // c = c - 3
        System.out.println("After c -= 3: c = " + c);
        c *= 2;  // c = c * 2
        System.out.println("After c *= 2: c = " + c);
        c /= 4;  // c = c / 4
        System.out.println("After c /= 4: c = " + c);
        c %= 3;  // c = c % 3
        System.out.println("After c %= 3: c = " + c);

        // 6. Unary Operators
        System.out.println("\n=== Unary Operators ===");
        int d = 10;
        System.out.println("d = " + d);
        System.out.println("Postfix increment: d++ = " + d++);
        System.out.println("After postfix increment: d = " + d);
        System.out.println("Prefix increment: ++d = " + ++d);
        System.out.println("Postfix decrement: d-- = " + d--);
        System.out.println("After postfix decrement: d = " + d);
        System.out.println("Prefix decrement: --d = " + --d);

        // 7. Ternary Operator
        System.out.println("\n=== Ternary Operator ===");
        int age = 21;
        String status = (age >= 22) ? "Adult" : "Minor";
        System.out.println("Age = " + age);
        System.out.println("Status = " + status);

        // 8. Operator Precedence Example
        System.out.println("\n=== Operator Precedence ===");
        int result = 10 + 2 * 3 - 4 / 2;
        System.out.println("10 + 2 * 3 - 4 / 2 = " + result);
        System.out.println("Evaluation order:");
        System.out.println("1. 2 * 3 = 6");
        System.out.println("2. 4 / 2 = 2");
        System.out.println("3. 10 + 6 - 2 = 14");
    }
} 