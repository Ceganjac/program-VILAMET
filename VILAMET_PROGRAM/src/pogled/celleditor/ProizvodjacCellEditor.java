package pogled.celleditor;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractCellEditor;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

import pogled.AkcijePanel;
import pogled.Obavestenje;
import pogled.TipObavestenja;
import pomocni.ProizvodjacInitial;

public class ProizvodjacCellEditor extends AbstractCellEditor implements TableCellEditor {

	// KLASA OMOGUĆAVA DA SE OMOGUĆI INTERAKTIVNOST DUGMADI PRIKAZANIH U POSLEDNJOJ
	// KOLONI TABELE tblProizvodjac

	private static final long serialVersionUID = 1L;
	private AkcijePanel panel;
	private int indeksRed; // Indeks reda u prikazu
	private int indeksModel; // Indeks reda u modelu
	private JTable tabela;

	public ProizvodjacCellEditor(JTable tabela) {
		this.tabela = tabela;
		panel = new AkcijePanel();

		// dugme Izbriši - dodajemo logiku
		panel.getBtnIzbrisi().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				int izbor = Obavestenje.prikaziPoruku("Да ли желите да избришете произвођача ?",
						TipObavestenja.UPITNIK);
				if (izbor == JOptionPane.YES_OPTION) {

					indeksModel = tabela.convertRowIndexToModel(indeksRed);
					String idProizvodjac = (String) tabela.getValueAt(indeksModel, 1);
					ProizvodjacInitial.brisanje(String.valueOf(idProizvodjac));

					// Zaustavlja editovanje da se ne bi "zaglavio" editor
					fireEditingStopped();
				}

			}
		});

		// Dugme Izmeni
		panel.getBtnIzmeni().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Кликнуто дугме измени!", "Обавештење",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});

		// Dugme Prikazi
		panel.getBtnPrikazi().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Кликнуто дугме прикажи!", "Обавештење",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
	}

	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		this.indeksRed = row;
		return panel;

	}

	@Override
	public Object getCellEditorValue() {
		return panel;
	}
}
