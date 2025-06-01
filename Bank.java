
package com.mycompany.prblm_6;

// Bank.java
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Bank {
    private String bankId;
    private String name;
    private List<Customer> customers;
    private HashMap<String, Account> accounts;

    public Bank(String bankId, String name) {
        this.bankId = bankId;
        this.name = name;
        this.customers = new ArrayList<>();
        this.accounts = new HashMap<>();
    }

    public String getBankId() {
        return bankId;
    }

    public String getName() {
        return name;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void addCustomer(Customer customer) {
        if (!customers.contains(customer)) {
            customers.add(customer);
        }
    }

    public void addAccount(Account account) {
        accounts.put(account.getAccountNumber(), account);
    }

    public Account getAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }

    public Customer getCustomerById(String customerId) {
        for (Customer c : customers) {
            if (c.getCustomerId().equals(customerId)) {
                return c;
            }
        }
        return null;
    }
}

