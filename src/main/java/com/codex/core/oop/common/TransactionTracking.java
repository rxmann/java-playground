package com.codex.core.oop.common;

import java.util.List;

/**
 * Interface for transaction tracking.
 */
public interface TransactionTracking {
    void addTransaction(Transaction transaction);
    List<Transaction> getTransactionHistory();
} 