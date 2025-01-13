package model;

public class Proizvod {
	
	// atributi
	private int id_proizvoda;
	private String naziv;
	private String vrsta;
	
	// konstruktor
	public Proizvod(int id_proizvoda, String naziv, String vrsta) {
		this.id_proizvoda = id_proizvoda;
		this.naziv = naziv;
		this.vrsta = vrsta;
	}
	
	//prazan konstruktor
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
	
	//geteri
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
