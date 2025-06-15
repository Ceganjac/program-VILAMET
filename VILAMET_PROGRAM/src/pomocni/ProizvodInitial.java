package pomocni;

import javax.swing.JLayeredPane;

import kontroler.ProizvodKontroler;
import model.baza.BranjeBaza;
import model.baza.ProizvodBaza;
import pogled.GuiMenadzer;
import pogled.paneli.ProizvodPanel;

public class ProizvodInitial {

	private static ProizvodBaza bp;
	private static ProizvodPanel pp;
	private static ProizvodKontroler pk;

	// POMOĆNA KLASA
	// KLASA JE NAMANJENA KREIRANJU ODNOSNO INSTANCIRANJU OBJEKATA MVC MODELA ZA
	// ENTITET Proizvod

	public static void prikazSvih() {
		bp = new ProizvodBaza();

		// uzimam panelProizvod koji je inicijalizovan prilikom izvršavanja konstruktora
		// klase Vilamet
		pp = (ProizvodPanel) GuiMenadzer.getProizvodPanel();
		ProizvodKontroler pk = new ProizvodKontroler(bp, pp);
		pk.prikazSvih();

	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static void citanjeId() {

	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static void dodavanje(String naziv, String vrsta) {
		
		bp = new ProizvodBaza();
		pp = (ProizvodPanel) GuiMenadzer.getProizvodPanel();
		ProizvodKontroler pk = new ProizvodKontroler(bp, pp);
		pk.dodavanje(naziv, vrsta);
		pk.prikazSvih();

	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static void izmena() {

	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static void brisanje(String id) {
		bp = new ProizvodBaza();
		pp = (ProizvodPanel) GuiMenadzer.getProizvodPanel();
		ProizvodKontroler pk = new ProizvodKontroler(bp, pp);
		pk.brisanje(id);
	}

}
