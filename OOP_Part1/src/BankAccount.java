public class BankAccount {

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
