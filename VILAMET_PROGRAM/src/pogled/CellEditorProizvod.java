package pogled;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractCellEditor;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
import pogled.paneli.PanelProizvod;
import pomocni.ProizvodInitial;

public class CellEditorProizvod extends AbstractCellEditor implements TableCellEditor {

	// KLASA OMOGUĆAVA DA SE OMOGUĆI INTERAKTIVNOST DUGMADI PRIKAZANIH U POSLEDNJOJ
	// KOLONI TABELE tblProizvod

	private static final long serialVersionUID = 1L;
	private PanelAkcije panel;
	private int rowIndex; // Indeks reda u prikazu
	private JTable tabela; // Referenca na tabelu

	public CellEditorProizvod(JTable tabela) {
		this.tabela = tabela;
		panel = new PanelAkcije();

		// dugme Izbriši - dodajemo logiku
		panel.getBtnIzbrisi().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				int izbor = JOptionPane.showConfirmDialog(null, "Да ли желите да обришете селектован производ ?",
						"Упит", JOptionPane.YES_NO_OPTION);

				// Dobijanje tačnog modelIndex-a
				if (izbor == JOptionPane.YES_OPTION) {
					int modelRow = tabela.convertRowIndexToModel(rowIndex);
					String indeksProizvoda = (String) tabela.getValueAt(modelRow, 0);

					// Poziv metode za brisanje koristeći indeks reda
					ProizvodInitial.obrisiProizvod(String.valueOf(indeksProizvoda));

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
		this.rowIndex = row; // Sačuvaj indeks reda kada se klikne na dugme
		return panel;
	}

	@Override
	public Object getCellEditorValue() {
		return panel;
	}
}
