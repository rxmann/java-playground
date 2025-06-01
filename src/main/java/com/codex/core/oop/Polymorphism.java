package com.codex.core.oop;

import com.codex.core.oop.common.BaseAccount;
import com.codex.core.oop.common.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Demonstrates polymorphism concepts:
 * - Runtime polymorphism (method overriding)
 * - Compile-time polymorphism (method overloading)
 * - Abstract classes and interfaces
 * - Dynamic method dispatch
 */
public class Polymorphism {
    // Abstract transaction processor
    public static abstract class TransactionProcessor {
        protected abstract void processTransaction(Transaction transaction);
        
        // Template method pattern
        public final void handle(Transaction transaction) {
            validateTransaction(transaction);
            processTransaction(transaction);
            logTransaction(transaction);
        }
        
        protected void validateTransaction(Transaction transaction) {
            if (transaction.getAmount() <= 0) {
                throw new IllegalArgumentException("Amount must be positive");
            }
        }
        
        protected void logTransaction(Transaction transaction) {
            System.out.printf("Processed %s: $%.2f%n", 
                transaction.getType(), transaction.getAmount());
        }
    }
    
    // Concrete processors demonstrating runtime polymorphism
    public static class DepositProcessor extends TransactionProcessor {
        @Override
        protected void processTransaction(Transaction transaction) {
            if (!transaction.getType().equals("DEPOSIT")) {
                throw new IllegalArgumentException("Invalid transaction type");
            }
            System.out.println("Processing deposit...");
        }
    }
    
    public static class WithdrawalProcessor extends TransactionProcessor {
        @Override
        protected void processTransaction(Transaction transaction) {
            if (!transaction.getType().equals("WITHDRAWAL")) {
                throw new IllegalArgumentException("Invalid transaction type");
            }
            System.out.println("Processing withdrawal...");
        }
        
        @Override
        protected void validateTransaction(Transaction transaction) {
            super.validateTransaction(transaction);
            if (transaction.getAmount() > 10000) {
                throw new IllegalArgumentException("Amount exceeds withdrawal limit");
            }
        }
    }
    
    // Account class demonstrating method overloading (compile-time polymorphism)
    public static class PolymorphicAccount extends BaseAccount {
        private final List<TransactionProcessor> processors;
        
        public PolymorphicAccount(String accountId, String accountHolder) {
            super(accountId, accountHolder, MINIMUM_BALANCE);
            this.processors = new ArrayList<>();
            this.processors.add(new DepositProcessor());
            this.processors.add(new WithdrawalProcessor());
        }
        
        // Method overloading examples
        public void transfer(double amount) {
            transfer(amount, "Default transfer");
        }
        
        public void transfer(String description) {
            transfer(100.0, description);  // Default amount
        }
        
        public void transfer(double amount, String description) {
            withdraw(amount);
            recordTransaction("TRANSFER", -amount, description);
        }
        
        // Process transaction using appropriate processor
        public void processTransaction(Transaction transaction) {
            for (TransactionProcessor processor : processors) {
                try {
                    processor.handle(transaction);
                    break;
                } catch (IllegalArgumentException e) {
                    // Try next processor
                    continue;
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Demonstrating Polymorphism ===");
        
        // Create account and transactions
        PolymorphicAccount account = new PolymorphicAccount("4001", "Alice Johnson");
        account.deposit(1000.0);
        
        // Demonstrate compile-time polymorphism (method overloading)
        System.out.println("\nDemonstrating method overloading:");
        account.transfer(200.0);
        account.transfer("Monthly savings");
        account.transfer(300.0, "Emergency fund");
        
        // Demonstrate runtime polymorphism
        System.out.println("\nDemonstrating runtime polymorphism:");
        Transaction deposit = new Transaction(account.getAccountId(), 500.0, "DEPOSIT", "Regular deposit");
        Transaction withdrawal = new Transaction(account.getAccountId(), 300.0, "WITHDRAWAL", "ATM withdrawal");
        
        account.processTransaction(deposit);
        account.processTransaction(withdrawal);
        
        // Show final state
        System.out.println("\nFinal account state:");
        System.out.println(account);
        System.out.println("Transaction history:");
        account.getTransactionHistory().forEach(System.out::println);
    }
} 