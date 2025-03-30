package DeclaringImmutableClassesToProduceImmutableObjects.Challenge;

public class AnotherBankAccount {

    public enum BankAccountType {
        CHECKING("checking"),
        SAVINGS("savings");

        private final String type;

        BankAccountType(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }
    }

    private final BankAccountType bankAccountType;
    private final Double balance;

    public AnotherBankAccount(BankAccountType bankAccountType, Double balance) {
        this.bankAccountType = bankAccountType;
        this.balance = balance < 0 ? 0 : balance;
    }

    public BankAccountType getBankAccountType() {
        return bankAccountType;
    }


    public Double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "%s $%.2f".formatted(bankAccountType, balance);
    }
}
