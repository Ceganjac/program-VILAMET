package glavni;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import com.toedter.calendar.JDateChooser;

import baza.BazaBranja;
import baza.BazaProizvod;
import baza.BazaProizvodjaci;
import ostalo.IDalgoritmi;

public class ObradaCuvanja {

// KLASA NAMNJENA ČUVANJU PODATAKA SA FORME

	// AKO SU SELEKTOVANI Radio_1 ILI Radio_2
	public static void obrada_cuvanja_1_2(char radio, JDateChooser datum, String ulaz, String bruto,
			String tara, String neto, String cena, String iznos, JComboBox<String> proizvodjac, JComboBox<String> proizvod) {


		// deklarisanje svih promenljivih
		LocalDate datumK = null;
		int id_proizvodjaca = 0;
		int id_proizvoda = 0;
		int ulazK = 0;
		double brutoK = 0;
		double taraK = 0;
		double netoK = 0;
		double cenaK = 0;
		double iznosK = 0;
		
		

		// PROVERA ZA DATUM
		if (datum == null) {
			JOptionPane.showMessageDialog(null, "Не можете сачувати брање, датум није одабран !", "Грешка ",
					JOptionPane.ERROR_MESSAGE);
			

		} else {
			datumK = datum.getDate().toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate();
		}

		// provera za proizvodjaca
		if (proizvodjac.getSelectedItem() == null) {
			JOptionPane.showMessageDialog(null, "Нисте изабрали произвођача !", "Грешка", JOptionPane.ERROR_MESSAGE);
			
		} else {
			String Proizvodjac = (String) proizvodjac.getSelectedItem();
			id_proizvodjaca = BazaProizvodjaci.izdvajanje_id(Proizvodjac);
		}

		// provera za proizvod
		if (proizvod.getSelectedItem() == null) {
			JOptionPane.showMessageDialog(null, "Нисте изабрали производ  !", "Грешка", JOptionPane.ERROR_MESSAGE);
			
		} else {
			String Proizvod = (String) proizvod.getSelectedItem();
			id_proizvoda = BazaProizvod.izvlacenje_id(Proizvod);
		}

		// provera za sve ostale podatke
		if (ulaz.equals("") || bruto.equals("") || tara.equals("") || neto.equals("") || cena.equals("")
				|| iznos.equals("")) {
			JOptionPane.showMessageDialog(null, "Не можете сачувати брање, подаци су непотпуни !", "Грешка ",
					JOptionPane.ERROR_MESSAGE);
			
		} else {
			String id_branja = IDalgoritmi.id_algoritam();

			ulazK = Integer.parseInt(ulaz);
			brutoK = Double.parseDouble(bruto);
			taraK = Double.parseDouble(tara);
			netoK = Double.parseDouble(neto);
			cenaK = Double.parseDouble(cena);
			String iznos1 = iznos.replaceAll(",", "");
			iznosK = Double.parseDouble(iznos1);
		}

		// KONAČAN UPIS U BAZU

		String id_branja = IDalgoritmi.id_algoritam();
		

		if (radio == '1') {
			BazaBranja.upis_baza(id_branja, datumK, ulazK, 0, brutoK, taraK, netoK, cenaK, iznosK, id_proizvodjaca,
					id_proizvoda);
		}
		if (radio == '2') {
			BazaBranja.upis_baza(id_branja, datumK, 0, ulazK, brutoK, taraK, netoK, cenaK, iznosK, id_proizvodjaca,
					id_proizvoda);
		}

		

	}

	public static void obrada_cuvanja_3( JDateChooser datum, String ulaz1, String ulaz2, String bruto,
			String tara, String neto, String cena, String iznos, JComboBox proizvodjac, JComboBox proizvod) {

	}

}