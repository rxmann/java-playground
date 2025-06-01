# Java OOP Learning Package: A Beginner's Guide

Welcome! This package is designed to help beginners understand Object-Oriented Programming (OOP) concepts in Java. We'll use a simple banking system to make these ideas practical and easy to grasp.

## Who is this for?

*   Java beginners who have a basic understanding of Java syntax (variables, data types, loops, conditional statements).
*   Anyone looking for clear, practical examples of core OOP principles.

## Prerequisites

*   Basic knowledge of Java programming (variables, methods, control flow).
*   A Java Development Kit (JDK) installed on your system to compile and run the examples.
*   A code editor or Integrated Development Environment (IDE) like VS Code, IntelliJ IDEA, or Eclipse (optional but recommended).

## How to Use This Repository

1.  **Follow the Learning Path:** The files are structured to introduce OOP concepts progressively. It's best to go through them in the suggested order (see "Learning Path" section below).
2.  **Read the Explanations:** Each concept in this README is explained before linking to the code. Understand the "what" and "why" first.
3.  **Study the Code:** Open the corresponding Java file. Pay attention to the comments, especially those explaining how the code demonstrates the OOP principle.
4.  **Compile and Run:** Each Java file has a `main` method. Compile and run the code to see it in action. Experiment by making small changes to see what happens!

## How to Compile and Run Examples

If you're using an IDE, you can usually right-click on the file and select "Run".

If you're using the command line:

1.  **Navigate to the `src` directory:** Open your terminal or command prompt and change to the `src` directory within this project.
    ```bash
    cd path/to/your/project/src
    ```
2.  **Compile:** For example, to compile `Classes.java` which is in the `com.codex.core.oop` package:
    ```bash
    javac com/codex/core/oop/Classes.java
    ```
    This will create a `Classes.class` file.
3.  **Run:**
    ```bash
    java com.codex.core.oop.Classes
    ```
    You should see the output from the program in your terminal.

*(Note: If you have issues with classpath, especially when dealing with the `common` package, compiling all files from the `src` directory might be easier: `javac com/codex/core/oop/*.java com/codex/core/oop/common/*.java`)*

## Package Structure

```
com.codex.core.oop/
├── common/                     # Shared code: interfaces and base classes
│   ├── AccountOperations.java  # What an account can do (deposit, withdraw)
│   ├── InterestBearing.java   # For accounts that earn interest
│   ├── AccountManagement.java # For managing account state (freeze, unfreeze)
│   ├── TransactionTracking.java # For keeping track of transactions
│   ├── Transaction.java       # Represents a single bank transaction
│   └── BaseAccount.java       # A foundational blueprint for all accounts
├── Classes.java               # Understanding Java Classes and Objects
├── Encapsulation.java        # Protecting data (Data Hiding)
├── Inheritance.java          # Creating specialized classes from general ones
├── Polymorphism.java         # Making objects behave in different ways
├── Abstraction.java          # Hiding complex details, showing essentials
└── Interfaces.java           # Defining contracts for classes
```

## Core OOP Concepts Explained

Let's dive into the core OOP concepts. For each, we'll explain what it is, why it's important, and how it's shown in our banking example.

### 1. Classes and Objects (`Classes.java`)

*   **What it is:** A **class** is like a blueprint for creating things. For example, a `BankAccount` class is a blueprint that describes what every bank account will have (like an account number, balance) and what it can do (like deposit, withdraw). An **object** is an actual instance created from that blueprint. So, `johnsAccount` and `janesAccount` would be two different objects of the `BankAccount` class.
*   **Why it's important:** Classes and objects help organize code by modeling real-world things or concepts, making programs more structured and understandable.
*   **In `Classes.java`:** You'll see how a `BankAccount` class is defined, how objects (instances of `BankAccount`) are created, and how they have their own data (attributes) and behaviors (methods).
    *   Look for instance variables (e.g., `accountNumber`, `balance`).
    *   Look for methods (e.g., `deposit()`, `withdraw()`).
    *   Notice how multiple `BankAccount` objects are created in the `main` method.

### 2. Encapsulation (`Encapsulation.java`)

*   **What it is:** Encapsulation means bundling data (attributes) and the methods that operate on that data within a single unit (a class). It also involves restricting direct access to some of an object's components (data hiding). Think of it like a capsule that protects its contents.
*   **Why it's important:** It protects data from accidental modification and hides internal complexity, making the class easier to use and maintain.
*   **In `Encapsulation.java`:** The `SecureAccount` class demonstrates this. Its internal data like `pin` or `balance` isn't directly accessible from outside. You have to use methods like `deposit(amount, pin)` to interact with it, ensuring security checks (like PIN verification) are performed.
    *   Look for `private` access modifiers on fields.
    *   See how public methods provide controlled access to data.

### 3. Inheritance (`Inheritance.java`)

