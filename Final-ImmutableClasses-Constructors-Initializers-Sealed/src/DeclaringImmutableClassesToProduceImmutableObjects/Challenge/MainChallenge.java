package DeclaringImmutableClassesToProduceImmutableObjects.Challenge;

import static DeclaringImmutableClassesToProduceImmutableObjects.Challenge.AnotherBankAccount.BankAccountType.CHECKING;

public class MainChallenge {

    public static void main(String[] args) {

        AnotherBankAccount account = new AnotherBankAccount(CHECKING, 500.0);
        System.out.println(account);

        AnotherBankCustomer joe = new AnotherBankCustomer("Joe", 500.00, 10000.00);
        System.out.print(joe);

        var joeAccounts = joe.getBankAccounts();
        joeAccounts.clear();  // doesn't change the original (see getBankAccounts())
        joeAccounts.add(new AnotherBankAccount(CHECKING, 123.12)); // doesn't change the original (see getBankAccounts())
        System.out.print(joe);

    }
}
