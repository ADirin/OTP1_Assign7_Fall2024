
public class MainClass {
    public static void main(String[] args) {
        // Create an instance of the Account class
        example.Account account = new example.Account();

        // Deposit some amount
        account.deposit(100.0);
        System.out.println("Deposited $100.0");

        // Withdraw some amount
        double amountWithdrawn = account.withdraw(50.0);
        System.out.println("Withdrawn $" + amountWithdrawn);

        // Display the current balance
        System.out.println("Current balance: $" + account.getBalance());
    }
}
