import java.util.ArrayList;

public class Bank {

    private String name;
    private ArrayList<Customer> customers;

    public Bank(String name) {
        this.name = name;
        this.customers = new ArrayList<>();
    }

    public boolean addNewCustomer(String customerName) {
        for (Customer customer : customers) {
            if (customer.getName().equalsIgnoreCase(customerName)) {
                System.out.println("Customer already exists");
                return false;
            }
        }
        customers.add(new Customer(customerName));
        System.out.println("Customer successfully added");
        return true;
    }

    public void addTransaction(String customerName, double transactionAmount) {
        for (Customer customer : customers) {
            if (customer.getName().equalsIgnoreCase(customerName)) {
                customer.addTransaction(transactionAmount);
            }
        }
        System.out.println("Customer not found");
    }

    public void printStatement() {
        for (Customer customer : customers) {
            printCustomerStatement(customer.getName());
        }
    }

    public void printCustomerStatement(String customerName) {
        for (Customer customer : customers) {
            if (customer.getName().equalsIgnoreCase(customerName)) {
                System.out.println("-".repeat(30));
                System.out.println("Customer Name: " + customer.getName());
                System.out.println("Transactions:");
                for (double d : customer.getTransactions()) { //
                    System.out.printf("$%10.2f (%s)%n", d, d < 0 ? "debit" : "credit"); // width of 10 and a precision of 2 decimals
                }
            }
        }
    }

}


class Customer {

    private String name;
    private ArrayList<Double> transactions;

    public Customer(String name) {
        this.name = name;
        this.transactions = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Double> getTransactions() {
        return transactions;
    }

    public void addTransaction(double transactionAmount) {
        this.transactions.add(transactionAmount);
        System.out.println("Transaction completed");
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", transactions=" + transactions +
                '}';
    }
}