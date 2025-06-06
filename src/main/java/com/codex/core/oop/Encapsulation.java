package com.codex.core.oop;

import com.codex.core.oop.common.BaseAccount;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

/**
 * Demonstrates encapsulation concepts:
 * - Data hiding
 * - Immutable objects
 * - Validation and security
 * - Controlled access to internal state
 */
public class Encapsulation {
    // Immutable transaction record
    public static final class SecureTransaction {
        private final String transactionId;
        private final double amount;
        private final String description;
        private final long timestamp;
        
        public SecureTransaction(double amount, String description) {
            this.transactionId = generateId();
            this.amount = amount;
            this.description = description;
            this.timestamp = System.currentTimeMillis();
        }
        
        // Only getters, no setters to maintain immutability
        public String getTransactionId() { return transactionId; }
        public double getAmount() { return amount; }
        public String getDescription() { return description; }
        public long getTimestamp() { return timestamp; }
        
        private String generateId() {
            try {
                String input = System.currentTimeMillis() + String.valueOf(amount);
                MessageDigest md = MessageDigest.getInstance("SHA-256");
                byte[] hash = md.digest(input.getBytes());
                StringBuilder hexString = new StringBuilder();
                for (byte b : hash) {
                    hexString.append(String.format("%02x", b));
                }
                return hexString.toString().substring(0, 8);
            } catch (NoSuchAlgorithmException e) {
                return String.valueOf(System.currentTimeMillis());
            }
        }
        
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof SecureTransaction)) return false;
            SecureTransaction that = (SecureTransaction) o;
            return Double.compare(that.amount, amount) == 0 &&
                   timestamp == that.timestamp &&
                   Objects.equals(transactionId, that.transactionId) &&
                   Objects.equals(description, that.description);
        }
        
        @Override
        public int hashCode() {
            return Objects.hash(transactionId, amount, description, timestamp);
        }
    }
    
    // Secure account implementation
    public static class SecureAccount extends BaseAccount {
        private final String pin;
        private int failedAttempts;
        private static final int MAX_ATTEMPTS = 3;
        
        public SecureAccount(String accountId, String accountHolder, String pin) {
            super(accountId, accountHolder, MINIMUM_BALANCE);
            this.pin = hashPin(pin);
            this.failedAttempts = 0;
        }
        
        // All sensitive operations require PIN verification
        @Override
        public void deposit(double amount) {
            throw new SecurityException("PIN required for this operation");
        }
        
        public void deposit(double amount, String pin) {
            verifyPin(pin);
            super.deposit(amount);
        }
        
        @Override
        public boolean withdraw(double amount) {
            throw new SecurityException("PIN required for this operation");
        }
        
        public boolean withdraw(double amount, String pin) {
            verifyPin(pin);
            return super.withdraw(amount);
        }
        
        // Private helper methods for security
        private void verifyPin(String inputPin) {
            if (failedAttempts >= MAX_ATTEMPTS) {
                throw new SecurityException("Account locked due to too many failed attempts");
            }
            
            if (!hashPin(inputPin).equals(this.pin)) {
                failedAttempts++;
                throw new SecurityException("Invalid PIN");
            }
            
            failedAttempts = 0;  // Reset on successful verification
        }
        
        private String hashPin(String pin) {
            try {
                MessageDigest md = MessageDigest.getInstance("SHA-256");
                byte[] hash = md.digest(pin.getBytes());
                StringBuilder hexString = new StringBuilder();
                for (byte b : hash) {
                    hexString.append(String.format("%02x", b));
                }
                return hexString.toString();
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException("Failed to hash PIN", e);
            }
        }
        
        // Limited access to account information
        @Override
        public String toString() {
            return String.format("SecureAccount[id=%s, holder=%s, status=%s]",
                               accountId, accountHolder, isFrozen() ? "Frozen" : "Active");
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Demonstrating Encapsulation ===");
        
        // Create a secure account
        SecureAccount account = new SecureAccount("2001", "Alice Smith", "1234");
        
        try {
            // This should fail
            account.deposit(1000.0);
        } catch (SecurityException e) {
            System.out.println("Security check worked: " + e.getMessage());
        }
        
        try {
            // This should work
            account.deposit(1000.0, "1234");
            System.out.println("Successful deposit with correct PIN");
            
            // Create an immutable transaction record
            SecureTransaction transaction = new SecureTransaction(1000.0, "Initial deposit");
            System.out.println("Transaction created: " + transaction.getTransactionId());
            
            // Try withdrawal with wrong PIN
            account.withdraw(500.0, "wrong");
        } catch (SecurityException e) {
            System.out.println("Security check worked: " + e.getMessage());
        }
        
        // Show final state (notice that balance is not displayed)
        System.out.println("\nFinal account state:");
        System.out.println(account);
    }
} 