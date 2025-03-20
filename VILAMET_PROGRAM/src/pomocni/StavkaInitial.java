package pomocni;

import kontroler.BranjeKontroler;
import kontroler.StavkaKontroler;
import model.baza.BranjeBaza;
import model.baza.StavkaBaza;
import pogled.Vilamet;
import pogled.branje.BranjePanel;

public class StavkaInitial {
	
	private static StavkaBaza sb;
	private static BranjePanel bp;
	private static StavkaKontroler sk;

	// POMOĆNA KLASA
	// KLASA JE NAMANJENA KREIRANJU ODNOSNO INSTANCIRANJU OBJEKATA MVC MODELA ZA
	// ENTITET Stavka Branja

	public static void prikazSvih() {

		// uzimam branjePanel koji je inicijalizovan prilikom izvršavanja konstruktora
		// klase Vilamet
		sb = new StavkaBaza();
		bp = (BranjePanel) Vilamet.vratiPanelBranje();

		sk = new StavkaKontroler(sb, bp);
		sk.prikazSvih();

	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static void citanjeId() {

	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static void dodavanje(String naziv, String vrsta) {
		

	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static void izmena() {

	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static void brisanje(String index) {

	}

}
