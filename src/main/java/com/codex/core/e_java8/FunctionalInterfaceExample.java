package com.codex.core.e_java8;

public class FunctionalInterfaceExample {
    public static void main(String[] args) {
        Greeting g = () -> System.out.println("Hello from lambda!");
        g.sayHello();
    }
}
