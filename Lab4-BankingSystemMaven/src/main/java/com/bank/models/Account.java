package com.bank.models;

import com.bank.exceptions.InsufficientFundsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class Account {
    private String accountNumber;
    private double balance;
    private Customer customer;
    private static final Logger log=LoggerFactory.getLogger(Account.class);

    public Account(String accountNumber, double balance, Customer customer) {
        if(accountNumber==null||accountNumber.isBlank()){
            log.error("Error: Account number can not be null");
            throw new IllegalArgumentException("Account number can not be null");
        }
        if (balance<0){
            log.error("Error:Balance can not be negative");
            throw new IllegalArgumentException("Balance can not be negative");
        }
        if (customer==null){
            log.error("Error: Account should owned by customer");
            throw new IllegalArgumentException("Account should owned by customer");
        }
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.customer = customer;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public Customer getCustomer() {
        return customer;
    }

    public abstract String getAccountType();

    public void deposit(double amount){
        if (amount<=0){
            log.error("Error: amount can not be negative or zero");
            throw new IllegalArgumentException("Amount can not be negative or zero");
        }
        balance+=amount;
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount<=0){
            log.error("Error: amount can not be negative or zero");
            throw new IllegalArgumentException("Amount can not be negative or zero");
        }
        if (amount>balance){
            throw new InsufficientFundsException("Insufficient funds");
        }
        balance-=amount;
    }



}
