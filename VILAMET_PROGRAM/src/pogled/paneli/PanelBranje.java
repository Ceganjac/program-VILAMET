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

public class PanelBranje extends JPanel {

	private static final long serialVersionUID = 1L;

	// UZIMANJE DIMENZIJA EKRANA
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	int screenSirina = screenSize.width;
	int screenVisina = screenSize.height;

	/**
	 * Create the panel.
	 */
	public PanelBranje() {

		JPanel pnlBranje = new JPanel();
		pnlBranje.setBackground(Color.WHITE);
		pnlBranje.setPreferredSize(new Dimension(screenSirina - 300, screenVisina));

		add(pnlBranje);

		JButton btnBranjeIzbrisi = new JButton("Избриши брање");
		btnBranjeIzbrisi.setForeground(Color.RED);
		btnBranjeIzbrisi.setFont(new Font("Arial", Font.PLAIN, 14));
		btnBranjeIzbrisi.setBackground(Color.WHITE);

		JScrollPane jspBranje = new JScrollPane();

		JLabel lblBranjeNaslov = new JLabel("Преглед сачуваних брања");
		lblBranjeNaslov.setHorizontalAlignment(SwingConstants.LEFT);
		lblBranjeNaslov.setFont(new Font("Arial", Font.PLAIN, 18));

		// TABELA BRANJA

		JTable tblBranje = new JTable();
		tblBranje.setShowVerticalLines(false);
		tblBranje.setFont(new Font("Arial", Font.PLAIN, 12));
		tblBranje.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblBranje.setBackground(Color.WHITE);
		jspBranje.setViewportView(tblBranje);
		
		

		// model tabele branja
		
		DefaultTableModel model_tabele_branje = new DefaultTableModel() {
			public boolean isCellEditable(int row, int column) {
				// Sve ćelije nisu editabilne
				return false;
			}
		};
		tblBranje.setModel(model_tabele_branje);


		GroupLayout gl_pnlBranje = new GroupLayout(pnlBranje);
		gl_pnlBranje.setHorizontalGroup(gl_pnlBranje.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlBranje.createSequentialGroup().addGap(120).addGroup(gl_pnlBranje
						.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlBranje.createSequentialGroup()
								.addComponent(btnBranjeIzbrisi, GroupLayout.PREFERRED_SIZE, 230,
										GroupLayout.PREFERRED_SIZE)
								.addContainerGap())
						.addGroup(gl_pnlBranje.createSequentialGroup()
								.addGroup(gl_pnlBranje.createParallelGroup(Alignment.LEADING)
										.addComponent(jspBranje, GroupLayout.DEFAULT_SIZE, 866, Short.MAX_VALUE)
										.addComponent(lblBranjeNaslov, GroupLayout.PREFERRED_SIZE, 349,
												GroupLayout.PREFERRED_SIZE))
								.addGap(250)))));
		gl_pnlBranje.setVerticalGroup(gl_pnlBranje.createParallelGroup(Alignment.LEADING).addGroup(gl_pnlBranje
				.createSequentialGroup().addGap(70)
				.addComponent(lblBranjeNaslov, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE).addGap(25)
				.addComponent(jspBranje, GroupLayout.PREFERRED_SIZE, 330, GroupLayout.PREFERRED_SIZE).addGap(20)
				.addComponent(btnBranjeIzbrisi, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
				.addGap(341)));
		// gl_Panel_Branja.setAutoCreateGaps(true);
		// gl_Panel_Branja.setAutoCreateContainerGaps(true);
		pnlBranje.setLayout(gl_pnlBranje);

	}

}
