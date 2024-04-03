package kivipaperisakset;

/**
 *
 * @author Ira Dook
 */
public class Peli {

     // Instassimuuttujat
     // Poistettu voitot
     // Lisätty Pelaajille instanssimuuttujat
     // Vaihdettu näkyvyystaso private

    private int pelatutPelit = 0; // Pelattujen pelien lkm
    private int tasapelit = 0; // Tasapelien lkm
    private Pelaaja pelaaja1, pelaaja2;

     // Lisätty konstruktori

    public Peli(Pelaaja p1, Pelaaja p2){
        pelaaja1 = p1;
        pelaaja2 = p2;
    }

    public void pelaa() {
        // Korvattu voiton tarkistuksen ehtolause
        // Poistettu ylimääräinen peliLoppui muuttuja
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

            kierros(p1Valinta, p2Valinta);

            //Vaihdettu merkkijonojen vertailuoperaattori == equals() metodiin

        } while (pelaaja1.getVoitot() < 3 && pelaaja2.getVoitot() < 3);
        System.out.println("KOLME VOITTOA - PELI PÄÄTTYY");
    }

    private void kierros(String p1, String p2){
        pelatutPelit++;
        switch (p1) {
            case "kivi" -> {
                if (p2.equals("paperi")) {
                    pelaaja2.setVoitot();
                    break;
                }
                pelaaja1.setVoitot();
            }
            case "paperi" -> {
                if (p2.equals("sakset")) {
                    pelaaja2.setVoitot();
                    break;
                }
                pelaaja1.setVoitot();
            }
            case "sakset" -> {
                if (p2.equals("kivi")) {
                    pelaaja2.setVoitot();
                    break;
                }
                pelaaja1.setVoitot();
            }
            default -> tasapelit++;
        }
    }
}
