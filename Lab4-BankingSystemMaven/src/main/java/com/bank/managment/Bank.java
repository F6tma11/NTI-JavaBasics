package com.bank.managment;

import com.bank.exceptions.InsufficientFundsException;
import com.bank.exceptions.ValueResolveException;
import com.bank.models.Account;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;


public class Bank {

    private HashMap<String, Account> accounts;
    private LinkedList<String> transactions;
    private static final Logger log= LoggerFactory.getLogger(Bank.class);

    public Bank() {
        accounts=new HashMap<>();
        transactions=new LinkedList<>();
    }

    public void openAccount(Account account){
        if (accounts.containsKey(account.getAccountNumber())){
            log.error("Account number already exist");
            throw new IllegalArgumentException("Account number already exist");
        }

        accounts.put(account.getAccountNumber(),account);
        System.out.printf("Opened %s  %s for %s  ($%.2f)\n",account.getAccountType(),account.getAccountNumber(),account.getCustomer().getName(),account.getBalance());
    }

    public Account getAccount(String accountNumber){
        if (accounts.get(accountNumber)==null){
            throw new ValueResolveException("Account not found");
        }

        return accounts.get(accountNumber);
    }

    public void deposit(String accountNumber,double amount){
        Account account=getAccount(accountNumber);
        account.deposit(amount);
        transactions.add("You added "+amount+" to your account total balance is"+account.getBalance());
        System.out.printf("Deposited $%.2f into account %s. New balance: $%.2f \n",amount,account.getAccountNumber(),account.getBalance());
    }

    public void withdraw(String accountNumber,double amount) throws InsufficientFundsException {
        Account account=getAccount(accountNumber);

        account.withdraw(amount);
        transactions.add("You withdraw "+amount+" total balance is "+account.getBalance());
    }

    public void displayTransaction(){
        for (String transaction:transactions){
            System.out.println(transaction);
        }
    }

    public void displayAccounts(){
        for (Map.Entry<String,Account> accountEntry:accounts.entrySet()){
            System.out.println(accountEntry.getValue().getAccountNumber());
        }
    }

}
