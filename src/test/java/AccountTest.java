import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class AccountTest {

    private example.Account account;

    @BeforeEach
    public void setUp() {
        account = new example.Account();
    }

    @Test
    public void testInitialBalance() {
        assertEquals(0.0, account.getBalance(), "Initial balance should be 0.0");
    }

    @Test
    public void testDeposit() {
        account.deposit(100.0);
        assertEquals(100.0, account.getBalance(), "Balance should be 100.0 after deposit");
    }

    @Test
    public void testWithdrawSuccessful() {
        account.deposit(100.0);
        double amountWithdrawn = account.withdraw(50.0);
        assertEquals(50.0, amountWithdrawn, "Withdrawn amount should be 50.0");
        assertEquals(50.0, account.getBalance(), "Balance should be 50.0 after withdrawal");
    }

    @Test
    public void testWithdrawInsufficientFunds() {
        account.deposit(50.0);
        double amountWithdrawn = account.withdraw(100.0);
        assertEquals(0.0, amountWithdrawn, "Withdrawn amount should be 0.0 when balance is insufficient");
        assertEquals(50.0, account.getBalance(), "Balance should remain 50.0 when withdrawal fails");
    }

    @Test
    public void testWithdrawExactAmount() {
        account.deposit(100.0);
        double amountWithdrawn = account.withdraw(100.0);
        assertEquals(100.0, amountWithdrawn, "Withdrawn amount should be 100.0");
        assertEquals(0.0, account.getBalance(), "Balance should be 0.0 after withdrawing the exact amount");
    }
}
