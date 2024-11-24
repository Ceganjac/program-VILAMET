package glavni;

import java.time.LocalDate;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import baza.BazaBranja;
import baza.BazaProizvod;
import baza.BazaProizvodjaci;
import ostalo.IDalgoritmi;

public class ObradaCuvanja {

// KLASA NAMNJENA ČUVANJU PODATAKA SA FORME

	// AKO SU SELEKTOVANI Radio_1 ILI Radio_2
	public static void obrada_cuvanja(int radio, String datum, String ulaz1, String ulaz2, String bruto,
			String tara, String neto, String cena, String iznos, JComboBox<String> proizvodjac,
			JComboBox<String> proizvod) {

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

		// PROVERA ZA PROIZVODJACA
		if (proizvodjac.getSelectedItem() == null) {
			JOptionPane.showMessageDialog(null, "Нисте изабрали произвођача !", "Грешка", JOptionPane.ERROR_MESSAGE);
			return;

		} else {
			String Proizvodjac = (String) proizvodjac.getSelectedItem();
			id_proizvodjaca = BazaProizvodjaci.izdvajanje_id(Proizvodjac);
		}

		// PROVERA ZA PROIZVOD
		if (proizvod.getSelectedItem() == null) {
			JOptionPane.showMessageDialog(null, "Нисте изабрали производ  !", "Грешка", JOptionPane.ERROR_MESSAGE);
			return;

		} else {
			String Proizvod = (String) proizvod.getSelectedItem();
			id_proizvoda = BazaProizvod.izvlacenje_id(Proizvod);
		}

		// PROVERA U ZAVISNOSTI OD radi-a

		switch (radio) {
		case 1:
			if (ulaz1.equals("") || bruto.equals("") || tara.equals("") || neto.equals("") || cena.equals("")
					|| iznos.equals("")) {
				JOptionPane.showMessageDialog(null, "Не можете сачувати брање, подаци су непотпуни !", "Грешка ",
						JOptionPane.ERROR_MESSAGE);
				return;

			} else {

				ulazK = Integer.parseInt(ulaz1);
				brutoK = Double.parseDouble(bruto);
				taraK = Double.parseDouble(tara);
				netoK = Double.parseDouble(neto);
				cenaK = Double.parseDouble(cena);
				String iznos1 = iznos.replaceAll(",", "");
				iznosK = Double.parseDouble(iznos1);

				String id_branja = IDalgoritmi.id_algoritam();
				BazaBranja.upis_baza(id_branja, datumK, ulazK, 0, brutoK, taraK, netoK, cenaK, iznosK, id_proizvodjaca,
						id_proizvoda);
				JOptionPane.showMessageDialog(null, "Подаци су успешно сачувани !", "Обавештење",
						JOptionPane.INFORMATION_MESSAGE);
			}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

			break;

		case 2:
			if (ulaz2.equals("") || bruto.equals("") || tara.equals("") || neto.equals("") || cena.equals("")
					|| iznos.equals("")) {
				JOptionPane.showMessageDialog(null, "Не можете сачувати брање, подаци су непотпуни !", "Грешка ",
						JOptionPane.ERROR_MESSAGE);
				return;
			} else {

				ulazK = Integer.parseInt(ulaz2);
				brutoK = Double.parseDouble(bruto);
				taraK = Double.parseDouble(tara);
				netoK = Double.parseDouble(neto);
				cenaK = Double.parseDouble(cena);
				String iznos1 = iznos.replaceAll(",", "");
				iznosK = Double.parseDouble(iznos1);

				String id_branja = IDalgoritmi.id_algoritam();
				BazaBranja.upis_baza(id_branja, datumK, 0, ulazK, brutoK, taraK, netoK, cenaK, iznosK, id_proizvodjaca,
						id_proizvoda);
				JOptionPane.showMessageDialog(null, "Подаци су успешно сачувани !", "Обавештење",
						JOptionPane.INFORMATION_MESSAGE);
				
			}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

			break;
		case 3:
			if (ulaz1.equals("") || ulaz2.equals("") || bruto.equals("") || tara.equals("") || neto.equals("")
					|| cena.equals("") || iznos.equals("")) {
				JOptionPane.showMessageDialog(null, "Не можете сачувати брање, подаци су непотпуни !", "Грешка ",
						JOptionPane.ERROR_MESSAGE);
				return;
			} else {

				int ulazK1 = Integer.parseInt(ulaz1);
				int ulazK2 = Integer.parseInt(ulaz2);
				brutoK = Double.parseDouble(bruto);
				taraK = Double.parseDouble(tara);
				netoK = Double.parseDouble(neto);
				cenaK = Double.parseDouble(cena);
				String iznos1 = iznos.replaceAll(",", "");
				iznosK = Double.parseDouble(iznos1);

				String id_branja = IDalgoritmi.id_algoritam();
				BazaBranja.upis_baza(id_branja, datumK, ulazK1, ulazK2, brutoK, taraK, netoK, cenaK, iznosK,
						id_proizvodjaca, id_proizvoda);
				JOptionPane.showMessageDialog(null, "Не можете сачувати брање, подаци су непотпуни !", "Грешка ",
						JOptionPane.ERROR_MESSAGE);
				JOptionPane.showMessageDialog(null, "Подаци су успешно сачувани !", "Обавештење",
						JOptionPane.INFORMATION_MESSAGE);
			}
			break;

		}
	}
}
