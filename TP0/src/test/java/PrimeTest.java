import org.example.Prime;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PrimeTest {

    @Test
    void testPrimeNumbers() {
        assertTrue(Prime.isPrime(2), "2 est premier");
        assertTrue(Prime.isPrime(5), "5 est premier");
        assertTrue(Prime.isPrime(7), "7 est premier");
        assertTrue(Prime.isPrime(13), "13 est premier");

    }

    @Test
    void testNonPrimeNumbers() {

        assertFalse(Prime.isPrime(8), "8 n'est pas premier");
        assertFalse(Prime.isPrime(9), "9 n'est pas premier");
        assertFalse(Prime.isPrime(100), "100 n'est pas premier");
    }
}
