package pogled;

import java.awt.Component;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractCellEditor;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;

import kontroler.ProizvodKontroler;
import pogled.paneli.PanelProizvod;
import pomocni.ProizvodInitial;

public class CellEditorProizvod extends AbstractCellEditor implements TableCellEditor {

	// KLASA OMOGUĆAVA INTERAKCIJU DUGMIĆA U KLASI "PanelAkcije"

	private PanelAkcije panel;
	private PanelProizvod pp = (PanelProizvod) VILAMET.vratiPanelProizvod();
	
	

	public CellEditorProizvod() {
		
		if(pp == null) {
			System.out.println("PanelProizvod je null !");
		}

		panel = new PanelAkcije();

		// pp je panel koji je uzet od klase VILAMET kako se ne bi kreirao novi

		panel.getBtnIzbrisi().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				int index = pp.vratiTabelu().getSelectedRow();
				String index1 = String.valueOf(index);
				System.out.println("Indeks selektovanog reda je: " + index);

				ProizvodInitial.obrisiProizvod(index1);
			}
		});

		panel.getBtnIzmeni().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Кликнуто дугме измени!", "Обавештење",
						JOptionPane.INFORMATION_MESSAGE);

			}
		});

		panel.getBtnPrikazi().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Кликнуто дугме прикажи!", "Обавештење",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
	}

	@Override
	public Object getCellEditorValue() {
		return panel;
	}

	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		return panel;
	}

}
