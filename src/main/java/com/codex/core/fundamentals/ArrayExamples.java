package com.codex.core.fundamentals;

import java.util.Arrays;

/**
 * This class demonstrates array concepts in Java:
 * - Array declaration and initialization
 * - Single and multidimensional arrays
 * - Array operations and methods
 * - Array iteration
 * - Array utility methods
 */
public class ArrayExamples {
    public static void main(String[] args) {
        // 1. Array Declaration and Initialization
        System.out.println("=== Array Declaration and Initialization ===");
        
        // Declaration
        int[] numbers;                 // Preferred syntax
        int scores[];                  // Alternative syntax
        
        // Initialization
        numbers = new int[5];          // Creates array of size 5 with default values
        scores = new int[]{90, 85, 88, 92, 95};  // Initialize with values
        
        // Declaration and initialization in one line
        int[] grades = {95, 88, 90, 87, 93};     // Array literal
        
        System.out.println("Scores array: " + Arrays.toString(scores));
        System.out.println("Grades array: " + Arrays.toString(grades));

        // 2. Accessing and Modifying Array Elements
        System.out.println("\n=== Accessing and Modifying Array Elements ===");
        System.out.println("First score: " + scores[0]);
        System.out.println("Last score: " + scores[scores.length - 1]);
        
        // Modifying elements
        scores[1] = 89;
        System.out.println("Modified scores array: " + Arrays.toString(scores));
        
        // Array length
        System.out.println("Array length: " + scores.length);

        // 3. Array Iteration
        System.out.println("\n=== Array Iteration ===");
        
        // Using for loop
        System.out.print("Using for loop: ");
        for (int i = 0; i < grades.length; i++) {
            System.out.print(grades[i] + " ");
        }
        System.out.println();
        
        // Using enhanced for loop
        System.out.print("Using enhanced for loop: ");
        for (int grade : grades) {
            System.out.print(grade + " ");
        }
        System.out.println();

        // 4. Multidimensional Arrays
        System.out.println("\n=== Multidimensional Arrays ===");
        
        // 2D array declaration and initialization
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        
        // Accessing 2D array elements
        System.out.println("Matrix:");
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
        
        // 3D array example
        int[][][] cube = new int[2][2][2];
        cube[0][0][0] = 1;
        System.out.println("\n3D array element: " + cube[0][0][0]);

        // 5. Array Utility Methods
        System.out.println("\n=== Array Utility Methods ===");
        
        // Sorting
        int[] numbersToSort = {5, 2, 8, 1, 9};
        System.out.println("Before sorting: " + Arrays.toString(numbersToSort));
        Arrays.sort(numbersToSort);
        System.out.println("After sorting: " + Arrays.toString(numbersToSort));
        
        // Binary search (array must be sorted)
        int key = 8;
        int index = Arrays.binarySearch(numbersToSort, key);
        System.out.println("Found " + key + " at index: " + index);
        
        // Fill
        int[] filledArray = new int[5];
        Arrays.fill(filledArray, 10);
        System.out.println("Filled array: " + Arrays.toString(filledArray));
        
        // Copy
        int[] copyOfGrades = Arrays.copyOf(grades, grades.length);
        System.out.println("Copied array: " + Arrays.toString(copyOfGrades));
        
        // Compare
        boolean areEqual = Arrays.equals(grades, copyOfGrades);
        System.out.println("Arrays are equal: " + areEqual);

        // 6. Common Array Operations
        System.out.println("\n=== Common Array Operations ===");
        
        // Finding maximum value
        int max = findMax(scores);
        System.out.println("Maximum score: " + max);
        
        // Finding minimum value
        int min = findMin(scores);
        System.out.println("Minimum score: " + min);
        
        // Calculating average
        double average = calculateAverage(scores);
        System.out.println("Average score: " + average);
    }
    
    // Helper methods for array operations
    private static int findMax(int[] array) {
        int max = array[0];
        for (int value : array) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }
    
    private static int findMin(int[] array) {
        int min = array[0];
        for (int value : array) {
            if (value < min) {
                min = value;
            }
        }
        return min;
    }
    
    private static double calculateAverage(int[] array) {
        int sum = 0;
        for (int value : array) {
            sum += value;
        }
        return (double) sum / array.length;
    }
} 