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

public class ProizvodCellEditor extends AbstractCellEditor implements TableCellEditor {

	// KLASA OMOGUĆAVA DA SE OMOGUĆI INTERAKTIVNOST DUGMADI PRIKAZANIH U POSLEDNJOJ
	// KOLONI TABELE tblProizvod

	private static final long serialVersionUID = 1L;
	private AkcijePanel panel;
	private int indeksRed; // Indeks reda u prikazu
	private int indeksModel;  // Indeks reda u modelu 
	private JTable tabela; //

	public ProizvodCellEditor(JTable tabela) {
		this.tabela = tabela;
		panel = new AkcijePanel();

		// dugme Izbriši - dodajemo logiku
		panel.getBtnIzbrisi().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				int izbor = Obavestenje.prikaziPoruku("Да ли желите да обришете производ ?", TipObavestenja.UPITNIK);

				// Ukoliko je izbor Da
				if (izbor == JOptionPane.YES_OPTION) {
										
					// konvertovanje iz indeks koji je u prikazu u indeks u modelu
					indeksModel = tabela.convertRowIndexToModel(indeksRed);
					String indeksProizvoda = (String) tabela.getValueAt(indeksModel, 1);
					

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
		this.indeksRed = row; // Sačuvaj indeks reda kada se klikne na dugme
		return panel;
	}

	@Override
	public Object getCellEditorValue() {
		return panel;
	}
}
