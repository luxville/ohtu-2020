
package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Erotus extends Komento {

    public Erotus(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        super(tuloskentta, syotekentta, nollaa, undo, sovellus);
    }

    @Override
    public void suorita() {
        int vahennettava = 0;
        try {
            vahennettava = Integer.parseInt(syotekentta.getText());
        } catch (Exception e) {
            vahennettava = 0;
        }
        sovellus.miinus(vahennettava);
        this.tuloskentta.setText(Integer.toString(sovellus.tulos()));
        nollaa.disableProperty().set(false);
        undo.disableProperty().set(false);
    }
    
    @Override
    public void peru() {
        this.sovellus.haeMuistista();
        undo.disableProperty().set(true);
        this.tuloskentta.setText(Integer.toString(sovellus.tulos()));
    }
}
