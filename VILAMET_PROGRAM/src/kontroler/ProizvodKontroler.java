package kontroler;

import java.sql.ResultSet;
import java.sql.SQLException;
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

		ResultSet rezultat = bazaProizvod.citanje_baza();
		DefaultTableModel model = (DefaultTableModel) panelProizvod.vratiTabelu().getModel();

		model.setRowCount(0);

		try {
			while (rezultat.next()) {
				String red[] = { rezultat.getString(1), rezultat.getString(2) };

				model.addRow(red);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Greska u ProizvodKontroler !");

		}

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
