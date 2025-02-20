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

import baza.BazaProizvod;
import baza.BazaProizvodjac;


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

		GradientPanel pnlMeni = new GradientPanel();
		pnlMeni.setBackground(Color.WHITE);
		pnlMeni.setPreferredSize(new Dimension(300, screenVisina));

		JButton btnMeniBranja = new JButton("Преглед брања");
		btnMeniBranja.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnMeniBranja.setContentAreaFilled(true);
				btnMeniBranja.setBackground(new Color(102, 255, 102));
				
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnMeniBranja.setContentAreaFilled(false);
			}
		});
		btnMeniBranja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(lp, "PanelBranja");

			}
		});
		btnMeniBranja.setIconTextGap(20);
		btnMeniBranja.setIcon(new ImageIcon(MeniPanel.class.getResource("/pogled/slike/lista.png")));
		btnMeniBranja.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnMeniBranja.setForeground(Color.BLACK);
		btnMeniBranja.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
		btnMeniBranja.setFocusable(false);
		btnMeniBranja.setContentAreaFilled(false);
		btnMeniBranja.setBorderPainted(false);
		btnMeniBranja.setBackground(Color.WHITE);

		JButton btnMeniProizvodjaci = new JButton("Произвођачи");
		btnMeniProizvodjaci.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnMeniProizvodjaci.setContentAreaFilled(true);
				btnMeniProizvodjaci.setBackground(new Color(102, 255, 102));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnMeniProizvodjaci.setContentAreaFilled(false);
			}
		});
		btnMeniProizvodjaci.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(lp, "PanelProizvodjaci");
				try{
					BazaProizvodjac.citanje_baza();	
				}
				catch(Exception e1) {
					System.out.println("Greska prilikom citanja proizvodjaca iz baze u tabelu - MeniPanel");
				}
				
				
			}
			}
		);
		btnMeniProizvodjaci.setIconTextGap(30);
		btnMeniProizvodjaci.setIcon(new ImageIcon(MeniPanel.class.getResource("/pogled/slike/ljudi.png")));
		btnMeniProizvodjaci.setForeground(Color.BLACK);
		btnMeniProizvodjaci.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
		btnMeniProizvodjaci.setFocusable(false);
		btnMeniProizvodjaci.setContentAreaFilled(false);
		btnMeniProizvodjaci.setBorderPainted(false);
		btnMeniProizvodjaci.setBackground(Color.WHITE);

		JButton btnMeniProizvodi = new JButton("Производи");
		btnMeniProizvodi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnMeniProizvodi.setContentAreaFilled(true);
				btnMeniProizvodi.setBackground(new Color(102, 255, 102));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnMeniProizvodi.setContentAreaFilled(false);
			}
		});
		btnMeniProizvodi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					BazaProizvod.citanje_baza();	
				}
				catch(Exception e1) {
					System.out.println("Greska prilikom citanja proizvoda iz baze u tabelu - MeniPanel");
				}
				
				cl.show(lp, "PanelProizvodi");
			}
		});
		btnMeniProizvodi.setIconTextGap(50);
		btnMeniProizvodi.setIcon(new ImageIcon(MeniPanel.class.getResource("/pogled/slike/proizvod.png")));
		btnMeniProizvodi.setForeground(Color.BLACK);
		btnMeniProizvodi.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
		btnMeniProizvodi.setFocusable(false);
		btnMeniProizvodi.setContentAreaFilled(false);
		btnMeniProizvodi.setBorderPainted(false);

		JButton btnMeniNovo = new JButton("Ново брање");
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
				cl.show(lp, "PanelNB");
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
		gl_pnlMeni.setHorizontalGroup(gl_pnlMeni.createParallelGroup(Alignment.LEADING)
				.addComponent(btnMeniNovo, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
				.addComponent(btnMeniBranja, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
				.addComponent(btnMeniProizvodjaci, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
				.addComponent(btnMeniProizvodi, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE));

		gl_pnlMeni.setVerticalGroup(gl_pnlMeni.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlMeni.createSequentialGroup().addGap(137)
						.addComponent(btnMeniNovo, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(btnMeniBranja, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addGap(10)
						.addComponent(btnMeniProizvodjaci, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addGap(10)
						.addComponent(btnMeniProizvodi, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(557, Short.MAX_VALUE)));
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
