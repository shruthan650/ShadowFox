package com.shruthan;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

public class SwitchHandlerTest {

    BankAccount account;
    SwitchHandler handler;

    @BeforeEach
    public void setup() {

        account = new BankAccount();
        handler = new SwitchHandler();
    }

    @AfterEach
    public void tearDown() {

        System.out.println("SwitchHandler Test Completed");
    }

    @Test
    public void testCheckNameAndMobileReturnsTrue() {

        assertTrue(handler.checkNameAndMobile(account));
    }

    @Test
    public void testCheckNameAndMobileReturnsFalse() {

        account.setAccountHolderName("Shruthan");
        account.setAccountHolderMobile("9876543210");

        assertFalse(handler.checkNameAndMobile(account));
    }
}        