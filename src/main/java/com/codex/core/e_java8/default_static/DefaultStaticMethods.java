package com.codex.core.e_java8.default_static;

public class DefaultStaticMethods {
    public static void main(String[] args) {
        Car car = new Car();
        car.start();
        car.drive();
        Vehicle.stop();
    }
}
