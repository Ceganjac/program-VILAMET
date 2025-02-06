package pogled.paneli;

import javax.swing.JPanel;
import pogled.GradientPanel;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLayeredPane;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MeniPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public MeniPanel(CardLayout cl, JLayeredPane lp) {

		// UZIMANJE DIMENZIJA EKRANA
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenSirina = screenSize.width;
		int screenVisina = screenSize.height;

		setPreferredSize(new Dimension(300, 864));

		GradientPanel MeniPanel = new GradientPanel();
		MeniPanel.setBackground(Color.WHITE);
		MeniPanel.setPreferredSize(new Dimension(300, screenVisina));

		JButton Dugme_pregled_branja = new JButton("Преглед брања");
		Dugme_pregled_branja.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Dugme_pregled_branja.setContentAreaFilled(true);
				Dugme_pregled_branja.setBackground(new Color(102, 255, 102));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Dugme_pregled_branja.setContentAreaFilled(false);
			}
		});
		Dugme_pregled_branja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(lp, "PanelBranja");
			}
		});
		Dugme_pregled_branja.setIconTextGap(20);
		Dugme_pregled_branja.setIcon(new ImageIcon(MeniPanel.class.getResource("/pogled/slike/lista.png")));
		Dugme_pregled_branja.setHorizontalTextPosition(SwingConstants.RIGHT);
		Dugme_pregled_branja.setForeground(Color.BLACK);
		Dugme_pregled_branja.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
		Dugme_pregled_branja.setFocusable(false);
		Dugme_pregled_branja.setContentAreaFilled(false);
		Dugme_pregled_branja.setBorderPainted(false);
		Dugme_pregled_branja.setBackground(Color.WHITE);

		JButton Dugme_proizvodjaci = new JButton("Произвођачи");
		Dugme_proizvodjaci.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Dugme_proizvodjaci.setContentAreaFilled(true);
				Dugme_proizvodjaci.setBackground(new Color(102, 255, 102));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Dugme_proizvodjaci.setContentAreaFilled(false);
			}
		});
		Dugme_proizvodjaci.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(lp, "PanelProizvodjaci");
			}
		});
		Dugme_proizvodjaci.setIconTextGap(30);
		Dugme_proizvodjaci.setIcon(new ImageIcon(MeniPanel.class.getResource("/pogled/slike/ljudi.png")));
		Dugme_proizvodjaci.setForeground(Color.BLACK);
		Dugme_proizvodjaci.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
		Dugme_proizvodjaci.setFocusable(false);
		Dugme_proizvodjaci.setContentAreaFilled(false);
		Dugme_proizvodjaci.setBorderPainted(false);
		Dugme_proizvodjaci.setBackground(Color.WHITE);

		JButton Dugme_proizvod = new JButton("Производи");
		Dugme_proizvod.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Dugme_proizvod.setContentAreaFilled(true);
				Dugme_proizvod.setBackground(new Color(102, 255, 102));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Dugme_proizvod.setContentAreaFilled(false);
			}
		});
		Dugme_proizvod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(lp, "PanelProizvodi");
			}
		});
		Dugme_proizvod.setIconTextGap(50);
		Dugme_proizvod.setIcon(new ImageIcon(MeniPanel.class.getResource("/pogled/slike/proizvod.png")));
		Dugme_proizvod.setForeground(Color.BLACK);
		Dugme_proizvod.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
		Dugme_proizvod.setFocusable(false);
		Dugme_proizvod.setContentAreaFilled(false);
		Dugme_proizvod.setBorderPainted(false);

		JButton Dugme_novo_branje = new JButton("Ново брање");
		Dugme_novo_branje.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Dugme_novo_branje.setContentAreaFilled(true);
				Dugme_novo_branje.setBackground(new Color(102, 255, 102));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Dugme_novo_branje.setContentAreaFilled(false);
			}
		});
		Dugme_novo_branje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(lp, "PanelNB");
			}
		});
		Dugme_novo_branje.setIconTextGap(50);
		Dugme_novo_branje.setIcon(new ImageIcon(MeniPanel.class.getResource("/pogled/slike/plus.png")));
		Dugme_novo_branje.setHorizontalTextPosition(SwingConstants.RIGHT);
		Dugme_novo_branje.setForeground(Color.BLACK);
		Dugme_novo_branje.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
		Dugme_novo_branje.setFocusable(false);
		Dugme_novo_branje.setContentAreaFilled(false);
		Dugme_novo_branje.setBorderPainted(false);
		Dugme_novo_branje.setBackground(Color.WHITE);

		GroupLayout gl_Meni_Panel_NB = new GroupLayout(MeniPanel);
		gl_Meni_Panel_NB.setHorizontalGroup(gl_Meni_Panel_NB.createParallelGroup(Alignment.LEADING)
				.addComponent(Dugme_novo_branje, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
				.addComponent(Dugme_pregled_branja, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
				.addComponent(Dugme_proizvodjaci, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
				.addComponent(Dugme_proizvod, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE));

		gl_Meni_Panel_NB.setVerticalGroup(gl_Meni_Panel_NB.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Meni_Panel_NB.createSequentialGroup().addGap(137)
						.addComponent(Dugme_novo_branje, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(Dugme_pregled_branja, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addGap(10)
						.addComponent(Dugme_proizvodjaci, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addGap(10)
						.addComponent(Dugme_proizvod, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(557, Short.MAX_VALUE)));
		MeniPanel.setLayout(gl_Meni_Panel_NB);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(MeniPanel,
				GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addComponent(MeniPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		setLayout(groupLayout);

	}
}
