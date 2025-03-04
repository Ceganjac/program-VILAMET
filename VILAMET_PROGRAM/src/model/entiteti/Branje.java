package model.entiteti;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Branje {

	// atributi
	private String id_branja; // za id branja postoji poseban algoritam u paketu kontroleri
	private LocalDate datum;
	private List<StavkaBranja> stavke;
	private Proizvodjac proizvodjac;

	// konstruktor
	Branje(String id_branja, LocalDate datum, Proizvodjac proizvodjac) {
		this.id_branja = id_branja;
		this.datum = datum;
		this.stavke = new ArrayList<>();
		this.proizvodjac = proizvodjac;
	}

	// prazan konstruktor
	Branje() {
	}

	// seteri
	public void setId_branja(String id_branja) {
		this.id_branja = id_branja;
	}

	public void setDatum(LocalDate datum) {
		this.datum = datum;
	}

	public void setStavke(List<StavkaBranja> stavke) {
		this.stavke = stavke;
	}

	public void setProizvodjac(Proizvodjac proizvodjac) {
		this.proizvodjac = proizvodjac;
	}

	// geteri
	public String getId_branja() {
		return id_branja;
	}

	public LocalDate getDatum() {
		return datum;
	}

	public List<StavkaBranja> getStavke() {
		return stavke;
	}

	public Proizvodjac getProizvodjac() {
		return proizvodjac;
	}

}
