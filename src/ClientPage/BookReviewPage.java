package ClientPage;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingConstants;

import utils.BookReviewDao;
import datamodel.Member;
import datamodel.UserModel;
import javafx.scene.control.RadioButton;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import java.awt.SystemColor;

public class BookReviewPage extends JFrame {
	String bookname,author;
	
	public BookReviewPage(String bookname,String author) {
		this.bookname = bookname;
		this.author = author;
		init();
		
	}
	
	void init() {
		Container c=getContentPane();
		c.setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		
		JButton homeButton = new JButton("HOME");
		homeButton.setBounds(12, 10, 71, 23);
		homeButton.setHorizontalAlignment(SwingConstants.LEFT);
		homeButton.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 10));
		homeButton.setBackground(Color.WHITE);
		homeButton.setBorderPainted(false);
		homeButton.setFocusPainted(false);
		homeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new ClientHome();
			}
		});

		getContentPane().add(homeButton);
		
		JButton myPageButton = new JButton("MYPAGE");
		myPageButton.setBounds(83, 10, 82, 23);
		myPageButton.setHorizontalAlignment(SwingConstants.LEFT);
		myPageButton.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 10));
		myPageButton.setBackground(Color.WHITE);
		myPageButton.setBorderPainted(false);
		myPageButton.setFocusPainted(false);
		myPageButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new ClientHome();
			}
		});
		getContentPane().add(myPageButton);
	
		JButton orderPageButton = new JButton("ÁÖ¹®ÆäÀÌÁö");
		orderPageButton.setBounds(165, 10, 92, 23);
		orderPageButton.setHorizontalAlignment(SwingConstants.LEFT);
		orderPageButton.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 10));
		orderPageButton.setBackground(Color.WHITE);
		orderPageButton.setBorderPainted(false);
		orderPageButton.setFocusPainted(false);
		orderPageButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new ClientHome();
			}
		});
		getContentPane().add(orderPageButton);
		
		JButton logoutButton = new JButton("LOGOUT");
		logoutButton.setBounds(257, 10, 82, 23);
		logoutButton.setHorizontalAlignment(SwingConstants.LEFT);
		logoutButton.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 10));
		logoutButton.setBackground(Color.WHITE);
		logoutButton.setBorderPainted(false);
		logoutButton.setFocusPainted(false);
		logoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new ClientHome();
			}
		});
		getContentPane().add(logoutButton);
		
		
		JButton mapButton = new JButton("ÁÖº¯ ¼­Á¡ Ã£±â");
		mapButton.setBounds(330, 10, 110, 23);
		mapButton.setHorizontalAlignment(SwingConstants.LEFT);
		mapButton.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 10));
		mapButton.setBackground(Color.WHITE);
		mapButton.setBorderPainted(false);
		mapButton.setFocusPainted(false);
		
		mapButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				new Map();
			}
		});
		getContentPane().add(mapButton);
		
		

		
		JLabel laBookname = new JLabel("Ã¥ ÀÌ¸§ : " );
		laBookname.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		laBookname.setBounds(12, 50, 57, 15);
		getContentPane().add(laBookname);
		
		JLabel laAuthor = new JLabel("ÀúÀÚ : " );
		laAuthor.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		laAuthor.setBounds(12, 70, 57, 15);
		getContentPane().add(laAuthor);
			
		
		
		JLabel titleLb = new JLabel(bookname);
		titleLb.setBounds(70, 51, 221, 15);
		getContentPane().add(titleLb);
		
		JLabel authorLb = new JLabel(author);
		authorLb.setBounds(70, 71, 187, 15);
		getContentPane().add(authorLb);
		
		JLabel lblNewLabel_4 = new JLabel("ÆòÁ¡ :");
		lblNewLabel_4.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(12, 118, 57, 15);
		getContentPane().add(lblNewLabel_4);
		
		ButtonGroup g= new ButtonGroup();
		
		JRadioButton star1 = new JRadioButton("¡Ú¡Ù¡Ù¡Ù¡Ù");
		star1.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		star1.setBackground(new Color(255,255,255));
		star1.setBounds(70, 113, 90, 23);
		JRadioButton star2 = new JRadioButton("¡Ú¡Ú¡Ù¡Ù¡Ù");
		star2.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		star2.setBackground(new Color(255,255,255));
		star2.setBounds(165, 113, 90, 23);
		JRadioButton star3 = new JRadioButton("¡Ú¡Ú¡Ú¡Ù¡Ù");
		star3.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		star3.setBackground(new Color(255,255,255));
		star3.setBounds(257, 113, 90, 23);
		JRadioButton star4 = new JRadioButton("¡Ú¡Ú¡Ú¡Ú¡Ù");
		star4.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		star4.setBackground(new Color(255,255,255));
		star4.setBounds(349, 113, 90, 23);
		JRadioButton star5 = new JRadioButton("¡Ú¡Ú¡Ú¡Ú¡Ú");
		star5.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		star5.setBackground(new Color(255,255,255));
		star5.setBounds(443, 113, 90, 23);
		
		
		
		g.add(star1);
		g.add(star2);
		g.add(star3);
		g.add(star4);
		g.add(star5);

		c.add(star1);
		c.add(star2);
		c.add(star3);
		c.add(star4);
		c.add(star5);
		
		
		
		JLabel lblNewLabel_5 = new JLabel("¼­Æò :");
		lblNewLabel_5.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		lblNewLabel_5.setBounds(12, 168, 57, 15);
		getContentPane().add(lblNewLabel_5);
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(new Color(250,250,250));
		textArea.setBounds(70, 168, 679, 356);
		getContentPane().add(textArea);
		
		JButton btnregister = new JButton("µî·Ï");
		btnregister.setBackground(new Color(25, 106, 179));
		btnregister.setForeground(Color.WHITE);
		btnregister.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 12));
		

		btnregister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int tempInt = 0;
				if(star1.isSelected()) {
					tempInt = 1;
				}
				else if(star2.isSelected()) {
					tempInt = 2;
					}
				else if(star3.isSelected()) {
					tempInt = 3;
					}
				else if(star4.isSelected()) {
					tempInt = 4;
					}
				else if(star5.isSelected()) {
					tempInt = 5;
					}
				BookReviewDao bookReviewDao = BookReviewDao.getInstance();
				int result = bookReviewDao.BookReviewWrite(bookname, UserModel.ID, tempInt, textArea.getText());
				if(result == 1) {
					JOptionPane.showMessageDialog(null, "µî·ÏÀÌ ¿Ï·áµÇ¾ú½À´Ï´Ù.");
					dispose();
					new BookParsingApp(bookname);
				} else {
					JOptionPane.showMessageDialog(null, "µî·ÏÇÏ´Â µµÁß ¿À·ù°¡ ¹ß»ýÇß½À´Ï´Ù.");
				}
			}
		});
		btnregister.setBounds(652, 135, 97, 23);
		getContentPane().add(btnregister);
		
		JButton backButton = new JButton("µÚ·Î °¡±â");
		backButton.setBounds(652, 20, 97, 23);
		backButton.setBackground(new Color(25, 106, 179));
		backButton.setForeground(Color.WHITE);
		getContentPane().add(backButton);
		backButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new BookParsingApp(bookname);
				
			}
		});
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800,600);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}

