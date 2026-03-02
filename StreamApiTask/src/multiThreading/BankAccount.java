package multiThreading;

import java.util.concurrent.ExecutionException;

public class BankAccount {
    int balance=1000;
    public synchronized void withdraw(int amount) throws InterruptedException, ExecutionException {


        if(balance<amount){
            System.out.println(Thread.currentThread().getName()+"entered Withdraw()");
            System.out.println("acquired lock on BankAccount");

            wait();

            //when notify() happen and lock is reAcquired -->execution resumes from here
            System.out.println(Thread.currentThread().getName()+"get Notified and required lock");
        }
        balance-=amount;
        System.out.println(Thread.currentThread().getName()+"completed withdrawl");
        System.out.println("Remaining blance"+balance);
    }
    public synchronized void deposit(int amount) {
        System.out.println(Thread.currentThread().getName()+"entered Deposit()");
        System.out.println("acquired lock on BankAccount");
        balance+=amount;

        System.out.println(Thread.currentThread().getName()+"deposited amount");
        System.out.println("Updated balance"+balance);
        //notify all
        notify();

    }
    public static void main(String[] args) {

        BankAccount account = new BankAccount();

        Thread t1 = new Thread(() -> {
            try {
                account.withdraw(1500);
            } catch (Exception e) {}
        }, "Withdraw-1");

        Thread t2 = new Thread(() -> {
            account.deposit(1000);
        }, "Deposit-1");

        t1.start();
        t2.start();
    }
}
