final class Employees{
	private final int id;
	private final String name;
	
	public Employees(int id, String name) {
		this.id = id;
		this.name = name;
	}
}

class BankAccount {
	 private long accNo;
	 private long balance;
	 
	 public BankAccount(long accNo, long balance) {
		 if(accNo <= 0) {
			 throw new IllegalArgumentException("Invalid account number");
		 }
		 
		 if(balance<0) {
			 throw new IllegalArgumentException("Balance cannot be negative");
		 }
		 
		 this.accNo = accNo;
		 this.balance = balance;
	 }
	 
	 public long getAccNo() {
		 return accNo;
	 }
	 
	 public long getBalance() {
		 return balance;
	 }
	 
	 public void deposit(long amount) {
		 if(amount <= 0) {
			 System.out.println("Invalid deposit amount");
			 return;
		 }
		 balance += amount;
		 System.out.println("Deposited: $"+ amount);
	 }
	 
	 public void withdraw(long amount) {
		 if(amount <= 0) {
			 System.out.println("Invalid withdraw amount");
			 return;
		 }
		 if(amount > balance) {
			 System.out.println("Insufficient balance");
			 return;
		 }
		 balance -= amount;
		 System.out.println("Withdrew: $"+ amount);
	 }
}

public class Encapsulation {

	public static void main(String[] args) {
		BankAccount ac = new BankAccount(12345, 600000);
		
		System.out.println("Account No: " + ac.getAccNo());
        System.out.println("Initial Balance: $" + ac.getBalance());
        
        ac.deposit(2000);
        ac.withdraw(10000);

        System.out.println("Final Balance: $" + ac.getBalance());

	}

}
