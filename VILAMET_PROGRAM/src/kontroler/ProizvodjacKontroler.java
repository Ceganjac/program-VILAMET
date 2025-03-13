package kontroler;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import model.baza.BazaProizvod;
import model.baza.BazaProizvodjac;
import model.entiteti.Proizvod;
import pogled.proizvod.PanelProizvod;
import pogled.proizvodjac.PanelProizvodjac;

public class ProizvodjacKontroler {

	// KONTROLER JE ZADUŽEN ZA KOMUNIKACIJU POGLEDA SA MODELOM
	// kontroler radi sa komponentama pogleda i modela

	private BazaProizvodjac bazaProizvodjac;
	private PanelProizvodjac panelProizvodjac;

	public ProizvodjacKontroler(BazaProizvodjac bazaProizvodjac, PanelProizvodjac panelProizvodjac) {
		this.bazaProizvodjac = bazaProizvodjac;
		this.panelProizvodjac = panelProizvodjac;
	}

	public void prikazSvih() {

		List<String[]> proizvodjaci = bazaProizvodjac.citanjeSvih();

		if (proizvodjaci == null || proizvodjaci.isEmpty()) {
			System.out.println("Nema podataka o proizvodima!");
			return; // Izlazi iz metode ako nema podataka
		}

		DefaultTableModel model = (DefaultTableModel) panelProizvodjac.vratiModel();
		model.setRowCount(0);

		for (int i = 0; i < proizvodjaci.size(); i++) {
			String[] red = proizvodjaci.get(i);
			model.addRow(red);
		}

	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void dodavanje() {

	}

	public void izmena() {
	}

	public void brisanje(String index) {

	}

}
