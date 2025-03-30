package ChallengeUseUnmodifiableCollections;

import java.util.List;

import static ChallengeUseUnmodifiableCollections.BankAccount.AccountType.CHECKING;
import static ChallengeUseUnmodifiableCollections.BankAccount.AccountType.SAVINGS;

public class Main {

    public static void main(String[] args) {

        Bank bank = new Bank(3214567);
        bank.addCustomer("Joe", 500.00, 10000.00);

        BankCustomer joe = bank.getCustomer("000000010000000");
        List<BankAccount> joeAccounts = joe.getAccounts();
        joeAccounts.forEach(System.out::println);
//        accounts.clear();
//        System.out.print(joe);

        if (bank.doTransaction(joe.getCustomerId(), CHECKING, 35)) {
            System.out.print(joe);
        }

        if (bank.doTransaction(joe.getCustomerId(), CHECKING, 45)) {
            System.out.print(joe);
        }

        if (bank.doTransaction(joe.getCustomerId(), SAVINGS, 35)) {
            System.out.print(joe);
        }

        if (bank.doTransaction(joe.getCustomerId(), SAVINGS, 45)) {
            System.out.print(joe);
        }

        BankAccount joeChecking = joe.getAccount(CHECKING);
        var joeCheckingTransactions = joeChecking.getTransactions();
        joeCheckingTransactions.forEach((k, v) -> System.out.println(k + ":" + v));
        BankAccount joeSavings = joe.getAccount(SAVINGS);
        var joeSavingsTransactions = joeSavings.getTransactions();
        joeSavingsTransactions.forEach((k, v) -> System.out.println(k + ":" + v));

//        joeCheckingTransactions.put(3L, new Transaction(1, 1,
//                Integer.parseInt(joe.getCustomerId()), 500)); // fails because it's final

//        for (var tx : joeCheckingTransactions.values()) { // fails because transactions returned are Map<Long, String>
//            tx.setCustomerId(2);
//            tx.setAmount(1000.00);
//        }
//        joeCheckingTransactions.forEach((k, v) -> System.out.println(k + " " + v));


    }
}
