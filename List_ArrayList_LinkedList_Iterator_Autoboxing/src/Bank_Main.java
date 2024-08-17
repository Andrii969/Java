public class Bank_Main {

    public static void main(String[] args) {
        // Create a new Bank
        Bank bank = new Bank("MyBank");

        // Add some customers
        System.out.println("Adding Customers:");
        bank.addNewCustomer("Alice");
        bank.addNewCustomer("Bob");
        bank.addNewCustomer("Charlie");

        // Try adding a customer that already exists
        System.out.println("\nAttempt to add an existing customer:");
        bank.addNewCustomer("Alice");  // Should indicate that the customer already exists

        // Add transactions for customers
        System.out.println("\nAdding Transactions:");
        bank.addTransaction("Alice", 250.50);
        bank.addTransaction("Bob", 100.00);
        bank.addTransaction("Alice", -75.00);
        bank.addTransaction("Charlie", 300.00);

        // Try adding a transaction for a non-existent customer
        System.out.println("\nAttempt to add a transaction to a non-existent customer:");
        bank.addTransaction("Dave", 50.00);  // Should indicate that the customer is not found

        // Print statements for all customers
        System.out.println("\nBank Statement:");
        bank.printStatement();


    }
}
