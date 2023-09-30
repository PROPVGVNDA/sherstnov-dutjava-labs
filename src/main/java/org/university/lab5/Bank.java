package org.university.lab5;

import org.university.lab5.exceptions.*;

import java.util.HashMap;
import java.util.Map;

public class Bank {
    private Map<Integer, BankAccount> accounts = new HashMap<>();

    public BankAccount createAccount(String accountName, double initialDeposit) throws NegativeAmountException {
        if (initialDeposit < 0) {
            throw new NegativeAmountException("Cannot create an account with a negative initial deposit.");
        }

        BankAccount account = new BankAccount(accountName, initialDeposit);
        accounts.put(account.getAccountNumber(), account);
        return account;
    }

    public BankAccount findAccount(int accountNumber) throws AccountNotFoundException {
        BankAccount account = accounts.get(accountNumber);
        if (account == null) {
            throw new AccountNotFoundException("Account not found.");
        }
        return account;
    }

    public void transferMoney(int fromAccountNumber, int toAccountNumber, double amount) throws AccountNotFoundException, InsufficientFundsException, NegativeAmountException {
        BankAccount fromAccount = findAccount(fromAccountNumber);
        BankAccount toAccount = findAccount(toAccountNumber);

        fromAccount.withdraw(amount);
        toAccount.deposit(amount);
    }
}
