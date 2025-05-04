import org.example.ServiceException;
import org.example.UserService;
import org.example.Utilisateur;
import org.example.UtilisateurApi;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @Mock
    private UtilisateurApi utilisateurApiMock;

    @Test
    public void testCreerUtilisateur() throws ServiceException {
        // Création d'un nouvel utilisateur
        Utilisateur utilisateur = new Utilisateur("Jean", "Dupont", "jeandupont@email.com");

        // TODO : Configuration du comportement du mock
        // Comme la méthode creerUtilisateur est void, on utilise doNothing()
        doNothing().when(utilisateurApiMock).creerUtilisateur(utilisateur);

        // TODO : Création du service avec le mock
        UserService userService = new UserService(utilisateurApiMock);

        // TODO : Appel de la méthode à tester
        userService.creerUtilisateur(utilisateur);

        // TODO : Vérification de l'appel à l'API
        verify(utilisateurApiMock).creerUtilisateur(utilisateur);
        verifyNoMoreInteractions(utilisateurApiMock);
    }
    @Test
    public void testCreerUtilisateur_EchecCreation() throws ServiceException {
        Utilisateur utilisateur = new Utilisateur("Jean", "Dupont", "jean@mail.com");
        // Configuration du mock pour lever une exception
        doThrow(new ServiceException("Echec de la création de l'utilisateur"))
                .when(utilisateurApiMock).creerUtilisateur(utilisateur);

        UserService userService = new UserService(utilisateurApiMock);

        // Vérifie que l’exception est bien levée
        ServiceException exception = assertThrows(ServiceException.class, () -> {
            userService.creerUtilisateur(utilisateur);
        });

        assertEquals("Echec de la création de l'utilisateur", exception.getMessage());

        verify(utilisateurApiMock).creerUtilisateur(utilisateur);
    }

}
