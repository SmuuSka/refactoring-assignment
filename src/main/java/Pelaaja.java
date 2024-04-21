/**
 *Pelaaja-luokka toteuttaa IPelaaja-rajapinnan. Sisältää pelaajan valinnan, voittojen määrän ja valinnan arvon.
 * @author Ira Dook
 */
public class Pelaaja implements IPelaaja {
    private int voitotYhteensä;
    private Valinnat valinta;
    private enum Valinnat {
        Kivi(0),
        Paperi(1),
        Sakset(2);
        private final int arvo;

        Valinnat(int arvo) {
            this.arvo = arvo;
        }
        private int getArvo() {
            return arvo;
        }
    }

    /**
     * Metodi tuottaa pelaajan valinnan, joka arvotaan satunnaislukugeneraattorilla Valinnat-sisäluokan koon mukaan.
     * Metodi palauttaa valintaa vastaavan arvon Valinnoista.
     * @return Valinnat enumin arvo
     */
    @Override
   public int pelaajanValinta() {
       int numero = (int) (Math.random() * Valinnat.values().length);
       valinta = Valinnat.values()[numero];
       return valinta.getArvo();
   }

    @Override
    public void setVoitot() {
        voitotYhteensä++;
    }

    @Override
    public int getVoitot() {
        return voitotYhteensä;
    }

    @Override
    public int getValinta() {
        return valinta.getArvo();
    }

}
