
import org.example.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class JeuTest {

    @Mock
    Banque banqueMock;
    @Mock
    Joueur joueurMock;
    @Mock
    De deMock1;
    @Mock
    De deMock2;

    @BeforeEach
    public void initialiserMocks() {
        MockitoAnnotations.openMocks(this);
    }

    // Test : Le jeu est fermé → une exception doit être levée
    @Test
    public void doitLancerExceptionQuandJeuEstFerme() {
        Jeu jeu = new Jeu(banqueMock);
        jeu.fermer();

        assertThrows(JeuFermeException.class, () -> jeu.jouer(joueurMock, deMock1, deMock2));
    }

    // Test : Joueur insolvable → une exception DebitImpossibleException est levée
    @Test
    public void doitRefuserPartieSiJoueurInsolvable() throws DebitImpossibleException {
        Jeu jeu = new Jeu(banqueMock);
        int mise = 50;

        when(joueurMock.mise()).thenReturn(mise);
        doThrow(new DebitImpossibleException("Fonds insuffisants")).when(joueurMock).debiter(mise);

        assertThrows(DebitImpossibleException.class, () -> jeu.jouer(joueurMock, deMock1, deMock2));

        verify(joueurMock).debiter(mise);
        verify(deMock1, never()).lancer();
        verify(deMock2, never()).lancer();
    }

    // Test : Le joueur perd → banque créditée, joueur débité
    @Test
    public void doitDebiterJoueurEtCrediterBanqueQuandPerdu() throws Exception {
        Jeu jeu = new Jeu(banqueMock);
        int mise = 10;

        when(joueurMock.mise()).thenReturn(mise);
        when(deMock1.lancer()).thenReturn(3);
        when(deMock2.lancer()).thenReturn(2); // somme ≠ 7

        jeu.jouer(joueurMock, deMock1, deMock2);

        verify(joueurMock).debiter(mise);
        verify(banqueMock).crediter(mise);
        verify(joueurMock, never()).crediter(anyInt());
    }

    // Test : Joueur gagne et banque est solvable
    @Test
    public void doitCrediterJoueurQuandGainEtBanqueSolvable() throws Exception {
        Jeu jeu = new Jeu(banqueMock);
        int mise = 20;

        when(joueurMock.mise()).thenReturn(mise);
        when(deMock1.lancer()).thenReturn(4);
        when(deMock2.lancer()).thenReturn(3); // somme = 7
        when(banqueMock.est_solvable()).thenReturn(true);

        jeu.jouer(joueurMock, deMock1, deMock2);

        verify(joueurMock).debiter(mise);
        verify(banqueMock).crediter(mise);
        verify(banqueMock).debiter(mise * 2);
        verify(joueurMock).crediter(mise * 2);
        assertTrue(jeu.estOuvert());
    }

    // Test : Joueur gagne mais banque insolvable → jeu fermé
    @Test
    public void doitFermerJeuQuandBanqueInsolvableApresGain() throws Exception {
        Jeu jeu = new Jeu(banqueMock);
        int mise = 30;

        when(joueurMock.mise()).thenReturn(mise);
        when(deMock1.lancer()).thenReturn(2);
        when(deMock2.lancer()).thenReturn(5); // somme = 7
        when(banqueMock.est_solvable()).thenReturn(false);

        jeu.jouer(joueurMock, deMock1, deMock2);

        verify(joueurMock).debiter(mise);
        verify(banqueMock).crediter(mise);
        verify(banqueMock).debiter(mise * 2);
        verify(joueurMock).crediter(mise * 2);
        assertFalse(jeu.estOuvert());
    }
}
