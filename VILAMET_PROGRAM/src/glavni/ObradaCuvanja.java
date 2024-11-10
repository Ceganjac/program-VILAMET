package glavni;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JOptionPane;

import baza.Baza_branja;
import baza.Baza_proizvod;
import baza.Baza_proizvodjaci;
import ostalo.ID_algoritmi;

// KLASA NAMNJENA ČUVANJU PODATAKA SA FORME

public class ObradaCuvanja extends Sistem_GUI {

	// AKO SU SELEKTOVANI Radio_1 ILI Radio_2
	public static void obrada_cuvanja_1_2(char radio) {

		if (datum.getDateEditor().getDate() == null) {
			JOptionPane.showMessageDialog(null, "Нисте изабрали датум !", "Грешка", JOptionPane.ERROR_MESSAGE);
			return;
		}

		if (padajuci_proizvodjaci.getSelectedItem() == null) {
			JOptionPane.showMessageDialog(null, "Нисте изабрали проиизвођача !", "Грешка", JOptionPane.ERROR_MESSAGE);
			return;
		}
		if (padajuci_proizvod.getSelectedItem() == null) {
			JOptionPane.showMessageDialog(null, "Нисте изабрали проиизвод !", "Грешка", JOptionPane.ERROR_MESSAGE);
			return;
		}

		if (textField_Ulaz.getText().equals("") || textField_Bruto.getText().equals("")
				|| textField_Cena.getText().equals("") || textField_Tara.getText().equals("")
				|| textField_Neto.getText().equals("") || textField_Iznos.getText().equals("")) {

			JOptionPane.showMessageDialog(null, "Не можете сачувати брање, подаци су непотпуни !", "Грешка ",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		else {

			// rad sa id-om branja

			String id_branja = ID_algoritmi.id_algoritam();

			// rad sa datumom
			LocalDate datumK = datum.getDate().toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate();
			DateTimeFormatter formater = DateTimeFormatter.ofPattern("dd.MM.yyyy");
			String formatiran_datum = datumK.format(formater);

			// rad sa id-om proizvođača
			String proizvodjac;
			int id_proiz;
			proizvodjac = (String) padajuci_proizvodjaci.getSelectedItem();
			id_proiz = Baza_proizvodjaci.izdvajanje_id(proizvodjac);

			// rad sa id_om proizvoda
			String proizvod;
			int id_proizvoda;
			proizvod = (String) padajuci_proizvod.getSelectedItem();
			id_proizvoda = Baza_proizvod.izvlacenje_id(proizvod);

			int ulazK = Integer.parseInt(textField_Ulaz.getText());
			double brutoK = Double.parseDouble(textField_Bruto.getText());
			double taraK = Double.parseDouble(textField_Tara.getText());
			double netoK = Double.parseDouble(textField_Neto.getText());
			double cenaK = Double.parseDouble(textField_Cena.getText());
			String iznos1 = textField_Iznos.getText().replaceAll(",", "");
			double iznosK = Double.parseDouble(iznos1);

			// ako je selektovano Radio_1 (0.4 kg) onda je broj gajbica od 0.5 jednak 0

			switch (radio) {
			case 1:
				Baza_branja.upis_baza(id_branja, datumK, ulazK, 0, brutoK, taraK, netoK, cenaK, iznosK, id_proiz,
						id_proizvoda);
				JOptionPane.showMessageDialog(null, "Подаци су успешно сачувани !", "Обавештење",
						JOptionPane.INFORMATION_MESSAGE);
				break;
			case 2:
				Baza_branja.upis_baza(id_branja, datumK, 0, ulazK, brutoK, taraK, netoK, cenaK, iznosK, id_proiz,
						id_proizvoda);
				JOptionPane.showMessageDialog(null, "Подаци су успешно сачувани !", "Обавештење",
						JOptionPane.INFORMATION_MESSAGE);
				break;

			}

		}
	}

	public static void obrada_cuvanja_3() {
		
		

	}

}
