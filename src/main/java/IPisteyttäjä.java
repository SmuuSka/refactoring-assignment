/**
 * Pisteyttäjä-rajapinta, joka määrittelee Pisteyttäjä-luokan toteutettavat metodit.
 */
public interface IPisteyttäjä {
    void pisteytä(IPelaaja pelaaja1, IPelaaja pelaaja2);
    int getTasapelit();
}
