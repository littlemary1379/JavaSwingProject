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

import utils.FindIDSourse;
import utils.ResizeImage;

@SuppressWarnings("serial")

public class FindID extends JFrame {

	private ImageIcon icon, bicon;
	private JPanel background, findIdPanel;
	private JLabel findIDLabel, findNameLabel, findEmailLabel;
	private JTextField findNameField, findEmailField;
	private JButton findIDButton, homeButton;
	ResizeImage resizeImage=new ResizeImage();


	public FindID() {
		initObject();
		initDesign();
		initListener();
	}
	
	void initObject() {
		icon = new ImageIcon("img/LoginBack2.jpg");
		bicon = new ImageIcon("img/home.png");
		findIdPanel = new JPanel();
		findIDLabel = new JLabel("ID √£±‚");
		findNameLabel = new JLabel("¿Ã∏ß");
		findNameField = new JTextField();
		findEmailLabel = new JLabel("E-mail");
		findEmailField = new JTextField();
		findIDButton = new JButton("√£±‚");
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
		
		setTitle("No24 æ∆¿Ãµ √£±‚ ∆‰¿Ã¡ˆ¿‘¥œ¥Ÿ.");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);
		setLocationRelativeTo(null);
		setVisible(true);

		background.setBackground(Color.WHITE);
		setContentPane(background);
		background.setLayout(null);

		findIdPanel.setBackground(new Color(255, 255, 255, 200));
		findIdPanel.setBounds(54, 137, 262, 248);
		findIdPanel.setLayout(null);
		
		findIDLabel.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 20));
		findIDLabel.setBounds(12, 10, 100, 25);
		
		findNameLabel.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 12));
		findNameLabel.setBounds(12, 71, 57, 15);
		
		findNameField.setBounds(12, 96, 225, 21);
		findNameField.setColumns(10);
		
		findEmailLabel.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 12));
		findEmailLabel.setBounds(12, 137, 57, 15);
		
		findEmailField.setBounds(12, 162, 225, 21);
		findEmailField.setColumns(10);
		
		findIDButton.setForeground(Color.WHITE);
		findIDButton.setBackground(new Color(51, 153, 153));
		findIDButton.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 11));
		findIDButton.setBounds(180, 204, 57, 23);


		homeButton.setBackground(new Color(255, 255, 255));
		homeButton.setBounds(12, 10, 30, 30);
		homeButton.setIcon(resizeImage.resizeIcon(bicon, 30, 30));
			
		//add
		background.add(findIdPanel);
		findIdPanel.add(findIDLabel);
		findIdPanel.add(findNameLabel);
		findIdPanel.add(findNameField);
		findIdPanel.add(findEmailLabel);
		findIdPanel.add(findEmailField);
		findIdPanel.add(findIDButton);
		background.add(homeButton);

		
		}
		
	void initListener() {
		findIDButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				FindIDSourse findingID=new FindIDSourse();
				findingID.FindingID(findNameField.getText(),findEmailField.getText());				
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