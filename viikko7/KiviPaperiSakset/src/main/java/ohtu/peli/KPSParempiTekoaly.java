package ohtu.peli;

import ohtu.pelilogiikka.TekoalyParannettu;
import ohtu.io.IO;

// Kivi-Paperi-Sakset, jossa voidaan valita pelataanko vastustajaa
// vastaan vai ei
public class KPSParempiTekoaly extends KiviPaperiSakset {
    private final int muisti = 50;
    private final TekoalyParannettu tekoaly;
    
    public KPSParempiTekoaly(IO io) {
        super(io);
        this.tekoaly = new TekoalyParannettu(muisti);
    }

    @Override
    protected String toisenSiirto() {
        String tekoalynSiirto = tekoaly.annaSiirto();
        io.tulosta("Tietokone valitsi: "+ tekoalynSiirto);
        return tekoalynSiirto;
    }

    @Override
    protected void asetaSiirto(String ekanSiirto) {
        tekoaly.asetaSiirto(ekanSiirto);
    }
}
