import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class TuloksetTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void testKierroksenTulokset() {
        IPelaaja mockPelaaja1 = Mockito.mock(IPelaaja.class);
        IPelaaja mockPelaaja2 = Mockito.mock(IPelaaja.class);
        ITulokset tulokset = new Tulokset();

        tulokset.kierroksenTulokset(mockPelaaja1, mockPelaaja2, 1, 0);

        String expectedOutput = "Erä: 1 =====================\nTasapelien lukumäärä: 0";
        assertTrue(outContent.toString().contains(expectedOutput));
    }

    @Test
    void testTulostaVoittaja() {
        IPelaaja mockPelaaja1 = Mockito.mock(IPelaaja.class);
        IPelaaja mockPelaaja2 = Mockito.mock(IPelaaja.class);
        ITulokset tulokset = new Tulokset();

        Mockito.when(mockPelaaja1.getVoitot()).thenReturn(1);
        Mockito.when(mockPelaaja2.getVoitot()).thenReturn(0);

        tulokset.tulostaVoittaja(mockPelaaja1, mockPelaaja2, 1);

        String expectedOutput = "Voittaja: Pelaaja 1";
        assertTrue(outContent.toString().contains(expectedOutput));
    }
}