/**
 * Tulokset-luokka, joka tulostaa kierroksen tulokset ja voittajan.
 */
public class Tulokset implements ITulokset{

    /**
     * Metodi kierrostuloksen tulostamiseen.
     * @param pelaaja1 Pelaaja 1-olio.
     * @param pelaaja2 Pelaaja 2-olio
     * @param pelatutPelit pelattujen pelien lukumäärä Peli-luokassa.
     * @param tasapelit tasapelien lukumäärä Peli-luokassa.
     */
    @Override
    public void kierroksenTulokset(IPelaaja pelaaja1, IPelaaja pelaaja2, int pelatutPelit, int tasapelit) {
        System.out.println("Erä: " + pelatutPelit + " =====================\n" + "Tasapelien lukumäärä: "+ tasapelit);
        System.out.println("Pelaaja 1: " + pelaaja1.getValinta() + "\n\t Pelaaja 1:llä koossa " + pelaaja1.getVoitot() + " voittoa.");
        System.out.println("Pelaaja 2: " + pelaaja2.getValinta() + "\n\t Pelaaja 2:lla koossa " + pelaaja2.getVoitot() + " voittoa.");
    }

    /**
     * Metodi voittajan tulostamiseen pelin loputtua.
     * @param pelaaja1 Pelaaja 1-olio.
     * @param pelaaja2 Pelaaja 2-olio
     * @param voittojenRaja Voittojen raja, joka määrittää voittajan Peli-luokassa.
     */
    @Override
    public void tulostaVoittaja(IPelaaja pelaaja1, IPelaaja pelaaja2, int voittojenRaja) {
        System.out.println("Voittaja: " + (pelaaja1.getVoitot() == voittojenRaja ? "Pelaaja 1" : "Pelaaja 2"));
    }
}
