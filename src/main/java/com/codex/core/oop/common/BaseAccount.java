package com.codex.core.oop.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Base account class implementing common functionality.
 */
public abstract class BaseAccount implements AccountOperations, AccountManagement, TransactionTracking {
    protected final String accountId;
    protected final String accountHolder;
    protected double balance;
    protected boolean frozen;
    protected final List<Transaction> transactions;
    protected static final double MINIMUM_BALANCE = 100.0;

    protected BaseAccount(String accountId, String accountHolder, double initialBalance) {
        this.accountId = accountId;
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
        this.frozen = false;
        this.transactions = new ArrayList<>();
    }

    @Override
    public void deposit(double amount) {
        validateState();
        validateAmount(amount);
        balance += amount;
        recordTransaction("DEPOSIT", amount, "Regular deposit");
    }

    @Override
    public boolean withdraw(double amount) {
        validateState();
        validateAmount(amount);
        validateBalance(amount);
        
        balance -= amount;
        recordTransaction("WITHDRAWAL", -amount, "Regular withdrawal");
        return true;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public String getAccountId() {
        return accountId;
    }

    @Override
    public void freeze() {
        frozen = true;
        recordTransaction("ADMIN", 0, "Account frozen");
    }

    @Override
    public void unfreeze() {
        frozen = false;
        recordTransaction("ADMIN", 0, "Account unfrozen");
    }

    @Override
    public boolean isFrozen() {
        return frozen;
    }

    @Override
    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    @Override
    public List<Transaction> getTransactionHistory() {
        return Collections.unmodifiableList(transactions);
    }

    protected void validateState() {
        if (frozen) {
            throw new IllegalStateException("Account is frozen");
        }
    }

    protected void validateAmount(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
    }

    protected void validateBalance(double withdrawalAmount) {
        if (balance - withdrawalAmount < MINIMUM_BALANCE) {
            throw new IllegalStateException("Insufficient funds or would break minimum balance");
        }
    }

    protected void recordTransaction(String type, double amount, String description) {
        Transaction transaction = new Transaction(accountId, amount, type, description);
        addTransaction(transaction);
    }

    @Override
    public String toString() {
        return String.format("Account[id=%s, holder=%s, balance=%.2f, status=%s]",
                           accountId, accountHolder, balance, frozen ? "Frozen" : "Active");
    }
} 