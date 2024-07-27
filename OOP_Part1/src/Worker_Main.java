public class Worker_Main {

    public static void main(String[] args) {
        Worker Tom = new Worker("Tom", "15.04.99");
        System.out.println(Tom);

        Worker_Employee Harry = new Worker_Employee("Harry", "12.05.1998", "11.03.2022");
        System.out.println(Harry);
        System.out.println("Age = " + Harry.getAge());
        System.out.println("Pay = " + Harry.collectPay());

        Worker_SalariedEmployee Ron = new Worker_SalariedEmployee("Ron", "12.05.1998",
                "11.03.2022", 35000);
        System.out.println(Ron);
        System.out.println("Paycheck = $" + Ron.collectPay());
        Ron.retire();
        System.out.println(Ron);
        System.out.println("Paycheck = $" + Ron.collectPay());

        Worker_HourlyEmployee Hermione = new Worker_HourlyEmployee("Hermione", "12.05.1998",
                "11.03.2022", 12);
        System.out.println(Hermione);
        System.out.println(Hermione.collectPay()); // 40 * 12 = 480
        System.out.println(Hermione.getDoublePay()); // 40 * 12 * 2 = 960
    }
}