*   **What it is:** Inheritance allows a new class (subclass or derived class) to inherit properties and methods from an existing class (superclass or base class). This promotes code reuse and creates a hierarchy of classes.
*   **Why it's important:** It avoids code duplication. If you have different types of accounts (Savings, Checking), they share common features (like account number, balance). These common features can be in a base `Account` class, and `SavingsAccount` and `CheckingAccount` can inherit them, adding their specific features (like interest calculation for savings).
*   **In `Inheritance.java`:** `SavingsAccount`, `CheckingAccount`, and `FixedDepositAccount` all inherit from `BaseAccount` (from the `common` package). They get common functionalities from `BaseAccount` and add their own specialized behaviors (e.g., `SavingsAccount` implements `InterestBearing`).
    *   Note the `extends BaseAccount` keyword.
    *   See how methods like `calculateInterest()` are specific to `SavingsAccount` or `FixedDepositAccount`.

### 4. Polymorphism (`Polymorphism.java`)

*   **What it is:** Polymorphism means "many forms." In OOP, it allows objects of different classes to respond to the same method call in different ways. It also refers to a single method name having different implementations (method overloading).
*   **Why it's important:** It makes code more flexible and extensible. You can treat objects of different classes uniformly if they share a common superclass or interface.
*   **In `Polymorphism.java`:**
    *   **Runtime Polymorphism (Method Overriding):** The `TransactionProcessor` has different implementations like `DepositProcessor` and `WithdrawalProcessor`. When `handle()` is called on a `TransactionProcessor` object, the *actual type* of the object determines which `processTransaction()` method is executed.
    *   **Compile-time Polymorphism (Method Overloading):** The `PolymorphicAccount` has multiple `transfer` methods with different parameters (e.g., `transfer(double amount)` vs. `transfer(double amount, String description)`).

### 5. Abstraction (`Abstraction.java`)

*   **What it is:** Abstraction means hiding complex implementation details and showing only the essential features of an object. It's about simplifying how users interact with an object.
*   **Why it's important:** It reduces complexity and makes systems easier to understand and use. Users don't need to know *how* something works internally, only *what* it does.
*   **In `Abstraction.java`:**
    *   **Interfaces like `NotificationService` or `InterestCalculator`** define a contract (what should be done) without specifying *how* it should be done. Concrete classes (`EmailNotificationService`, `SimpleInterestCalculator`) provide the actual implementation.
    *   The `AbstractAccountService` uses these interfaces, decoupling itself from specific implementations.

### 6. Interfaces (`Interfaces.java`)

*   **What it is:** An interface is a contract that defines a set of methods a class must implement. It specifies *what* a class can do, but not *how* it does it.
*   **Why it's important:** Interfaces allow for a high degree of abstraction and enable different classes to be treated similarly if they implement the same interface. They are crucial for achieving loose coupling and polymorphism.
*   **In `Interfaces.java`:** This file showcases advanced interface features:
    *   `TransactionValidator` is a **functional interface** (an interface with a single abstract method), suitable for lambda expressions.
    *   **Default methods** (`and` in `TransactionValidator`) provide common functionality directly in the interface.
    *   **Static methods** (`minAmount` in `TransactionValidator`) provide utility functions related to the interface.

## Common Package (`com.codex.core.oop.common`)

This sub-package contains shared code used by the main example files:

*   `AccountOperations.java`: Defines basic actions like deposit and withdraw.
*   `InterestBearing.java`: For accounts that can calculate and accrue interest.
*   `AccountManagement.java`: For actions like freezing or unfreezing an account.
*   `TransactionTracking.java`: For keeping a history of transactions.
*   `Transaction.java`: A simple class to represent a bank transaction (e.g., a deposit of $100).
*   `BaseAccount.java`: An **abstract class** that provides a common foundation (shared attributes and methods) for all specific account types. It implements the common interfaces.

## Learning Path Recommendation

1.  **`Classes.java`**: Start here to understand the basics of classes and objects.
2.  **`Encapsulation.java`**: Learn how to protect data within your classes.
3.  **`Inheritance.java`**: See how to create specialized classes from general ones.
4.  **`Polymorphism.java`**: Explore how objects can take on different forms and behaviors.
5.  **`Abstraction.java`**: Understand how to simplify complex systems by hiding details.
6.  **`Interfaces.java`**: Learn about defining contracts and using modern interface features.
7.  **`common` package**: Review the files in this package to see how shared code is organized and reused.

## Glossary of OOP Terms (Simplified)

*   **Class:** A blueprint or template for creating objects.
*   **Object:** An instance of a class; a concrete entity created from the blueprint.
*   **Encapsulation:** Bundling data and methods together and protecting data by restricting direct access.
*   **Inheritance:** A mechanism where a new class (subclass) acquires properties and behaviors from an existing class (superclass).
*   **Polymorphism:** "Many forms." The ability of objects to respond differently to the same method call, or a method having multiple implementations.
*   **Abstraction:** Hiding complex implementation details and showing only essential features.
*   **Interface:** A contract that defines methods a class must implement, specifying *what* to do but not *how*.
*   **Attribute/Field/Instance Variable:** Data that belongs to an object (e.g., `balance` in `BankAccount`).
*   **Method/Behavior:** An action an object can perform (e.g., `deposit()` in `BankAccount`).
*   **Constructor:** A special method used to create and initialize objects.
*   **`private`:** An access modifier restricting access to members within the same class only.
*   **`public`:** An access modifier allowing access from any other class.
*   **`protected`:** An access modifier allowing access within the same class, subclasses, and classes in the same package.
*   **`static`:** Indicates a member belongs to the class itself, not to instances of the class.

Happy Coding! 