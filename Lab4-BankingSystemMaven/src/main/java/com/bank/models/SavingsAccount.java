package com.bank.models;

public class SavingsAccount extends Account {
    private double interestRate;
    public SavingsAccount(String accountNumber, double balance, Customer customer,double interestRate) {
        super(accountNumber, balance, customer);
        this.interestRate=interestRate;
    }

    @Override
    public String getAccountType() {
        return "Savings Account";
    }
}
