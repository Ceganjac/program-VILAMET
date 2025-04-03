package pogled;

import javax.swing.JPanel;

import pomocni.ProizvodInitial;
import pomocni.ProizvodjacInitial;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLayeredPane;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.SwingConstants;

import kontroler.ProizvodKontroler;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;

import model.baza.ProizvodBaza;
import model.baza.ProizvodjacBaza;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MeniPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */

	public MeniPanel(CardLayout cl, JLayeredPane paneli) {

		// UZIMANJE DIMENZIJA EKRANA
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		// int screenSirina = screenSize.width;
		int screenVisina = screenSize.height;

		setPreferredSize(new Dimension(300, 864));
		setMaximumSize(new Dimension(300, 864));

		GradientPanel pnlMeni = new GradientPanel();
		pnlMeni.setBackground(Color.WHITE);
		pnlMeni.setPreferredSize(new Dimension(300, screenVisina));

		JButton btnMeniBranje = new JButton("Откупни листови");
		btnMeniBranje.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnMeniBranje.setContentAreaFilled(true);
				btnMeniBranje.setBackground(new Color(102, 255, 102));

			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnMeniBranje.setContentAreaFilled(false);
			}
		});
		btnMeniBranje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(paneli, "PanelBranje");

			}
		});
		btnMeniBranje.setIconTextGap(20);
		btnMeniBranje.setIcon(new ImageIcon(MeniPanel.class.getResource("/pogled/slike/lista.png")));
		btnMeniBranje.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnMeniBranje.setForeground(Color.BLACK);
		btnMeniBranje.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
		btnMeniBranje.setFocusable(false);
		btnMeniBranje.setContentAreaFilled(false);
		btnMeniBranje.setBorderPainted(false);
		btnMeniBranje.setBackground(Color.WHITE);

		JButton btnMeniProizvodjac = new JButton("Произвођачи");
		btnMeniProizvodjac.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnMeniProizvodjac.setContentAreaFilled(true);
				btnMeniProizvodjac.setBackground(new Color(102, 255, 102));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnMeniProizvodjac.setContentAreaFilled(false);
			}
		});
		btnMeniProizvodjac.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(paneli, "PanelProizvodjaci");
				try {
					ProizvodjacInitial.prikazSvih();
				} catch (Exception e1) {
					System.out.println("Greska prilikom prikaza proizvodjaca - MeniPanel");
				}

			}
		});
		btnMeniProizvodjac.setIconTextGap(30);
		btnMeniProizvodjac.setIcon(new ImageIcon(MeniPanel.class.getResource("/pogled/slike/ljudi.png")));
		btnMeniProizvodjac.setForeground(Color.BLACK);
		btnMeniProizvodjac.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
		btnMeniProizvodjac.setFocusable(false);
		btnMeniProizvodjac.setContentAreaFilled(false);
		btnMeniProizvodjac.setBorderPainted(false);
		btnMeniProizvodjac.setBackground(Color.WHITE);

		JButton btnMeniProizvod = new JButton("Производи");
		btnMeniProizvod.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnMeniProizvod.setContentAreaFilled(true);
				btnMeniProizvod.setBackground(new Color(102, 255, 102));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnMeniProizvod.setContentAreaFilled(false);
			}
		});
		btnMeniProizvod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					ProizvodInitial.prikazSvih();

				} catch (Exception e1) {
					System.out.println("Greska prilikom prikaza proizvoda - MeniPanel");
					e1.printStackTrace();
				}

				cl.show(paneli, "PanelProizvod");

			}
		});
		btnMeniProizvod.setIconTextGap(50);
		btnMeniProizvod.setIcon(new ImageIcon(MeniPanel.class.getResource("/pogled/slike/proizvod.png")));
		btnMeniProizvod.setForeground(Color.BLACK);
		btnMeniProizvod.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
		btnMeniProizvod.setFocusable(false);
		btnMeniProizvod.setContentAreaFilled(false);
		btnMeniProizvod.setBorderPainted(false);

		JButton btnMeniNovo = new JButton("Откуп");
		btnMeniNovo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnMeniNovo.setContentAreaFilled(true);
				btnMeniNovo.setBackground(new Color(102, 255, 102));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnMeniNovo.setContentAreaFilled(false);
			}
		});
		btnMeniNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(paneli, "PanelNB");
			}
		});
		btnMeniNovo.setIconTextGap(50);
		btnMeniNovo.setIcon(new ImageIcon(MeniPanel.class.getResource("/pogled/slike/plus.png")));
		btnMeniNovo.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnMeniNovo.setForeground(Color.BLACK);
		btnMeniNovo.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
		btnMeniNovo.setFocusable(false);
		btnMeniNovo.setContentAreaFilled(false);
		btnMeniNovo.setBorderPainted(false);
		btnMeniNovo.setBackground(Color.WHITE);

		GroupLayout gl_pnlMeni = new GroupLayout(pnlMeni);
		gl_pnlMeni.setHorizontalGroup(
			gl_pnlMeni.createParallelGroup(Alignment.TRAILING)
				.addComponent(btnMeniNovo, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
				.addComponent(btnMeniBranje, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
				.addComponent(btnMeniProizvodjac, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
				.addComponent(btnMeniProizvod, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
		);
		gl_pnlMeni.setVerticalGroup(
			gl_pnlMeni.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlMeni.createSequentialGroup()
					.addGap(137)
					.addComponent(btnMeniNovo, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnMeniBranje, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(btnMeniProizvodjac, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(btnMeniProizvod, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(557, Short.MAX_VALUE))
		);
		pnlMeni.setLayout(gl_pnlMeni);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(pnlMeni,
				GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addComponent(pnlMeni, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		setLayout(groupLayout);

	}
}
