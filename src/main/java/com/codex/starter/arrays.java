package com.codex.starter;

public class arrays {

    public static void print2DArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {

        int[][] mat1 = {{1, 2}, {2, 1}};
        int[][] mat2 = {{2, 1}, {1, 2}};

        print2DArray(mat1);
        System.out.println(' ');
        print2DArray(mat2);

        for (int i = 0; i < mat1.length; i++) {
            for (int j = 0; j < mat1[i].length; j++) {
                for (int k = 0; k < mat1.length; k++) {
                    System.out.println(mat1[i][j] + " * " + mat2[k][j] + " = " + mat1[i][k] * mat2[j][k]);
                }
            }
        }


    }
}
