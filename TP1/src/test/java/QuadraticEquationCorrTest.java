
import org.example.QuadraticEquationCorr;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuadraticEquationCorrTest {

    @Test
    void testTwoRealSolutions() {
        double[] result = QuadraticEquationCorr.solve(1, -3, 2); // x² - 3x + 2 = 0
        assertNotNull(result);
        assertEquals(2.0, result[0], 0.0001);
        assertEquals(1.0, result[1], 0.0001);
    }

    @Test
    void testOneRealSolution() {
        double[] result = QuadraticEquationCorr.solve(1, 2, 1); // x² + 2x + 1 = 0
        assertNotNull(result);
        assertEquals(-1.0, result[0], 0.0001);
        assertEquals(1, result.length);
    }

    @Test
    void testNoRealSolution() {
        double[] result = QuadraticEquationCorr.solve(1, 0, 1); // x² + 1 = 0
        assertNull(result); // pas de solution réelle
    }

    @Test
    void testIllegalArgumentWhenAIsZero() {
        assertThrows(IllegalArgumentException.class, () -> QuadraticEquationCorr.solve(0, 2, 3));
    }

    @Test
    void testNegativeBAndC() {
        double[] result = QuadraticEquationCorr.solve(1, -2, -3); // x² - 2x - 3 = 0
        assertNotNull(result);
        assertEquals(3.0, result[0], 0.0001);
        assertEquals(-1.0, result[1], 0.0001);
    }
}

