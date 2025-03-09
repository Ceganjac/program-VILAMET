package model.entiteti;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

import pogled.paneli.PanelProizvod;

public class Proizvod {

	// atributi
	private int id_proizvoda;
	private String naziv;
	private String vrsta;

	// konstruktor
	public Proizvod(String naziv, String vrsta) {
		this.naziv = naziv;
		this.vrsta = vrsta;
	}

	// prazan konstruktor
	public Proizvod() {
	}

	// seteri
	public void setId_proizvoda(int id_proizvoda) {
		this.id_proizvoda = id_proizvoda;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public void setVrsta(String vrsta) {
		this.vrsta = vrsta;
	}

	// geteri
	public int getId_proizvoda() {
		return id_proizvoda;
	}

	public String getNaziv() {
		return naziv;
	}

	public String getVrsta() {
		return vrsta;
	}

}
