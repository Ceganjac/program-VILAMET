package kontroler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import javax.swing.SwingUtilities;
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
		
		model.setRowCount(0);

		for (int i = 0; i < proizvodi.size(); i++) {
			String[] red = proizvodi.get(i);
			System.out.println(red[0] + " " + red[1]);
			model.addRow(red);
		}
		
		String Red[] = {"000", "PROBA"};
		model.addRow(Red);
		
	    
		

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
