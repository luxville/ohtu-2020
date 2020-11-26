package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Nollaa extends Komento {

    public Nollaa(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        super(tuloskentta, syotekentta, nollaa, undo, sovellus);
    }

    @Override
    public void suorita() {
        this.sovellus.nollaa();
        this.tuloskentta.setText("0");
        this.syotekentta.setText("0");
    }

    @Override
    public void peru() {
        this.sovellus.haeMuistista();
        nollaa.disableProperty().set(true);
        undo.disableProperty().set(true);
        this.tuloskentta.setText(Integer.toString(sovellus.tulos()));
    }
}
