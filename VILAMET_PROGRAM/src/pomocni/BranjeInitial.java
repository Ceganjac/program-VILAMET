package pomocni;

import kontroler.BranjeKontroler;
import model.baza.BranjeBaza;
import pogled.Vilamet;
import pogled.branje.BranjePanel;

public class BranjeInitial {

	private static BranjeBaza bb;
	private static BranjePanel bp;
	private static BranjeKontroler bk;

	// POMOĆNA KLASA
	// KLASA JE NAMANJENA KREIRANJU ODNOSNO INSTANCIRANJU OBJEKATA MVC MODELA ZA
	// ENTITET Branje

	public static void prikazSvih() {

		// uzimam branjePanel koji je inicijalizovan prilikom izvršavanja konstruktora
		// klase Vilamet
		bb = new BranjeBaza();
		bp = (BranjePanel) Vilamet.vratiPanelBranje();

		bk = new BranjeKontroler(bb, bp);
		bk.prikazSvih();

	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static void citanjeId() {

	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static void dodavanje() {
		bk = new BranjeKontroler(bb, bp);
		bk.dodavanje();
		bk.prikazSvih();

	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static void izmena() {

	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static void brisanje(String index) {

	}
}
