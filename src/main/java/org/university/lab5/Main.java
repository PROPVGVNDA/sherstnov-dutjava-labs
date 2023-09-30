package org.university.lab5;

import org.university.lab5.exceptions.*;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();

        try {
            BankAccount johnAccount = bank.createAccount("John Doe", 1000);
            System.out.println("John's Account Summary: " + johnAccount.getAccountSummary());
        } catch (NegativeAmountException e) {
            System.out.println("Error creating John's account: " + e.getMessage());
        }

        try {
            BankAccount janeAccount = bank.createAccount("Jane Smith", -500);
            System.out.println("Jane's Account Summary: " + janeAccount.getAccountSummary());
        } catch (NegativeAmountException e) {
            System.out.println("Error creating Jane's account: " + e.getMessage());
        }

        try {
            BankAccount existingAccount = bank.createAccount("Existing User", 1000);
            existingAccount.deposit(-500);
            System.out.println("Existing User's Account after deposit: " + existingAccount.getBalance());
        } catch (NegativeAmountException e) {
            System.out.println("Error depositing to Existing User's account: " + e.getMessage());
        }

        try {
            BankAccount existingAccount = bank.createAccount("Another User", 100);
            existingAccount.withdraw(200);
            System.out.println("Another User's Account after withdrawal: " + existingAccount.getBalance());
        } catch (InsufficientFundsException e) {
            System.out.println("Error withdrawing from Another User's account: " + e.getMessage());
        } catch (NegativeAmountException e) {
            System.out.println("Error withdrawing from Another User's account: " + e.getMessage());
        }

        try {
            BankAccount sender = bank.createAccount("Sender", 1000);
            BankAccount receiver = bank.createAccount("Receiver", 500);
            bank.transferMoney(sender.getAccountNumber(), -5, 300);
        } catch (AccountNotFoundException e) {
            System.out.println("Error transferring money: " + e.getMessage());
        } catch (InsufficientFundsException | NegativeAmountException e) {
            System.out.println("Error transferring money: " + e.getMessage());
        }
    }
}

