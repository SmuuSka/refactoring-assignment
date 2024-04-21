public class Pisteyttäjä implements IPisteyttäjä{
    private int[][] pisteytysmatriisi;
    private int tasapelit;

    /**
     * Alustaa pelin voittomatriisin. 0 = tasapeli, 1 = pelaaja 1 voittaa, 2 = pelaaja 2 voittaa
     * 0 tarkoittaa kiveä, 1 paperia ja 2 saksia
     */
    public Pisteyttäjä() {
        this.pisteytysmatriisi = new int[3][3];
        //Mahdolliset tasapelitapaukset
        pisteytysmatriisi[0][0] = 0;
        pisteytysmatriisi[1][1] = 0;
        pisteytysmatriisi[2][2] = 0;

        //Mahdolliset voittotapaukset pelaajalle 1
        pisteytysmatriisi[1][0] = 1;
        pisteytysmatriisi[2][1] = 1;
        pisteytysmatriisi[0][2] = 1;

        //Mahdolliset voittotapaukset pelaajalle 2
        pisteytysmatriisi[0][1] = 2;
        pisteytysmatriisi[1][2] = 2;
        pisteytysmatriisi[2][0] = 2;
    }


    /**
     * Palauttaa voittajan hakemalla voittotapamatriisista pelaajien valintoja vastaavan arvon ja lopulta pisteyttää voittajan.
     * @param pelaaja1 pelaaja 1-olio
     * @param pelaaja1 pelaaja 2-olio
     */
    @Override
    public void pisteytä(IPelaaja pelaaja1, IPelaaja pelaaja2) {
        int pelaajan1Valinta = pelaaja1.pelaajanValinta();
        int pelaajan2Valinta = pelaaja2.pelaajanValinta();
        int kierroksenTulos = pisteytysmatriisi[pelaajan1Valinta][pelaajan2Valinta];
        switch (kierroksenTulos){
            case 0 -> tasapelit++;
            case 1 -> pelaaja1.setVoitot();
            case 2 -> pelaaja2.setVoitot();
        }
    }

    @Override
    public int getTasapelit() {
        return tasapelit;
    }

}
