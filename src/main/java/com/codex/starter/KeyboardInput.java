package com.codex.starter;

import java.util.Scanner;


public class KeyboardInput {
    public static void main(String[] args) {
        String name;
        int age;
        int $home;
        $home = 69;

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your name: ");
        name = sc.nextLine();
        System.out.println("Enter your age: ");
        age = sc.nextInt();

        System.out.println("Your name is " + name + " and your age is " + age);

        System.out.println($home);

        // Literals are constant values used in a program: values used to initialize a variable

    }
}
