import java.util.*;

// Custom Checked Exception
class InvalidAmountException extends Exception {
    public InvalidAmountException(String message) {
        super(message);
    }
}

// Custom Unchecked Exception
class InsufficientBalanceException extends RuntimeException {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

// Abstract Wallet
abstract class DigitalWallet {
    private String walletId;
    private String ownerName;
    private double balance;

    public DigitalWallet(String walletId, String ownerName, double balance) {
        this.walletId = walletId;
        this.ownerName = ownerName;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    protected void setBalance(double balance) {
        this.balance = balance;
    }

    // Overloaded Methods
    public abstract void addMoney(double amount, String mode) throws InvalidAmountException;

    public abstract void transfer(double amount, DigitalWallet receiver)
            throws InvalidAmountException;

    public abstract void transfer(double amount, DigitalWallet receiver, String remarks)
            throws InvalidAmountException;
}

// Basic Wallet
class BasicWallet extends DigitalWallet {

    public BasicWallet(String id, String name, double balance) {
        super(id, name, balance);
    }

    // WRITE FUNCTION BODY ONLY
    @Override
    public void addMoney(double amount, String mode) throws InvalidAmountException {
        //1.Validate amount
    	if(amount<0) {
    		throw new InvalidAmountException("Invalid amount");
    	}
    	//2.Add money nowmally
    	setBalance(getBalance()+amount);
    }

    // WRITE FUNCTION BODY ONLY
    @Override
    public void transfer(double amount, DigitalWallet receiver)
            throws InvalidAmountException {
        if(amount<=0) throw new InvalidAmountException("Invalid amount");
        
        if(amount> getBalance()) {
        	throw new InsufficientBalanceException("Insufficent Balance");
        }
        
        setBalance(getBalance()-amount);
        receiver.setBalance(receiver.getBalance()+amount);
    }

    // WRITE FUNCTION BODY ONLY
    @Override
    public void transfer(double amount, DigitalWallet receiver, String remarks)
            throws InvalidAmountException {
        transfer(amount,receiver);
        System.out.println("Reamrks"+remarks);
        
    }
}

// Premium Wallet
class PremiumWallet extends DigitalWallet {

    public PremiumWallet(String id, String name, double balance) {
        super(id, name, balance);
    }

    // WRITE FUNCTION BODY ONLY
    public void addMoney(double amount, String mode) throws InvalidAmountException {
        if(amount<=0) throw new InvalidAmountException("Invalid amount");
        
        //2%discount
        double cashback=amount*0.02;
        
        setBalance(getBalance()+amount+cashback);
        
    }

    // WRITE FUNCTION BODY ONLY
    @Override
    public void transfer(double amount, DigitalWallet receiver)
            throws InvalidAmountException {
    	if(amount<=0) {
    		throw new InvalidAmountException("Invalid amount");
    		
    	}
    	if(amount>getBalance()) {
    		throw new InsufficientBalanceException("Insufficient balance");
    		
    	}
    	setBalance(getBalance()-amount);
    	receiver.setBalance(receiver.getBalance()+amount);
    }

    // WRITE FUNCTION BODY ONLY
    public void transfer(double amount, DigitalWallet receiver, String remarks)
            throws InvalidAmountException {
        transfer(amount,receiver);
        System.out.println("Remarks "+remarks);
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            String type = sc.nextLine();
            String walletId = sc.next();
            String owner = sc.next();
            double balance = sc.nextDouble();
            sc.nextLine();

            DigitalWallet wallet;

            if (type.equals("BASIC")) {
                wallet = new BasicWallet(walletId, owner, balance);
            } else {
                wallet = new PremiumWallet(walletId, owner, balance);
            }

            int n = sc.nextInt();
            sc.nextLine();

            for (int i = 0; i < n; i++) {
                String line = sc.nextLine();
                String[] parts = line.split(" ");

                if (parts[0].equals("ADD")) {
                    wallet.addMoney(Double.parseDouble(parts[1]), parts[2]);
                } else if (parts[0].equals("TRANSFER")) {
                    if (parts.length == 2) {
                        wallet.transfer(Double.parseDouble(parts[1]), wallet);
                    } else {
                        wallet.transfer(Double.parseDouble(parts[1]), wallet, parts[2]);
                    }
                }
            }

            System.out.println("Final Balance: " + wallet.getBalance());

        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        } finally {
            System.out.println("Transaction Process Completed");
        }
    }
}