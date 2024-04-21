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
        IPisteyttäjä mockPisteyttäjä = Mockito.mock(IPisteyttäjä.class);
        IPeli peli = new Peli(mockPelaaja1, mockPelaaja2,mockPisteyttäjä, 3);
        assertNotNull(peli);
    }

    @ParameterizedTest(name = "Testataan virheellinen voitosta poikki-syöte")
    @ValueSource(ints = {0, -1})
    void testaaPelinLuontiVirheelliselläSyötteellä(int syöte) {
        IPelaaja mockPelaaja1 = Mockito.mock(IPelaaja.class);
        IPelaaja mockPelaaja2 = Mockito.mock(IPelaaja.class);
        IPisteyttäjä mockPisteyttäjä = Mockito.mock(IPisteyttäjä.class);
        assertThrows(IllegalArgumentException.class, () -> new Peli(mockPelaaja1, mockPelaaja2, mockPisteyttäjä, syöte));
        assertThrows(IllegalArgumentException.class, () -> new Peli(mockPelaaja1, mockPelaaja2, mockPisteyttäjä, syöte));
    }

    @ParameterizedTest(name = "Testataan pelaajien voitot")
    @CsvSource({"3, 0 , 3", "0, 3, 3", "3, 2, 3", "2, 3, 3"})
    void testaaPeliPäätyyKunVoittojaTarpeeksi(int voitotPelaaja1, int voitotPelaaja2, int voitotTarpeeksi) {
        IPelaaja mockPelaaja1 = Mockito.mock(IPelaaja.class);
        IPelaaja mockPelaaja2 = Mockito.mock(IPelaaja.class);
        IPisteyttäjä mockPisteyttäjä = Mockito.mock(IPisteyttäjä.class);
        when(mockPelaaja1.getVoitot()).thenReturn(voitotPelaaja1);
        when(mockPelaaja2.getVoitot()).thenReturn(voitotPelaaja2);
        IPeli peli = new Peli(mockPelaaja1, mockPelaaja2, mockPisteyttäjä, voitotTarpeeksi);
        peli.pelaa();
        assertTrue(mockPelaaja1.getVoitot() == voitotTarpeeksi || mockPelaaja2.getVoitot() == voitotTarpeeksi);
    }


}