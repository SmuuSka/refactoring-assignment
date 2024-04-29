/**
 * Main-luokka, joka käynnistää pelin.
 */
public class Main {
    public static void main(String[] args) {
        int voittojenRaja = 100000;
        IPelaaja pelaaja1 = new Pelaaja();
        IPelaaja pelaaja2 = new Pelaaja();
        IPisteyttaja pisteyttaja = new Pisteyttaja();
        IPeli peli = new Peli(pelaaja1, pelaaja2, pisteyttaja, voittojenRaja);
        peli.pelaa();
    }
}
