package kivipaperisakset;

public class Main {
    public static void main(String[] args) {

        Peli peli = new Peli(new Pelaaja(), new Pelaaja());
        peli.pelaa();
    }
}
