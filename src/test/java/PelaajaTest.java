import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PelaajaTest {
    @Test
    void testaaPelaajanValinta() {
        Pelaaja pelaaja = new Pelaaja();
        pelaaja.pelaajanValinta();
        int valinta = pelaaja.getValinta();
        assertTrue(valinta >= 0 && valinta <= 2);
    }

    @Test
    void testaaVoittojenLaskeminen() {
        Pelaaja pelaaja = new Pelaaja();
        pelaaja.setVoitot();
        assertEquals(1, pelaaja.getVoitot());
    }
}