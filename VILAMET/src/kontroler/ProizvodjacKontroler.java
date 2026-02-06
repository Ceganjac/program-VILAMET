package kontroler;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import model.baza.KonektorBaze;
import model.baza.ProizvodBaza;
import model.baza.ProizvodjacBaza;
import model.domen.Proizvod;
import model.domen.Proizvodjac;
import pogled.paneli.ProizvodPanel;
import pogled.paneli.ProizvodjacPanel;

public class ProizvodjacKontroler {

	// KONTROLER JE ZADUŽEN ZA KOMUNIKACIJU POGLEDA SA MODELOM
	// kontroler radi sa komponentama pogleda i modela

	private KonektorBaze kb;
	private ProizvodjacBaza proizvodjacBaza;

	public ProizvodjacKontroler() {
		
	}

	public void prikazSvih() {

		List<String[]> proizvodjaci = proizvodjacBaza.citanjeSvih();

	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void prikazId() {

	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void dodavanj() {
	

	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void izmena() {
	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void brisanje(String id) {
	
	}

}
