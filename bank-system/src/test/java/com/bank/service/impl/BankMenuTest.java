package com.bank.service.impl;

import com.bank.BankAccount;
import com.bank.BankMenu;
import com.bank.service.BankService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)

public class BankMenuTest {
    BankMenu bankMenu;
    BankAccount bankAccount;
    BankService bankService;

    @BeforeEach
    void initializeBankAccountAndSetBalance(){
        bankAccount = new BankAccount("Jane Doe", "1");
        bankAccount.setBalance(1000.00);
        bankAccount.setPrevTrans(300.00);

    }

}
