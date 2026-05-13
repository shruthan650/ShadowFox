package com.shruthan;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class ThreadSafetyTest {

    @Test
    public void testConcurrentWithdraw()
            throws InterruptedException {

        BankAccount account = new BankAccount();

        Withdraw withdraw = new Withdraw();

        List<String> history = new ArrayList<>();

        account.setInitialAmount(1000);

        Thread t1 = new Thread(() -> {

            try {

                withdraw.withdrawAmount(
                        800,
                        account,
                        history
                );

            }
            catch (Exception e) {
                System.out.println(Thread.currentThread().getName()+ ": "+ e.getMessage());
            }

        }, "Thread-1");

        Thread t2 = new Thread(() -> {

            try {

                withdraw.withdrawAmount(
                        500,
                        account,
                        history
                );

            }
            catch (Exception e) {
                System.out.println(Thread.currentThread().getName() + ": " + e.getMessage());
            }

        }, "Thread-2");

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final Balance: "+ account.getInitialAmount());

        assertTrue(account.getInitialAmount() >= 0);
    }
}