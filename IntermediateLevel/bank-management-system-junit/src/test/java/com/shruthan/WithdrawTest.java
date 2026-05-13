package com.shruthan;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

import org.junit.jupiter.api.*;

public class WithdrawTest {

    BankAccount account;
    Withdraw withdraw;
    List<String> history;

    @BeforeEach
    public void setup() {

        account = new BankAccount();
        withdraw = new Withdraw();
        history = new ArrayList<>();

        account.setInitialAmount(2000);
    }

    @AfterEach
    public void tearDown() {

        System.out.println("Withdraw Test Completed");
    }

    @Test
    public void testSuccessfulWithdraw() {

        withdraw.withdrawAmount(500, account, history);

        assertEquals(1500, account.getInitialAmount());
    }

    @Test
    public void testWithdrawEqualToBalance() {

        account.setInitialAmount(1000);

        withdraw.withdrawAmount(1000, account, history);

        assertEquals(0, account.getInitialAmount());
    }

    @Test
    public void testInsufficientFundsException() {

        account.setInitialAmount(1000);

        assertThrows(
                InsufficientFundsException.class,
                () -> withdraw.withdrawAmount(5000, account, history));
    }

    @Test
    public void testBalanceUnchangedAfterFailedWithdraw() {

        account.setInitialAmount(1000);

        try {
            withdraw.withdrawAmount(5000, account, history);
        } catch (InsufficientFundsException e) {

        }

        assertEquals(1000, account.getInitialAmount());
    }

    @Test
    public void testNegativeWithdraw() {

        withdraw.withdrawAmount(-100, account, history);

        assertEquals(2000, account.getInitialAmount());
    }

    @Test
    public void testWithdrawHistoryAdded() {

        withdraw.withdrawAmount(500, account, history);

        assertEquals(1, history.size());
    }
}