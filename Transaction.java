
package com.mycompany.prblm_6;

// Transaction.java
import java.util.Date;

public class Transaction {
    private String transactionId;
    private Date date;
    private String type; // "Withdrawal", "Deposit", "Transfer"
    private double amount;
    private String sourceAccountNumber;
    private String targetAccountNumber; // null if not a transfer

    public Transaction(String transactionId, Date date, String type, double amount, String sourceAccountNumber, String targetAccountNumber) {
        this.transactionId = transactionId;
        this.date = date;
        this.type = type;
        this.amount = amount;
        this.sourceAccountNumber = sourceAccountNumber;
        this.targetAccountNumber = targetAccountNumber;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public Date getDate() {
        return date;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public String getSourceAccountNumber() {
        return sourceAccountNumber;
    }

    public String getTargetAccountNumber() {
        return targetAccountNumber;
    }

    public String getSummary() {
        if ("Transfer".equalsIgnoreCase(type) && targetAccountNumber != null) {
            return date + " | " + type + " | " + amount + " | From: " + sourceAccountNumber + " To: " + targetAccountNumber;
        } else {
            return date + " | " + type + " | " + amount + " | Account: " + sourceAccountNumber;
        }
    }
}
