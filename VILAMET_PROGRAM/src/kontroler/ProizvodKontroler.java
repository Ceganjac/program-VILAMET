package kontroler;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import model.baza.BazaProizvod;
import pogled.paneli.PanelProizvod;

public class ProizvodKontroler {

	private BazaProizvod bazaProizvod;
	private PanelProizvod panelProizvod;

	public ProizvodKontroler(BazaProizvod bazaProizvod, PanelProizvod panelProizvod) {
		this.bazaProizvod = bazaProizvod;
		this.panelProizvod = panelProizvod;
	}

	public void prikaziSve() {

		List<String[]> proizvodi = bazaProizvod.vratiProizvode();

		if (proizvodi == null || proizvodi.isEmpty()) {
			System.out.println("Nema podataka o proizvodima!");
			return; // Izlazi iz metode ako nema podataka
		}

		DefaultTableModel model = (DefaultTableModel) panelProizvod.vratiModel();

		for (int i = 0; i < proizvodi.size(); i++) {
			String[] red = proizvodi.get(i);
			model.addRow(red);
		}

		// Osveži tabelu
		model.fireTableDataChanged();

	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void dodajProizvod() {
	}

	{
	}

	public void izmeniProizvod() {
	}

	public void obrisiProizvod() {
	}

}
