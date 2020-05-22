package adminpage;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.google.gson.Gson;

import datamodel.*;
import loginpage.Login;

import javax.swing.JTextArea;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class AdminUpdate extends JFrame {
	private JTextField textField;
	private JTextField tfReBookid;
	private JTextField tfName;
	private JTextField tfAuthor;
	private JTextField tfPrice;
	private JTextField tfPublicationDate;
	private JTextField tfISBN;
	private JTextField tfPublisher;
	private JTextField tfCategory;
	private ImageIcon imageIcon;
	private URL url1;
	private Image image;
	private ImagePanel imagePanel;

	private JLabel lblReBookIDCheck;
	private JLabel lblNameCheck;
	private JLabel lblAuthorCheck;
	private JLabel lblPriceCheck;
	private JLabel lblPublicationDateCheck;
	private JLabel lblISBNCheck;
	private JLabel lblPublisherCheck;
	private JLabel lblCategoryCheck;

	private String bookidExp = "^[0-9]+$";
	private String priceExp = "^[0-9]+$";
	private String ISBNExp = "^[0-9]{13}$";
	private String tfPublicationDateExp = "^[0-9]{4}[-]{1}[0-9]{2}[-]{1}[0-9]{2}$";
	private String BlankExp = "^[A-Za-z.\\\\s\\\\-\\\\.\\\\D[^!\\\"$%\\\\^&*:;@#~,/?]]+$";

	public AdminUpdate(int oriBookId, int bookId, String name, String author, long price, String publicationDate,
			long iSBN, String publisher, String category, String summary) {
		setTitle("관리자 수정 페이지");
		setSize(800, 600);
		getContentPane().setLayout(null);

		System.out.println(bookId);

		JPanel panelMain = new JPanel();
		panelMain.setBounds(363, 10, 431, 571);
		getContentPane().add(panelMain);
		panelMain.setLayout(null);

		JPanel panelSub = new JPanel();
		panelSub.setBackground(new Color(255, 255, 255));
		panelSub.setBounds(0, 30, 420, 491);
		panelMain.add(panelSub);
		panelSub.setLayout(null);

		JLabel lblReBookID = new JLabel("ReBookID");
		lblReBookID.setBounds(28, 57, 90, 22);
		panelSub.add(lblReBookID);

		JLabel lblName = new JLabel("이름");
		lblName.setBounds(28, 89, 90, 22);
		panelSub.add(lblName);

		JLabel lblAuthor = new JLabel("저자");
		lblAuthor.setBounds(28, 121, 90, 22);
		panelSub.add(lblAuthor);

		JLabel lblPrice = new JLabel("가격");
		lblPrice.setBounds(28, 153, 90, 22);
		panelSub.add(lblPrice);

		JLabel lblPublicationDate = new JLabel("출판일");
		lblPublicationDate.setBounds(28, 185, 90, 22);
		panelSub.add(lblPublicationDate);

		JLabel lblISBN = new JLabel("ISBN");
		lblISBN.setBounds(28, 217, 90, 22);
		panelSub.add(lblISBN);

		JLabel lblPublisher = new JLabel("출판사");
		lblPublisher.setBounds(28, 249, 90, 22);
		panelSub.add(lblPublisher);

		JLabel lblSummary = new JLabel("줄거리");
		lblSummary.setBounds(28, 323, 90, 22);
		panelSub.add(lblSummary);

		JLabel lblCategory = new JLabel("카테고리");
		lblCategory.setBounds(28, 284, 57, 15);
		panelSub.add(lblCategory);
		

		tfReBookid = new JTextField();
		tfReBookid.setOpaque(false);
		tfReBookid.setBounds(93, 58, 279, 21);
		tfReBookid.setColumns(10);
		panelSub.add(tfReBookid);

		tfName = new JTextField();
		tfName.setOpaque(false);
		tfName.setColumns(10);
		tfName.setBounds(93, 90, 279, 21);
		panelSub.add(tfName);

		tfAuthor = new JTextField();
		tfAuthor.setOpaque(false);
		tfAuthor.setColumns(10);
		tfAuthor.setBounds(93, 121, 279, 21);
		panelSub.add(tfAuthor);

		tfPrice = new JTextField();
		tfPrice.setOpaque(false);
		tfPrice.setColumns(10);
		tfPrice.setBounds(93, 154, 279, 21);
		panelSub.add(tfPrice);

		tfPublicationDate = new JTextField();
		tfPublicationDate.setOpaque(false);
		tfPublicationDate.setColumns(10);
		tfPublicationDate.setBounds(93, 186, 279, 21);
		panelSub.add(tfPublicationDate);

		tfISBN = new JTextField();
		tfISBN.setOpaque(false);
		tfISBN.setColumns(10);
		tfISBN.setBounds(93, 218, 279, 21);
		panelSub.add(tfISBN);

		tfPublisher = new JTextField();
		tfPublisher.setOpaque(false);
		tfPublisher.setColumns(10);
		tfPublisher.setBounds(93, 250, 279, 21);
		panelSub.add(tfPublisher);

		tfCategory = new JTextField();
		tfCategory.setOpaque(false);
		tfCategory.setColumns(10);
		tfCategory.setBounds(93, 281, 279, 21);
		panelSub.add(tfCategory);

		// 검증
		lblReBookIDCheck = new JLabel("");
		lblReBookIDCheck.setBounds(93, 61, 279, 15);
		panelSub.add(lblReBookIDCheck);

		lblNameCheck = new JLabel("");
		lblNameCheck.setBounds(93, 93, 279, 15);
		panelSub.add(lblNameCheck);

		lblAuthorCheck = new JLabel("");
		lblAuthorCheck.setBounds(93, 125, 279, 15);
		panelSub.add(lblAuthorCheck);

		lblPriceCheck = new JLabel("");
		lblPriceCheck.setBounds(93, 157, 279, 15);
		panelSub.add(lblPriceCheck);

		lblPublicationDateCheck = new JLabel("");
		lblPublicationDateCheck.setBounds(93, 189, 279, 15);
		panelSub.add(lblPublicationDateCheck);

		lblISBNCheck = new JLabel("");
		lblISBNCheck.setBounds(93, 221, 279, 15);
		panelSub.add(lblISBNCheck);

		lblPublisherCheck = new JLabel("");
		lblPublisherCheck.setBounds(93, 253, 279, 15);
		panelSub.add(lblPublisherCheck);

		lblCategoryCheck = new JLabel("");
		lblCategoryCheck.setBounds(93, 284, 279, 15);
		panelSub.add(lblCategoryCheck);
		//

		JButton btnUpdate = new JButton("수정");
		btnUpdate.setBackground(new Color(102, 153, 255));
		btnUpdate.setBounds(307, 445, 79, 23);
		panelSub.add(btnUpdate);
		tfReBookid.setText(Integer.toString(oriBookId));
		tfName.setText(name);
		tfAuthor.setText(author);
		tfPrice.setText(Long.toString(price));
		tfPublicationDate.setText(publicationDate);
		tfISBN.setText(Long.toString(iSBN));
		tfPublisher.setText(publisher);
		tfCategory.setText(category);
		
		BookParsing bookParsing = utils.Naver.naverkey(name);
		List<Item> list = bookParsing.getItems();

		for (Item item : list) {

			String imageUrl = item.getImage();
			String url = imageUrl.split("\\?")[0];
			try {
				url1 = new URL(url);
				image = ImageIO.read(url1);
				// image = image.getScaledInstance(200, 200, Image.SCALE_SMOOTH);

			} catch (Exception e1) {
				e1.printStackTrace();
			}
			imageIcon = new ImageIcon(image);
		}

		imagePanel = new ImagePanel();
		imagePanel.setBounds(40, 40, 500, 500);
		getContentPane().add(imagePanel);

		repaint();
		
	
		JButton btnDelete = new JButton("삭제");
		btnDelete.setBounds(197, 445, 79, 23);
		panelSub.add(btnDelete);

		JButton btnpicture = new JButton("사진보기");
		btnpicture.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				imagePanel.removeAll();
				
				String searchText = tfName.getText();

				BookParsing bookParsing = utils.Naver.naverkey(tfName.getText());
				List<Item> list = bookParsing.getItems();

				for (Item item : list) {
					/*
					 * System.out.println(item.getTitle()); System.out.println(item.getImage());
					 * System.out.println(item.getPrice());
					 */

					String imageUrl = item.getImage();
					String url = imageUrl.split("\\?")[0];
					try {
						url1 = new URL(url);
						image = ImageIO.read(url1);
						// image = image.getScaledInstance(300, 300, Image.SCALE_SMOOTH); //그림크기

					} catch (Exception e1) {
						e1.printStackTrace();
					}
					imageIcon = new ImageIcon(image);
				}

				imagePanel = new ImagePanel();
				imagePanel.setBounds(40, 40, 500, 500);// 그림 시작x값,시작y값
				getContentPane().add(imagePanel);

				repaint();
			}

		});
		btnpicture.setBounds(64, 445, 97, 23);
		panelSub.add(btnpicture);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(93, 323, 279, 112);
		panelSub.add(scrollPane);

		JTextArea taSummary = new JTextArea();
		scrollPane.setViewportView(taSummary);
		taSummary.setBackground(new Color(245, 255, 250));
		taSummary.setForeground(Color.BLACK);
		taSummary.setLineWrap(true);
		taSummary.setText(summary);

		JButton btnBackHome = new JButton("홈페이지 돌아가기");
		btnBackHome.setBounds(30, 10, 125, 33);
		btnBackHome.setBackground(new Color(25, 106, 179));
		btnBackHome.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		btnBackHome.setForeground(Color.WHITE);
		getContentPane().add(btnBackHome);

		btnBackHome.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Admin();

			}
		});
		
		JButton logoutButton = new JButton("LOGOUT");
		logoutButton.setFocusable(false);
		logoutButton.setBackground(new Color(25, 106, 179));
		logoutButton.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		logoutButton.setForeground(Color.WHITE);
		logoutButton.setBounds(160, 10, 118, 33);
		getContentPane().add(logoutButton);

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
		
		btnDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int result1 = BookInfoDao.getInstance().delete(bookId);
				if (result1 == 1) {
					JOptionPane.showMessageDialog(null, "삭제 완료");
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "삭제 실패");
					dispose();
				}

			}
		});

		btnUpdate.addActionListener(new ActionListener() {

			@SuppressWarnings("unused")
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (tfReBookid.getText().trim().equals("")) {
						JOptionPane.showMessageDialog(null, "빈칸이 있습니다.");
					} else if (tfPrice.getText().trim().equals("")) {
						JOptionPane.showMessageDialog(null, "빈칸이 있습니다.");
					} else if (tfISBN.getText().trim().equals("") || tfName.getText().trim().equals("")
							|| tfAuthor.getText().trim().equals("") || tfPublicationDate.getText().trim().equals("")
							|| tfPublisher.getText().trim().equals("") || tfCategory.getText().trim().equals("")
							|| taSummary.getText().trim().equals("")) {
						JOptionPane.showMessageDialog(null, "빈칸이 있습니다.");
					} else {
						// int bookid = Integer.parseInt(tfReBookid.getText());
						BookInfoDao bookInfoDao = BookInfoDao.getInstance();
						int result = bookInfoDao.searchIdCheck(oriBookId);
						System.out.println("res: " + result);
						if (result == 1) {
							BookInfo bookinfo = new BookInfo();

							bookinfo.setBookid(Integer.parseInt(tfReBookid.getText().trim()));
							bookinfo.setBookname(tfName.getText().trim());
							bookinfo.setAuthor(tfAuthor.getText().trim());
							bookinfo.setPrice(Long.parseLong(tfPrice.getText().trim()));
							bookinfo.setPublicationDate(tfPublicationDate.getText().trim());
							bookinfo.setISBN(Long.parseLong(tfISBN.getText().trim()));
							bookinfo.setPublisher(tfPublisher.getText().trim());
							bookinfo.setCategory(tfCategory.getText().trim());
							bookinfo.setSummary(taSummary.getText().trim());

							BookInfoDao bookInfoDao2 = BookInfoDao.getInstance();
							int result2 = bookInfoDao2.update(bookinfo, oriBookId);
							if (result2 == 1) {
								JOptionPane.showMessageDialog(null, "수정 완료");
								dispose();
								new AdminSearch();
							} else {
								JOptionPane.showMessageDialog(null, "Bookid가 중복입니다.");
								// dispose();
							}
						} else {
							JOptionPane.showMessageDialog(null, "Bookid가 중복입니다.");
						}
					}
				} catch (Exception e2) {
					System.out.println("dddd : " + tfISBN.getText());
					JOptionPane.showMessageDialog(null, "책 정보 형식이 올바르지 않습니다.");
				}
			}
		});

		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);

		// bookid 숫자인지 체크
		tfReBookid.addFocusListener(new FocusListener() {

			public void focusLost(FocusEvent e) {

				if (tfReBookid.getText().matches(bookidExp)) {
					panelSub.remove(lblReBookIDCheck);

					repaint();
					// panelMain.remove(lblBookIdCheck);
					System.out.println(tfReBookid.getText().matches(bookidExp));
				} else if (tfReBookid.getText().trim().equals("")) {
					lblReBookIDCheck = new JLabel("! 정보를 입력해주세요.");
					lblReBookIDCheck.setFont(new Font("굴림", Font.PLAIN, 11));
					lblReBookIDCheck.setForeground(Color.RED);
					lblReBookIDCheck.setBounds(95, 61, 279, 15);
					panelSub.add(lblReBookIDCheck);
					repaint();

				} else {
					tfReBookid.setText("");

					lblReBookIDCheck = new JLabel("! BookID는 숫자만 입력할수 있습니다.");
					lblReBookIDCheck.setFont(new Font("굴림", Font.PLAIN, 11));
					lblReBookIDCheck.setForeground(Color.RED);
					lblReBookIDCheck.setBounds(95, 61, 279, 15);
					panelSub.add(lblReBookIDCheck);
					repaint();
					// tfBookID.requestFocus(true); //포커스주기

				}

			}

			@Override
			public void focusGained(FocusEvent e) {
				panelSub.remove(lblReBookIDCheck);
				repaint();
			}
		});

		// price 숫자인지 체크
		tfPrice.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {
				if (tfPrice.getText().matches(priceExp)) {

					panelSub.remove(lblPriceCheck);
					repaint();

				} else if (tfPrice.getText().trim().equals("")) {
					lblPriceCheck = new JLabel("! 정보를 입력해주세요.");
					lblPriceCheck.setFont(new Font("굴림", Font.PLAIN, 11));
					lblPriceCheck.setForeground(Color.RED);
					lblPriceCheck.setBounds(95, 157, 279, 15);
					panelSub.add(lblPriceCheck);
					repaint();

				} else {
					tfPrice.setText("");

					lblPriceCheck = new JLabel("! Price는 숫자만 입력할수 있습니다.");
					lblPriceCheck.setFont(new Font("굴림", Font.PLAIN, 11));
					lblPriceCheck.setForeground(Color.RED);
					lblPriceCheck.setBounds(95, 157, 279, 15);
					panelSub.add(lblPriceCheck);
					repaint();
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				panelSub.remove(lblPriceCheck);

			}
		});

		// tfPublicationDate 날짜양식 체크
		tfPublicationDate.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {
				if (tfPublicationDate.getText().matches(tfPublicationDateExp)) {
					panelSub.remove(lblPublicationDateCheck);
					repaint();

				} else if (tfPublicationDate.getText().trim().equals("")) {
					lblPublicationDateCheck = new JLabel("! 정보를 입력해주세요.");
					lblPublicationDateCheck.setFont(new Font("굴림", Font.PLAIN, 11));
					lblPublicationDateCheck.setForeground(Color.RED);
					lblPublicationDateCheck.setBounds(95, 189, 279, 15);
					panelSub.add(lblPublicationDateCheck);
					repaint();

				} else {
					tfPublicationDate.setText("");

					lblPublicationDateCheck = new JLabel("! 날짜형식이 올바르지 않습니다.  ex) 2020-05-13");
					lblPublicationDateCheck.setForeground(Color.RED);
					lblPublicationDateCheck.setFont(new Font("굴림", Font.PLAIN, 11));
					lblPublicationDateCheck.setBounds(95, 189, 279, 15);
					panelSub.add(lblPublicationDateCheck);
					repaint();
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				panelSub.remove(lblPublicationDateCheck);

			}
		});

		// ISBN 숫자인지 체크
		tfISBN.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {
				if (tfISBN.getText().matches(ISBNExp)) {
					panelSub.remove(lblISBNCheck);
					repaint();

				} else if (tfISBN.getText().trim().equals("")) {
					lblISBNCheck = new JLabel("! 정보를 입력해주세요.");
					lblISBNCheck.setFont(new Font("굴림", Font.PLAIN, 11));
					lblISBNCheck.setForeground(Color.RED);
					lblISBNCheck.setBounds(95, 221, 279, 15);
					panelSub.add(lblISBNCheck);
					repaint();

				} else {
					tfISBN.setText("");

					lblISBNCheck = new JLabel("! ISBN은 13자리 숫자만 입력할수 있습니다.");
					lblISBNCheck.setForeground(Color.RED);
					lblISBNCheck.setFont(new Font("굴림", Font.PLAIN, 11));
					lblISBNCheck.setBounds(95, 221, 279, 15);
					panelSub.add(lblISBNCheck);
					repaint();
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				panelSub.remove(lblISBNCheck);
			}
		});

		// Name 공백 체크
		tfName.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {
				if (tfName.getText().matches(BlankExp)) {
					panelSub.remove(lblNameCheck);
					repaint();
				} else {
					tfName.setText("");

					lblNameCheck = new JLabel("! 정보를 입력해주세요.");
					lblNameCheck.setFont(new Font("굴림", Font.PLAIN, 11));
					lblNameCheck.setBounds(95, 93, 279, 15);
					lblNameCheck.setForeground(Color.RED);
					panelSub.add(lblNameCheck);

					repaint();
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				panelSub.remove(lblNameCheck);
			}
		});

		// Author 공백 체크
		tfAuthor.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {
				if (tfAuthor.getText().matches(BlankExp)) {
					panelSub.remove(lblAuthorCheck);
					repaint();
				} else {
					tfAuthor.setText("");

					lblAuthorCheck = new JLabel("! 정보를 입력해주세요.");
					lblAuthorCheck.setFont(new Font("굴림", Font.PLAIN, 11));
					lblAuthorCheck.setBounds(95, 125, 279, 15);
					lblAuthorCheck.setForeground(Color.RED);
					panelSub.add(lblAuthorCheck);

					repaint();
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				panelSub.remove(lblAuthorCheck);
			}
		});

		// Publisher 공백 체크
		tfPublisher.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {
				if (tfPublisher.getText().matches(BlankExp)) {
					panelSub.remove(lblPublisherCheck);
					repaint();
				} else {
					tfPublisher.setText("");

					lblPublisherCheck = new JLabel("! 정보를 입력해주세요.");
					lblPublisherCheck.setFont(new Font("굴림", Font.PLAIN, 11));
					lblPublisherCheck.setBounds(95, 253, 279, 15);
					lblPublisherCheck.setForeground(Color.RED);
					panelSub.add(lblPublisherCheck);

					repaint();
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				panelSub.remove(lblPublisherCheck);
			}
		});

		// Category 공백 체크
		tfCategory.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {
				if (tfCategory.getText().matches(BlankExp)) {
					panelSub.remove(lblCategoryCheck);
					repaint();
				} else {
					tfCategory.setText("");

					lblCategoryCheck = new JLabel("! 정보를 입력해주세요.");
					lblCategoryCheck.setFont(new Font("굴림", Font.PLAIN, 11));
					lblCategoryCheck.setBounds(95, 284, 279, 15);
					lblCategoryCheck.setForeground(Color.RED);
					panelSub.add(lblCategoryCheck);

					repaint();
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				panelSub.remove(lblCategoryCheck);
			}
		});

	}



	class ImagePanel extends JPanel {

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(imageIcon.getImage(), 0, 70, 300, 400, null);
//		setOpaque(false);				
		}
	}
}
