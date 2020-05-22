package loginpage;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import utils.FindPwdSource;
import utils.ResizeImage;

@SuppressWarnings("serial")
public class FindPW extends JFrame {
	private ImageIcon icon, bicon;
	private JTextField nametextField,idtextField,emailtextField;
	private JLabel findPwdLabel,findNameLabel, findIDLabel, findEmailLabel;
	private JPanel background, findPwdPanel;
	private JButton findPwdButton, homeButton;
	ResizeImage resizeImage=new ResizeImage();

	public FindPW() {
		initObject();
		initDesign();
		initListener();
	}
	
	void initObject() {
		icon = new ImageIcon("img/LoginBack2.jpg");
		bicon = new ImageIcon("img/home.png");
		findPwdPanel = new JPanel();
		findPwdLabel = new JLabel("PW √£±‚");
		findNameLabel = new JLabel("¿Ã∏ß");
		nametextField = new JTextField();
		findIDLabel = new JLabel("ID");
		idtextField = new JTextField();
		findEmailLabel = new JLabel("E-mail");
		emailtextField = new JTextField();
		findPwdButton = new JButton("√£±‚");
		homeButton = new JButton(bicon);
	}
	
	void initDesign(){
		
		//design
		background = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(icon.getImage(), -50, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		
		setTitle("No24 ∫Òπ–π¯»£ √£±‚ ∆‰¿Ã¡ˆ¿‘¥œ¥Ÿ.");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);
		setLocationRelativeTo(null);
		setVisible(true);

		background.setBackground(Color.WHITE);
		setContentPane(background);
		background.setLayout(null);

		findPwdPanel.setBackground(new Color(255, 255, 255, 200));
		findPwdPanel.setBounds(54, 137, 254, 275);
		findPwdPanel.setLayout(null);
		
		findPwdLabel.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 20));
		findPwdLabel.setBounds(12, 10, 100, 25);
		
		findNameLabel.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 12));
		findNameLabel.setBounds(12, 59, 57, 15);
		
		nametextField.setBounds(12, 84, 225, 21);
		nametextField.setColumns(10);
		
		findIDLabel.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 12));
		findIDLabel.setBounds(12, 115, 57, 15);
		
		idtextField.setBounds(12, 140, 225, 21);
		idtextField.setColumns(10);
				
		findEmailLabel.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 12));
		findEmailLabel.setBounds(12, 171, 57, 15);
		
		emailtextField.setBounds(12, 196, 225, 21);
		emailtextField.setColumns(10);
		
		findPwdButton.setForeground(Color.WHITE);
		findPwdButton.setBackground(new Color(51, 153, 153));
		findPwdButton.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 11));
		findPwdButton.setBounds(180, 242, 57, 23);

		homeButton.setBackground(new Color(255, 255, 255));
		homeButton.setBounds(12, 10, 30, 30);
		homeButton.setIcon(resizeImage.resizeIcon(bicon, 30, 30));

		//add
		background.add(findPwdPanel);
		findPwdPanel.add(findPwdLabel);
		findPwdPanel.add(findNameLabel);
		findPwdPanel.add(nametextField);
		findPwdPanel.add(findIDLabel);
		findPwdPanel.add(idtextField);
		findPwdPanel.add(findEmailLabel);
		findPwdPanel.add(emailtextField);
		findPwdPanel.add(findPwdButton);
		background.add(homeButton);

	}
	
	void initListener() {
		
		findPwdButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				FindPwdSource findPwdSource=new FindPwdSource();
				findPwdSource.FindingPW(nametextField.getText(),idtextField.getText(),emailtextField.getText());	
			}
		});
		
		homeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Login();
			}
		});
	}
}