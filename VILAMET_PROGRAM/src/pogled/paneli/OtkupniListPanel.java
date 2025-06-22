package pogled.paneli;

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

		setPreferredSize(new Dimension(screenSirina-200, screenVisina-150));
		setBackground(Color.white);

		// pnlOtkupniList ne mora da ima postavljenu dimenziju zbog grou layout-a
		JPanel pnlOtkupniList = new JPanel();
		pnlOtkupniList.setBackground(Color.WHITE);

		JScrollPane jspOtkupniList = new JScrollPane();

		JLabel lblOtkupniListNaslov = new JLabel("Преглед сачуваних брања");
		lblOtkupniListNaslov.setLabelFor(jspOtkupniList);
		lblOtkupniListNaslov.setHorizontalAlignment(SwingConstants.LEFT);
		lblOtkupniListNaslov.setFont(new Font("Arial", Font.PLAIN, 20));

		// TABELA BRANJA

		JTable tblOtkupniList = new JTable();
		tblOtkupniList.setShowVerticalLines(false);
		tblOtkupniList.setFont(new Font("Arial", Font.PLAIN, 14));
		tblOtkupniList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblOtkupniList.setBackground(Color.WHITE);
		jspOtkupniList.setViewportView(tblOtkupniList);

		// model tabele branja

		DefaultTableModel model = new DefaultTableModel() {
			public boolean isCellEditable(int row, int column) {
				// Sve ćelije nisu editabilne
				return false;
			}
		};
		tblOtkupniList.setModel(model);

		GroupLayout gl_pnlOtkupniList = new GroupLayout(pnlOtkupniList);
		gl_pnlOtkupniList.setHorizontalGroup(
			gl_pnlOtkupniList.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlOtkupniList.createSequentialGroup()
					.addGap(120)
					.addGroup(gl_pnlOtkupniList.createParallelGroup(Alignment.LEADING)
						.addComponent(jspOtkupniList, GroupLayout.DEFAULT_SIZE, 1250, Short.MAX_VALUE)
						.addComponent(lblOtkupniListNaslov, GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE))
					.addGap(250))
		);
		gl_pnlOtkupniList.setVerticalGroup(
			gl_pnlOtkupniList.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlOtkupniList.createSequentialGroup()
					.addGap(40)
					.addComponent(lblOtkupniListNaslov, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addGap(25)
					.addComponent(jspOtkupniList, GroupLayout.PREFERRED_SIZE, 330, GroupLayout.PREFERRED_SIZE)
					.addGap(401))
		);
		// gl_Panel_Branja.setAutoCreateGaps(true);
		// gl_Panel_Branja.setAutoCreateContainerGaps(true);
		pnlOtkupniList.setLayout(gl_pnlOtkupniList);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(pnlOtkupniList, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(pnlOtkupniList, GroupLayout.PREFERRED_SIZE, 1030, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		setLayout(groupLayout);

	}

}
