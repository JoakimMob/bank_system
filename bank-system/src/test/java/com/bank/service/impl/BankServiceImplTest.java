package com.bank.service.impl;

import com.bank.BankAccount;
import junit.framework.TestCase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class BankServiceImplTest extends TestCase {
     BankServiceImpl bankService = new BankServiceImpl();
    BankAccount bankAccount = new BankAccount("Elias", "1");

    @Test
    public void testIfWithdrawWorks() {
        bankAccount.setBalance(100);
        bankService.withdraw(bankAccount,100.0);
        assertEquals(0.0, bankAccount.getBalance());
        assertEquals(-100.0,bankAccount.getPrevTrans());
    }
    @Test
    public void testWithdrawWithBiggerWithdrawAmount(){
        bankAccount.setBalance(200);
        bankService.withdraw(bankAccount,210);
        assertEquals(200.0,bankAccount.getBalance());
    }
    @Test
    public void testIfDepositWorks() {
        bankAccount.setBalance(100);
        bankService.deposit(bankAccount,200);
        assertEquals(300.0,bankAccount.getBalance());
    }
    @Test
    public void testDepositWithNegativeAmount(){
        bankAccount.setBalance(100);
        bankService.deposit(bankAccount,200);
        bankService.deposit(bankAccount,-200);
        assertEquals(300.0,bankAccount.getBalance());
    }

}