package com.codex.core.fundamentals;

/**
 * This class demonstrates String handling in Java:
 * - String creation and initialization
 * - String methods
 * - String comparison
 * - String manipulation
 * - StringBuilder and StringBuffer
 */
public class B_Strings {
    public static void main(String[] args) {
        // 1. String Creation and Initialization
        System.out.println("=== String Creation and Initialization ===");
        String str1 = "Hello";                     // String literal
        String str2 = new String("Hello");         // Using constructor
        String str3 = String.valueOf(123);         // Using valueOf
        String str4 = "hello";

        System.out.println("str1: " + str1);
        System.out.println("str2: " + str2);
        System.out.println("str3: " + str3);
        System.out.println("str4: " + str4);


        // 2. String Comparison
        System.out.println("\n=== String Comparison ===");
        System.out.println("str1 equals str2: " + str1.equals(str2));
        System.out.println("str1 == str2: " + (str1 == str2));
        System.out.println("str1 equalsIgnoreCase str4: " + str1.equalsIgnoreCase(str4));
        System.out.println("str1 compareTo str4: " + str1.compareTo(str4));

        // 3. String Methods
        System.out.println("\n=== String Methods ===");
        String text = "Java Programming";
        
        // Length
        System.out.println("Length: " + text.length());
        
        // Case conversion
        System.out.println("Uppercase: " + text.toUpperCase());
        System.out.println("Lowercase: " + text.toLowerCase());
        
        // Substring
        System.out.println("Substring(0,4): " + text.substring(0, 4));
        System.out.println("Substring(5): " + text.substring(5));
        
        // Character extraction
        System.out.println("charAt(0): " + text.charAt(0));
        
        // Index finding
        System.out.println("indexOf('a'): " + text.indexOf('a'));
        System.out.println("lastIndexOf('a'): " + text.lastIndexOf('a'));

        // 4. String Manipulation
        System.out.println("\n=== String Manipulation ===");
        
        // Concatenation
        String firstName = "John";
        String lastName = "Doe";
        String fullName = firstName + " " + lastName;
        System.out.println("Concatenation using +: " + fullName);
        
        String concatName = firstName.concat(" ").concat(lastName);
        System.out.println("Concatenation using concat(): " + concatName);
        
        // Replace
        String original = "Hello World";
        String replaced = original.replace('l', 'w');
        System.out.println("Replace: " + replaced);
        
        // Trim
        String spacedText = "   Trim Example   ";
        System.out.println("Original: '" + spacedText + "'");
        System.out.println("Trimmed: '" + spacedText.trim() + "'");
        
        // Split
        String csvText = "apple,banana,orange";
        String[] fruits = csvText.split(",");
        System.out.print("Split result: ");
        for (String fruit : fruits) {
            System.out.print(fruit + " ");
        }
        System.out.println();

        // 5. StringBuilder and StringBuffer
        System.out.println("\n=== StringBuilder and StringBuffer ===");
        
        // StringBuilder (not thread-safe, but faster)
        StringBuilder builder = new StringBuilder();
        builder.append("Hello");
        builder.append(" ");
        builder.append("World");
        System.out.println("StringBuilder result: " + builder.toString());
        
        // StringBuilder methods
        builder.insert(5, "!");
        System.out.println("After insert: " + builder);
        builder.reverse();
        System.out.println("After reverse: " + builder);
        builder.delete(5, 6);
        System.out.println("After delete: " + builder);
        
        // StringBuffer (thread-safe)
        StringBuffer buffer = new StringBuffer();
        buffer.append("Thread");
        buffer.append("-");
        buffer.append("Safe");
        System.out.println("StringBuffer result: " + buffer.toString());

        // 6. String Performance
        System.out.println("\n=== String Performance Example ===");
        long startTime = System.nanoTime();
        
        StringBuffer sbffer = new StringBuffer();
        for (int i = 0; i < 100000; i++) {
            sbffer.append("a");
        }
        
        long endTime = System.nanoTime();
        System.out.println("Time taken with String concatenation: " + 
                          (endTime - startTime) / 1000000.0 + " ms");
        
        startTime = System.nanoTime();
        
        StringBuilder efficientBuilder = new StringBuilder();
        for (int i = 0; i < 100000; i++) {
            efficientBuilder.append("a");
        }
        
        endTime = System.nanoTime();
        System.out.println("Time taken with StringBuilder: " + 
                          (endTime - startTime) / 1000000.0 + " ms");
    }
}
