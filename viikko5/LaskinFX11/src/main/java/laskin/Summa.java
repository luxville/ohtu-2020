
package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Summa extends Komento {

    public Summa(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        super(tuloskentta, syotekentta, nollaa, undo, sovellus);
    }

    @Override
    public void suorita() {
        int lisattava = 0;
        try {
            lisattava = Integer.parseInt(syotekentta.getText());
        } catch (Exception e) {
            lisattava = 0;
        }
        sovellus.plus(lisattava);
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
