/**
 *Peli-luokka, joka sisältää pelin pelilogiikan. Peli-luokka käyttää Pelaaja-luokkaa pelaajien hallintaan ja
 * erien pisteyttämiseen erillistä pisteyttäjä-luokkaa.
 * @author Ira Dook
 */
public class Peli implements IPeli {
    /**
     * VOITTOJA: Pelataan peliä kunnes jompikumpi pelaajista saavuttaa tämän määrän voittoja.
     */
    private final int VOITTOJA;
    /**
     * pelatutPelit: Pelattujen pelien määrä.
     */
    private int pelatutPelit = 0;
    /**
     * IPelaaja pelaaja1, pelaaja2: Pelaajat, pelaaja-instanssit
     */
    private int tasapelit = 0;
    private final IPelaaja pelaaja1, pelaaja2;
    /**
     * IPisteyttäjä pisteyttäjä: Pisteyttäjä-instanssi, joka hoitaa pelaajien pisteytyksen.
     */
    private final IPisteyttäjä pisteyttäjä;
    /**
     * ITulokset tulokset: Tulokset-instanssi, joka hoitaa tulosten tulostamisen.
     */
    private final ITulokset tulokset = new Tulokset();

    /**
     * Konstruktori, joka alustaa pelin pelaajat ja pisteyttäjän, ja tarkistaa, että voitostaPoikki on positiivinen kokonaisluku.
     * @param p1 Pelaaja 1
     * @param p2 Pelaaja 2
     * @param pisteyttäjä Pisteyttäjä
     * @param voitostaPoikki Voitosta poikki-syöte
     * @throws IllegalArgumentException Jos voitostaPoikki arvo on pienempi kuin 1
     */
    public Peli(IPelaaja p1, IPelaaja p2, IPisteyttäjä pisteyttäjä, int voitostaPoikki) throws IllegalArgumentException{
        pelaaja1 = p1;
        pelaaja2 = p2;
        this.pisteyttäjä = pisteyttäjä;
        if (voitostaPoikki < 1) {
            throw new IllegalArgumentException("Voitosta poikki -syötteen tulee olla positiivinen kokonaisluku.");
        }
        VOITTOJA = voitostaPoikki;
    }

    /**
     * Pelin päämetodi, jossa pelataan niin kauan kunnes jompikumpi pelaajista saavuttaa ERIÄ-muuttujan arvon.
     * Peli kutsuu pisteyttäjää, joka pistettää valinnat ja kierroksen lopuksi tulokset-oliota, joka tulostaa kierroksen tulokset.
     * Hakee tasapelien lukumäärän pisteyttäjältä.
     * Silmukan loputtua, tulostaja tulostaa pelin voittajan.
     */
    public void pelaa(){
        do{
            pelatutPelit++;
            pisteyttäjä.pisteytä(pelaaja1, pelaaja2);
            tasapelit = pisteyttäjä.getTasapelit();
            tulokset.kierroksenTulokset(pelaaja1, pelaaja2, pelatutPelit, tasapelit);
        }while (pelaaja1.getVoitot() < VOITTOJA && pelaaja2.getVoitot() < VOITTOJA);
        tulokset.tulostaVoittaja(pelaaja1, pelaaja2, VOITTOJA);
    }
}
