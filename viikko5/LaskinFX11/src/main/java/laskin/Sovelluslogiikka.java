package laskin;

public class Sovelluslogiikka {

    private int tulos;
    private int[] muisti;
    private int indeksi;

    public Sovelluslogiikka() {
        this.tulos = 0;
        this.muisti = new int[1000];
        this.indeksi = 0;
    }

    public void plus(int luku) {
        tulos += luku;
        lisaaMuistiin(tulos);
    }

    public void miinus(int luku) {
        tulos -= luku;
        lisaaMuistiin(tulos);
    }

    public void nollaa() {
        tulos = 0;
        lisaaMuistiin(tulos);
    }

    public int tulos() {
        return tulos;
    }

    public void setTulos(int tulos) {
        this.tulos = tulos;
    }

    private void lisaaMuistiin(int luku) {
        this.muisti[indeksi] = luku;
        indeksi++;
        if (indeksi >= muisti.length) {
            indeksi = 0;
        }
    }

    public void haeMuistista() {
        indeksi-= 2;
        if (indeksi <= 0) {
            indeksi = 0;
        }
        tulos = this.muisti[indeksi];
    }
}
