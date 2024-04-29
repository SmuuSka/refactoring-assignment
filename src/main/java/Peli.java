/**
 *Peli-luokka, joka sisaltaa pelin pelilogiikan. Peli-luokka kayttaa Pelaaja-luokkaa pelaajien hallintaan ja
 * erien pisteyttamiseen erillista pisteyttaja-luokkaa.
 * @author Ira Dook
 */
public class Peli implements IPeli {
    /**
     * VOITTOJA: Pelataan pelia kunnes jompikumpi pelaajista saavuttaa taman maaran voittoja.
     */
    private final int VOITTOJA;
    /**
     * pelatutPelit: Pelattujen pelien maara.
     */
    private int pelatutPelit = 0;
    /**
     * IPelaaja pelaaja1, pelaaja2: Pelaajat, pelaaja-instanssit
     */
    private final IPelaaja pelaaja1, pelaaja2;
    /**
     * IPisteyttaja pisteyttaja: Pisteyttaja-instanssi, joka hoitaa pelaajien pisteytyksen.
     */
    private final IPisteyttaja pisteyttaja;
    /**
     * ITulokset tulokset: Tulokset-instanssi, joka hoitaa tulosten tulostamisen.
     */
    private final ITulokset tulokset = new Tulokset();

    /**
     * Konstruktori, joka alustaa pelin pelaajat ja pisteyttajan, ja tarkistaa, että voitostaPoikki on positiivinen kokonaisluku.
     * @param p1 Pelaaja 1
     * @param p2 Pelaaja 2
     * @param pisteyttaja Pisteyttäjä
     * @param voitostaPoikki Voitosta poikki-syöte
     * @throws IllegalArgumentException Jos voitostaPoikki arvo on pienempi kuin 1
     */
    public Peli(IPelaaja p1, IPelaaja p2, IPisteyttaja pisteyttaja, int voitostaPoikki) throws IllegalArgumentException{
        pelaaja1 = p1;
        pelaaja2 = p2;
        this.pisteyttaja = pisteyttaja;
        if (voitostaPoikki < 1) {
            throw new IllegalArgumentException("Voitosta poikki -syotteen tulee olla positiivinen kokonaisluku.");
        }
        VOITTOJA = voitostaPoikki;
    }

    /**
     * Pelin paametodi, jossa pelataan niin kauan kunnes jompikumpi pelaajista saavuttaa VOITTOJA-muuttujan arvon.
     * Peli kutsuu pisteyttajaa, joka pistettaa valinnat ja kierroksen lopuksi tulokset-oliota, joka tulostaa kierroksen tulokset.
     * Hakee tasapelien lukumäärän pisteyttajalta.
     * Silmukan loputtua, tulostaja tulostaa pelin voittajan.
     */
    public void pelaa(){
        do{
            pelatutPelit++;
            pisteyttaja.pisteyta(pelaaja1, pelaaja2);
            int tasapelit = pisteyttaja.getTasapelit();
            tulokset.kierroksenTulokset(pelaaja1, pelaaja2, pelatutPelit, tasapelit);
        }while (pelaaja1.getVoitot() < VOITTOJA && pelaaja2.getVoitot() < VOITTOJA);
        tulokset.tulostaVoittaja(pelaaja1, pelaaja2, VOITTOJA);
    }
}
