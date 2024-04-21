public class Main {
    public static void main(String[] args) {
        int voittojenRaja = 100000;
        IPelaaja pelaaja1 = new Pelaaja();
        IPelaaja pelaaja2 = new Pelaaja();
        IPisteyttäjä pisteyttäjä = new Pisteyttäjä();
        IPeli peli = new Peli(pelaaja1, pelaaja2, pisteyttäjä, voittojenRaja);
        peli.pelaa();
    }
}
