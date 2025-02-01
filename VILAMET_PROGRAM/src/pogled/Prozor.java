package pogled;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import javax.swing.JLayeredPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.FlowLayout;
import pogled.paneli.PanelPocetni;
import pogled.paneli.PanelNB;
import pogled.paneli.PanelBranja;
import pogled.paneli.PanelProizvodjaci;
import pogled.paneli.PanelProizvodi;
import pogled.paneli.MeniPanel;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;

public class Prozor extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Prozor frame = new Prozor();
                    frame.setVisible(true);
                    frame.setExtendedState(frame.MAXIMIZED_BOTH);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Prozor() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1600, 700);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
        setContentPane(contentPane);
        contentPane.setLayout(new CardLayout(0, 0));
        PanelPocetni pocetni = new PanelPocetni((CardLayout) null, (JPanel) null);
        contentPane.add(pocetni, "name_788214687561000");
        
        JPanel glavni = new JPanel();
        contentPane.add(glavni, "name_788598884697300");
        
        JLayeredPane paneli = new JLayeredPane();
        
        PanelProizvodi proizvodi = new PanelProizvodi();
        
        PanelNB novoBranje = new PanelNB();
        
        PanelBranja branja = new PanelBranja();
        
        PanelProizvodjaci proizvodjaci = new PanelProizvodjaci();
        GroupLayout gl_paneli = new GroupLayout(paneli);
        gl_paneli.setHorizontalGroup(
        	gl_paneli.createParallelGroup(Alignment.LEADING)
        		.addGap(0, 1540, Short.MAX_VALUE)
        		.addComponent(proizvodi, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        		.addComponent(novoBranje, GroupLayout.PREFERRED_SIZE, 1540, GroupLayout.PREFERRED_SIZE)
        		.addComponent(branja, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        		.addComponent(proizvodjaci, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        );
        gl_paneli.setVerticalGroup(
        	gl_paneli.createParallelGroup(Alignment.LEADING)
        		.addGap(0, 845, Short.MAX_VALUE)
        		.addComponent(proizvodi, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        		.addComponent(novoBranje, GroupLayout.PREFERRED_SIZE, 845, GroupLayout.PREFERRED_SIZE)
        		.addComponent(branja, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        		.addComponent(proizvodjaci, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        );
        paneli.setLayout(gl_paneli);
        glavni.setLayout(new BoxLayout(glavni, BoxLayout.X_AXIS));
        
        MeniPanel meni = new MeniPanel();
        GroupLayout gl_meni = new GroupLayout(meni);
        gl_meni.setHorizontalGroup(
        	gl_meni.createParallelGroup(Alignment.LEADING)
        		.addGap(0, 1540, Short.MAX_VALUE)
        );
        gl_meni.setVerticalGroup(
        	gl_meni.createParallelGroup(Alignment.LEADING)
        		.addGap(0, 845, Short.MAX_VALUE)
        );
        meni.setLayout(gl_meni);
        glavni.add(meni);
        glavni.add(paneli);
    }
}
