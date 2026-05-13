package com.shruthan;

import java.util.List;

public class Withdraw {

    public void withdrawAmount(
            int withdrawAmount,
            BankAccount account,
            List<String> history)
            throws InsufficientFundsException {

        synchronized(account) {

            if (withdrawAmount <= 0) {

                System.out.println("Invalid withdraw amount");

                history.add("Tried invalid withdrawal of " + withdrawAmount);
                return;
            }

            System.out.println(Thread.currentThread().getName() + " is trying to withdraw " + withdrawAmount);

            if (withdrawAmount > account.getInitialAmount()) {

                history.add(withdrawAmount + " cannot be withdrawn as there is less balance.. "+ account.getInitialAmount());

                throw new InsufficientFundsException(withdrawAmount + " cannot be withdrawn as there is less balance..");
            }

            int currentBalance = account.getInitialAmount();

            int newAmount = currentBalance - withdrawAmount;

            account.setInitialAmount(newAmount);

            System.out.println(Thread.currentThread().getName()+ " completed withdrawal.");

            System.out.println("Remaining Balance: " + account.getInitialAmount());

            history.add("Withdraw of "+ withdrawAmount+ " is complete.. Total: "+ account.getInitialAmount());
        }
    }
}