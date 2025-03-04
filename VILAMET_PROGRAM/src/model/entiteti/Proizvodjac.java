package model.entiteti;

public class Proizvodjac {

	// atributi
	private int id_proizvodjaca;
	private String ime;
	private String prezime;
	private String mesto_grad;
	private String selo;
	private String ulica_broj;

	// konstruktor
	public Proizvodjac(int id_proizvodjaca, String ime, String prezime, String mesto_grad, String selo,
			String ulica_broj) {

	};

	// prazan konstruktor
	public Proizvodjac() {
	}

	// seteri
	public void setId_proizvodjaca(int id_proizvodjaca) {
		this.id_proizvodjaca = id_proizvodjaca;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public void setMesto_grad(String mesto_grad) {
		this.mesto_grad = mesto_grad;
	}

	public void setSelo(String selo) {
		this.selo = selo;
	}

	public void setUlica_broj(String ulica_broj) {
		this.ulica_broj = ulica_broj;
	}
	
	// geteri
	public int getId_proizvodjaca() {
		return id_proizvodjaca;
	}

	public String getIme() {
		return ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public String getMesto_grad() {
		return mesto_grad;
	}

	public String getSelo() {
		return selo;
	}

	public String getUlica_broj() {
		return ulica_broj;
	}
	

	
	

}
