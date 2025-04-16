import org.example.Palindrome;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PalindromeTest {

    // Vérifie qu'une chaîne nulle déclenche une NullPointerException
    @Test
    public void testNullInput() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            Palindrome.isPalindrome(null);
        });
        assertEquals("String must not be null", exception.getMessage());
    }

    // Vérifie qu'une chaîne vide est considérée comme un palindrome
    @Test
    public void testEmptyString() {
        assertTrue(Palindrome.isPalindrome(""), "Une chaîne vide doit être considérée comme un palindrome");
    }

    // Vérifie qu'une chaîne à un seul caractère est un palindrome
    @Test
    public void testSingleCharacter() {
        assertTrue(Palindrome.isPalindrome("a"), "Un seul caractère est toujours un palindrome");
    }

    // Vérifie un palindrome simple
    @Test
    public void testSimplePalindrome() {
        // "kayak" est un palindrome
        assertTrue(Palindrome.isPalindrome("kayak"), "\"kayak\" est un palindrome");
    }

    // Vérifie un palindrome en ignorant espaces et casse
    @Test
    public void testPalindromeWithSpacesAndCase() {
        // "Esope reste ici et se repose" est un palindrome lorsque les espaces et la casse sont ignorés
        assertTrue(Palindrome.isPalindrome("Esope reste ici et se repose"),
                "\"Esope reste ici et se repose\" est un palindrome");
    }

    // Vérifie qu'une chaîne non palindromique retourne false
    @Test
    public void testNonPalindrome() {
        assertFalse(Palindrome.isPalindrome("bonjour"), "\"bonjour\" n'est pas un palindrome");
    }

    // Vérifie qu'un palindrome avec espaces supplémentaires est correctement traité
    @Test
    public void testPalindromeWithExtraSpaces() {
        assertTrue(Palindrome.isPalindrome("  radar  "), "La chaîne \"  radar  \" doit être considérée comme un palindrome");
    }
}
