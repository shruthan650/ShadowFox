package com.shruthan;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

import org.junit.jupiter.api.*;

public class DepositTest {

    BankAccount account;
    Deposit deposit;
    List<String> history;

    @BeforeEach
    public void setup() {

        account = new BankAccount();
        deposit = new Deposit();
        history = new ArrayList<>();

        account.setInitialAmount(1000);
    }

    @AfterEach
    public void tearDown() {

        System.out.println("Deposit Test Completed");
    }

    @Test
    public void testPositiveDeposit() {

        deposit.depositAmount(500, account, history);

        assertEquals(1500, account.getInitialAmount());
    }

    @Test
    public void testZeroDeposit() {

        deposit.depositAmount(0, account, history);

        assertEquals(1000, account.getInitialAmount());
    }

    @Test
    public void testNegativeDeposit() {

        deposit.depositAmount(-500, account, history);

        assertEquals(1000, account.getInitialAmount());
    }

    @Test
    public void testDepositHistoryAdded() {

        deposit.depositAmount(500, account, history);

        assertEquals(1, history.size());
    }

    @Test
    public void testNegativeDepositHistory() {

        deposit.depositAmount(-1000, account, history);

        assertTrue(history.get(0).contains("negative"));
    }
}