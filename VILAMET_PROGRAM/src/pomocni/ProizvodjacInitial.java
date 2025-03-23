package pomocni;

import kontroler.ProizvodKontroler;
import kontroler.ProizvodjacKontroler;
import model.baza.ProizvodBaza;
import model.baza.ProizvodjacBaza;
import pogled.Vilamet;
import pogled.proizvod.ProizvodPanel;
import pogled.proizvodjac.ProizvodjacPanel;

public class ProizvodjacInitial {
	
	private static ProizvodjacBaza pb;
	private static ProizvodjacPanel pp;
	private static ProizvodjacKontroler pk;
	
	// POMOĆNA KLASA
	// KLASA JE NAMANJENA KREIRANJU ODNOSNO INSTANCIRANJU OBJEKATA MVC MODELA ZA ENTITET Proizvodjac

	public static void prikazSvih() {
		pb = new ProizvodjacBaza();

		// uzimam panelProizvodjac koji je inicijalizovan prilikom izvršavanja konstruktora
		// klase Vilamet
		pp = (ProizvodjacPanel) Vilamet.getProizvodjacPanel();
		ProizvodjacKontroler pk = new ProizvodjacKontroler(pb, pp);
		pk.prikazSvih();

	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static void dodavanje(String naziv, String vrsta) {
		pb = new ProizvodjacBaza();
		pp = (ProizvodjacPanel) Vilamet.getProizvodjacPanel();
		ProizvodjacKontroler pk = new ProizvodjacKontroler(pb, pp);
		

	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static void izmena() {

	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static void brisanje(String index) {
		pb = new ProizvodjacBaza();
		pp = (ProizvodjacPanel) Vilamet.getProizvodjacPanel();
		ProizvodjacKontroler pk = new ProizvodjacKontroler(pb, pp);
		pk.brisanje(index);
	}


}
