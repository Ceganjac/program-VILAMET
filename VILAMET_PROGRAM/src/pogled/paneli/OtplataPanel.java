package pogled.paneli;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.JButton;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import pogled.CellRenderer;
import pogled.celleditor.AmbalazaCellEditor;

import javax.swing.JTextArea;
import javax.swing.BorderFactory;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;

public class OtplataPanel extends JPanel {

	// UZIMANJE DIMENZIJA EKRANA
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	int screenSirina = screenSize.width;
	int screenVisina = screenSize.height;

	private static final long serialVersionUID = 1L;
	private DefaultTableModel modelIsplata;
	private DefaultTableModel modelUOtplate;
	private JTextField txtNovaIznos;
	private JTable tblIsplata;
	private JTable tblUOtplate;

	/**
	 * Create the panel.
	 */
	public OtplataPanel() {
		setPreferredSize(new Dimension(screenSirina - 300, screenVisina - 50));
		setBackground(Color.white);

		JTabbedPane tpnOtplata = new JTabbedPane(JTabbedPane.TOP);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(120)
					.addComponent(tpnOtplata, GroupLayout.PREFERRED_SIZE, 1240, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(260, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(40)
					.addComponent(tpnOtplata, GroupLayout.PREFERRED_SIZE, 590, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(290, Short.MAX_VALUE))
		);

		/////////////////////////////////////////////////////////////////////////////////////////////////////////////
		// PANEL USLOVI OTPLATE

		JPanel pnlUOtplate = new JPanel();
		pnlUOtplate.setBackground(Color.WHITE);
		tpnOtplata.addTab("Услови отплате", null, pnlUOtplate, null);

		JScrollPane jspUOtplateOtpl = new JScrollPane();

		JLabel lblUOtplatePrikaz = new JLabel("Приказ услова отплате");
		lblUOtplatePrikaz.setFont(new Font("Arial", Font.PLAIN, 20));

		JLabel lblUOtplateNovi = new JLabel("Унесите нови услов отплате");
		lblUOtplateNovi.setFont(new Font("Arial", Font.PLAIN, 20));

		JPanel pnlUOtplateNovi = new JPanel();
		pnlUOtplateNovi.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pnlUOtplateNovi.setBackground(Color.WHITE);

		JButton btnNoviIsprazni = new JButton("Испразни поља");
		btnNoviIsprazni.setForeground(Color.RED);
		btnNoviIsprazni.setFont(new Font("Arial", Font.PLAIN, 14));
		btnNoviIsprazni.setBackground(Color.WHITE);

		JButton btnNoviDodaj = new JButton("Додај");
		btnNoviDodaj.setFont(new Font("Arial", Font.PLAIN, 14));
		btnNoviDodaj.setBackground(new Color(153, 255, 153));

		JLabel lblNoviOpis = new JLabel("Опис начина :");
		lblNoviOpis.setFont(new Font("Arial", Font.PLAIN, 16));

		JTextArea txaNoviOpis = new JTextArea();
		txaNoviOpis.setLineWrap(true);
		txaNoviOpis.setBorder(BorderFactory.createLineBorder(Color.gray));
		txaNoviOpis.setBackground(Color.WHITE);

		// Raspored elemenata pomoću Group Layout-a za pnlUOtplateNovi
		GroupLayout gl_pnlUOtplateNovi = new GroupLayout(pnlUOtplateNovi);
		gl_pnlUOtplateNovi.setHorizontalGroup(
			gl_pnlUOtplateNovi.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlUOtplateNovi.createSequentialGroup()
					.addGap(30)
					.addGroup(gl_pnlUOtplateNovi.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_pnlUOtplateNovi.createSequentialGroup()
							.addComponent(btnNoviIsprazni, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnNoviDodaj, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pnlUOtplateNovi.createSequentialGroup()
							.addComponent(lblNoviOpis, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(txaNoviOpis, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(30, Short.MAX_VALUE))
		);
		gl_pnlUOtplateNovi.setVerticalGroup(
			gl_pnlUOtplateNovi.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlUOtplateNovi.createSequentialGroup()
					.addGap(30)
					.addGroup(gl_pnlUOtplateNovi.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNoviOpis, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(txaNoviOpis, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
					.addGap(50)
					.addGroup(gl_pnlUOtplateNovi.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNoviIsprazni, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNoviDodaj, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addGap(204))
		);
		pnlUOtplateNovi.setLayout(gl_pnlUOtplateNovi);

		// Raspored elemenata pomoću Group Layout-a za pnlUOtplate
		GroupLayout gl_pnlUOtplate = new GroupLayout(pnlUOtplate);
		gl_pnlUOtplate.setHorizontalGroup(
			gl_pnlUOtplate.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlUOtplate.createSequentialGroup()
					.addGap(40)
					.addGroup(gl_pnlUOtplate.createParallelGroup(Alignment.LEADING)
						.addComponent(lblUOtplatePrikaz, GroupLayout.PREFERRED_SIZE, 349, GroupLayout.PREFERRED_SIZE)
						.addComponent(jspUOtplateOtpl, GroupLayout.PREFERRED_SIZE, 640, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
					.addGroup(gl_pnlUOtplate.createParallelGroup(Alignment.LEADING)
						.addComponent(lblUOtplateNovi, GroupLayout.PREFERRED_SIZE, 349, GroupLayout.PREFERRED_SIZE)
						.addComponent(pnlUOtplateNovi, GroupLayout.PREFERRED_SIZE, 490, GroupLayout.PREFERRED_SIZE))
					.addGap(34))
		);
		gl_pnlUOtplate.setVerticalGroup(
			gl_pnlUOtplate.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlUOtplate.createSequentialGroup()
					.addGap(40)
					.addGroup(gl_pnlUOtplate.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlUOtplate.createSequentialGroup()
							.addComponent(lblUOtplateNovi, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
							.addGap(25)
							.addComponent(pnlUOtplateNovi, GroupLayout.PREFERRED_SIZE, 430, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pnlUOtplate.createSequentialGroup()
							.addComponent(lblUOtplatePrikaz, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
							.addGap(25)
							.addComponent(jspUOtplateOtpl, GroupLayout.PREFERRED_SIZE, 430, GroupLayout.PREFERRED_SIZE))))
		);

		// TABELA USLOVI OTPLATE

		tblUOtplate = new JTable();
		tblUOtplate.setSelectionBackground(new Color(153, 255, 153));
		tblUOtplate.setRowHeight(25);
		tblUOtplate.setFont(new Font("Arial", Font.PLAIN, 12));
		tblUOtplate.setBackground(Color.WHITE);

		// heder tabele tblpRAVNO
		JTableHeader hederP = tblUOtplate.getTableHeader();
		hederP.setBackground(Color.LIGHT_GRAY);
		hederP.setPreferredSize(new Dimension(hederP.getWidth(), 30));

		// Inicijalizacija modela tabele
		String[] koloneUo = { "Редни бр.", "ИД ", "Опис услова исплате" };
		modelUOtplate = new DefaultTableModel();
		modelUOtplate.setColumnIdentifiers(koloneUo);
		tblUOtplate.setModel(modelUOtplate);

		// render za prikaz sadržaja tabele centrirano
		DefaultTableCellRenderer centerRendererP = new DefaultTableCellRenderer();
		centerRendererP.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
		for (int i = 0; i < tblUOtplate.getColumnCount() - 1; i++) {
			tblUOtplate.getColumnModel().getColumn(i).setCellRenderer(centerRendererP);
		}

		// okruživanje tabele sa jspUOtplate
		jspUOtplateOtpl.setViewportView(tblUOtplate);

		pnlUOtplate.setLayout(gl_pnlUOtplate);

		/////////////////////////////////////////////////////////////////////////////////////////////////////////////
		// PANEL ISPLATA

		JPanel pnlIsplate = new JPanel();
		pnlIsplate.setBackground(Color.WHITE);
		tpnOtplata.addTab("Исплате", null, pnlIsplate, null);

		JLabel lblIsplataPregled = new JLabel("Преглед реализованих исплата");
		lblIsplataPregled.setFont(new Font("Arial", Font.PLAIN, 20));

		JLabel lblIsplataNova = new JLabel("Унесите нову исплату");
		lblIsplataNova.setFont(new Font("Arial", Font.PLAIN, 20));

		JPanel pnlIsplataNova = new JPanel();
		pnlIsplataNova.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pnlIsplataNova.setBackground(Color.WHITE);

		JButton btnNovaIsprazni = new JButton("Испразни поља");
		btnNovaIsprazni.setForeground(Color.RED);
		btnNovaIsprazni.setFont(new Font("Arial", Font.PLAIN, 14));
		btnNovaIsprazni.setBackground(Color.WHITE);

		JButton btnNovaDodaj = new JButton("Додај");
		btnNovaDodaj.setFont(new Font("Arial", Font.PLAIN, 14));
		btnNovaDodaj.setBackground(new Color(153, 255, 153));

		JLabel lblNovaIznos = new JLabel("Износ :");
		lblNovaIznos.setFont(new Font("Arial", Font.PLAIN, 16));

		JLabel lblNovaNapomena = new JLabel("Напомена :");
		lblNovaNapomena.setFont(new Font("Arial", Font.PLAIN, 16));

		JLabel lblNovaDatum = new JLabel("Датум :");
		lblNovaDatum.setFont(new Font("Arial", Font.PLAIN, 16));

		txtNovaIznos = new JTextField();
		txtNovaIznos.setHorizontalAlignment(SwingConstants.CENTER);
		txtNovaIznos.setToolTipText("");
		txtNovaIznos.setColumns(10);

		JDateChooser dtcNovaDatum = new JDateChooser();
		dtcNovaDatum.getCalendarButton().setBackground(Color.WHITE);
		dtcNovaDatum.setBackground(Color.WHITE);

		JTextArea txaNovaNapomena = new JTextArea();
		txaNovaNapomena.setLineWrap(true);
		txaNovaNapomena.setBorder(BorderFactory.createLineBorder(Color.gray));
		txaNovaNapomena.setBackground(Color.WHITE);

		JLabel lblNovaProizvodjac = new JLabel("Произвођач :");
		lblNovaProizvodjac.setFont(new Font("Arial", Font.PLAIN, 16));

		JComboBox<String> cmbNovaProizvodjac = new JComboBox<String>();
		cmbNovaProizvodjac.setBackground(Color.WHITE);

		GroupLayout gl_pnlIsplataNova = new GroupLayout(pnlIsplataNova);
		gl_pnlIsplataNova.setHorizontalGroup(gl_pnlIsplataNova.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlIsplataNova.createSequentialGroup().addGap(30).addGroup(gl_pnlIsplataNova
						.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_pnlIsplataNova.createSequentialGroup()
								.addComponent(btnNovaIsprazni, GroupLayout.PREFERRED_SIZE, 140,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnNovaDodaj, GroupLayout.PREFERRED_SIZE, 160,
										GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pnlIsplataNova.createSequentialGroup()
								.addGroup(gl_pnlIsplataNova.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_pnlIsplataNova.createSequentialGroup()
												.addComponent(lblNovaNapomena, GroupLayout.PREFERRED_SIZE, 180,
														GroupLayout.PREFERRED_SIZE)
												.addGap(10))
										.addGroup(gl_pnlIsplataNova.createSequentialGroup()
												.addComponent(lblNovaIznos, GroupLayout.PREFERRED_SIZE, 180,
														GroupLayout.PREFERRED_SIZE)
												.addGap(10)))
								.addGroup(
										gl_pnlIsplataNova.createParallelGroup(Alignment.LEADING, false)
												.addComponent(txaNovaNapomena, GroupLayout.DEFAULT_SIZE, 220,
														Short.MAX_VALUE)
												.addComponent(txtNovaIznos)))
						.addGroup(gl_pnlIsplataNova.createSequentialGroup()
								.addComponent(lblNovaDatum, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
								.addGap(10).addComponent(dtcNovaDatum, GroupLayout.PREFERRED_SIZE, 220,
										GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pnlIsplataNova.createSequentialGroup().addGap(0)
								.addComponent(lblNovaProizvodjac, GroupLayout.PREFERRED_SIZE, 180,
										GroupLayout.PREFERRED_SIZE)
								.addGap(10).addComponent(cmbNovaProizvodjac, GroupLayout.PREFERRED_SIZE, 220,
										GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(46, Short.MAX_VALUE)));
		gl_pnlIsplataNova.setVerticalGroup(gl_pnlIsplataNova.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlIsplataNova.createSequentialGroup().addGap(30)
						.addGroup(gl_pnlIsplataNova.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNovaDatum, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
								.addComponent(dtcNovaDatum, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
						.addGap(10)
						.addGroup(gl_pnlIsplataNova.createParallelGroup(Alignment.BASELINE)
								.addComponent(cmbNovaProizvodjac, GroupLayout.PREFERRED_SIZE, 26,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNovaProizvodjac, GroupLayout.PREFERRED_SIZE, 26,
										GroupLayout.PREFERRED_SIZE))
						.addGap(10)
						.addGroup(gl_pnlIsplataNova.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNovaIznos, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtNovaIznos, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
						.addGap(10)
						.addGroup(gl_pnlIsplataNova.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNovaNapomena, GroupLayout.PREFERRED_SIZE, 26,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(txaNovaNapomena, GroupLayout.PREFERRED_SIZE, 80,
										GroupLayout.PREFERRED_SIZE))
						.addGap(50)
						.addGroup(gl_pnlIsplataNova.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnNovaIsprazni, GroupLayout.PREFERRED_SIZE, 40,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNovaDodaj, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
						.addGap(113)));
		pnlIsplataNova.setLayout(gl_pnlIsplataNova);

		/////////////////////////////////////////////////////////////////////////////////////////////////////////////
		// TABELA ISPLATA

		tblIsplata = new JTable();

		// stavljanje boje koju će imati polja koja selektovana
		tblIsplata.setSelectionBackground(new Color(153, 255, 153));

		tblIsplata.setRowHeight(25);
		tblIsplata.setFont(new Font("Arial", Font.PLAIN, 12));
		tblIsplata.setBackground(Color.WHITE);

		// heder tabele
		JTableHeader heder = tblIsplata.getTableHeader();
		heder.setBackground(Color.LIGHT_GRAY);
		heder.setPreferredSize(new Dimension(heder.getWidth(), 30));

		// omogućava hover reda
		tblIsplata.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				tblIsplata.clearSelection();
			}
		});

		String[] kolone = { "Редни бр.", "ИД исплате", "Датум", "Произвођач", "Износ", "Опције" };

		// inicijalizacija modela tabele
		modelIsplata = new DefaultTableModel();

		// postavljanje modela tabeli
		tblIsplata.setModel(modelIsplata);
		modelIsplata.setColumnIdentifiers(kolone);

		// kako bi sve ćelije tabele bile needitabilne
		tblIsplata.setDefaultEditor(Object.class, null);

		// postavljanje CellRenderer-a i CellEditor-a
		tblIsplata.getColumnModel().getColumn(4).setCellRenderer(new CellRenderer());
		tblIsplata.getColumnModel().getColumn(4).setCellEditor(new AmbalazaCellEditor(tblIsplata));

		// render za prikaz sadržaja tabele centrirano
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
		for (int i = 0; i < tblIsplata.getColumnCount() - 1; i++) {
			tblIsplata.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
		}

		// okruživanje tabele sa JscrollPane
		JScrollPane jspIsplata = new JScrollPane();
		jspIsplata.setViewportView(tblIsplata);
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////

		GroupLayout gl_pnlIsplate = new GroupLayout(pnlIsplate);
		gl_pnlIsplate.setHorizontalGroup(
			gl_pnlIsplate.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlIsplate.createSequentialGroup()
					.addGap(40)
					.addGroup(gl_pnlIsplate.createParallelGroup(Alignment.LEADING)
						.addComponent(lblIsplataPregled, GroupLayout.PREFERRED_SIZE, 349, GroupLayout.PREFERRED_SIZE)
						.addComponent(jspIsplata, GroupLayout.PREFERRED_SIZE, 640, GroupLayout.PREFERRED_SIZE))
					.addGap(30)
					.addGroup(gl_pnlIsplate.createParallelGroup(Alignment.LEADING)
						.addComponent(lblIsplataNova, GroupLayout.PREFERRED_SIZE, 349, GroupLayout.PREFERRED_SIZE)
						.addComponent(pnlIsplataNova, GroupLayout.PREFERRED_SIZE, 490, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(35, Short.MAX_VALUE))
		);
		gl_pnlIsplate.setVerticalGroup(
			gl_pnlIsplate.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlIsplate.createSequentialGroup()
					.addGap(40)
					.addGroup(gl_pnlIsplate.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblIsplataPregled, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblIsplataNova, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addGap(25)
					.addGroup(gl_pnlIsplate.createParallelGroup(Alignment.LEADING, false)
						.addComponent(jspIsplata, GroupLayout.PREFERRED_SIZE, 430, GroupLayout.PREFERRED_SIZE)
						.addComponent(pnlIsplataNova, GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE))
					.addContainerGap(40, Short.MAX_VALUE))
		);
		pnlIsplate.setLayout(gl_pnlIsplate);
		setLayout(groupLayout);

	}
}
