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
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import datamodel.UserModel;
import designmodel.LoginBackground;
import utils.LoginConnection;

@SuppressWarnings("serial")

public class Login extends JFrame{
	
	private JPanel background,loginPanel;
	private ImageIcon icon;
	private JTextField IDField, pwdField;
	private JButton loginButton, joinButton, findIDButton,findpwdButton;
	private JLabel loginLabel, IDLabel,pwdLabel, joinLabel;
	private JSeparator separator;
	LoginBackground loginBackground=new LoginBackground();

	public Login() {
		/* try {
			 UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} */

		System.out.println(UserModel.getName());
		initObject();
		initDesign();
		initListener();
	}
	void initObject() {
		icon=new ImageIcon("img/LoginBack2.jpg");
		loginPanel = new JPanel();
		loginLabel = new JLabel("LOGIN");
		IDLabel = new JLabel("ID");
		IDField = new JTextField();
		pwdLabel = new JLabel("PW");
		pwdField = new JPasswordField();
		loginButton = new JButton("·Î±×ÀÎ");
		joinLabel = new JLabel("¾ÆÁ÷ È¸¿øÀÌ ¾Æ´Ï½Å°¡¿ä?");
		joinButton = new JButton("È¸¿ø°¡ÀÔ");
		separator = new JSeparator();
		findIDButton = new JButton("¾ÆÀÌµð Ã£±â");
		findpwdButton = new JButton("ºñ¹Ð¹øÈ£ Ã£±â");

	}
	void initDesign() {
		
		//design
		background=new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(icon.getImage(), -50, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		background.setBackground(Color.WHITE);
		setContentPane(background);
		background.setLayout(null);
		setTitle("No24 ·Î±×ÀÎ ÆäÀÌÁöÀÔ´Ï´Ù.");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);
		setLocationRelativeTo(null);
		setVisible(true);
	
		loginPanel.setBackground(new Color(255,255,255,200));
		loginPanel.setBounds(76, 146, 300, 276);
		loginPanel.setLayout(null);
		
		loginLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		loginLabel.setBounds(23, 21, 78, 30);
		
		IDLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		IDLabel.setBounds(33, 68, 20, 15);
		
		IDField.setBounds(65, 61, 215, 30);
		IDField.setColumns(10);
		
		pwdLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		pwdLabel.setBounds(28, 107, 25, 15);
		
		pwdField.setBounds(65, 100, 215, 30);
		loginPanel.add(pwdField);
		pwdField.setColumns(10);
		
		loginButton.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 12));
		loginButton.setBackground(new Color(51, 153, 153));
		loginButton.setForeground(Color.WHITE);
		loginButton.setBounds(28, 140, 252, 23);
		
		joinLabel.setForeground(Color.GRAY);
		joinLabel.setFont(new Font("±¼¸²", Font.PLAIN, 11));
		joinLabel.setBounds(28, 182, 151, 15);
		
		joinButton.setBackground(Color.WHITE);
		joinButton.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 11));
		joinButton.setBounds(191, 177, 89, 23);
	
		separator.setBackground(Color.GRAY);
		separator.setForeground(Color.GRAY);
		separator.setBounds(0, 224, 300, 1);
		
		findIDButton.setBackground(Color.WHITE);
		findIDButton.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 11));
		findIDButton.setBounds(10, 236, 105, 23);
		
		findpwdButton.setBackground(Color.WHITE);
		findpwdButton.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 11));
		findpwdButton.setBounds(123, 236, 105, 23);
		
		//add
		background.add(loginPanel);
		loginPanel.add(loginLabel);
		loginPanel.add(IDLabel);
		loginPanel.add(IDField);
		loginPanel.add(pwdLabel);
		loginPanel.add(loginButton);
		loginPanel.add(joinLabel);
		loginPanel.add(joinButton);
		loginPanel.add(separator);
		loginPanel.add(findIDButton);
		loginPanel.add(findpwdButton);

	}
	
	void initListener() {
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginConnection logConnection=new LoginConnection();
				logConnection.Loginconnect(IDField.getText(),pwdField.getText());
				int frame=logConnection.getFr();
				if(frame==1) {
					dispose();
				}

			}
		});
		
		joinButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new SignupMain();
			}
		});
		
		findIDButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new FindID();
			}
		});
		
		findpwdButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new FindPW();
			}
		});
	}
	
}
