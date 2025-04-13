package pomocni;

import kontroler.BranjeKontroler;
import kontroler.StavkaKontroler;
import model.baza.BranjeBaza;
import model.baza.StavkaBaza;
import model.entiteti.StavkaBranja;
import pogled.Vilamet;
import pogled.otkup.Otkup;
import pogled.otkupni_list.OtkupniListPanel;

public class StavkaInitial {
	
	private static StavkaBaza sb;
	private static Otkup bp;
	private static StavkaKontroler sk;

	// POMOĆNA KLASA
	// KLASA JE NAMANJENA KREIRANJU ODNOSNO INSTANCIRANJU OBJEKATA MVC MODELA ZA
	// ENTITET Stavka Branja

	public static void prikazSvih() {

		// uzimam branjePanel koji je inicijalizovan prilikom izvršavanja konstruktora
		// klase Vilamet
		sb = new StavkaBaza();
		bp = (Otkup) Vilamet.getOtkupPanel();

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
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static void izracunajStavku(int ulaz, float masa, float bruto, float cena) {
		sb = new StavkaBaza();
		bp =  (Otkup) Vilamet.getOtkupPanel();
		sk = new StavkaKontroler(sb,bp);
		sk.izracunajStavku(ulaz, masa, bruto, cena);
	}

}
