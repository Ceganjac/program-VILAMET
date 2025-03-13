package pomocni;

import kontroler.ProizvodKontroler;
import kontroler.ProizvodjacKontroler;
import model.baza.BazaProizvod;
import model.baza.BazaProizvodjac;
import pogled.Vilamet;
import pogled.proizvod.PanelProizvod;
import pogled.proizvodjac.PanelProizvodjac;

public class ProizvodjacInitial {
	
	private static BazaProizvodjac bp;
	private static PanelProizvodjac pp;
	private static ProizvodjacKontroler pk;
	
	// POMOĆNA KLASA
	// KLASA JE NAMANJENA KREIRANJU ODNOSNO INSTANCIRANJU OBJEKATA MVC MODELA ZA ENTITET Proizvod

	public static void prikazSvih() {
		bp = new BazaProizvodjac();

		// uzimam panelProizvodjac koji je inicijalizovan prilikom izvršavanja konstruktora
		// klase Vilamet
		pp = (PanelProizvodjac) Vilamet.vratiPanelProizvodjac();
		ProizvodjacKontroler pk = new ProizvodjacKontroler(bp, pp);
		pk.prikazSvih();

	}

	public static void dodavanje(String naziv, String vrsta) {
		bp = new BazaProizvodjac();
		pp = (PanelProizvodjac) Vilamet.vratiPanelProizvod();
		ProizvodjacKontroler pk = new ProizvodjacKontroler(bp, pp);
		

	}

	public static void izmena() {

	}

	public static void brisanje(String index) {
		bp = new BazaProizvodjac();
		pp = (PanelProizvodjac) Vilamet.vratiPanelProizvod();
		ProizvodjacKontroler pk = new ProizvodjacKontroler(bp, pp);
		pk.brisanje(index);
	}


}
