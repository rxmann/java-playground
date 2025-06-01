package com.codex.core.b_oop;

public class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void greet() {
        System.out.println("Hi, I'm " + name + " and I'm " + age);
    }
}
