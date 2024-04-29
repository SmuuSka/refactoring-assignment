import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class PisteyttajaTest {

    @Test
    void testaaPisteytysTasapeli() {
        IPelaaja mockPelaaja1 = Mockito.mock(IPelaaja.class);
        IPelaaja mockPelaaja2 = Mockito.mock(IPelaaja.class);
        IPisteyttaja pisteyttaja = new Pisteyttaja();
        when(mockPelaaja1.pelaajanValinta()).thenReturn(0);
        when(mockPelaaja2.pelaajanValinta()).thenReturn(0);

        pisteyttaja.pisteyta(mockPelaaja1, mockPelaaja2);
        assertEquals(1, pisteyttaja.getTasapelit());
    }

    @Test
    void testaaPisteytysPelaaja1Voittaa() {
        IPelaaja mockPelaaja1 = Mockito.mock(IPelaaja.class);
        IPelaaja mockPelaaja2 = Mockito.mock(IPelaaja.class);
        IPisteyttaja pisteyttaja = new Pisteyttaja();

        when(mockPelaaja1.pelaajanValinta()).thenReturn(1);
        when(mockPelaaja2.pelaajanValinta()).thenReturn(0);

        pisteyttaja.pisteyta(mockPelaaja1, mockPelaaja2);
        when(mockPelaaja1.getVoitot()).thenReturn(1);
        assertEquals(1, mockPelaaja1.getVoitot());
    }
    @Test
    void testaaPisteytysPelaaja2Voittaa() {
        IPelaaja mockPelaaja1 = Mockito.mock(IPelaaja.class);
        IPelaaja mockPelaaja2 = Mockito.mock(IPelaaja.class);
        IPisteyttaja pisteyttaja = new Pisteyttaja();

        when(mockPelaaja1.pelaajanValinta()).thenReturn(0);
        when(mockPelaaja2.pelaajanValinta()).thenReturn(1);

        pisteyttaja.pisteyta(mockPelaaja1, mockPelaaja2);
        when(mockPelaaja2.getVoitot()).thenReturn(1);
        assertEquals(1, mockPelaaja2.getVoitot());
    }
}