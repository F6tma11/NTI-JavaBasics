package com.bank;

import com.bank.exceptions.InsufficientFundsException;
import com.bank.exceptions.ValueResolveException;
import com.bank.managment.Bank;
import com.bank.models.Account;
import com.bank.models.CheckingAccount;
import com.bank.models.Customer;
import com.bank.models.SavingsAccount;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Bank bank=new Bank();

        Account account=new SavingsAccount("001-S",1000,new Customer("101","fatma","fatma@gmail.com"),3.5);
        Account account1=new CheckingAccount("002-C",100000,new Customer("102","Fatma Ahmed","fatmaahmed@gmail.com"));
        try {
            Account account2=new CheckingAccount("002-C",100000,new Customer("102","Fatma Ahmed","fatmaahmed@gmail.com"));
        }catch (IllegalArgumentException illegalArgumentException){
            System.out.println(illegalArgumentException.getMessage());
        }

        bank.openAccount(account);
        bank.openAccount(account1);
        bank.displayAccounts();
        bank.deposit("001-S",20000);
        try{
            bank.withdraw("002-C",90);
            bank.withdraw("001-S",300000);

        }catch (InsufficientFundsException ex){
            System.out.println(ex.getMessage());
        }
        bank.displayTransaction();

        try{
            bank.getAccount("119-S");
        }catch (ValueResolveException valueResolveException){
            System.out.println("Account look up : "+valueResolveException.getMessage());
        }

    }
}