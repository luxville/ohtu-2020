package ohtu.io;

import java.util.Scanner;

public class IOToiminnot implements IO {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void tulosta(String tuloste) {
        System.out.println(tuloste);
    }

    @Override
    public String lueSyote() {
        return scanner.nextLine();
    }

    @Override
    public String tulostaJaLue(String tuloste) {
        tulosta(tuloste);
        return lueSyote();
    }

    @Override
    public void tyhjaRivi() {
        System.out.println();
    }
}
