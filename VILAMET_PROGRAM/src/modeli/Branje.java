package modeli;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Branje implements Serializable {
private static final long serialVersionUID = 1975513249083200080L; // Postavite odgovarajuću vrednost

	// atributi
	private String id_branja;
	private LocalDate datum;
	private List<StavkaBranja> stavke;
	
	// konstruktor
	Branje (String id_branja, LocalDate datum) {
		this.id_branja = id_branja;
		this.datum = datum;
		this.stavke = new ArrayList<>();
	}
	
	// prazan konstruktor
	Branje(){	}
	

	// seteri
	public void setId_branja(String id_branja) {
		this.id_branja = id_branja;
	}
	public void setDatum(LocalDate datum) {
		this.datum = datum;
	}
	

	// geteri
	public String getId_branja() {
		return id_branja;
	}
	public LocalDate getDatum() {
		return datum;
	}
	
	

	
	
	

}
