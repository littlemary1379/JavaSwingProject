package ClientPage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

import com.google.gson.Gson;

import datamodel.BookParsing;
import datamodel.Item;
import datamodel.Mypage;
import datamodel.UserModel;
import loginpage.Login;
import utils.BookReviewDao;
import utils.MemberDao;
import utils.Naver;
import utils.OrderBookDao;

public class BookParsingApp extends JFrame {

	private JLabel txtSummary, txtBookname, txtAuthor, txtPrice, booknameValue, authorValue, priceValue, txtReview,
			lblNewLabel_1, laReviewName, laGrade, lareview;
	private ImageIcon imageIcon;
	private ImagePanel imagePanel;
	private JButton btnreview, myPageButton;
	private String bookname, author;
	public int x;
	private URL url1;
	private JButton homeButton, orderButton, orderPageButton, logoutButton, mapButton;
	private Image image;
	private JTextArea textAreaSummary, textAreaReview;

	JScrollPane scrollPaneMain, scrollPane_1;
	JPanel panel_2, panel, panel_1;

	public BookParsingApp(String bookname) {
		this.bookname = bookname;
		initObject();
		initListener();
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);

	}

	void initObject() {
		setSize(800, 600);
		getContentPane().setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		txtBookname = new JLabel("¡¶∏Ò");
		txtBookname.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 12));
		txtBookname.setBounds(342, 70, 57, 15);
		getContentPane().add(txtBookname);

		txtAuthor = new JLabel("¿˙¿⁄");
		txtAuthor.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 12));
		txtAuthor.setBounds(342, 110, 57, 15);
		getContentPane().add(txtAuthor);

		txtPrice = new JLabel("∞°∞›");
		txtPrice.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 12));
		txtPrice.setBounds(342, 148, 57, 15);
		getContentPane().add(txtPrice);

		txtSummary = new JLabel("¡Ÿ∞≈∏Æ");
		txtSummary.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 12));
		txtSummary.setBounds(342, 183, 57, 15);
		getContentPane().add(txtSummary);

		booknameValue = new JLabel("");
		booknameValue.setBounds(392, 70, 380, 15);
		booknameValue.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 12));
		getContentPane().add(booknameValue);

		authorValue = new JLabel("");
		authorValue.setBounds(392, 110, 380, 15);
		authorValue.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 12));
		getContentPane().add(authorValue);

		priceValue = new JLabel("");
		priceValue.setBounds(392, 148, 380, 15);
		priceValue.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 12));
		getContentPane().add(priceValue);

		txtReview = new JLabel("º≠∆Ú");
		txtReview.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 14));
		txtReview.setForeground(new Color(25, 106, 179));
		txtReview.setBounds(24, 301, 57, 15);
		getContentPane().add(txtReview);

		panel = new JPanel();
		panel.setLayout(null);

		panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 724, 82);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel laname = new JLabel("æ∆¿Ãµ : ");
		laname.setBounds(0, 10, 36, 62);
		panel_1.add(laname);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(197, 0, 504, 82);
		panel_1.add(scrollPane_2);

		JTextArea textAreaReveiw = new JTextArea();
		scrollPane_2.setViewportView(textAreaReveiw);
		textAreaReveiw.setLineWrap(true);
		textAreaReveiw.setEditable(false);

		lblNewLabel_1 = new JLabel("∆Ú¡°");
		lblNewLabel_1.setBounds(111, 34, 57, 15);
		panel_1.add(lblNewLabel_1);

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(392, 183, 350, 104);
		getContentPane().add(scrollPane_1);

		textAreaSummary = new JTextArea();
		scrollPane_1.setViewportView(textAreaSummary);
		textAreaSummary.setLineWrap(true);
		textAreaSummary.setEditable(false);

		scrollPaneMain = new JScrollPane();
		scrollPaneMain.setBounds(24, 322, 718, 222);
		scrollPaneMain.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPaneMain.getVerticalScrollBar().setUnitIncrement(30);
		getContentPane().add(scrollPaneMain);

		panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setLayout(null);
		scrollPaneMain.setViewportView(panel_2);

		//

		Dimension size = new Dimension();// ªÁ¿Ã¡Ó∏¶ ¡ˆ¡§«œ±‚ ¿ß«— ∞¥√º ª˝º∫

		// ∞¥√º¿« ªÁ¿Ã¡Ó∏¶ ¡ˆ¡§

		panel_2.setPreferredSize(size);// ªÁ¿Ã¡Ó ¡§∫∏∏¶ ∞°¡ˆ∞Ì ¿÷¥¬ ∞¥√º∏¶ ¿ÃøÎ«ÿ ∆–≥Œ¿« ªÁ¿Ã¡Ó ¡ˆ¡§

		// jScrollPane.setViewportView(panel_ex);

		List<Mypage> result;
		MemberDao memberdao = MemberDao.getInstance();
		result = memberdao.select1(bookname);
		int k = result.size();
		for (int i = 0; i < k; i++) {
			int d = (77 * i);
			JPanel panel_3 = new JPanel();
			panel_3.setBorder(new MatteBorder(0, 0, 1, 1, (Color) new Color(216, 216, 216)));
			panel_3.setBackground(Color.WHITE);
			panel_3.setBounds(10, d, 724, 77);
			panel_2.add(panel_3);
			panel_3.setLayout(null);

			JScrollPane scrollPane = new JScrollPane();
			scrollPane.getVerticalScrollBar().setUnitIncrement(30);
			scrollPane.setBounds(160, 0, 539, (int) 76.5);
			panel_3.add(scrollPane);

			textAreaReview = new JTextArea();
			textAreaReview.setLineWrap(true);
			textAreaReview.setEditable(false);
			scrollPane.setViewportView(textAreaReview);
			textAreaReview.setText(result.get(i).getComments());

			laReviewName = new JLabel("");
			laReviewName.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 12));
			laReviewName.setBounds(0, 28, 57, 15);
			laReviewName.setText(result.get(i).getUserid());
			panel_3.add(laReviewName);

			laGrade = new JLabel("");
			laGrade.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 12));
			laGrade.setBounds(70, 28, 80, 15);
