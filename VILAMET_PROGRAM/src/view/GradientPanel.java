package view;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GradientPanel extends JPanel {
	
	protected void paintComponent (Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		int sirina = getWidth();
		int visina = getHeight();
		
		Color boja1 = new Color(153,255,200);
		Color boja2 = new Color(0,153,0);
		GradientPaint gp = new GradientPaint(0,0,boja1,sirina,visina,boja2);
		g2d.setPaint(gp);
		g2d.fillRect(0, 0, sirina, visina);
		
		
		
	}

}
