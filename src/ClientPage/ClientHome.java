package ClientPage;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import datamodel.ClientPageBook;
import datamodel.UserModel;
import loginpage.Login;
import utils.ClientPageBookSource;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class ClientHome extends JFrame {

	private String[] searchbook = { "¿Ã∏ß", "¿˙¿⁄", "√‚∆«ªÁ", "ISBN" };
	private String[] category = { "º“º≥/Ω√", "ø°ºº¿Ã", "¿ŒπÆ", "ø™ªÁ", "øπº˙", "¡æ±≥", "ªÁ»∏", "∞˙«–", "∞Ê¡¶ ∞Êøµ", "¿⁄±‚∞Ëπﬂ", "∏∏»≠", "∂Û¿Ã∆Æ≥Î∫ß",
			"ø©«‡", "¿‚¡ˆ", "æÓ∏∞¿Ã", "¿¸¡˝", "√ªº“≥‚", "ø‰∏Æ", "¿∞æ∆", "∞°¡§ªÏ∏≤", "∞«∞≠√ÎπÃ", "¥Î«–±≥¿Á", "IT∏πŸ¿œ", "ºˆ«Ëº≠ ¿⁄∞›¡ı", "¬¸∞Ìº≠" };
	private JTextField tfSearch;
	private JButton homeButton, myPageButton, orderPageButton, logoutButton, btnSearch, recombook1, recombook2,
			recombook3,mapButton;
	private JScrollPane scrollPane, summaryscroll1, summaryscroll2, summaryscroll3;
	private JList list;
	public String dbname;
	public String dbsummary;
	public String str = "∏ﬁ¿Œ∆‰¿Ã¡ˆ";
	JLabel recomtitle1_main, recomtitle1, recomsummary1, recomsummary1_main, recomtitle2_main, recomtitle2,
			recomsummary2, recomsummary2_main, recomtitle3_main, recomtitle3, recomsummary3, recomsummary3_main;
	JPanel mainPanel, bookPanel1, bookPanel2, bookPanel3;

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	ArrayList<ClientPageBook> cb_arrayBooks = new ArrayList<>();

	JComboBox comboBox;
	ClientPageBookSource spbc = new ClientPageBookSource();

	public ClientHome() {
		spbc.RecommendBookList();

		initObject();
		initDesign();
		initListener();
	}

	void initObject() {
		homeButton = new JButton("HOME");
		myPageButton = new JButton("MYPAGE");
		orderPageButton = new JButton("¡÷πÆ∆‰¿Ã¡ˆ");
		logoutButton = new JButton("LOGOUT");
		mapButton = new JButton("¡÷∫Ø º≠¡° √£±‚");
		comboBox = new JComboBox(searchbook);
		tfSearch = new JTextField();
		btnSearch = new JButton("∞Àªˆ");
		recombook1 = new JButton(spbc.getdbname(0));
		recombook2 = new JButton(spbc.getdbname(1));
		recombook3 = new JButton(spbc.getdbname(2));
		scrollPane = new JScrollPane();
		list = new JList(category);
		mainPanel = new JPanel();
		bookPanel1 = new JPanel();
		recomtitle1 = new JLabel("√• ¡¶∏Ò : ");
		recomtitle1_main = new JLabel(spbc.getdbname(0));
		recomsummary1 = new JLabel("¡Ÿ∞≈∏Æ : ");
		recomsummary1_main = new JLabel(spbc.getdbsummary(0));
		bookPanel2 = new JPanel();
		recomtitle2 = new JLabel("√• ¡¶∏Ò : ");
		recomtitle2_main = new JLabel(spbc.getdbname(1));
		recomsummary2 = new JLabel("¡Ÿ∞≈∏Æ : ");
		recomsummary2_main = new JLabel(spbc.getdbsummary(1));
		bookPanel3 = new JPanel();
		recomtitle3 = new JLabel("√• ¡¶∏Ò : ");
		recomtitle3_main = new JLabel(spbc.getdbname(2));
		recomsummary3 = new JLabel("¡Ÿ∞≈∏Æ : ");
		recomsummary3_main = new JLabel(spbc.getdbsummary(2));
		summaryscroll1 = new JScrollPane();
		summaryscroll2 = new JScrollPane();
		summaryscroll3 = new JScrollPane();

	}

	void initDesign() {

		// design
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);
		setVisible(true);
		setLocationRelativeTo(null);
		
		Container c = getContentPane();
		c.setBackground(Color.WHITE);
		c.setLayout(null);

		homeButton.setBounds(12, 10, 71, 23);
		homeButton.setHorizontalAlignment(SwingConstants.LEFT);
		homeButton.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 10));
		homeButton.setBackground(Color.WHITE);
		homeButton.setBorderPainted(false);
		homeButton.setFocusPainted(false);

		myPageButton.setBounds(83, 10, 82, 23);
		myPageButton.setHorizontalAlignment(SwingConstants.LEFT);
		myPageButton.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 10));
		myPageButton.setBackground(Color.WHITE);
		myPageButton.setBorderPainted(false);
		myPageButton.setFocusPainted(false);

		orderPageButton.setBounds(165, 10, 90, 23);
		orderPageButton.setHorizontalAlignment(SwingConstants.LEFT);
		orderPageButton.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 10));
		orderPageButton.setBackground(Color.WHITE);
		orderPageButton.setBorderPainted(false);
		orderPageButton.setFocusPainted(false);

		logoutButton.setBounds(257, 10, 82, 23);
		logoutButton.setHorizontalAlignment(SwingConstants.LEFT);
		logoutButton.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 10));
		logoutButton.setBackground(Color.WHITE);
		logoutButton.setBorderPainted(false);
		logoutButton.setFocusPainted(false);
		
		mapButton.setBounds(330, 10, 110, 23);
		mapButton.setHorizontalAlignment(SwingConstants.LEFT);
		mapButton.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 10));
		mapButton.setBackground(Color.WHITE);
		mapButton.setBorderPainted(false);
		mapButton.setFocusPainted(false);

		comboBox.setBounds(12, 43, 98, 23);
		comboBox.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 12));
		comboBox.setBackground(Color.WHITE);

		tfSearch.setBounds(110, 43, 557, 24);
		tfSearch.setColumns(10);

		btnSearch.setBounds(660, 43, 97, 23);
		btnSearch.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 12));
		btnSearch.setBackground(new Color(25, 106, 179));
		btnSearch.setForeground(Color.WHITE);

		recombook1.setBounds(12, 76, 217, 23);
		recombook1.setForeground(Color.WHITE);
		recombook1.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 12));
		recombook1.setBackground(new Color(25, 106, 179));

		recombook2.setBounds(278, 76, 217, 23);
		recombook2.setBackground(new Color(25, 106, 179));
		recombook2.setForeground(Color.WHITE);
		recombook2.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 12));

		recombook3.setBounds(540, 76, 217, 23);
		recombook3.setBackground(new Color(25, 106, 179));
		recombook3.setForeground(Color.WHITE);
		recombook3.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 12));

		scrollPane.setBounds(12, 109, 217, 442);

		list.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 14));
		list.setForeground(Color.WHITE);
		list.setBackground(new Color(102, 153, 204));
		scrollPane.setViewportView(list);

		mainPanel.setBounds(241, 109, 514, 442);
		mainPanel.setBorder(new LineBorder(new Color(216, 216, 216)));
		mainPanel.setBackground(new Color(248, 248, 248));
		mainPanel.setLayout(null);

		bookPanel1.setBackground(Color.WHITE);
		bookPanel1.setBounds(12, 10, 490, 120);
		bookPanel1.setBorder(new LineBorder(new Color(216, 216, 216)));
		bookPanel1.setLayout(null);

		summaryscroll1.setBounds(80, 49, 398, 61);
		summaryscroll1.getViewport().setBackground(Color.WHITE);
		summaryscroll1.getVerticalScrollBar().setUnitIncrement(30);

		summaryscroll2.setBounds(80, 49, 398, 61);
		summaryscroll2.getViewport().setBackground(Color.WHITE);
		summaryscroll2.getVerticalScrollBar().setUnitIncrement(30);

		summaryscroll3.setBounds(80, 49, 398, 61);
		summaryscroll3.getViewport().setBackground(Color.WHITE);
		summaryscroll3.getVerticalScrollBar().setUnitIncrement(30);

		recomtitle1.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 14));
		recomtitle1.setBounds(11, 20, 75, 15);

		recomtitle1_main.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 14));
		recomtitle1_main.setBounds(80, 20, 200, 15);

		recomsummary1.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 14));
		recomsummary1.setBounds(11, 71, 57, 15);

		recomsummary1_main.setText("<html><p style=\"width:280px\">" + spbc.getdbsummary(0) + "</p></html>");
		recomsummary1_main.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 14));
		recomsummary1_main.setBounds(80, 49, 398, 61);
		summaryscroll1.setViewportView(recomsummary1_main);

		bookPanel2.setBackground(Color.WHITE);
		bookPanel2.setBounds(12, 153, 490, 120);
		bookPanel2.setBorder(new LineBorder(new Color(216, 216, 216)));
		bookPanel2.setLayout(null);

		recomtitle2.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 14));
		recomtitle2.setBounds(11, 20, 75, 15);

		recomtitle2_main.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 14));
		recomtitle2_main.setBounds(80, 20, 200, 15);

		recomsummary2.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 14));
		recomsummary2.setBounds(12, 74, 57, 15);

		recomsummary2_main.setText("<html><p style=\"width:280px\">" + spbc.getdbsummary(1) + "</p></html>");
		recomsummary2_main.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 14));
		recomsummary2_main.setBounds(80, 49, 398, 61);
		summaryscroll2.setViewportView(recomsummary2_main);

		bookPanel3.setBackground(Color.WHITE);
		bookPanel3.setBounds(12, 297, 490, 120);
		bookPanel3.setBorder(new LineBorder(new Color(216, 216, 216)));
		bookPanel3.setLayout(null);

		recomtitle3.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 14));
		recomtitle3.setBounds(11, 20, 75, 15);

		recomtitle3_main.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 14));
		recomtitle3_main.setBounds(80, 20, 200, 15);

		recomsummary3.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 14));
		recomsummary3.setBounds(12, 74, 57, 15);

		recomsummary3_main.setText("<html><p style=\"width:280px\">" + spbc.getdbsummary(2) + "</p></html>");
		recomsummary3_main.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 14));
		recomsummary3_main.setBounds(80, 49, 398, 61);
		summaryscroll3.setViewportView(recomsummary3_main);

		// add
		c.add(homeButton);
		c.add(myPageButton);
		c.add(orderPageButton);
		c.add(logoutButton);
		c.add(comboBox);
		c.add(tfSearch);
		c.add(btnSearch);
		c.add(recombook1);
		c.add(recombook2);
		c.add(recombook3);
		c.add(scrollPane);
		c.add(mainPanel);
		c.add(mapButton);
		mainPanel.add(bookPanel1);
		bookPanel1.add(recomtitle1);
		bookPanel1.add(recomtitle1_main);
		bookPanel1.add(recomsummary1);
		// bookPanel1.add(recomsummary1_main);
		mainPanel.add(bookPanel2);
		bookPanel2.add(recomtitle2);
		bookPanel2.add(recomtitle2_main);
		bookPanel2.add(recomsummary2);
		// bookPanel2.add(recomsummary2_main);
		mainPanel.add(bookPanel3);
		bookPanel1.add(summaryscroll1);
		bookPanel2.add(summaryscroll2);
		bookPanel3.add(summaryscroll3);
		bookPanel3.add(recomtitle3);
		bookPanel3.add(recomtitle3_main);
		bookPanel3.add(recomsummary3);
		// bookPanel3.add(recomsummary3_main);

	}

	void initListener() {
		homeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new ClientHome();
			}
		});

		myPageButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new UserInfoUpdate();
			}
		});

		orderPageButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new OrderPage();

			}
		});
		logoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserModel.setID(null);
				UserModel.setPwd(null);
				UserModel.setName(null);
				UserModel.setAge(null);
				UserModel.setEmail(null);
				UserModel.setTel(null);
				dispose();
				new Login();
			}
		});
		mapButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Map();
			}
		});
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String getHomeComboBox;
				getHomeComboBox = comboBox.getSelectedItem().toString();
				if (tfSearch.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "∞ÀªˆæÓ∏¶ ¿‘∑¬«œººø‰.");
				} else {

					if (getHomeComboBox.equals("¿Ã∏ß")) {
						String getHomeSearch = tfSearch.getText().trim();
						dispose();
						new UserSearchBook(getHomeComboBox, getHomeSearch);

					} else if (getHomeComboBox.equals("¿˙¿⁄")) {
						String getHomeSearch = tfSearch.getText().trim();
						dispose();
						new UserSearchBook(getHomeComboBox, getHomeSearch);

					} else if (getHomeComboBox.equals("√‚∆«ªÁ")) {
						String getHomeSearch = tfSearch.getText().trim();
						dispose();
						new UserSearchBook(getHomeComboBox, getHomeSearch);

					} else if (getHomeComboBox.equals("ISBN")) {
						String getHomeSearch = tfSearch.getText().trim();
						dispose();
						new UserSearchBook(getHomeComboBox, getHomeSearch);
					}
				}

			}

		});
		recombook1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				new BookParsingApp(spbc.getdbname(0));

			}
		});
		recombook2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				new BookParsingApp(spbc.getdbname(1));

			}
		});
		recombook3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				new BookParsingApp(spbc.getdbname(2));

			}
		});

		list.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				str = (String) list.getSelectedValue();

				System.out.println("str :" + str);
				recomtitle1_main.setText(spbc.getdbname(0));
				recomsummary1_main.setText("<html><p style=\"width:280px\">" + spbc.getdbsummary(0) + "</p></html>");
				recomtitle2_main.setText(spbc.getdbname(1));
				recomsummary2_main.setText("<html><p style=\"width:280px\">" + spbc.getdbsummary(1) + "</p></html>");
				recomtitle3_main.setText(spbc.getdbname(2));
				recomsummary3_main.setText("<html><p style=\"width:280px\">" + spbc.getdbsummary(2) + "</p></html>");
				spbc.RecommendBookList(str);
				spbc.printBook_obj_array();

			}
		});

	}

}
