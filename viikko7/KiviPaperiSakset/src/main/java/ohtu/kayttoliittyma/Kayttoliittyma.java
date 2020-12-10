package ohtu.kayttoliittyma;

import ohtu.io.IO;
import ohtu.io.IOToiminnot;
import ohtu.peli.PeliTehdas;

public class Kayttoliittyma {

    private final IO io;
    private final PeliTehdas pelit;

    public Kayttoliittyma() {
        this.io = new IOToiminnot();
        this.pelit = new PeliTehdas(io);
    }
    
    public void suorita() {
        while (true) {
            String alkuteksti = ("\nValitse pelataanko"
                    + "\n (a) ihmistä vastaan "
                    + "\n (b) tekoälyä vastaan"
                    + "\n (c) parannettua tekoälyä vastaan"
                    + "\nmuilla valinnoilla lopetataan");
            
            String valinta = io.tulostaJaLue(alkuteksti);
            
            switch (valinta) {
                case "a":
                    pelit.kaksinpeli(io).pelaa();
                    break;
                case "b":
                    pelit.helppoYksinpeli(io).pelaa();
                    break;
                case "c":
                    pelit.vaikeaYksinpeli(io).pelaa();
                default:
                    return;
            }
        }
    }
}
