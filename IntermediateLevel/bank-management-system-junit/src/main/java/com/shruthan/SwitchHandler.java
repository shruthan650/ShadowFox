package com.shruthan;

import java.util.*;

public class SwitchHandler {

    public void handleSwitch(
            BankAccount account,
            int choice,
            Deposit deposit,
            Withdraw withdraw,
            Scanner s,
            List<String> history) {
        switch (choice) {
            case 1:
                s.nextLine();
                System.out.print("Enter Account Holder Name: ");
                String name = s.nextLine();

                account.setAccountHolderName(name);

                System.out.println("Account name set..");
                break;

            case 2:
                System.out.println("Enter Account Phone Number: ");
                String phone = s.next();

                account.setAccountHolderMobile(phone);

                System.out.println("Account Phone Number set..");
                break;

            case 3:
                if (checkNameAndMobile(account)) {
                    System.out.println("Enter Name and Phone number first");
                    break;
                } else {
                    System.out.print("Enter Initial Amount: ");

                    int initialBalance = s.nextInt();
                    account.setInitialAmount(initialBalance);

                    System.out.println("Initial Amount of " + account.getInitialAmount() + " is set..");
                    history.add(("Initial Amount of " + account.getInitialAmount() + " is set.." + " Total: "
                            + account.getInitialAmount()).toString());

                    break;
                }

            case 4:

                if (checkNameAndMobile(account)) {

                    System.out.println("Enter Name and Phone number first");
                    break;

                } else {

                    System.out.print("Enter Deposit Amount: ");

                    int depositAmount = s.nextInt();

                    deposit.depositAmount(
                            depositAmount,
                            account,
                            history);

                    break;
                }

            case 5:

                if (checkNameAndMobile(account)) {

                    System.out.println("Enter Name and Phone number first");

                    break;

                } else {

                    System.out.println("Enter Withdraw Amount: ");

                    int withdrawAmount = s.nextInt();

                    try {
                        withdraw.withdrawAmount(
                                withdrawAmount,
                                account,
                                history);

                    } catch (InsufficientFundsException e) {
                        System.out.println("InsufficientFundsException: " + e.getMessage());
                        break;
                    }

                    break;
                }

            case 6:
                if (checkNameAndMobile(account) || account.getInitialAmount() == 0) {
                    System.out.println("Enter Name and Phone number first and also initial amount");
                    break;
                } else {
                    System.out.println("Balance: " + account.getInitialAmount());
                    history.add("Checked balance" + " Total: " + account.getInitialAmount());
                    break;
                }

            case 7:
                if (checkNameAndMobile(account)) {
                    System.out.println("Enter Name and Phone number first");
                    break;
                } else {
                    System.out.println("Transaction History");
                    System.out.println("----------------------------------");

                    for (String logs : history)
                        System.out.println(logs);

                    System.out.println("----------------------------------");
                    break;
                }

            case 8:
                System.out.println("Exiting.....");
                history.add("Exited");
                s.close();
                System.exit(0);
                break;

            default:
                System.out.println("Invalid choice");
        }
    }

    public boolean checkNameAndMobile(BankAccount account) {
        if ((account.getAccountHolderName()) == null || (account.getAccountHolderMobile()) == null)
            return true;
        else
            return false;
    }
}
