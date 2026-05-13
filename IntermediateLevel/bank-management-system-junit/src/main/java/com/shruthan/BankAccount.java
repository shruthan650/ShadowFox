package com.shruthan;

public class BankAccount {
    private String accountHolderName;
    private String accountHolderMobile;
    private int initialAmount;
 
    public String getAccountHolderName() {
        return accountHolderName;
    }

    public int getInitialAmount() {
        return initialAmount;
    }

    public void setInitialAmount(int initialAmount) {
        this.initialAmount = initialAmount;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public String getAccountHolderMobile() {
        return accountHolderMobile;
    }

    public void setAccountHolderMobile(String accountHolderMobile) {
        this.accountHolderMobile = accountHolderMobile;
    }
}
