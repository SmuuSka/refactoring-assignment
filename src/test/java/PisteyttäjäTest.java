import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class PisteyttäjäTest {

    @Test
    void testaaPisteytysTasapeli() {
        IPelaaja mockPelaaja1 = Mockito.mock(IPelaaja.class);
        IPelaaja mockPelaaja2 = Mockito.mock(IPelaaja.class);
        IPisteyttäjä pisteyttäjä = new Pisteyttäjä();
        when(mockPelaaja1.pelaajanValinta()).thenReturn(0);
        when(mockPelaaja2.pelaajanValinta()).thenReturn(0);

        pisteyttäjä.pisteytä(mockPelaaja1, mockPelaaja2);
        assertEquals(1, pisteyttäjä.getTasapelit());
    }

    @Test
    void testaaPisteytysPelaaja1Voittaa() {
        IPelaaja mockPelaaja1 = Mockito.mock(IPelaaja.class);
        IPelaaja mockPelaaja2 = Mockito.mock(IPelaaja.class);
        IPisteyttäjä pisteyttäjä = new Pisteyttäjä();

        when(mockPelaaja1.pelaajanValinta()).thenReturn(1);
        when(mockPelaaja2.pelaajanValinta()).thenReturn(0);

        pisteyttäjä.pisteytä(mockPelaaja1, mockPelaaja2);
        when(mockPelaaja1.getVoitot()).thenReturn(1);
        assertEquals(1, mockPelaaja1.getVoitot());
    }
    @Test
    void testaaPisteytysPelaaja2Voittaa() {
        IPelaaja mockPelaaja1 = Mockito.mock(IPelaaja.class);
        IPelaaja mockPelaaja2 = Mockito.mock(IPelaaja.class);
        IPisteyttäjä pisteyttäjä = new Pisteyttäjä();

        when(mockPelaaja1.pelaajanValinta()).thenReturn(0);
        when(mockPelaaja2.pelaajanValinta()).thenReturn(1);

        pisteyttäjä.pisteytä(mockPelaaja1, mockPelaaja2);
        when(mockPelaaja2.getVoitot()).thenReturn(1);
        assertEquals(1, mockPelaaja2.getVoitot());
    }
}