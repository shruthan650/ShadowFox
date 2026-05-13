package com.shruthan;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

public class BankAccountTest {

    BankAccount account;

    @BeforeEach
    public void setup() {

        account = new BankAccount();
    }

    @AfterEach
    public void tearDown() {

        System.out.println("BankAccount Test Completed");
    }

    @Test
    public void testSetAndGetAccountHolderName() {

        account.setAccountHolderName("Shruthan");

        assertEquals("Shruthan", account.getAccountHolderName());
    }

    @Test
    public void testSetAndGetAccountHolderMobile() {

        account.setAccountHolderMobile("9876543210");

        assertEquals("9876543210", account.getAccountHolderMobile());
    }

    @Test
    public void testSetAndGetInitialAmount() {

        account.setInitialAmount(5000);

        assertEquals(5000, account.getInitialAmount());
    }
}