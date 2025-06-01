package com.codex.core.oop;

import com.codex.core.oop.common.BaseAccount;
import com.codex.core.oop.common.InterestBearing;

/**
 * Demonstrates inheritance concepts:
 * - Class inheritance
 * - Method overriding
 * - Super constructor calls
 * - Protected members
 * - Final methods and classes
 */
public class Inheritance {
    // Basic savings account with interest
    public static class SavingsAccount extends BaseAccount implements InterestBearing {
        private final double interestRate;
        private static final double DEFAULT_INTEREST_RATE = 0.025; // 2.5%
        
        public SavingsAccount(String accountId, String accountHolder) {
            this(accountId, accountHolder, DEFAULT_INTEREST_RATE);
        }
        
        public SavingsAccount(String accountId, String accountHolder, double interestRate) {
            super(accountId, accountHolder, MINIMUM_BALANCE);
            this.interestRate = interestRate;
        }
        
        @Override
        public void calculateInterest() {
            double interest = balance * interestRate;
            deposit(interest);
            recordTransaction("INTEREST", interest, "Interest payment");
        }
        
        @Override
        public double getInterestRate() {
            return interestRate;
        }
    }
    
    // Checking account with overdraft protection
    public static class CheckingAccount extends BaseAccount {
        private final double overdraftLimit;
        
        public CheckingAccount(String accountId, String accountHolder, double overdraftLimit) {
            super(accountId, accountHolder, 0);
            this.overdraftLimit = overdraftLimit;
        }
        
        @Override
        protected void validateBalance(double withdrawalAmount) {
            if (balance - withdrawalAmount < -overdraftLimit) {
                throw new IllegalStateException("Would exceed overdraft limit");
            }
        }
        
        public double getOverdraftLimit() {
            return overdraftLimit;
        }
    }
    
    // Fixed deposit account with maturity date and penalties
    public static final class FixedDepositAccount extends BaseAccount implements InterestBearing {
        private final double interestRate;
        private final long maturityDate;
        private static final double EARLY_WITHDRAWAL_PENALTY = 0.05; // 5%
        
        public FixedDepositAccount(String accountId, String accountHolder, 
                                 double amount, double interestRate, int termMonths) {
            super(accountId, accountHolder, amount);
            this.interestRate = interestRate;
            this.maturityDate = System.currentTimeMillis() + (termMonths * 30L * 24 * 60 * 60 * 1000);
        }
        
        @Override
        public boolean withdraw(double amount) {
            if (System.currentTimeMillis() < maturityDate) {
                double penalty = amount * EARLY_WITHDRAWAL_PENALTY;
                super.withdraw(penalty); // Deduct penalty first
                recordTransaction("PENALTY", -penalty, "Early withdrawal penalty");
            }
            return super.withdraw(amount);
        }
        
        @Override
        public void calculateInterest() {
            if (System.currentTimeMillis() >= maturityDate) {
                double interest = balance * interestRate;
                deposit(interest);
                recordTransaction("INTEREST", interest, "Maturity interest payment");
            }
        }
        
        @Override
        public double getInterestRate() {
            return interestRate;
        }
        
        public long getMaturityDate() {
            return maturityDate;
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Demonstrating Inheritance ===");
        
        // Create different types of accounts
        SavingsAccount savings = new SavingsAccount("3001", "John Doe", 0.03);
        CheckingAccount checking = new CheckingAccount("3002", "Jane Smith", 1000.0);
        FixedDepositAccount fd = new FixedDepositAccount("3003", "Bob Wilson", 
                                                        5000.0, 0.06, 12);
        
        // Demonstrate savings account
        savings.deposit(1000.0);
        savings.calculateInterest();
        System.out.println("Savings account after interest: " + savings);
        
        // Demonstrate checking account with overdraft
        checking.deposit(500.0);
        checking.withdraw(1000.0); // Should work due to overdraft
        System.out.println("Checking account after overdraft: " + checking);
        
        // Demonstrate fixed deposit with early withdrawal
        try {
            fd.withdraw(1000.0); // Should incur penalty
        } catch (IllegalStateException e) {
            System.out.println("Fixed deposit protection: " + e.getMessage());
        }
        
        // Show different account types
        System.out.println("\nDifferent account types demonstration:");
        System.out.println(savings);
        System.out.println(checking);
        System.out.println(fd);
    }
} 