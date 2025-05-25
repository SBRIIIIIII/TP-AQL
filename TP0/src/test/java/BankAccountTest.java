import org.example.BankAccount;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {

    @Test
    void testInitialBalance() {
        BankAccount account = new BankAccount(1000.0, 0.05);
        assertEquals(1000.0, account.getBalance(), 0.0001);
    }

    @Test
    void testDepositValidAmount() {
        BankAccount account = new BankAccount(500.0, 0.03);
        account.deposit(200.0);
        assertEquals(700.0, account.getBalance(), 0.0001);
    }

    @Test
    void testDepositNegativeAmountThrowsException() {
        BankAccount account = new BankAccount(500.0, 0.03);
        assertThrows(IllegalArgumentException.class, () -> account.deposit(-100.0));
    }

    @Test
    void testWithdrawValidAmount() {
        BankAccount account = new BankAccount(800.0, 0.04);
        account.withdraw(300.0);
        assertEquals(500.0, account.getBalance(), 0.0001);
    }

    @Test
    void testWithdrawMoreThanBalanceThrowsException() {
        BankAccount account = new BankAccount(400.0, 0.02);
        assertThrows(IllegalStateException.class, () -> account.withdraw(500.0));
    }

    @Test
    void testWithdrawNegativeAmountThrowsException() {
        BankAccount account = new BankAccount(400.0, 0.02);
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(-50.0));
    }

    @Test
    void testTransferValidAmount() {
        BankAccount source = new BankAccount(1000.0, 0.01);
        BankAccount target = new BankAccount(500.0, 0.01);
        source.transfer(300.0, target);

        assertEquals(700.0, source.getBalance(), 0.0001);
        assertEquals(800.0, target.getBalance(), 0.0001);
    }

    @Test
    void testTransferToNullAccountThrowsException() {
        BankAccount source = new BankAccount(1000.0, 0.01);
        assertThrows(NullPointerException.class, () -> source.transfer(100.0, null));
    }

    @Test
    void testAddInterest() {
        BankAccount account = new BankAccount(1000.0, 0.10); // 10% interest
        account.addInterest();
        assertEquals(1100.0, account.getBalance(), 0.0001);
    }
}
