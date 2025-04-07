import static org.junit.jupiter.api.Assertions.*;

import org.example.Person;
import org.junit.jupiter.api.Test;

public class PersonTest {

    @Test
    void testGetFullName() {

        Person person = new Person("SABRI", "BENMATOUK", 30);


        String fullName = person.getFullName();


        assertEquals("SABRI BENMATOUK", fullName, "Le nom complet doit être 'SABRI BENMATOUK'");
    }

    @Test
    void testIsAdult() {
        // Cas d'une personne majeure
        Person adult = new Person("RAMZI", "AISSANI", 20);
        // Cas d'une personne mineure
        Person minor = new Person("ADEM", "BELOUFI", 16);

        // Vérifier que la méthode isAdult retourne true pour une personne majeure
        assertTrue(adult.isAdult(), "RAMZI AISSANI doit être considéré comme adulte");

        // Vérifier que la méthode isAdult retourne false pour une personne mineure
        assertFalse(minor.isAdult(), "ADEM BELOUFI ne doit pas être considéré comme adulte");
    }

}

