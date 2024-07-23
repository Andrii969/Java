public class ConstructorChaining_Main {

    public static void main(String[] args) {


//        ConstructorChaining bobsAccount = new ConstructorChaining(1234567, "Bob Brown", 100,
//                "bobbrown@g.com", "(068) 34-23-943");

//        ConstructorChaining bobsAccount = new ConstructorChaining();

        ConstructorChaining bobsAccount = new ConstructorChaining("Mike Beach", "mikebeach@g.com",
                "(096) 34-54-231");

        System.out.println(
                bobsAccount.getAccountNumber() + " " +
                        bobsAccount.getCustomerName() + " " +
                        bobsAccount.getAccountBalance() + " " +
                        bobsAccount.getEmail() + " " +
                        bobsAccount.getPhoneNumber()
        );

        bobsAccount.depositing(20);
        bobsAccount.withdrawing(90);
        bobsAccount.withdrawing(20);
        bobsAccount.withdrawing(10);
        bobsAccount.withdrawing(1);
    }
}
