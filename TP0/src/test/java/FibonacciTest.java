import static org.junit.jupiter.api.Assertions.*;
import org.example.Fibonacci;
import org.junit.jupiter.api.Test;
public class FibonacciTest {

    @Test
    void TestFibonacci(){
        assertEquals(0, Fibonacci.fibonacci(0));
        assertEquals(1, Fibonacci.fibonacci(1));
        assertEquals(3, Fibonacci.fibonacci(4));
        assertEquals(5, Fibonacci.fibonacci(5));
        assertEquals(8, Fibonacci.fibonacci(6));

    }
    @Test
    public void testFibonacciNegativeInput() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> Fibonacci.fibonacci(-1));
        assertEquals("n must be positive", exception.getMessage());
    }

}