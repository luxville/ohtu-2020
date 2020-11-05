
package ohtu.verkkokauppa;

public interface PankkiRajapinta {
    //PankkiRajapinta getInstance();
    boolean tilisiirto(String nimi, int viitenumero, String tililta, String tilille, int summa);
}
