package com.codex.core.oop.common;

import java.time.LocalDateTime;

/**
 * Common transaction class used across all banking examples.
 */
public class Transaction {
    private final String transactionId;
    private final String accountId;
    private final double amount;
    private final String type;
    private final LocalDateTime timestamp;
    private final String description;

    public Transaction(String accountId, double amount, String type, String description) {
        this.transactionId = generateTransactionId();
        this.accountId = accountId;
        this.amount = amount;
        this.type = type;
        this.description = description;
        this.timestamp = LocalDateTime.now();
    }

    public String getTransactionId() { return transactionId; }
    public String getAccountId() { return accountId; }
    public double getAmount() { return amount; }
    public String getType() { return type; }
    public LocalDateTime getTimestamp() { return timestamp; }
    public String getDescription() { return description; }

    private String generateTransactionId() {
        return "TXN" + System.currentTimeMillis();
    }

    @Override
    public String toString() {
        return String.format("Transaction[id=%s, account=%s, type=%s, amount=%.2f, desc=%s]",
                           transactionId, accountId, type, amount, description);
    }
} 