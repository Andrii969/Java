package ChallengeUseUnmodifiableCollections;

import ChallengeUseUnmodifiableCollections.BankAccount.AccountType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static ChallengeUseUnmodifiableCollections.BankAccount.AccountType.CHECKING;
import static ChallengeUseUnmodifiableCollections.BankAccount.AccountType.SAVINGS;

public class BankCustomer {
    private static int lastCustomerId = 10_000_000;

    private final String name;
    private final int customerId;
    private final List<BankAccount> accounts = new ArrayList<>();

    BankCustomer(String name, double checkingAmount, double savingsAmount) {
        this.name = name;
        this.customerId = lastCustomerId++;
        accounts.add(new BankAccount(CHECKING, checkingAmount));
        accounts.add(new BankAccount(SAVINGS, savingsAmount));
    }

    public String getName() {
        return name;
    }

    public String getCustomerId() {
        return "%015d".formatted(customerId);
    }

    public List<BankAccount> getAccounts() {
        return List.copyOf(accounts); // making it immutable
    }

    public BankAccount getAccount(AccountType type) {

        for (var account : accounts) {
            if (account.getAccountType() == type) {
                return account;
            }
        }
        return null;
    }

    @Override
    public String toString() {

        String[] accountStrings = new String[accounts.size()];
        Arrays.setAll(accountStrings, i -> accounts.get(i).toString());
        return "Customer: %s (id:%015d)%n\t%s%n".formatted(name, customerId,
                String.join("\n\t", accountStrings));
    }
}
