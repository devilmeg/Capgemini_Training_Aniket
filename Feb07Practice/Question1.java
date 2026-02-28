package Feb07Practice;

import java.util.Scanner;

class Wallet{
	private int balance;
	boolean creditMoneyRunning;
	boolean withdrawMoneyRunning;
	
	Wallet(int balance){
		this.balance = balance;
	}
	
	public void creditMoney(int amount) {
		if(withdrawMoneyRunning) {
			System.out.println("Try again!!");
			return;
		}
		creditMoneyRunning = true;
		balance = balance + amount;
		creditMoneyRunning = false;
	}
	
	public void withdrawMoney(int amount) {
		if(amount > balance) {
			System.out.println("Insufficient Balance");
			return;
		}
		if(creditMoneyRunning) {
			System.out.println("Try again!!");
			return;
		}
		withdrawMoneyRunning = true;
		balance = balance - amount;
		withdrawMoneyRunning = false;
	}
	
	public int getbalance() {
		return balance;
	}
}

public class Question1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Wallet w = new Wallet(10000);
		
		System.out.println("Enter 1 to credit and 2 to withdraw and 3 to check balance: ");
		
		int select = sc.nextInt();
		
		if(select == 1) {
			System.out.println("Enter the amount to credit: ");
			int amount = sc.nextInt();
			w.creditMoney(amount);
		}else if(select == 2) {
			System.out.println("Enter the amount to withdraw: ");
			int amount = sc.nextInt();
			w.withdrawMoney(amount);
		}else {
			System.out.println("Your balance is: "+ w.getbalance());
		}
		
		

	}

}