//		lblGrade.setBounds(91, 28, 57, 15);
			if (result.get(i).getStar() == 1) {
				laGrade.setText("°⁄°Ÿ°Ÿ°Ÿ°Ÿ");
			} else if (result.get(i).getStar() == 2) {
				laGrade.setText("°⁄°⁄°Ÿ°Ÿ°Ÿ");
			} else if (result.get(i).getStar() == 3) {
				laGrade.setText("°⁄°⁄°⁄°Ÿ°Ÿ");
			} else if (result.get(i).getStar() == 4) {
				laGrade.setText("°⁄°⁄°⁄°⁄°Ÿ");
			} else if (result.get(i).getStar() == 5) {
				laGrade.setText("°⁄°⁄°⁄°⁄°⁄");
			}
//		lblGrade.setText(Integer.toString(result.get(i).getStar()));
			panel_3.add(laGrade);

			size.setSize(1000, d + 80);

		}

		btnreview = new JButton("º≠∆Ú≥≤±‚±‚");

		btnreview.setBounds(613, 297, 129, 23);
		getContentPane().add(btnreview);
		btnreview.setBackground(new Color(25, 106, 179));
		btnreview.setForeground(Color.WHITE);
		btnreview.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 12));

		lareview = new JLabel();
		lareview.setBounds(111, 400, 661, 23);

		homeButton = new JButton("HOME");
		homeButton.setHorizontalAlignment(SwingConstants.LEFT);
		homeButton.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 10));
		homeButton.setFocusPainted(false);
		homeButton.setBorderPainted(false);
		homeButton.setBackground(Color.WHITE);
		homeButton.setBounds(12, 10, 71, 23);
		getContentPane().add(homeButton);

		myPageButton = new JButton("MYPAGE");
		myPageButton.setHorizontalAlignment(SwingConstants.LEFT);
		myPageButton.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 10));
		myPageButton.setFocusPainted(false);
		myPageButton.setBorderPainted(false);
		myPageButton.setBackground(Color.WHITE);
		myPageButton.setBounds(95, 10, 82, 23);
		getContentPane().add(myPageButton);

		orderPageButton = new JButton("¡÷πÆ∆‰¿Ã¡ˆ");
		orderPageButton.setHorizontalAlignment(SwingConstants.LEFT);
		orderPageButton.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 10));
		orderPageButton.setFocusPainted(false);
		orderPageButton.setBorderPainted(false);
		orderPageButton.setBackground(Color.WHITE);
		orderPageButton.setBounds(184, 10, 92, 23);
		getContentPane().add(orderPageButton);

		logoutButton = new JButton("LOGOUT");
		logoutButton.setHorizontalAlignment(SwingConstants.LEFT);
		logoutButton.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 10));
		logoutButton.setFocusPainted(false);
		logoutButton.setBorderPainted(false);
		logoutButton.setBackground(Color.WHITE);
		logoutButton.setBounds(286, 10, 82, 23);
		getContentPane().add(logoutButton);
		
		mapButton = new JButton("¡÷∫Ø º≠¡° √£±‚");
		mapButton.setBounds(370, 10, 110, 23);
		mapButton.setHorizontalAlignment(SwingConstants.LEFT);
		mapButton.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 10));
		mapButton.setBackground(Color.WHITE);
		mapButton.setBorderPainted(false);
		mapButton.setFocusPainted(false);
		getContentPane().add(mapButton);


		orderButton = new JButton("¿ÂπŸ±∏¥œ");
		orderButton.setBounds(633, 9, 129, 23);
		orderButton.setBackground(new Color(25, 106, 179));
		orderButton.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 12));
		orderButton.setForeground(Color.WHITE);
		orderButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("µÈæÓ∞´≥™ø‰1?");
				String x = JOptionPane.showInputDialog(null, "∏Ó ±« ¡÷πÆ«œΩ√∞⁄Ω¿¥œ±Ó?");					
				System.out.println(x);
				if(x != null) {
					new OrderBookDao(bookname, Integer.parseInt(x));
					System.out.println("µÈæÓ∞´≥™ø‰2?");
					JOptionPane.showMessageDialog(null, "¿ÂπŸ±∏¥œø° √ﬂ∞°µ«æ˙Ω¿¥œ¥Ÿ. ¡÷πÆ∆‰¿Ã¡ˆø°º≠ »Æ¿Œ«ÿ¡÷ººø‰");
					System.out.println("¿Œ≈Õ∞…"+Integer.parseInt(x));					
				}
				
			}
		});
		getContentPane().add(orderButton);

		BookParsing bookParsing = Naver.naverkey(bookname);
		List<Item> list = bookParsing.getItems();

		for (Item item : list) {

			String imageUrl = item.getImage();
			String url = imageUrl.split("\\?")[0];
			try {
				url1 = new URL(url);
				image = ImageIO.read(url1);
				image = image.getScaledInstance(160, 220, Image.SCALE_SMOOTH);

			} catch (Exception e1) {
				e1.printStackTrace();
			}
			imageIcon = new ImageIcon(image);

			bookname = item.getTitle();
			bookname = bookname.replaceAll("<b>", "");
			bookname = bookname.replaceAll("</b>", "");
			booknameValue.setText(bookname);
			author = item.getPublisher();
			authorValue.setText(author);
			String price = item.getPrice();
			priceValue.setText(price);
			String summary = item.getDescription();
			summary = summary.replaceAll("<b>", "");
			summary = summary.replaceAll("</b>", "");
			summary = summary.replaceAll("&lt;", "");
			summary = summary.replaceAll("&gt;", "");
			textAreaSummary.setText(summary);
			// lblNewLabel.setIcon(image);
		}

		int BookReviewResult;
		BookReviewDao bookReviewDao = BookReviewDao.getInstance();
		BookReviewResult = bookReviewDao.bookReview(bookname);

		imagePanel = new ImagePanel();
		imagePanel.setBackground(Color.WHITE);
		imagePanel.setBounds(50, 40, 300, 300);
		getContentPane().add(imagePanel);

		repaint();

	}

	void initListener() {
		btnreview.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				new BookReviewPage(bookname, author);
				dispose();
			}
		});
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
				new ClientPage.Map();
			}
		});
	}
	

	class ImagePanel extends JPanel {

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(imageIcon.getImage(), 30, 30, null);
//			setOpaque(false);

		}
	}

}
