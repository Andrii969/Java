package dev;

import java.util.ArrayList;

public class Bank {

    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<>();
    }

    public boolean addBranch(String branchName) {
        Branch branch = findBranch(branchName);
        if (branch == null) {
            branches.add(new Branch(branchName));
            return true;
        }
        return false;
    }

    public boolean addCustomer(String branchName, String customerName, double initialTransaction) {
        Branch branch = findBranch(branchName);
        ArrayList<Customer> list;
        if (branch == null) { // checking if branch exists
            return false;
        }
//        else {
//            list = branch.getCustomers();
//        }
//        Customer customer = branch.findCustomer(customerName);
//        if (customer == null) { // checking if customer isn't already added to this branch
//            branch.newCustomer(customerName, initialTransaction); // if not added -> create & add a new customer
//            return true;
//        }
        return branch.newCustomer(customerName, initialTransaction); // method from the Branch class, that checks if there is no such a customer & adds it
        // returns true if added successfully, or false if not added
    }

    public boolean addCustomerTransaction(String branchName, String customerName, double transaction) {
        Branch branch = findBranch(branchName);
        ArrayList<Customer> list;
        if (branch == null) { // checking if branch exists
            return false;
        }
        return branch.addCustomerTransaction(customerName, transaction); // method from the Branch class, that checks if there is such a customer & adds transaction
        // returns true if added successfully, or false if not added
    }

    private Branch findBranch(String branchName) {
        for (Branch branch : branches) {
            if (branch.getName().equalsIgnoreCase(branchName)) {
                return branch;
            }
        }
        return null;
    }

    public boolean listCustomers(String branchName, boolean printTransactions) {
        Branch branch = findBranch(branchName);
        if (branch == null) {
            return false;
        }
        ArrayList<Customer> customersOnBranch = branch.getCustomers();
        System.out.println("Customer details for branch " + branchName);
        for (int i = 0; i < customersOnBranch.size(); i++) {
            Customer customer = customersOnBranch.get(i);
            System.out.printf("Customer: %s[%d] %n", customer.getName(), i + 1);
            if (printTransactions) {
                ArrayList<Double> customerTransactions = customer.getTransactions();
                System.out.println("Transactions");
                for (int j = 0; j < customerTransactions.size(); j++) {
//                    double transaction = customerTransactions.get(j);
                    System.out.printf("[%d] Amount %.2f %n", j + 1, customerTransactions.get(j)); // 2 decimal places
                }
            }
        }
        return true;
    }
}
