
package com.mycompany.prblm_6;

// ATM.java
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class ATM {
    private String atmId;
    private Bank bank;
    private ArrayList<Transaction> transactionLog;

    public ATM(String atmId, Bank bank) {
        this.atmId = atmId;
        this.bank = bank;
        this.transactionLog = new ArrayList<>();
    }

    public String getAtmId() {
        return atmId;
    }

    public boolean authenticate(Customer customer, String accountNumber) {
        for (Account acc : customer.getAccounts()) {
            if (acc.getAccountNumber().equals(accountNumber)) {
                return true;
            }
        }
        return false;
    }

    public boolean withdraw(String accountNumber, double amount) {
        Account account = bank.getAccount(accountNumber);
        if (account != null && account.withdraw(amount)) {
            logTransaction("Withdrawal", amount, accountNumber, null);
            return true;
        }
        return false;
    }

    public boolean deposit(String accountNumber, double amount) {
        Account account = bank.getAccount(accountNumber);
        if (account != null && amount > 0) {
            account.deposit(amount);
            logTransaction("Deposit", amount, accountNumber, null);
            return true;
        }
        return false;
    }

    public boolean transfer(String fromAccountNumber, String toAccountNumber, double amount) {
        Account fromAcc = bank.getAccount(fromAccountNumber);
        Account toAcc = bank.getAccount(toAccountNumber);
        if (fromAcc != null && toAcc != null && fromAcc.transfer(toAcc, amount)) {
            logTransaction("Transfer", amount, fromAccountNumber, toAccountNumber);
            return true;
        }
        return false;
    }

    public void printTransactionLog() {
        for (Transaction t : transactionLog) {
            System.out.println(t.getSummary());
        }
    }

    private void logTransaction(String type, double amount, String sourceAcc, String targetAcc) {
        String trxId = UUID.randomUUID().toString();
        transactionLog.add(new Transaction(trxId, new Date(), type, amount, sourceAcc, targetAcc));
    }
}
