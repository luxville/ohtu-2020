package ohtu.peli;

import ohtu.pelilogiikka.Tuomari;
import ohtu.io.IO;

public abstract class KiviPaperiSakset {

    final IO io;

    public KiviPaperiSakset(IO io) {
        this.io = io;
    }

    // tämä on ns template metodi
    public void pelaa() {
        Tuomari tuomari = new Tuomari();

        String ekanSiirto = ensimmaisenSiirto();
        String tokanSiirto = toisenSiirto();

        while (onkoOkSiirto(ekanSiirto) && onkoOkSiirto(tokanSiirto)) {
            tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
            io.tulosta(tuomari.toString());
            io.tyhjaRivi();
            ekanSiirto = ensimmaisenSiirto();
            tokanSiirto = toisenSiirto();
            asetaSiirto(ekanSiirto);
        }

        io.tyhjaRivi();
        io.tulosta("Kiitos!");
        io.tulosta(tuomari.toString());
    }

    protected String ensimmaisenSiirto() {
        return io.tulostaJaLue("Ensimmäisen pelaajan siirto: ");
    }

    // tämä on abstrakti metodi sillä sen toteutus vaihtelee eri pelityypeissä
    abstract protected String toisenSiirto();

    protected static boolean onkoOkSiirto(String siirto) {
        return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
    }

    abstract protected void asetaSiirto(String ekanSiirto);
}
