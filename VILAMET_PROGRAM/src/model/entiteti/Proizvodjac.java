package model.entiteti;

public class Proizvodjac {

	// atributi
	private String ime;
	private String prezime;
	private String mestoGrad;
	private String selo;
	private String ulicaBroj;

	// konstruktor
	public Proizvodjac(String ime, String prezime, String mestoGrad, String selo, String ulicaBroj) {
		this.ime = ime;
		this.prezime = prezime;
		this.mestoGrad = mestoGrad;
		this.selo = selo;
		this.ulicaBroj = ulicaBroj;
	};

	// prazan konstruktor
	public Proizvodjac() {
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public void setMestoGrad(String mesto_grad) {
		this.mestoGrad = mesto_grad;
	}

	public void setSelo(String selo) {
		this.selo = selo;
	}

	public void setUlicaBroj(String ulica_broj) {
		this.ulicaBroj = ulica_broj;
	}

	// geteri

	public String getIme() {
		return ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public String getMestoGrad() {
		return mestoGrad;
	}

	public String getSelo() {
		return selo;
	}

	public String getUlicaBroj() {
		return ulicaBroj;
	}

}
