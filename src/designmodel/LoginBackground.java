package designmodel;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class LoginBackground extends JPanel{
	
	JPanel background;
	ImageIcon icon;
	
	public LoginBackground() {
		icon = new ImageIcon("img/LoginBack2.jpg");
		background = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(icon.getImage(), -50, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};

	}
	
}
