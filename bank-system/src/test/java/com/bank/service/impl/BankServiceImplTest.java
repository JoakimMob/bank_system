package com.bank.service.impl;

import com.bank.BankAccount;
import junit.framework.TestCase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class BankServiceImplTest extends TestCase {
    BankServiceImpl bankService;
    BankAccount bankAccount;
    @BeforeAll
    public void initialize(){
        bankService = new BankServiceImpl();
        bankAccount = new BankAccount("Elias", "1");
    }
    @Test
    public void testIfWithdrawWorks() {
        bankAccount.setBalance(100);
        bankService.withdraw(bankAccount,100.0);
        assertEquals(100, bankAccount.getBalance());
        assertEquals(-100,bankAccount.getPrevTrans());
    }
    @Test
    public void testWithdrawWithBiggerWithdrawAmount(){
        bankAccount.setBalance(200);
        bankService.withdraw(bankAccount,210);
        assertEquals(200,bankAccount.getBalance());
    }

    public void testDeposit() {
    }
}