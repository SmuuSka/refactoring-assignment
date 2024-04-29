/**
 * IPisteyttaja-rajapinta, joka maarittelee Pisteyttaja-luokalle toteutettavat metodit.
 */
public interface IPisteyttaja {
    void pisteyta(IPelaaja pelaaja1, IPelaaja pelaaja2);
    int getTasapelit();
}
