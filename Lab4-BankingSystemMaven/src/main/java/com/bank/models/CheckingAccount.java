package com.bank.models;

public class CheckingAccount extends Account {
    public CheckingAccount(String accountNumber, double balance, Customer customer) {
        super(accountNumber, balance, customer);
    }

    @Override
    public String getAccountType() {
        return "Checking Account";
    }
}
