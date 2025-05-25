import org.example.Factorial;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FactorialTest {

    @Test
    void testFactorialBaseCases() {
        assertEquals(1, Factorial.factorial(0), "factorial(0) = 1");
        assertEquals(1, Factorial.factorial(1), "factorial(1) = 1");
    }

    @Test
    void testFactorialGeneralCases() {
        assertEquals(2, Factorial.factorial(2), "factorial(2) = 2");

        assertEquals(120, Factorial.factorial(5), "factorial(5) = 120");
    }

    @Test
    void testFactorialLargerInput() {
        assertEquals(362880, Factorial.factorial(10), "factorial(10) = 362880");
    }
}
