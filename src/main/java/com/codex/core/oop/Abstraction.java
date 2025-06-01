package com.codex.core.oop;

import com.codex.core.oop.common.*;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Demonstrates abstraction concepts:
 * - Interface abstraction
 * - Abstract classes
 * - Separation of concerns
 * - Interface segregation
 * - Dependency inversion
 */
public class Abstraction {
    // Abstract notification service
    public interface NotificationService {
        void notify(String accountId, String message);
    }
    
    // Abstract interest calculator
    public interface InterestCalculator {
        double calculateInterest(double balance, double rate);
    }
    
    // Concrete notification implementations
    public static class EmailNotificationService implements NotificationService {
        @Override
        public void notify(String accountId, String message) {
            System.out.printf("Sending email for account %s: %s%n", accountId, message);
        }
    }
    
    public static class SMSNotificationService implements NotificationService {
        @Override
        public void notify(String accountId, String message) {
            System.out.printf("Sending SMS for account %s: %s%n", accountId, message);
        }
    }
    
    // Concrete interest calculators
    public static class SimpleInterestCalculator implements InterestCalculator {
        @Override
        public double calculateInterest(double balance, double rate) {
            return balance * rate;
        }
    }
    
    public static class CompoundInterestCalculator implements InterestCalculator {
        private final int compoundingFrequency;
        
        public CompoundInterestCalculator(int compoundingFrequency) {
            this.compoundingFrequency = compoundingFrequency;
        }
        
        @Override
        public double calculateInterest(double balance, double rate) {
            return balance * Math.pow(1 + rate/compoundingFrequency, compoundingFrequency) - balance;
        }
    }
    
    // Abstract account service using dependency injection
    public static abstract class AbstractAccountService {
        protected final NotificationService notificationService;
        protected final InterestCalculator interestCalculator;
        protected final List<BaseAccount> accounts;
        
        protected AbstractAccountService(NotificationService notificationService,
                                      InterestCalculator interestCalculator) {
            this.notificationService = notificationService;
            this.interestCalculator = interestCalculator;
            this.accounts = new ArrayList<>();
        }
        
        public void addAccount(BaseAccount account) {
            accounts.add(account);
            notificationService.notify(account.getAccountId(), "Account created successfully");
        }
        
        public abstract void processInterest();
        
        protected List<BaseAccount> filterAccounts(Predicate<BaseAccount> predicate) {
            List<BaseAccount> filtered = new ArrayList<>();
            for (BaseAccount account : accounts) {
                if (predicate.test(account)) {
                    filtered.add(account);
                }
            }
            return filtered;
        }
    }
    
    // Concrete account service implementation
    public static class SavingsAccountService extends AbstractAccountService {
        public SavingsAccountService(NotificationService notificationService,
                                   InterestCalculator interestCalculator) {
            super(notificationService, interestCalculator);
        }
        
        @Override
        public void processInterest() {
            List<BaseAccount> interestBearingAccounts = filterAccounts(
                account -> account instanceof InterestBearing
            );
            
            for (BaseAccount account : interestBearingAccounts) {
                InterestBearing interestAccount = (InterestBearing) account;
                double interest = interestCalculator.calculateInterest(
                    account.getBalance(),
                    interestAccount.getInterestRate()
                );
                
                account.deposit(interest);
                notificationService.notify(account.getAccountId(),
                    String.format("Interest credited: $%.2f", interest));
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Demonstrating Abstraction ===");
        
        // Create service with dependencies
        NotificationService emailService = new EmailNotificationService();
        InterestCalculator compoundCalculator = new CompoundInterestCalculator(12);
        AbstractAccountService accountService = new SavingsAccountService(emailService, compoundCalculator);
        
        // Create and add accounts
        BaseAccount savingsAccount = new Inheritance.SavingsAccount("5001", "David Brown", 0.03);
        savingsAccount.deposit(1000.0);
        accountService.addAccount(savingsAccount);
        
        BaseAccount checkingAccount = new Inheritance.CheckingAccount("5002", "Sarah Wilson", 500.0);
        checkingAccount.deposit(500.0);
        accountService.addAccount(checkingAccount);
        
        // Process interest (only savings account will earn interest)
        System.out.println("\nProcessing interest for all accounts:");
        accountService.processInterest();
        
        // Show final states
        System.out.println("\nFinal account states:");
        accountService.accounts.forEach(System.out::println);
    }
} 