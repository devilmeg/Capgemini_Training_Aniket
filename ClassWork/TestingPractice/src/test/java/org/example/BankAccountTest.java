package org.example;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class BankAccountTest {

    @Test
    public void testDeposit(){
        BankAccount account = new BankAccount(100);
        account.deposit(50);
        assertEquals(150, account.getBalance());
    }

    @Test
    public void testWithdrawSuccess(){
        BankAccount account = new BankAccount(100);
        account.withdraw(50);
        assertEquals(50, account.getBalance());
    }

    @Test
    public void testWithdrawInsufficientBalance(){
        BankAccount account = new BankAccount(100);
        assertThrows(IllegalArgumentException.class, ()-> account.withdraw(170));
    }
}
