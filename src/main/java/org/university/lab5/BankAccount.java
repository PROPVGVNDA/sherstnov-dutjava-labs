package org.university.lab5;

import org.university.lab5.exceptions.InsufficientFundsException;
import org.university.lab5.exceptions.NegativeAmountException;

public class BankAccount {
    private static int counter = 0;
    private int accountNumber;
    private String accountName;
    private double balance;

    public BankAccount(String accountName, double initialDeposit) {
        this.accountNumber = counter++;
        this.accountName = accountName;
        this.balance = initialDeposit;
    }

    public void deposit(double amount) throws NegativeAmountException {
        if (amount < 0) {
            throw new NegativeAmountException("Cannot deposit a negative amount.");
        }
        balance += amount;
    }

    public void withdraw(double amount) throws InsufficientFundsException, NegativeAmountException {
        if (amount < 0) {
            throw new NegativeAmountException("Cannot withdraw a negative amount.");
        }
        if (balance < amount) {
            throw new InsufficientFundsException("Insufficient funds.");
        }
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountSummary() {
        return "Account Number: " + accountNumber + ", Account Name: " + accountName + ", Balance: " + balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }
}

