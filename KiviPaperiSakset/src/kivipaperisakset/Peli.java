package kivipaperisakset;

/**
 *
 * @author Ira Dook
 */
public class Peli {
    /**
     * Instassimuuttujat
     * Poistettu voitot
     * Lisätty Pelaajille instanssimuuttujat
     * Vaihdettu näkyvyystaso private
     */
    private int pelatutPelit = 0;           // Pelattujen pelien lkm
    private int tasapelit = 0;              // Tasapelien lkm
    private Pelaaja pelaaja1, pelaaja2;
    /**
     * Lisätty konstruktori
     */
    public Peli(Pelaaja p1, Pelaaja p2){
        pelaaja1 = p1;
        pelaaja2 = p2;
    }

    private void pelaa() {

        /*
        Korvattu turha ehtolause
         */
        boolean peliLoppui = false;

        String p1Valinta;
        String p2Valinta;
       
        do {
            System.out.println("Erä: "
                    + pelatutPelit + " =====================\n");
            System.out.println("Tasapelien lukumäärä: "
                    + tasapelit + "\n");
            p1Valinta = pelaaja1.pelaajanValinta();
            System.out.println("Pelaaja 1: " + p1Valinta
                    + "\n\t Pelaaja 1:llä koossa " + pelaaja1.getVoitot() + " voittoa.");
            p2Valinta = pelaaja2.pelaajanValinta();
            System.out.println("Pelaaja 2: " + p2Valinta
                    + "\n\t Pelaaja 2:lla koossa " + pelaaja2.getVoitot() + " voittoa.");
            
            // Allaolevassa pätkässä on yritetty eri tapoja saada
            // lukumäärän laskeminen toimimaan oikein.
            // Ei tää kyllä vieläkään skulaa - KORJAA!
            
            if ((p1Valinta.equals("kivi")) && (p2Valinta.equals("paperi"))) {
                System.out.println("Pelaaja 2 voittaa");
                pelaaja2.setVoitot();  // Kokeile eri tapoja saada lukumäärän laskenta kuntoon
            } else if ((p1Valinta.equals("paperi")) && (p2Valinta.equals("kivi"))) {
                pelaaja1.setVoitot();
                System.out.println("Pelaaja 1 voittaa");
            } else if ((p1Valinta.equals("kivi")) && (p2Valinta.equals("sakset"))) {
                pelaaja1.voitot = pelaaja1.setVoitot();
                System.out.println("Pelaaja 1 voittaa");
            } else if ((p1Valinta.equals("sakset")) && (p2Valinta.equals("kivi"))) {
                pelaaja2.voitot = pelaaja2.setVoitot();
                System.out.println("Pelaaja 2 voittaa");
            } else if ((p1Valinta.equals("sakset")) && (p2Valinta.equals("paperi"))) {
                pelaaja1.voitot = pelaaja1.setVoitot();
                System.out.println("Pelaaja 1 voittaa");
            } else if ((p1Valinta.equals("paperi")) && (p2Valinta.equals("sakset"))) {
                pelaaja2.voitot = pelaaja2.setVoitot();
                System.out.println("Pelaaja 2 voittaa");
            }
            if (p1Valinta == p2Valinta) {
                tasapelit++;
                System.out.println("\n\t\t\t Tasapeli \n");
            }
//            pelatutPelit++;
//            if ((p1.getVoitot() >= 3) || (p2.getVoitot() >= 3)) {
//                peliLoppui = true;
//
//            }
//            System.out.println();
        } while (pelaaja1.getVoitot() > 2 || pelaaja2.getVoitot() > 3);
        System.out.println("KOLME VOITTOA - PELI PÄÄTTYY");
    }
}
