package com.codex.core.b_oop;

public class Main {
    public static void main(String[] args) {
        Person p = new Person("Alice", 30);
        Student s = new Student("Bob", 20, "Computer Science");

        p.greet();
        s.greet();
    }
}
