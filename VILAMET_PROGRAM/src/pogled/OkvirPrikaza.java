package pogled;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;

import pogled.paneli.MeniPanel;
import pogled.paneli.NaziviPanel;
import pogled.paneli.PocetniPanel;

public class OkvirPrikaza extends JFrame {

    private static final long serialVersionUID = 1L;

    private static OkvirPrikaza frame = null;

    // Dimenzije ekrana
    static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int screenSirina = screenSize.width;
    int screenVisina = screenSize.height;

    private JPanel contentPane;
    private CardLayout cardLayout;
    private JLayeredPane paneli;
    private PocetniPanel pocetniPanel;

    private static JPanel glavni;
    private static CardLayout clPaneli;
    private static NaziviPanel naziviPanel;

    // ================= KONSTRUKTOR =================

    public OkvirPrikaza(PocetniPanel pocetniPanel) {
    	this.pocetniPanel = pocetniPanel;
        initUI();
    }

    // ================= INICIJALIZACIJA UI =================

    private void initUI() {

        setTitle("ВИЛАМЕТ");
        setIconImage(Toolkit.getDefaultToolkit().getImage(
                OkvirPrikaza.class.getResource("/pogled/slike/logo donji.png")));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(screenSirina - 200, screenVisina - 150));

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));

        cardLayout = new CardLayout();
        contentPane.setLayout(cardLayout);
        setContentPane(contentPane);
        contentPane.add(pocetniPanel);

        // ================= GLAVNI PANEL =================

        glavni = new JPanel();
        glavni.setBackground(Color.DARK_GRAY);
        contentPane.add(glavni, "glavni");

        // ================= LAYERED PANE =================

        paneli = new JLayeredPane();
        paneli.setPreferredSize(new Dimension(screenSirina - 300, screenVisina));

        clPaneli = new CardLayout();
        paneli.setLayout(clPaneli);

        // ================= MENI PANEL =================

        MeniPanel meni = new MeniPanel(clPaneli, paneli);

        // ================= NAZIVI PANEL =================

        naziviPanel = new NaziviPanel();

        // ================= LAYOUT =================

        GroupLayout gl = new GroupLayout(glavni);
        glavni.setLayout(gl);

        gl.setHorizontalGroup(
            gl.createParallelGroup(Alignment.LEADING)
                .addGroup(gl.createSequentialGroup()
                    .addComponent(meni, GroupLayout.PREFERRED_SIZE,
                            GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGroup(gl.createParallelGroup(Alignment.LEADING)
                        .addComponent(naziviPanel, GroupLayout.PREFERRED_SIZE, 1620,
                                GroupLayout.PREFERRED_SIZE)
                        .addComponent(paneli, GroupLayout.DEFAULT_SIZE,
                                GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        gl.setVerticalGroup(
            gl.createParallelGroup(Alignment.LEADING)
                .addComponent(meni, GroupLayout.PREFERRED_SIZE,
                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGroup(gl.createSequentialGroup()
                    .addComponent(naziviPanel, GroupLayout.PREFERRED_SIZE,
                            GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(paneli, GroupLayout.DEFAULT_SIZE,
                            GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        // ================= PRIKAZ =================

        cardLayout.show(contentPane, "pocetni");
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

  

  

    // ================= GETTERI =================

    public static JPanel getGlavni() {
        return glavni;
    }

    public CardLayout getCLPaneli() {
        return clPaneli;
    }

    public static NaziviPanel getNaziviPanel() {
        return naziviPanel;
    }
    public  JLayeredPane getJLayeredPane() {
        return paneli;
    }
    
}
