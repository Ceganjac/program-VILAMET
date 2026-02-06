package pogled;

import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;


public class CellRenderer extends DefaultTableCellRenderer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		
		AkcijePanel pa = new AkcijePanel();
		
		if(isSelected) {
			pa.setBackground(table.getSelectionBackground());
		}
		else {
			pa.setBackground(table.getBackground());
		}
		
		return pa;

	}

}
