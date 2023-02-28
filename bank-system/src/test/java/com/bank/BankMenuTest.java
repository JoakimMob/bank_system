package com.bank;

import com.bank.service.BankService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.*;


public class BankMenuTest {
@Mock
    BankMenu bankMenu;
    BankAccount bankAccount;
    BankService bankService;

    @BeforeEach
    void initializeBankAccountAndSetBalance(){
        bankAccount = new BankAccount("Jane Doe", "1");
        bankAccount.setBalance(1000.00);
    }

    @Test
    void withdrawMenuTest(){
        bankService = mock(BankService.class);
        bankMenu = new BankMenu(bankService, bankAccount);

        String input = "c\n200\ne";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        bankMenu.menu();
        verify(bankService, atLeast(1)).withdraw(bankAccount,200.00);
    }

    @Test
    void depositMenuTest(){
        bankService = mock(BankService.class);
        bankMenu = new BankMenu(bankService, bankAccount);

        String input = "b\n800\ne";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        bankMenu.menu();
        verify(bankService, atLeast(1)).deposit(bankAccount,800);
    }
    @Test
    public void testBankMenuDoesntThrowRuntimeException(){
        Scanner sc = mock(Scanner.class);
        bankService = mock(BankService.class);
        bankMenu = new BankMenu(bankService,bankAccount,sc);
        doThrow(new RuntimeException()).when(bankService).withdraw(any(),anyDouble());
        assertThrows(RuntimeException.class, ()-> bankService.withdraw(any(),anyDouble()));
        when(sc.next()).thenReturn("c", "e");
        when(sc.nextDouble()).thenReturn(0.0);
        bankMenu.menu();
        assertDoesNotThrow(()->bankMenu.menu());

    }
}
