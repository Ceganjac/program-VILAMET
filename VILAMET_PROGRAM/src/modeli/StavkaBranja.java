package modeli;

public class StavkaBranja {
	
	
	// atributi
	private int id_stavke;
	private int ulaz_04;
	private int ulaz_05;
	private float bruto;
	private float tara;
	private float neto;
	private float cena;
	private float iznos;
	
	// konstruktor
	public StavkaBranja(int id_stavke, int ulaz_04, int ulaz_05, float bruto, float tara, float neto, float cena,
			float iznos) {
	
		this.id_stavke = id_stavke;
		this.ulaz_04 = ulaz_04;
		this.ulaz_05 = ulaz_05;
		this.bruto = bruto;
		this.tara = tara;
		this.neto = neto;
		this.cena = cena;
		this.iznos = iznos;
	}
	
	// prazan konstruktor
	public StavkaBranja() {}

	
	// seteri
	public void setId_stavke(int id_stavke) {
		this.id_stavke = id_stavke;
	}

	public void setUlaz_04(int ulaz_04) {
		this.ulaz_04 = ulaz_04;
	}

	public void setUlaz_05(int ulaz_05) {
		this.ulaz_05 = ulaz_05;
	}

	public void setBruto(float bruto) {
		this.bruto = bruto;
	}

	public void setTara(float tara) {
		this.tara = tara;
	}

	public void setNeto(float neto) {
		this.neto = neto;
	}

	public void setCena(float cena) {
		this.cena = cena;
	}

	public void setIznos(float iznos) {
		this.iznos = iznos;
	}
	
	
	// getri
	public int getId_stavke() {
		return id_stavke;
	}

	public int getUlaz_04() {
		return ulaz_04;
	}

	public int getUlaz_05() {
		return ulaz_05;
	}

	public float getBruto() {
		return bruto;
	}

	public float getTara() {
		return tara;
	}

	public float getNeto() {
		return neto;
	}

	public float getCena() {
		return cena;
	}

	public float getIznos() {
		return iznos;
	};
	
	
	
	

}
