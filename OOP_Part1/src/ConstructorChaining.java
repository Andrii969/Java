public class ConstructorChaining {

    private int accountNumber;
    private double accountBalance;
    private String customerName;
    private String email;
    private String phoneNumber;


    public int getAccountNumber() {
        return accountNumber;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // Constructors Start
    public ConstructorChaining() {
        this (7654321, "John Smith", 200, "johnsmith@g.com",
                "(097) 34-56-564"); // must be first line here
        System.out.println("Empty constructor called");
    }

    public ConstructorChaining(int accountNumber, String customerName, double accountBalance, String customerEmail,
                        String customerPhone) {
        System.out.println("Account constructor with parameters called");
        this.accountNumber = accountNumber;
        this.customerName = customerName;
        this.accountBalance = accountBalance;
        email = customerEmail; // not necessary to use 'this', as parameter names are different
        phoneNumber = customerPhone; // not necessary to use 'this', as parameter names are different
    }

    public ConstructorChaining(String customerName, String customerEmail, String customerPhone) {
        this(99999, customerName, 1010, customerEmail, customerPhone);
//        this.customerName = customerName;
//        this.email = email;
//        this.phoneNumber = phoneNumber;
    }
    // Constructors End

    public void depositing (double depositAmount) {
        this.accountBalance += depositAmount;
        System.out.println("Account balance was updated. The current balance is " + this.accountBalance);
    };

    public void withdrawing (double withdrawAmount) {
        if (withdrawAmount > this.accountBalance) {
            System.out.println("Withdrawing isn't allowed. Not enough money. The current balance is " + this.accountBalance);
            return;
        }
        this.accountBalance -= withdrawAmount;
        System.out.println("Account balance was updated. The current balance is " + this.accountBalance);
    };
}
