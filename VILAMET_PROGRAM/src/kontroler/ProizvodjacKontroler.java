package kontroler;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import model.baza.ProizvodBaza;
import model.baza.ProizvodjacBaza;
import model.entiteti.Proizvod;
import model.entiteti.Proizvodjac;
import pogled.proizvod.ProizvodPanel;
import pogled.proizvodjac.ProizvodjacPanel;

public class ProizvodjacKontroler {

	// KONTROLER JE ZADUŽEN ZA KOMUNIKACIJU POGLEDA SA MODELOM
	// kontroler radi sa komponentama pogleda i modela

	private ProizvodjacBaza proizvodjacBaza;
	private ProizvodjacPanel proizvodjacPanel;

	public ProizvodjacKontroler(ProizvodjacBaza proizvodjacBaza, ProizvodjacPanel proizvodjacPanel) {
		this.proizvodjacBaza = proizvodjacBaza;
		this.proizvodjacPanel = proizvodjacPanel;
	}

	public void prikazSvih() {

		List<String[]> proizvodjaci = proizvodjacBaza.citanjeSvih();

		if (proizvodjaci == null || proizvodjaci.isEmpty()) {
			System.out.println("Nema podataka o proizvodima!");
			return; // Izlazi iz metode ako nema podataka
		}

		DefaultTableModel model = (DefaultTableModel) proizvodjacPanel.getModel();
		model.setRowCount(0);

		for (int i = 0; i < proizvodjaci.size(); i++) {
			String[] red = proizvodjaci.get(i);
			model.addRow(red);
		}

	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void prikazId() {

	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void dodavanje(String ime, String prezime, String mestoGrad, String selo, String ulicaBroj) {
		Proizvodjac proizvodjac = new Proizvodjac(ime,prezime,mestoGrad,selo,ulicaBroj);
		proizvodjacBaza.dodavanje(proizvodjac);
		prikazSvih();
		
	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void izmena() {
	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void brisanje(String indeks) {
		proizvodjacBaza.brisanje(indeks);
		prikazSvih();
	}

}
