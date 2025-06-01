package com.codex.core.oop.common;

public interface AccountOperations {
    void deposit(double amount);
    boolean withdraw(double amount);
    double getBalance();
    String getAccountId();
} 