package DeclaringImmutableClassesToProduceImmutableObjects.Challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static DeclaringImmutableClassesToProduceImmutableObjects.Challenge.AnotherBankAccount.BankAccountType.CHECKING;
import static DeclaringImmutableClassesToProduceImmutableObjects.Challenge.AnotherBankAccount.BankAccountType.SAVINGS;

public class AnotherBankCustomer {

    private static int counter = 10_000_000;
    private final int customerId;
    private final String customerName;
    private final List<AnotherBankAccount> anotherBankAccounts = new ArrayList<>();

    public AnotherBankCustomer(String customerName, double checkingAmount, double savingsAmount) {
        this.customerId = counter++;
        this.customerName = customerName;
        anotherBankAccounts.add(new AnotherBankAccount(CHECKING, checkingAmount));
        anotherBankAccounts.add(new AnotherBankAccount(SAVINGS, savingsAmount));
    }

    public String getCustomerName() {
        return customerName;
    }

    public List<AnotherBankAccount> getBankAccounts() {
        return new ArrayList<>(anotherBankAccounts);
    }

    @Override
    public String toString() {
        String[] accountStrings = new String[anotherBankAccounts.size()];
        Arrays.setAll(accountStrings, i -> getBankAccounts().get(i).toString());
        return "Customer: %s (id:%015d)%n \t%s%n".formatted(customerName, customerId,
                String.join("\n\t", accountStrings));
    }
}
