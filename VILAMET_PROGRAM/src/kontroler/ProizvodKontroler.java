package kontroler;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import model.baza.ProizvodBaza;
import model.entiteti.Proizvod;
import pogled.paneli.ProizvodPanel;

public class ProizvodKontroler {

	// KONTROLER JE ZADUŽEN ZA KOMUNIKACIJU POGLEDA SA MODELOM
	// kontroler radi sa komponentama pogleda i modela

	private ProizvodBaza proizvodBaza;
	private ProizvodPanel proizvodPanel;

	public ProizvodKontroler(ProizvodBaza proizvodBaza, ProizvodPanel proizvodPanel) {
		this.proizvodBaza = proizvodBaza;
		this.proizvodPanel = proizvodPanel;
	}

	public void prikazSvih() {

		List<String[]> proizvodi = proizvodBaza.citanjeSvih();

		DefaultTableModel model = (DefaultTableModel) proizvodPanel.vratiModel();
		model.setRowCount(0);
		
		if (proizvodi == null || proizvodi.isEmpty()) {
			System.out.println("Nema podataka o proizvodima!");
			return; // Izlazi iz metode ako nema podataka
		}

		
		for (int i = 0; i < proizvodi.size(); i++) {
			String[] red = proizvodi.get(i);
		    
		    String[] redRedniBr = new String[red.length + 1];  // Novi niz sa dodatim mestom za redni broj
		    redRedniBr[0] = String.valueOf(i + 1);  // Redni broj počinje od 1
		    
		    // Kopirajte podatke iz 'red' u novi niz, počevši od indeksa 1
		    System.arraycopy(red, 0, redRedniBr, 1, red.length);
		    model.addRow(redRedniBr);
		}

	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void prikazId() {

	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void dodavanje(String naziv, String vrsta) {

		Proizvod proizvod = new Proizvod(naziv, vrsta);
		proizvodBaza.dodavanje(proizvod);
		prikazSvih();

	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void izmena() {
	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void brisanje(String id) {
		proizvodBaza.brisanje(id);
		prikazSvih();
	}

}
