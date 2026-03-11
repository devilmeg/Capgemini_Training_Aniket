package org.example;

public class BankAccount {
    private int balance;

    public BankAccount(int balance){
        this.balance=balance;
    }

    public void deposit(int amount){
        balance += amount;
        System.out.println(balance);
    }

    public void withdraw(int amount){
        if(balance < amount){
            throw new IllegalArgumentException("Withdraw amount must be less than balance");
        }
        if(amount <= 0){
            throw new IllegalArgumentException("Withdraw amount must be greater than 0");
        }
        balance-=amount;
    }

    public int getBalance(){
        return balance;
    }
}
