package com.codex.core.b_oop;

public class Student extends Person {
    String major;

    public Student(String name, int age, String major) {
        super(name, age);
        this.major = major;
    }

    @Override
    public void greet() {
        System.out.println("I'm " + name + ", a " + major + " student.");
    }
}
