package com.codex.core.oop.common;

/**
 * Interface for account management operations.
 */
public interface AccountManagement {
    void freeze();
    void unfreeze();
    boolean isFrozen();
} 