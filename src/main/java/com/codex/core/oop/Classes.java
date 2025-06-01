package com.codex.core.oop;

import com.codex.core.oop.common.BaseAccount;
import com.codex.core.oop.common.InterestBearing;

/**
 * Demonstrates core class concepts:
 * - Class definition and structure
 * - Instance variables and methods
 * - Static members
 * - Enums
 * - Method overloading
 * - Inner classes
 */
public class Classes {
    // Example of an enum
    public enum AccountType {
        SAVINGS(0.025),
        CHECKING(0.0),
        FIXED_DEPOSIT(0.06);
        
        private final double interestRate;
        
        AccountType(double interestRate) {
            this.interestRate = interestRate;
        }
        
        public double getInterestRate() { return interestRate; }
    }

    // Main account class extending base functionality
    public static class BankAccount extends BaseAccount implements InterestBearing {
        private final AccountType accountType;
        private static int totalAccounts = 0;  // Static member
        
        // Constructor overloading
        public BankAccount(String accountId, String accountHolder) {
            this(accountId, accountHolder, AccountType.CHECKING);
        }
        
        public BankAccount(String accountId, String accountHolder, AccountType type) {
            super(accountId, accountHolder, MINIMUM_BALANCE);
            this.accountType = type;
            totalAccounts++;
        }
        
        // Method overloading example
        public void transfer(BankAccount recipient, double amount) {
            transfer(recipient, amount, "Regular transfer");
        }
        
        public void transfer(BankAccount recipient, double amount, String description) {
            if (withdraw(amount)) {
                recipient.deposit(amount);
                recordTransaction("TRANSFER", -amount, description + " to " + recipient.getAccountId());
            }
        }

        @Override
        public void calculateInterest() {
            double interest = balance * getInterestRate();
            deposit(interest);
            recordTransaction("INTEREST", interest, "Interest payment");
        }

        @Override
        public double getInterestRate() {
            return accountType.getInterestRate();
        }
        
        // Static method
        public static int getTotalAccounts() {
            return totalAccounts;
        }
        
        // Inner class for audit logging
        public class AuditLog {
            public void logAccountActivity() {
                System.out.printf("Audit: Account %s (%s) - Current balance: $%.2f%n", 
                    accountId, accountType, balance);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Demonstrating Class Concepts ===");
        
        // Create accounts using different constructors
        BankAccount checking = new BankAccount("1001", "John Doe");
        BankAccount savings = new BankAccount("1002", "John Doe", AccountType.SAVINGS);
        
        // Demonstrate operations and method overloading
        checking.deposit(1000.0);
        checking.transfer(savings, 500.0);
        checking.transfer(savings, 200.0, "Monthly savings");
        
        // Demonstrate interest calculation
        savings.calculateInterest();
        
        // Use inner class
        BankAccount.AuditLog auditLog = checking.new AuditLog();
        auditLog.logAccountActivity();
        
        // Show static member usage
        System.out.println("Total accounts created: " + BankAccount.getTotalAccounts());
        
        // Display final states
        System.out.println("\nFinal account states:");
        System.out.println(checking);
        System.out.println(savings);
    }
} 