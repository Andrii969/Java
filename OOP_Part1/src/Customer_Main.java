public class Customer_Main {

    public static void main(String[] args) {

        Customer customerOne = new Customer("John", 0, "john@g.com");
        System.out.println(
                customerOne.getName() + " " +
                        customerOne.getCreditLimit() + " " +
                        customerOne.getEmailAddress()
        );

        Customer customerTwo = new Customer("Mike", "mike@g.com");
        System.out.println(
                customerTwo.getName() + " " +
                        customerTwo.getCreditLimit() + " " +
                        customerTwo.getEmailAddress()
        );

        Customer customerThree = new Customer();
        System.out.println(
                customerThree.getName() + " " +
                        customerThree.getCreditLimit() + " " +
                        customerThree.getEmailAddress()
        );

    }
}
