public class BankAccount_Main {

    public static void main(String[] args) {
        BankAccount bobsAccount = new BankAccount();

        bobsAccount.setCustomerName("Bob Brown");
        bobsAccount.setPhoneNumber("(068) 34-23-943");
        bobsAccount.setEmail("bobbrown@g.com");
        bobsAccount.setAccountNumber(1234567);
        bobsAccount.setAccountBalance(100);

        bobsAccount.depositing(20);
        bobsAccount.withdrawing(90);
        bobsAccount.withdrawing(20);
        bobsAccount.withdrawing(10);
        bobsAccount.withdrawing(1);
    }
}
