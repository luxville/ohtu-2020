package ohtu.peli;

import ohtu.io.IO;

public class KPSPelaajaVsPelaaja extends KiviPaperiSakset {

    public KPSPelaajaVsPelaaja(IO io) {
        super(io);
    }


    @Override
    protected String toisenSiirto() {
        return io.tulostaJaLue("Toisen pelaajan siirto: ");
    }

    @Override
    protected void asetaSiirto(String ekanSiirto) {
    }
}