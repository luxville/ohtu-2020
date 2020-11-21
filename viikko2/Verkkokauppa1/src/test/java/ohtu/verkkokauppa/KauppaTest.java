package ohtu.verkkokauppa;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class KauppaTest {

    Pankki pankki;
    Viitegeneraattori viite;
    Varasto varasto;
    Kauppa k;

    @Before
    public void setUp() {
        pankki = mock(Pankki.class);
        viite = mock(Viitegeneraattori.class);
        varasto = mock(Varasto.class);
        k = new Kauppa(varasto, pankki, viite);
        when(viite.uusi()).thenReturn(42);
        when(varasto.saldo(1)).thenReturn(10); 
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));
        when(varasto.saldo(2)).thenReturn(13); 
        when(varasto.haeTuote(2)).thenReturn(new Tuote(2, "piimä", 3));
        when(varasto.saldo(3)).thenReturn(0);
        when(varasto.haeTuote(3)).thenReturn(new Tuote(3, "Tesla", 85499));
        k.aloitaAsiointi();
    }

    @Test
    public void ostoksenPaaytyttyaPankinMetodiaTilisiirtoKutsutaan() {
        k.lisaaKoriin(1);     // ostetaan tuotetta numero 1 eli maitoa
        k.tilimaksu("pekka", "12345");

        // sitten suoritetaan varmistus, että pankin metodia tilisiirto on kutsuttu
        verify(pankki).tilisiirto(anyString(), anyInt(), anyString(), anyString(),anyInt());   
        // toistaiseksi ei välitetty kutsussa käytetyistä parametreista
    }

    @Test
    public void ostoksenPaaytyttyaPankinMetodiaTilisiirtoKutsutaanOikeillaParametreilla() {
        k.lisaaKoriin(1);     // ostetaan tuotetta numero 1 eli maitoa
        k.tilimaksu("pekka", "12345");

        verify(pankki).tilisiirto("pekka", viite.uusi(), "12345", "33333-44455", 5);   
    }

    @Test
    public void ostoksenPaaytyttyaEriTuotteidenOstonJalkeenPankinMetodiaTilisiirtoKutsutaanOikeillaParametreilla() {
        k.lisaaKoriin(1);     // ostetaan tuotetta numero 1 eli maitoa
        k.lisaaKoriin(2);     // ostetaan tuotetta numero 2 eli piimää
        k.tilimaksu("pekka", "12345");

        verify(pankki).tilisiirto("pekka", viite.uusi(), "12345", "33333-44455", 8);   
    }

    @Test
    public void ostoksenPaaytyttyaSamojenTuotteidenOstonJalkeenPankinMetodiaTilisiirtoKutsutaanOikeillaParametreilla() {
        k.lisaaKoriin(2);
        k.lisaaKoriin(2);
        k.tilimaksu("pekka", "12345");

        verify(pankki).tilisiirto("pekka", viite.uusi(), "12345", "33333-44455", 6);   
    }

    @Test
    public void ostoksenPaaytyttyaJodToinenTuoteOnLoppunutMaksetaanVainVarastossaOlleista() {
        k.lisaaKoriin(2);
        k.lisaaKoriin(3);
        k.tilimaksu("pekka", "12345");

        verify(pankki).tilisiirto("pekka", viite.uusi(), "12345", "33333-44455", 3);   
    }

    @Test
    public void aloitaAsiointiNollaaEdellistenOstostenTiedot() {
        k.lisaaKoriin(2);
        k.lisaaKoriin(3);
        k.aloitaAsiointi();
        k.tilimaksu("pekka", "12345");

        verify(pankki).tilisiirto("pekka", viite.uusi(), "12345", "33333-44455", 0);   
    }

    @Test
    public void kauppaPyytaaUudenViitenumeronJokaiselleMaksutapahtumalle() {
        k.lisaaKoriin(1);
        k.tilimaksu("pekka", "12345");
        verify(viite, times(1)).uusi();
        k.lisaaKoriin(1);
        k.tilimaksu("pekka", "12345");
        verify(viite, times(2)).uusi();
    }

    @Test
    public void koristaPoistettuTuotePalautuuVarastoon() {
        k.lisaaKoriin(1);
        k.poistaKorista(1);
        verify(varasto).saldo(1);
    }
}

