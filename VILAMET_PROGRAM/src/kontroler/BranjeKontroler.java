package kontroler;

import java.util.List;
import javax.swing.table.DefaultTableModel;

import model.baza.BranjeBaza;
import model.baza.ProizvodjacBaza;
import pogled.branje.BranjePanel;
import pogled.proizvodjac.ProizvodjacPanel;

public class BranjeKontroler {

	// KONTROLER JE ZADUŽEN ZA KOMUNIKACIJU POGLEDA SA MODELOM
	// kontroler radi sa komponentama pogleda i modela

	private BranjeBaza branjeBaza;
	private BranjePanel branjePanel;

	public BranjeKontroler(BranjeBaza branjeBaza, BranjePanel branjePanel) {
		this.branjeBaza = branjeBaza;
		this.branjePanel = branjePanel;
	}

	public void prikazSvih() {

	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void prikazId() {

	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void dodavanje() {
	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void izmena() {
	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void brisanje(String index) {

	}

}
