package com.codex.core.d_access_modifiers;

public class Main {
    public static void main(String[] args) {
        MyClass obj = new MyClass();
        System.out.println(obj.publicVar);
        obj.showAccess();
        // obj.privateVar; // ❌ Not accessible
    }
}
