public class Constructors_Main {

    public static void main(String[] args) {


        Constructors bobsAccount = new Constructors(1234567, "Bob Brown", 100,
                "bobbrown@g.com", "(068) 34-23-943");

//        bobsAccount.setCustomerName("Bob Brown");
//        bobsAccount.setPhoneNumber("(068) 34-23-943");
//        bobsAccount.setEmail("bobbrown@g.com");
//        bobsAccount.setAccountNumber(1234567);
//        bobsAccount.setAccountBalance(100);

        bobsAccount.depositing(20);
        bobsAccount.withdrawing(90);
        bobsAccount.withdrawing(20);
        bobsAccount.withdrawing(10);
        bobsAccount.withdrawing(1);
    }
}
