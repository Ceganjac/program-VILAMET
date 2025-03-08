package pogled;

import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;


public class CellRenderer extends DefaultTableCellRenderer {

	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		
		PanelAkcije pa = new PanelAkcije();
		
		if(isSelected) {
			pa.setBackground(table.getSelectionBackground());
		}
		else {
			pa.setBackground(table.getBackground());
		}
		
		return pa;

	}

}
