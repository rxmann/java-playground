package com.codex.core.oop;

import com.codex.core.oop.common.BaseAccount;
import com.codex.core.oop.common.Transaction;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Demonstrates interface concepts:
 * - Default methods
 * - Static methods
 * - Functional interfaces
 * - Interface inheritance
 * - Interface composition
 */
public class Interfaces {
    // Functional interface for transaction validation
    @FunctionalInterface
    public interface TransactionValidator {
        boolean validate(Transaction transaction);
        
        default TransactionValidator and(TransactionValidator other) {
            return transaction -> this.validate(transaction) && other.validate(transaction);
        }
        
        static TransactionValidator minAmount(double minAmount) {
            return transaction -> transaction.getAmount() >= minAmount;
        }
        
        static TransactionValidator maxAmount(double maxAmount) {
            return transaction -> transaction.getAmount() <= maxAmount;
        }
    }
    
    // Interface with default methods
    public interface AccountFilter {
        boolean test(BaseAccount account);
        
        default AccountFilter and(AccountFilter other) {
            return account -> this.test(account) && other.test(account);
        }
        
        default AccountFilter or(AccountFilter other) {
            return account -> this.test(account) || other.test(account);
        }
        
        default AccountFilter negate() {
            return account -> !this.test(account);
        }
    }
    
    // Interface extending multiple interfaces
    public interface EnhancedAccount extends AccountFilter, TransactionValidator {
        void processTransaction(Transaction transaction);
        
        default boolean isValidAndProcessable(Transaction transaction) {
            return test(null) && validate(transaction);  // Simplified example
        }
    }
    
    // Account processor with interface implementation
    public static class AccountProcessor implements EnhancedAccount {
        private final List<Transaction> transactions = new ArrayList<>();
        private final TransactionValidator validator;
        private final Consumer<Transaction> processor;
        
        public AccountProcessor(TransactionValidator validator, Consumer<Transaction> processor) {
            this.validator = validator;
            this.processor = processor;
        }
        
        @Override
        public boolean test(BaseAccount account) {
            return true;  // Simplified implementation
        }
        
        @Override
        public boolean validate(Transaction transaction) {
            return validator.validate(transaction);
        }
        
        @Override
        public void processTransaction(Transaction transaction) {
            if (validate(transaction)) {
                processor.accept(transaction);
                transactions.add(transaction);
            }
        }
    }
    
    // Account with interface composition
    public static class ModernAccount extends BaseAccount {
        private final List<TransactionValidator> validators;
        private final List<Consumer<Transaction>> processors;
        
        public ModernAccount(String accountId, String accountHolder) {
            super(accountId, accountHolder, MINIMUM_BALANCE);
            this.validators = new ArrayList<>();
            this.processors = new ArrayList<>();
            
            // Add default validators
            addValidator(TransactionValidator.minAmount(0.01));
            addValidator(TransactionValidator.maxAmount(10000.0));
        }
        
        public void addValidator(TransactionValidator validator) {
            validators.add(validator);
        }
        
        public void addProcessor(Consumer<Transaction> processor) {
            processors.add(processor);
        }
        
        @Override
        public void deposit(double amount) {
            Transaction transaction = new Transaction(accountId, amount, "DEPOSIT", "Modern deposit");
            if (validateTransaction(transaction)) {
                super.deposit(amount);
                processTransaction(transaction);
            }
        }
        
        private boolean validateTransaction(Transaction transaction) {
            return validators.stream().allMatch(v -> v.validate(transaction));
        }
        
        private void processTransaction(Transaction transaction) {
            processors.forEach(p -> p.accept(transaction));
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Demonstrating Interface Features ===");
        
        // Create validators using static factory methods and composition
        TransactionValidator baseValidator = TransactionValidator.minAmount(0.01)
            .and(TransactionValidator.maxAmount(5000.0));
        
        // Create account processor with lambda expressions
        AccountProcessor processor = new AccountProcessor(
            baseValidator,
            transaction -> System.out.printf("Processing %s: $%.2f%n",
                transaction.getType(), transaction.getAmount())
        );
        
        // Create modern account with interface composition
        ModernAccount account = new ModernAccount("6001", "Emma Davis");
        
        // Add custom validator using lambda
        account.addValidator(transaction -> 
            !transaction.getType().equals("WITHDRAWAL") || 
            transaction.getAmount() <= 1000.0
        );
        
        // Add custom processor using method reference
        account.addProcessor(System.out::println);
        
        // Demonstrate operations
        account.deposit(1000.0);
        
        // Create and process a transaction
        Transaction transaction = new Transaction(account.getAccountId(), 2000.0, "TRANSFER", "Test transfer");
        processor.processTransaction(transaction);
        
        // Show final state
        System.out.println("\nFinal account state:");
        System.out.println(account);
    }
} 