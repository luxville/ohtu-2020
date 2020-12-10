package ohtu.peli;

import ohtu.pelilogiikka.Tekoaly;
import ohtu.io.IO;

public class KPSTekoaly extends KiviPaperiSakset {

    private final Tekoaly tekoaly;

    public KPSTekoaly(IO io) {
        super(io);
        this.tekoaly = new Tekoaly();
    }

    @Override
    protected String toisenSiirto() {
        String tekoalynSiirto = tekoaly.annaSiirto();
        io.tulosta("Tietokone valitsi: "+ tekoalynSiirto);
        return tekoalynSiirto;
    }

    @Override
    protected void asetaSiirto(String ekanSiirto) {
    }
}