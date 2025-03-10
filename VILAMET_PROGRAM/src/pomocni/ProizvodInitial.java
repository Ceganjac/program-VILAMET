package pomocni;

import javax.swing.JLayeredPane;

import kontroler.ProizvodKontroler;
import model.baza.BazaProizvod;
import pogled.Vilamet;
import pogled.paneli.PanelProizvod;

public class ProizvodInitial {

	private static BazaProizvod bp;
	private static PanelProizvod pp;
	private static ProizvodKontroler pk;
	
	// POMOĆNA KLASA
	// KLASA JE NAMANJENA KREIRANJU ODNOSNO INSTANCIRANJU OBJEKATA MVC MODELA ZA ENTITET Proizvod

	public static void prikaziSve() {
		bp = new BazaProizvod();

		// uzimam panelProizvod koji je inicijalizovan prilikom izvršavanja konstruktora
		// klase Vilamet
		pp = (PanelProizvod) Vilamet.vratiPanelProizvod();
		ProizvodKontroler pk = new ProizvodKontroler(bp, pp);
		pk.prikaziSve();

	}

	public static void dodajProizvod(String naziv, String vrsta) {
		bp = new BazaProizvod();
		pp = (PanelProizvod) Vilamet.vratiPanelProizvod();
		ProizvodKontroler pk = new ProizvodKontroler(bp, pp);
		pk.dodajProizvod(naziv, vrsta);
		pk.prikaziSve();

	}

	public static void izmeniProizvod() {

	}

	public static void obrisiProizvod(String index) {
		bp = new BazaProizvod();
		pp = (PanelProizvod) Vilamet.vratiPanelProizvod();
		ProizvodKontroler pk = new ProizvodKontroler(bp, pp);
		pk.obrisiProizvod(index);
	}

}
