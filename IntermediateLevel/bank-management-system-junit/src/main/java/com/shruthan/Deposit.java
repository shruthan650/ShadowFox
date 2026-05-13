package com.shruthan;

import java.util.List;

public class Deposit {

    public void depositAmount(
            int depositAmount,
            BankAccount account,
            List<String> history) {

        if (depositAmount <= 0) {

            System.out.println("Negative money cannot be deposited");

            history.add(
                    "Tried to deposit negative amount: " + depositAmount);

            return;
        }

        int newAmount = account.getInitialAmount() + depositAmount;

        account.setInitialAmount(newAmount);

        System.out.println(
                "Deposited " + depositAmount + " to your bank account..");

        history.add(
                "Deposited " + depositAmount +
                        " Total: " + account.getInitialAmount());
    }
}