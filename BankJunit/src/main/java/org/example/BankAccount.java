package org.example;

public class BankAccount {

    private int balance;

    public BankAccount(int balance) {
        this.balance = balance;
    }

    public void deposit(int amount) {
        balance += amount;
        System.out.println("Deposited: " + amount + ", New Balance: " + balance);
    }

    public void withdraw(int amount) {
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient Balance");
        }
        if(amount<0){
            throw new IllegalArgumentException("Amount cannot be negative");
        }
        balance -= amount;
    }

    public int getBalance() {
        return balance;
    }
}