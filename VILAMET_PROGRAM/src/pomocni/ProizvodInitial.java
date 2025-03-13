package pomocni;

import javax.swing.JLayeredPane;

import kontroler.ProizvodKontroler;
import model.baza.BazaProizvod;
import pogled.Vilamet;
import pogled.proizvod.PanelProizvod;

public class ProizvodInitial {

	private static BazaProizvod bp;
	private static PanelProizvod pp;
	private static ProizvodKontroler pk;
	
	// POMOĆNA KLASA
	// KLASA JE NAMANJENA KREIRANJU ODNOSNO INSTANCIRANJU OBJEKATA MVC MODELA ZA ENTITET Proizvod

	public static void prikazSvih() {
		bp = new BazaProizvod();

		// uzimam panelProizvod koji je inicijalizovan prilikom izvršavanja konstruktora
		// klase Vilamet
		pp = (PanelProizvod) Vilamet.vratiPanelProizvod();
		ProizvodKontroler pk = new ProizvodKontroler(bp, pp);
		pk.prikazSvih();

	}

	public static void dodavanje(String naziv, String vrsta) {
		bp = new BazaProizvod();
		pp = (PanelProizvod) Vilamet.vratiPanelProizvod();
		ProizvodKontroler pk = new ProizvodKontroler(bp, pp);
		pk.dodavanje(naziv, vrsta);
		pk.prikazSvih();

	}

	public static void izmena() {

	}

	public static void brisanje(String index) {
		bp = new BazaProizvod();
		pp = (PanelProizvod) Vilamet.vratiPanelProizvod();
		ProizvodKontroler pk = new ProizvodKontroler(bp, pp);
		pk.brisanje(index);
	}

}
