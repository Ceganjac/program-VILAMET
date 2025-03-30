package kontroler;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.List;
import java.util.Locale;

import javax.swing.table.DefaultTableModel;

import model.baza.BranjeBaza;
import model.baza.ProizvodBaza;
import model.baza.StavkaBaza;
import model.entiteti.Proizvod;
import model.logika.Kalkulacija;
import pogled.branje.BranjePanel;
import pogled.otkup.Otkup;
import pogled.proizvod.ProizvodPanel;

public class StavkaKontroler {

	// KONTROLER JE ZADUŽEN ZA KOMUNIKACIJU POGLEDA SA MODELOM
	// kontroler radi sa komponentama pogleda i modela

	private StavkaBaza stavkaBaza;
	private Otkup nbPanel;

	public StavkaKontroler(StavkaBaza stavkaBaza, Otkup nbPanel) {
		this.stavkaBaza = stavkaBaza;
		this.nbPanel = nbPanel;
	}

	public void prikazSvih() {

	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void prikazId() {

	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void dodavanje(String naziv, String vrsta) {

	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void izmena() {
	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void brisanje(String index) {
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void izracunajStavku(int ulaz, float masa, float bruto, float cena) {

		Kalkulacija k = new Kalkulacija();
		k.kalkulacija(ulaz, masa, bruto, cena);

		float tara = k.getTara();
		float neto = k.getNeto();
		float iznos = k.getIznos();

		// pravljenje formatera za numeričke vrednosti
		DecimalFormatSymbols simboli = new DecimalFormatSymbols(Locale.getDefault());
		simboli.setDecimalSeparator('.');
		simboli.setGroupingSeparator(',');
		DecimalFormat df = new DecimalFormat("#,###.00", simboli);

		nbPanel.getTxtIzlazniTara().setText("" + df.format(tara));
		nbPanel.getTxtIzlazniNeto().setText("" + df.format(neto));
		nbPanel.getTxtIzlazniIznos().setText("" + df.format(iznos) +" рсд");

	}
}
