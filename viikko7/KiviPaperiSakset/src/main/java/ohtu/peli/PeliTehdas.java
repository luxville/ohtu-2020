package ohtu.peli;

import ohtu.io.IO;

public class PeliTehdas {
    
    private final IO io;

    public PeliTehdas(IO io) {
        this.io = io;
    }
    
    public static KiviPaperiSakset kaksinpeli(IO io) {
        return new KPSPelaajaVsPelaaja(io);
    }
    
    public static KiviPaperiSakset helppoYksinpeli(IO io) {
        return new KPSTekoaly(io);
    }
    
    public static KiviPaperiSakset vaikeaYksinpeli(IO io) {
        return new KPSParempiTekoaly(io);
    }
}
