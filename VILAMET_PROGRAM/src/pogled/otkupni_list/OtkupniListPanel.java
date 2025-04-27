package pogled.otkupni_list;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class OtkupniListPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	// UZIMANJE DIMENZIJA EKRANA
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	int screenSirina = screenSize.width;
	int screenVisina = screenSize.height;

	/**
	 * Create the panel.
	 */
	public OtkupniListPanel() {

		JPanel pnlBranje = new JPanel();
		pnlBranje.setBackground(Color.WHITE);
		pnlBranje.setPreferredSize(new Dimension(screenSirina - 300, screenVisina));

		JScrollPane jspBranje = new JScrollPane();

		JLabel lblBranjeNaslov = new JLabel("Преглед сачуваних брања");
		lblBranjeNaslov.setHorizontalAlignment(SwingConstants.LEFT);
		lblBranjeNaslov.setFont(new Font("Arial", Font.PLAIN, 20));

		// TABELA BRANJA

		JTable tblBranje = new JTable();
		tblBranje.setShowVerticalLines(false);
		tblBranje.setFont(new Font("Arial", Font.PLAIN, 12));
		tblBranje.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblBranje.setBackground(Color.WHITE);
		jspBranje.setViewportView(tblBranje);
		
		

		// model tabele branja
		
		DefaultTableModel model = new DefaultTableModel() {
			public boolean isCellEditable(int row, int column) {
				// Sve ćelije nisu editabilne
				return false;
			}
		};
		tblBranje.setModel(model);


		GroupLayout gl_pnlBranje = new GroupLayout(pnlBranje);
		gl_pnlBranje.setHorizontalGroup(
			gl_pnlBranje.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlBranje.createSequentialGroup()
					.addGap(120)
					.addGroup(gl_pnlBranje.createParallelGroup(Alignment.LEADING)
						.addComponent(jspBranje, GroupLayout.DEFAULT_SIZE, 1250, Short.MAX_VALUE)
						.addComponent(lblBranjeNaslov, GroupLayout.PREFERRED_SIZE, 349, GroupLayout.PREFERRED_SIZE))
					.addGap(250))
		);
		gl_pnlBranje.setVerticalGroup(
			gl_pnlBranje.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlBranje.createSequentialGroup()
					.addGap(40)
					.addComponent(lblBranjeNaslov, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addGap(25)
					.addComponent(jspBranje, GroupLayout.PREFERRED_SIZE, 330, GroupLayout.PREFERRED_SIZE)
					.addGap(401))
		);
		// gl_Panel_Branja.setAutoCreateGaps(true);
		// gl_Panel_Branja.setAutoCreateContainerGaps(true);
		pnlBranje.setLayout(gl_pnlBranje);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(pnlBranje, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addComponent(pnlBranje, GroupLayout.PREFERRED_SIZE, 1085, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		setLayout(groupLayout);

	}

}
