package kontroler;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import model.baza.BazaProizvod;
import model.entiteti.Proizvod;
import pogled.proizvod.PanelProizvod;

public class ProizvodKontroler {
	
	// KONTROLER JE ZADUŽEN ZA KOMUNIKACIJU POGLEDA SA MODELOM
	// kontroler radi sa komponentama pogleda i modela

	private BazaProizvod bazaProizvod;
	private PanelProizvod panelProizvod;

	public ProizvodKontroler(BazaProizvod bazaProizvod, PanelProizvod panelProizvod) {
		this.bazaProizvod = bazaProizvod;
		this.panelProizvod = panelProizvod;
	}

	public void prikazSvih() {

		List<String[]> proizvodi = bazaProizvod.citanjeSvih();

		if (proizvodi == null || proizvodi.isEmpty()) {
			System.out.println("Nema podataka o proizvodima!");
			return; // Izlazi iz metode ako nema podataka
		}

		DefaultTableModel model = (DefaultTableModel) panelProizvod.vratiModel();
		model.setRowCount(0);

		for (int i = 0; i < proizvodi.size(); i++) {
			String[] red = proizvodi.get(i);
			model.addRow(red);
		}

	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void dodavanje(String naziv, String vrsta) {

		Proizvod proizvod = new Proizvod(naziv, vrsta);
		BazaProizvod.dodavanje(proizvod);
		prikazSvih();

	}

	public void izmena() {
	}

	public void brisanje(String index) {
		BazaProizvod.brisanje(index);
		prikazSvih();
	}

}
