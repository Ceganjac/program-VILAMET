package pomocni;

import kontroler.ProizvodKontroler;
import kontroler.ProizvodjacKontroler;
import model.baza.ProizvodBaza;
import model.baza.ProizvodjacBaza;
import pogled.Vilamet;
import pogled.proizvod.ProizvodPanel;
import pogled.proizvodjac.ProizvodjacPanel;

public class ProizvodjacInitial {
	
	private static ProizvodjacBaza bp;
	private static ProizvodjacPanel pp;
	private static ProizvodjacKontroler pk;
	
	// POMOĆNA KLASA
	// KLASA JE NAMANJENA KREIRANJU ODNOSNO INSTANCIRANJU OBJEKATA MVC MODELA ZA ENTITET Proizvod

	public static void prikazSvih() {
		bp = new ProizvodjacBaza();

		// uzimam panelProizvodjac koji je inicijalizovan prilikom izvršavanja konstruktora
		// klase Vilamet
		pp = (ProizvodjacPanel) Vilamet.vratiPanelProizvodjac();
		ProizvodjacKontroler pk = new ProizvodjacKontroler(bp, pp);
		pk.prikazSvih();

	}

	public static void dodavanje(String naziv, String vrsta) {
		bp = new ProizvodjacBaza();
		pp = (ProizvodjacPanel) Vilamet.vratiPanelProizvod();
		ProizvodjacKontroler pk = new ProizvodjacKontroler(bp, pp);
		

	}

	public static void izmena() {

	}

	public static void brisanje(String index) {
		bp = new ProizvodjacBaza();
		pp = (ProizvodjacPanel) Vilamet.vratiPanelProizvod();
		ProizvodjacKontroler pk = new ProizvodjacKontroler(bp, pp);
		pk.brisanje(index);
	}


}
