import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class PeliTest {
    @Test
    void testaaPelinLuonti() {
        IPelaaja mockPelaaja1 = Mockito.mock(IPelaaja.class);
        IPelaaja mockPelaaja2 = Mockito.mock(IPelaaja.class);
        IPisteyttaja mockPisteyttaja = Mockito.mock(IPisteyttaja.class);
        IPeli peli = new Peli(mockPelaaja1, mockPelaaja2,mockPisteyttaja, 3);
        assertNotNull(peli);
    }

    @ParameterizedTest(name = "Testataan virheellinen voitosta poikki-syote")
    @ValueSource(ints = {0, -1})
    void testaaPelinLuontiVirheellisellaSyotteella(int syote) {
        IPelaaja mockPelaaja1 = Mockito.mock(IPelaaja.class);
        IPelaaja mockPelaaja2 = Mockito.mock(IPelaaja.class);
        IPisteyttaja mockPisteyttaja = Mockito.mock(IPisteyttaja.class);
        assertThrows(IllegalArgumentException.class, () -> new Peli(mockPelaaja1, mockPelaaja2, mockPisteyttaja, syote));
        assertThrows(IllegalArgumentException.class, () -> new Peli(mockPelaaja1, mockPelaaja2, mockPisteyttaja, syote));
    }

    @ParameterizedTest(name = "Testataan pelaajien voitot")
    @CsvSource({"3, 0 , 3", "0, 3, 3", "3, 2, 3", "2, 3, 3"})
    void testaaPeliPaattyyKunVoittojaTarpeeksi(int voitotPelaaja1, int voitotPelaaja2, int voitotTarpeeksi) {
        IPelaaja mockPelaaja1 = Mockito.mock(IPelaaja.class);
        IPelaaja mockPelaaja2 = Mockito.mock(IPelaaja.class);
        IPisteyttaja mockPisteyttaja = Mockito.mock(IPisteyttaja.class);
        when(mockPelaaja1.getVoitot()).thenReturn(voitotPelaaja1);
        when(mockPelaaja2.getVoitot()).thenReturn(voitotPelaaja2);
        IPeli peli = new Peli(mockPelaaja1, mockPelaaja2, mockPisteyttaja, voitotTarpeeksi);
        peli.pelaa();
        assertTrue(mockPelaaja1.getVoitot() == voitotTarpeeksi || mockPelaaja2.getVoitot() == voitotTarpeeksi);
    }


}