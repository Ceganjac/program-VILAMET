package kontroler;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import model.baza.BranjeBaza;
import model.baza.ProizvodBaza;
import model.baza.StavkaBaza;
import model.entiteti.Proizvod;
import pogled.branje.BranjePanel;
import pogled.proizvod.ProizvodPanel;

public class StavkaKontroler {

	// KONTROLER JE ZADUŽEN ZA KOMUNIKACIJU POGLEDA SA MODELOM
	// kontroler radi sa komponentama pogleda i modela

	private StavkaBaza stavkaBaza;
	private BranjePanel branjePanel;

	public StavkaKontroler(StavkaBaza stavkaBaza, BranjePanel branjePanel) {
		this.stavkaBaza = stavkaBaza;
		this.branjePanel = branjePanel;
	}

	public void prikazSvih() {

	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void prikazId() {

	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void dodavanje(String naziv, String vrsta) {

	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void izmena() {
	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void brisanje(String index) {
	}
}
