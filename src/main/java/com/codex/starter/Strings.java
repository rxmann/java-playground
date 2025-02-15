package com.codex.starter;

import java.util.Scanner;

public class Strings {
    public static void main(String[] args) {

        // System.out: A reference to the standard output stream (usually the console).
        // It is an instance of the PrintStream class, which provides methods like print() and println() to output data.

        String str = "Hi, My name is Codex!";

        System.out.println(str);
        System.out.println(str.length());
        System.out.println(str.toLowerCase());

        // Formatted output: printf(string with format specifiers, values)
        System.out.printf(str + " It's length is %d letters.\n", str.length());
        String name = "Alice";
        int age = 25;
        double height = 5.7;
        boolean isStudent = true;

        System.out.printf("Name: %s, Age: %d, Height: %.2f, Student: %b\n", name, age, height, isStudent);
        System.out.printf("The string '%s' has %d characters.\n", str, str.length());
        double price = 59.99;
        System.out.printf("The price is $%.2f\n", price);
        // Using the '$' flag to refer to argument positions
        System.out.printf("Name = %1$-6s, Age = %2$2d, Height = %3$4.2f\n", name, age, height);

        // String Object: built in class is a collection of characters

        String str2 = new String("Hello");

        char[] chars = {'H', 'e', 'l', 'l', 'o'};
        String str3 = new String(chars);

        byte[] byteArray = {72, 101, 108, 108, 111};
        String str4 = new String(byteArray);

        StringBuilder sb = new StringBuilder();
        sb.append("Hello");
        String str5 = sb.toString();

        // Print all strings
        System.out.println("str2: " + str2);
        System.out.println("str3: " + str3);
        System.out.println("str4: " + str4);
        System.out.println("str5: " + str5);


        String text = "This is the state of art.";
        String text2 = "a";
        String text3 = "ART";
        System.out.println(text.matches("[a-zA-Z\\s]+\\."));
        System.out.println(text2.matches("."));
        System.out.println(text3.matches("[A-Z]+"));


        Scanner sc = new Scanner(System.in);
//        String phone;
//        System.out.println("Enter a phone number: ");
//        phone = sc.nextLine();
//        boolean isValidPhoneNum = phone.matches("^9[0-9]{9}"); // {min, max} length
//        System.out.println("Is a valid phone number? " + isValidPhoneNum);

        String gmail = "codex@gmail.com";
        boolean isValidGmail = gmail.matches("\\w*@gmail(.*)");
        System.out.println("isValidGmail: " + isValidGmail);

        // Step 1: find the index of the @
        int indexOfSeperator = gmail.indexOf('@');
        System.out.println("indexOfSeperator: " + indexOfSeperator);

        if (indexOfSeperator == -1) {
            System.out.println("Not a valid email address");
            return;
        }

        // Step 2: extract the domain and username
        String domain = gmail.substring(indexOfSeperator + 1);
        String username = gmail.substring(0, indexOfSeperator);
        System.out.println("username: " + username + " Domain: " + domain);

        // Step 3: validate username and domain
        boolean isValidUsername = username.matches("[a-zA-Z0-9]+");
        boolean isValidDomain = domain.matches("gmail.[a-z]{2,3}");

        System.out.println("isValidUsername: " + isValidUsername + " isValidDomain: " + isValidDomain);





    }
}
