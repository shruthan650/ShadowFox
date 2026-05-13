package com.shruthan;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        SwitchHandler handle;
        List<String> history = new ArrayList<>();
        BankAccount account = new BankAccount();
        int choice;
        Deposit deposit = new Deposit();
        Withdraw withdraw = new Withdraw();
        Scanner s = new Scanner(System.in);

        while (true) {
            System.out.println("BANK MANAGEMENT SYSTEM");
            System.out.println("-----------------------------------------");
            System.out.println("1. Set Account Name: ");
            System.out.println("2. Set Account Holder Phone Number: ");
            System.out.println("3. Set Initial Balance");
            System.out.println("4. Deposit Amount");
            System.out.println("5. Withdraw Amount");
            System.out.println("6. Check Balance");
            System.out.println("7. View Transaction History");
            System.out.println("8. Exit");
            System.out.println("------------------------------------------");

            System.out.println("Enter your choice: ");
            choice =  s.nextInt();

            handle = new SwitchHandler();

            handle.handleSwitch(
                account,
                choice,
                deposit, 
                withdraw, 
                s,
                history
            );
        }
    }
}
