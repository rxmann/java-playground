package com.codex.core.e_java8;

import java.util.Arrays;
import java.util.List;

public class MethodReferenceExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Java", "Python", "Go");

        names.forEach(System.out::println);  // Method reference
    }
}
