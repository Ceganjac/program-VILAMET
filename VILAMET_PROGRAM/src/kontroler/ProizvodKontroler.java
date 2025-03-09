package kontroler;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import model.baza.BazaProizvod;
import model.entiteti.Proizvod;
import pogled.paneli.PanelProizvod;

public class ProizvodKontroler {

	private BazaProizvod bazaProizvod;
	private PanelProizvod panelProizvod;

	public ProizvodKontroler(BazaProizvod bazaProizvod, PanelProizvod panelProizvod) {
		this.bazaProizvod = bazaProizvod;
		this.panelProizvod = panelProizvod;
	}

	public void prikaziSve() {

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

	public void dodajProizvod(String naziv, String vrsta) {

		Proizvod proizvod = new Proizvod(naziv, vrsta);
		BazaProizvod.upis(proizvod);
		prikaziSve();

	}

	public void izmeniProizvod() {
	}

	public void obrisiProizvod(String index) {
		bazaProizvod.brisanje(index);
	}

}
