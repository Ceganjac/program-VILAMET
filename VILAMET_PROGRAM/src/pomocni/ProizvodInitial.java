package pomocni;

import javax.swing.JLayeredPane;

import kontroler.ProizvodKontroler;
import model.baza.BazaProizvod;
import pogled.VILAMET;
import pogled.paneli.PanelProizvod;

public class ProizvodInitial {

	private static BazaProizvod bp;
	private static PanelProizvod pp;

	public static void prikaziSve() {

	}

	public static void dodajProizvod() {

	}

	public static void izmeniProizvod() {

	}

	public static void obrisiProizvod(String index) {
		bp = new BazaProizvod();
		pp = (PanelProizvod) VILAMET.vratiPanelProizvod();
		ProizvodKontroler pk = new ProizvodKontroler(bp, pp);
		pk.obrisiProizvod(index);
	}

}
