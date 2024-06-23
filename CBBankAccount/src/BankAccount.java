public class BankAccount {
    private int accountNumber;
    private String accountHolderName;
    private double balance;

    public BankAccount(int accountNumberIn, String accountHolderNameIn, double balanceIn) {
        accountNumber = accountNumberIn;
        accountHolderName = accountHolderNameIn;
        balance = balanceIn;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (balance > amount) {
            balance -= amount;
        }
    }

    public String toString() {
        String result = "Name: " + accountHolderName + "\nAccount Number: " + accountNumber + "\nBalance: " + balance;
        return result;
    }

}