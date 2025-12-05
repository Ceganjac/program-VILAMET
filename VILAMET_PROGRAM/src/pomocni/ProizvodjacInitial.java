package pomocni;

import kontroler.ProizvodKontroler;
import kontroler.ProizvodjacKontroler;
import model.baza.ProizvodBaza;
import model.baza.ProizvodjacBaza;
import pogled.OkvirPrikaza;
import pogled.paneli.ProizvodPanel;
import pogled.paneli.ProizvodjacPanel;

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
		/*pp = (ProizvodjacPanel) OkvirPrikaza.getProizvodjacPanel();*/
		ProizvodjacKontroler pk = new ProizvodjacKontroler(pb, pp);
		pk.prikazSvih();

	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static void prikazId() {
		
	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	
	public static void dodavanje(String ime, String prezime, String mestoGrad, String selo, String ulicaBroj) {
		pb = new ProizvodjacBaza();
		/*pp = (ProizvodjacPanel) OkvirPrikaza.getProizvodjacPanel();*/
		ProizvodjacKontroler pk = new ProizvodjacKontroler(pb, pp);
		pk.dodavanje(ime, prezime, mestoGrad, selo, ulicaBroj);
		

	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static void izmena() {

	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static void brisanje(String id) {
		pb = new ProizvodjacBaza();
		/*pp = (ProizvodjacPanel) OkvirPrikaza.getProizvodjacPanel();*/
		ProizvodjacKontroler pk = new ProizvodjacKontroler(pb, pp);
		pk.brisanje(id);
	}


}
