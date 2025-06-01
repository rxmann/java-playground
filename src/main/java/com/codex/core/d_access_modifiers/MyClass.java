package com.codex.core.d_access_modifiers;

public class MyClass {
    public String publicVar = "Visible";
    private String privateVar = "Hidden";

    public void showAccess() {
        System.out.println("Public: " + publicVar);
        System.out.println("Private: " + privateVar);
    }
}
