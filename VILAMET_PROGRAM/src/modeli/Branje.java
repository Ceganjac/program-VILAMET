package modeli;

import java.io.Serializable;
import java.time.LocalDate;


public class Branje implements Serializable {
private static final long serialVersionUID = 1975513249083200080L; // Postavite odgovarajuću vrednost

	
	/**
	 * 
	 */
	private LocalDate datum;
	private int ulaz_1 = 0;  // gajbice 0.4
	private int ulaz_2 = 0;  // gajbice 0.5
	private double bruto = 0;
	private double tara = 0;
	private double neto = 0;
	private int cena = 0;
	private double iznos = 0;
	
	
	// konstruktor
	Branje (LocalDate datum, int ulaz_1, int ulaz_2, double bruto, double tara, double neto, int cena, 
			double iznos ) {
		
		this.datum = datum;
		this.ulaz_1 = ulaz_1;
		this.ulaz_2 = ulaz_2;
		this.bruto = bruto;
		this.tara = tara;
		this.neto = neto;
		this.cena = cena;
		this.iznos = iznos;

	}
	
	// prazan konstruktor
	Branje(){	}

	public LocalDate getDatum() {
		return datum;
	}


	public int getUlaz_1() {
		return ulaz_1;
	}

	public int getUlaz_2() {
		return ulaz_2;
	}

	public double getBruto() {
		return bruto;
	}

	public double getTara() {
		return tara;
	}

	public double getNeto() {
		return neto;
	}

	public int getCena() {
		return cena;
	}

	public double getIznos() {
		return iznos;
	}
	
	

}
