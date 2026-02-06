package model.domen;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class OtkupniList {

	// atributi
	private String idBranje; // za id branja postoji poseban algoritam u paketu kontroleri
	private LocalDate datumOtkupa;
	private LocalTime vremeDatumIzdavanja;
	private float ukupanIznos;
	private int brojIzdatihPrimeraka;
	private List<StavkaBranja> stavke;
	private Proizvodjac proizvodjac;

	// konstruktor
	

	// prazan konstruktor
	OtkupniList() {
	}

	// seteri


}
