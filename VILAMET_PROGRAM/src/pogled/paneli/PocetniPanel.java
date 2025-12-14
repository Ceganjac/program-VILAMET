package pogled.paneli;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;

import pogled.GradientPanel;
import pogled.PozadinaPanel;

public class PocetniPanel extends PozadinaPanel {

    private static final long serialVersionUID = 1L;

    // Dimenzije ekrana
    static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int screenSirina = screenSize.width;
    int screenVisina = screenSize.height;

    private JLayeredPane paneli;
    private JPanel contentPane;

    // ================= KONSTRUKTOR =================

    public PocetniPanel() {
        super("/pogled/slike/pozadina1.png");
        initUI();
    }

    // ================= INICIJALIZACIJA =================

    private void initUI() {

        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(screenSirina - 200, screenVisina - 150));

        JPanel pnlPocetni = new GradientPanel();
        pnlPocetni.setOpaque(false);

        JLabel lblPocetniDobro = new JLabel("Добро дошли !");
        lblPocetniDobro.setHorizontalAlignment(SwingConstants.CENTER);
        lblPocetniDobro.setForeground(Color.WHITE);
        lblPocetniDobro.setFont(new Font("Arial", Font.ITALIC, 24));

        JButton btnPocetniPocetak = new JButton("ПОЧЕТАК");
        btnPocetniPocetak.setForeground(Color.BLACK);
        btnPocetniPocetak.setFont(new Font("Arial", Font.BOLD, 12));
        btnPocetniPocetak.setBorder(null);
        btnPocetniPocetak.setFocusable(false);
        btnPocetniPocetak.setBackground(Color.WHITE);

        btnPocetniPocetak.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnPocetniPocetak.setBackground(Color.BLACK);
                btnPocetniPocetak.setForeground(Color.WHITE);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnPocetniPocetak.setBackground(Color.WHITE);
                btnPocetniPocetak.setForeground(Color.BLACK);
            }
        });

        btnPocetniPocetak.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OtkupPanel otkupPanel = new OtkupPanel();
                paneli.add(otkupPanel);
            }
        });

        JLabel lblPocetniLogo = new JLabel();
        lblPocetniLogo.setIcon(
                new ImageIcon(PocetniPanel.class.getResource("/pogled/slike/logo crveni.png"))
        );

        // ================= LAYOUT pnlPocetni =================

        GroupLayout glPocetni = new GroupLayout(pnlPocetni);
        pnlPocetni.setLayout(glPocetni);

        glPocetni.setHorizontalGroup(
            glPocetni.createParallelGroup(Alignment.CENTER)
                .addGroup(glPocetni.createSequentialGroup()
                    .addGap(124)
                    .addGroup(glPocetni.createParallelGroup(Alignment.CENTER)
                        .addComponent(lblPocetniDobro, 270, 270, 270)
                        .addComponent(btnPocetniPocetak, 240, 240, 240)
                        .addComponent(lblPocetniLogo))
                    .addGap(125))
        );

        glPocetni.setVerticalGroup(
            glPocetni.createSequentialGroup()
                .addGap(330)
                .addComponent(lblPocetniDobro, 70, 70, 70)
                .addGap(40)
                .addComponent(btnPocetniPocetak, 40, 40, 40)
                .addGap(90)
                .addComponent(lblPocetniLogo)
                .addGap(121)
        );

        // ================= LAYOUT ovog panela =================

        GroupLayout gl = new GroupLayout(this);
        setLayout(gl);

        gl.setHorizontalGroup(
            gl.createSequentialGroup()
                .addGap(600)
                .addComponent(pnlPocetni, 520, 520, Short.MAX_VALUE)
                .addGap(600)
        );

        gl.setVerticalGroup(
            gl.createParallelGroup(Alignment.LEADING)
                .addComponent(pnlPocetni, GroupLayout.DEFAULT_SIZE, 930, Short.MAX_VALUE)
        );
    }
}
