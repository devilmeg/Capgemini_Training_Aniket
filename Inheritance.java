class Account{
	long accNo;
	long balance;
	
	void deposit(double amount) {}
	void withdraw(double amount) {}
}

class SavingsAccount extends Account{
	double interestRate;
	
	void addInterest() {
		balance += balance*interestRate;
	}
}

class CurrentAccount extends Account{
	double overdraftLimit;
	
	void useOverdraft() {
		System.out.println("Using overdraft...");
	}
}

public class Inheritance {

	public static void main(String[] args) {
		

	}

}
