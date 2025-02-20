
package logika;

/**
 *
 * @author Aleksandar
 */
public class Kalkulacija {

	private float tara = 0;
	private float neto = 0;
	private float iznos = 0;

	// klasa zadužena za računanje tare, neta i iznosa stavke branja
	// ulazni parametri funkcije su ulaz(broj ambalaže), masa ambalaže, bruto i cena

	public void kalkulacija(int ulaz, float masa, float bruto, float cena) {

		tara = ulaz * masa;
		neto = bruto - tara;
		iznos = neto * cena;

	}

	public float getTara() {
		return tara;
	}

	public float getNeto() {
		return neto;
	}

	public float getIznos() {
		return iznos;
	}
}
