package com.codex.core.e_java8.default_static;

interface Vehicle {
    void drive();

    default void start() {
        System.out.println("Vehicle starting...");
    }

    static void stop() {
        System.out.println("Vehicle stopping...");
    }
}
