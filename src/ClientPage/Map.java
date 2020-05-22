package ClientPage;

import javax.swing.*;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;

public class Map extends JFrame {

	public Map() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		JFXPanel fxPanel = new JFXPanel();
		fxPanel.setBounds(0, 0, 800, 500);
		
		getContentPane().add(fxPanel);
		
		JButton searchbtn = new JButton("Home");
		searchbtn.setBounds(20, 530, 100, 23);
		searchbtn.setBackground(new Color(25, 106, 179));
		searchbtn.setForeground(Color.WHITE);
		searchbtn.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 12));
		getContentPane().add(searchbtn);
		searchbtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				new ClientHome();
			}
		});
		
		JButton basketbtn = new JButton("¡÷πÆ∆‰¿Ã¡ˆ");
		basketbtn.setBackground(new Color(25, 106, 179));
		basketbtn.setForeground(Color.WHITE);
		basketbtn.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 12));
		basketbtn.setBounds(135, 530, 100, 23);
		getContentPane().add(basketbtn);
		basketbtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				new OrderPage();
			}
		});
		
		
		JButton mapbtn = new JButton("¡ˆµµ");
		mapbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Map();
			}
		});
		mapbtn.setBounds(255, 530, 100, 23);
		mapbtn.setBackground(new Color(25, 106, 179));
		mapbtn.setForeground(Color.WHITE);
		mapbtn.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 12));
		getContentPane().add(mapbtn);
		Platform.runLater(new Runnable() {

			public void run() {
				initAndLoadWebView(fxPanel);
			}
		});
		setVisible(true);
	}

	private static void initAndLoadWebView(final JFXPanel fxPanel) {
		Group group = new Group();
		Scene scene = new Scene(group);
		fxPanel.setScene(scene);
		WebView webView = new WebView();
		group.getChildren().add(webView);
		webView.setMinSize(500, 500);
		webView.setMaxSize(1000, 600);
		WebEngine webEngine = webView.getEngine();
		webEngine.load("");
	}
}