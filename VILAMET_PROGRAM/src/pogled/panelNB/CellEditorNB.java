package pogled.panelNB;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractCellEditor;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

import pogled.PanelAkcije;
import pomocni.ProizvodInitial;

public class CellEditorNB extends AbstractCellEditor implements TableCellEditor {

	// KLASA OMOGUĆAVA DA SE OMOGUĆI INTERAKTIVNOST DUGMADI PRIKAZANIH U POSLEDNJOJ
	// KOLONI TABELE tblProizvod

	private static final long serialVersionUID = 1L;
	private PanelAkcije panel;
	private int rowIndex; // Indeks reda u prikazu
	private JTable tabela; // Referenca na tabelu

	public CellEditorNB(JTable tabela) {
		this.tabela = tabela;
		panel = new PanelAkcije();

		// dugme Izbriši - dodajemo logiku
		panel.getBtnIzbrisi().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				int izbor = JOptionPane.showConfirmDialog(null, "Да ли желите да обришете селектованог произвођача ?",
						"Упит", JOptionPane.YES_NO_OPTION);

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
