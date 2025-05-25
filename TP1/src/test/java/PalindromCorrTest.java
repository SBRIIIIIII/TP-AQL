import org.example.PalindromCorr;
import org.example.Palindrome;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PalindromCorrTest {

    @Test
    void testSimplePalindrome() {
        assertTrue(PalindromCorr.isPalindrome("kayak"));
    }

    @Test
    void testPalindromeWithSpacesAndUpperCase() {
        assertTrue(PalindromCorr.isPalindrome("Esope reste ici et se repose"));
    }

    @Test
    void testNonPalindrome() {
        assertFalse(Palindrome.isPalindrome("bonjour"));
    }

    @Test
    void testSingleCharacter() {
        assertTrue(Palindrome.isPalindrome("A"));
    }

    @Test
    void testEmptyString() {
        assertTrue(Palindrome.isPalindrome(""));  // convention : chaîne vide = palindrome
    }

    @Test
    void testNullInput() {
        assertThrows(NullPointerException.class, () -> Palindrome.isPalindrome(null));
    }
}
