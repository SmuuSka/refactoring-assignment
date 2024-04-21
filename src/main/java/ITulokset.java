/**
 * ITulokset on rajapinta, joka määrittelee metodit kierroksen tulosten ja voittajan tulostamiseen.
 */
public interface ITulokset {
    void kierroksenTulokset(IPelaaja pelaaja1, IPelaaja pelaaja2, int pelatutPelit ,int tasapelit);
    void tulostaVoittaja(IPelaaja pelaaja1, IPelaaja pelaaja2, int voittojenRaja);
}
