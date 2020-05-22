package adminpage;

import java.awt.Color;
import java.awt.EventQueue;
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

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import com.google.gson.Gson;

import datamodel.BookInfo;
import datamodel.BookInfoDao;
import datamodel.BookParsing;
import datamodel.Item;
import datamodel.UserModel;
import loginpage.Login;

public class AdminInsert extends JFrame {
	private JTextField textField;
	private JTextField tfBookID;
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
	JTextArea taSummary_1;

	private String bookidExp = "^[0-9]+$";
	private String priceExp = "^[0-9]+$";
	private String ISBNExp = "^[0-9]{13}$";
	private String tfPublicationDateExp = "^[0-9]{4}[-]{1}[0-9]{2}[-]{1}[0-9]{2}$";
	private String BlankExp = "^[A-Za-z가-힣\\s,~!@#$%^&*+=`.(){}:0-9]+$";
	private String CategoryExp = "^[가-힣/,\\s]+$";
	// private String numberExp="^[a-zA-Z0-9_]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]+$";

	private JLabel lblBookIdCheck;
	private JLabel lblPriceCheck;
	private JLabel lblPublicDateCheck;
	private JLabel lblISBNCheck;
	private JLabel lblNameCheck;
	private JLabel lblAuthorCheck;
	private JLabel lblPublisherCheck;
	private JLabel lblCategoryCheck;
	private JLabel lblSummaryCheck;
	private JScrollPane scrollPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminInsert adminInsert = new AdminInsert();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public AdminInsert() {
		setBackground(new Color(255, 255, 255));
		setTitle("관리자 등록 페이지");
		setSize(800, 600);
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panelMain = new JPanel();
		panelMain.setBackground(Color.WHITE);
		panelMain.setBounds(361, 10, 423, 538);
		getContentPane().add(panelMain);
		panelMain.setLayout(null);

		JLabel lblBookID = new JLabel("BookID");
		lblBookID.setBounds(28, 25, 90, 22);
		lblBookID.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		panelMain.add(lblBookID);

		JLabel lblName = new JLabel("이름");
		lblName.setBounds(28, 69, 90, 22);
		panelMain.add(lblName);
		lblName.setFont(new Font("맑은 고딕", Font.BOLD, 12));

		JLabel lblAuthor = new JLabel("저자");
		lblAuthor.setBounds(28, 110, 90, 22);
		panelMain.add(lblAuthor);
		lblAuthor.setFont(new Font("맑은 고딕", Font.BOLD, 12));

		JLabel lblPrice = new JLabel("가격");
		lblPrice.setBounds(28, 153, 90, 22);
		panelMain.add(lblPrice);
		lblPrice.setFont(new Font("맑은 고딕", Font.BOLD, 12));

		JLabel lblPublicationDate = new JLabel("출판일");
		lblPublicationDate.setBounds(28, 198, 90, 22);
		panelMain.add(lblPublicationDate);
		lblPublicationDate.setFont(new Font("맑은 고딕", Font.BOLD, 12));

		JLabel lblISBN = new JLabel("ISBN");
		lblISBN.setBounds(28, 242, 90, 22);
		panelMain.add(lblISBN);
		lblISBN.setFont(new Font("맑은 고딕", Font.BOLD, 12));

		JLabel lblPublisher = new JLabel("출판사");
		lblPublisher.setBounds(28, 289, 90, 22);
		panelMain.add(lblPublisher);
		lblPublisher.setFont(new Font("맑은 고딕", Font.BOLD, 12));

		JLabel lblSummary = new JLabel("줄거리");
		lblSummary.setBounds(28, 386, 90, 22);
		panelMain.add(lblSummary);
		lblSummary.setFont(new Font("맑은 고딕", Font.BOLD, 12));

		tfBookID = new JTextField();
		tfBookID.setOpaque(false);
		tfBookID.setBounds(93, 26, 279, 21);
		panelMain.add(tfBookID);
		tfBookID.setColumns(10);

		tfName = new JTextField();
		tfName.setOpaque(false);
		tfName.setColumns(10);
		tfName.setBounds(93, 70, 279, 21);
		panelMain.add(tfName);

		tfAuthor = new JTextField();
		tfAuthor.setOpaque(false);
		tfAuthor.setColumns(10);
		tfAuthor.setBounds(93, 111, 279, 21);
		panelMain.add(tfAuthor);

		tfPrice = new JTextField();
		tfPrice.setOpaque(false);
		tfPrice.setColumns(10);
		tfPrice.setBounds(93, 154, 279, 21);
		panelMain.add(tfPrice);

		tfPublicationDate = new JTextField();
		tfPublicationDate.setOpaque(false);
		tfPublicationDate.setColumns(10);
		tfPublicationDate.setBounds(93, 199, 279, 21);
		panelMain.add(tfPublicationDate);

		tfISBN = new JTextField();
		tfISBN.setOpaque(false);
		tfISBN.setColumns(10);
		tfISBN.setBounds(93, 243, 279, 21);
		panelMain.add(tfISBN);

		tfPublisher = new JTextField();
		tfPublisher.setOpaque(false);
		tfPublisher.setColumns(10);
		tfPublisher.setBounds(93, 290, 279, 21);
		panelMain.add(tfPublisher);

		tfCategory = new JTextField();
		tfCategory.setOpaque(false);
		tfCategory.setColumns(10);
		tfCategory.setBounds(93, 339, 279, 21);
		panelMain.add(tfCategory);

		// 검증
		lblBookIdCheck = new JLabel("");
		lblBookIdCheck.setFont(new Font("굴림", Font.PLAIN, 11));
		lblBookIdCheck.setBounds(95, 50, 279, 15);
		panelMain.add(lblBookIdCheck);

		lblPriceCheck = new JLabel("");
		lblPriceCheck.setFont(new Font("굴림", Font.PLAIN, 11));
		lblPriceCheck.setBounds(93, 179, 279, 15);
		panelMain.add(lblPriceCheck);

		lblPublicDateCheck = new JLabel("");
		lblPublicDateCheck.setFont(new Font("굴림", Font.PLAIN, 11));
		lblPublicDateCheck.setBounds(93, 224, 279, 15);
		panelMain.add(lblPublicDateCheck);

		lblISBNCheck = new JLabel("");
		lblISBNCheck.setFont(new Font("굴림", Font.PLAIN, 11));
		lblISBNCheck.setBounds(93, 269, 279, 15);
		panelMain.add(lblISBNCheck);

		lblNameCheck = new JLabel("");
		lblNameCheck.setFont(new Font("굴림", Font.PLAIN, 11));
		lblNameCheck.setBounds(93, 73, 279, 15);
		panelMain.add(lblNameCheck);

		lblAuthorCheck = new JLabel("");
		lblAuthorCheck.setFont(new Font("굴림", Font.PLAIN, 11));
		lblAuthorCheck.setBounds(93, 114, 279, 15);
		panelMain.add(lblAuthorCheck);

		lblPublisherCheck = new JLabel("");
		lblPublisherCheck.setFont(new Font("굴림", Font.PLAIN, 11));
		lblPublisherCheck.setBounds(93, 293, 279, 15);
		panelMain.add(lblPublisherCheck);

		lblCategoryCheck = new JLabel("");
		lblCategoryCheck.setFont(new Font("굴림", Font.PLAIN, 11));
		lblCategoryCheck.setBounds(93, 342, 279, 15);
		panelMain.add(lblCategoryCheck);

		JButton btnInsert = new JButton("등록");
		btnInsert.setBackground(new Color(102, 153, 255));
		btnInsert.setBounds(316, 508, 79, 23);
		panelMain.add(btnInsert);
		btnInsert.setForeground(Color.WHITE);
		btnInsert.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		btnInsert.setBackground(new Color(25, 106, 179));

		JLabel lblCategory = new JLabel("카테고리");
		lblCategory.setBounds(28, 342, 57, 15);
		panelMain.add(lblCategory);

		scrollPane = new JScrollPane();
		scrollPane.setOpaque(false);
		scrollPane.setBounds(93, 386, 279, 112);
		panelMain.add(scrollPane);

		//
		taSummary_1 = new JTextArea();
		scrollPane.setViewportView(taSummary_1);
		taSummary_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		taSummary_1.setOpaque(false);
		taSummary_1.setLineWrap(true);
		taSummary_1.setBackground(new Color(245, 255, 250));
		taSummary_1.setForeground(Color.BLACK);

//		lblSummaryCheck = new JLabel("");
//		scrollPane.setColumnHeaderView(lblSummaryCheck);
//		lblSummaryCheck.setFont(new Font("굴림", Font.PLAIN, 11));

		JButton btnBackHome = new JButton("홈페이지 돌아가기");
		btnBackHome.setRequestFocusEnabled(false);
		btnBackHome.setForeground(Color.WHITE);
		btnBackHome.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		btnBackHome.setBackground(new Color(25, 106, 179));
		btnBackHome.setBounds(12, 10, 150, 33);
		getContentPane().add(btnBackHome);
		
		JButton logoutButton = new JButton("LOGOUT");
		logoutButton.setFocusable(false);
		logoutButton.setBackground(new Color(25, 106, 179));
		logoutButton.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		logoutButton.setForeground(Color.WHITE);
		logoutButton.setBounds(170, 10, 150, 33);
		getContentPane().add(logoutButton);

		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);

		JButton btnpicture = new JButton("사진검색");
		btnpicture.setForeground(Color.WHITE);
		btnpicture.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		btnpicture.setBackground(new Color(25, 106, 179));
		btnpicture.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String searchText = tfName.getText();

				BookParsing bookParsing = naverkey(searchText);
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
						// image = image.getScaledInstance(500, 500, Image.SCALE_SMOOTH);

					} catch (Exception e1) {
						e1.printStackTrace();
					}
					imageIcon = new ImageIcon(image);
				}

				imagePanel = new ImagePanel();
				imagePanel.setBounds(40, 40, 500, 500);
				getContentPane().add(imagePanel);

				repaint();
			}
		});
		btnpicture.setBounds(28, 508, 97, 23);
		panelMain.add(btnpicture);

		// bookid 숫자인지 체크
		tfBookID.addFocusListener(new FocusListener() {

			public void focusLost(FocusEvent e) {

				if (tfBookID.getText().matches(bookidExp)) {
					panelMain.remove(lblBookIdCheck);

					repaint();
					// panelMain.remove(lblBookIdCheck);
					System.out.println(tfBookID.getText().matches(bookidExp));
				} else if (tfBookID.getText().trim().equals("")) {
					lblBookIdCheck = new JLabel("! 정보를 입력해주세요.");
					lblBookIdCheck.setFont(new Font("굴림", Font.PLAIN, 11));
					lblBookIdCheck.setForeground(Color.RED);
					lblBookIdCheck.setBounds(95, 29, 279, 15);
					panelMain.add(lblBookIdCheck);
					repaint();

				} else {
					tfBookID.setText("");

					lblBookIdCheck = new JLabel("! BookID는 숫자만 입력할수 있습니다.");
					lblBookIdCheck.setFont(new Font("굴림", Font.PLAIN, 11));
					lblBookIdCheck.setForeground(Color.RED);
					lblBookIdCheck.setBounds(95, 29, 279, 15);
					panelMain.add(lblBookIdCheck);
					repaint();
					// tfBookID.requestFocus(true); //포커스주기

				}

			}

			@Override
			public void focusGained(FocusEvent e) {
				panelMain.remove(lblBookIdCheck);
				repaint();
			}
		});

		// price 숫자인지 체크
		tfPrice.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {
				if (tfPrice.getText().matches(priceExp)) {

					panelMain.remove(lblPriceCheck);
					repaint();

				} else if (tfPrice.getText().trim().equals("")) {
					lblPriceCheck = new JLabel("! 정보를 입력해주세요.");
					lblPriceCheck.setFont(new Font("굴림", Font.PLAIN, 11));
					lblPriceCheck.setForeground(Color.RED);
					lblPriceCheck.setBounds(95, 158, 279, 15);
					panelMain.add(lblPriceCheck);
					repaint();

				} else {
					tfPrice.setText("");

					lblPriceCheck = new JLabel("! Price는 숫자만 입력할수 있습니다.");
					lblPriceCheck.setFont(new Font("굴림", Font.PLAIN, 11));
					lblPriceCheck.setForeground(Color.RED);
					lblPriceCheck.setBounds(95, 158, 279, 15);
					panelMain.add(lblPriceCheck);
					repaint();
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				panelMain.remove(lblPriceCheck);

			}
		});

		// tfPublicationDate 날짜양식 체크
		tfPublicationDate.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {
				if (tfPublicationDate.getText().matches(tfPublicationDateExp)) {
					panelMain.remove(lblPublicDateCheck);
					repaint();

				} else if (tfPublicationDate.getText().trim().equals("")) {
					lblPublicDateCheck = new JLabel("! 정보를 입력해주세요.");
					lblPublicDateCheck.setFont(new Font("굴림", Font.PLAIN, 11));
					lblPublicDateCheck.setForeground(Color.RED);
					lblPublicDateCheck.setBounds(95, 203, 279, 15);
					panelMain.add(lblPublicDateCheck);
					repaint();

				} else {
					tfPublicationDate.setText("");

					lblPublicDateCheck = new JLabel("! 날짜형식이 올바르지 않습니다.  ex) 2020-05-13");
					lblPublicDateCheck.setForeground(Color.RED);
					lblPublicDateCheck.setFont(new Font("굴림", Font.PLAIN, 11));
					lblPublicDateCheck.setBounds(95, 203, 279, 15);
					panelMain.add(lblPublicDateCheck);
					repaint();
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				panelMain.remove(lblPublicDateCheck);

			}
		});

		// ISBN 숫자인지 체크
		tfISBN.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {
				if (tfISBN.getText().matches(ISBNExp)) {
					panelMain.remove(lblISBNCheck);
					repaint();

				} else if (tfISBN.getText().trim().equals("")) {
					lblISBNCheck = new JLabel("! 정보를 입력해주세요.");
					lblISBNCheck.setFont(new Font("굴림", Font.PLAIN, 11));
					lblISBNCheck.setForeground(Color.RED);
					lblISBNCheck.setBounds(95, 248, 279, 15);
					panelMain.add(lblISBNCheck);
					repaint();

				} else {
					tfISBN.setText("");

					lblISBNCheck = new JLabel("! ISBN은 13자리 숫자만 입력할수 있습니다.");
					lblISBNCheck.setForeground(Color.RED);
					lblISBNCheck.setFont(new Font("굴림", Font.PLAIN, 11));
					lblISBNCheck.setBounds(95, 248, 279, 15);
					panelMain.add(lblISBNCheck);
					repaint();
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				panelMain.remove(lblISBNCheck);
			}
		});

		// Name 공백 체크
		tfName.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {
				if (tfName.getText().matches(BlankExp)) {
					panelMain.remove(lblNameCheck);
					repaint();
				} else {
					tfName.setText("");

					lblNameCheck = new JLabel("! 정보를 입력해주세요.");
					lblNameCheck.setFont(new Font("굴림", Font.PLAIN, 11));
					lblNameCheck.setBounds(95, 73, 279, 15);
					lblNameCheck.setForeground(Color.RED);
					panelMain.add(lblNameCheck);

					repaint();
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				panelMain.remove(lblNameCheck);
			}
		});

		// Author 공백 체크
		tfAuthor.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {
				if (tfAuthor.getText().matches(BlankExp)) {
					panelMain.remove(lblAuthorCheck);
					repaint();
				} else {
					tfAuthor.setText("");

					lblAuthorCheck = new JLabel("! 정보를 입력해주세요.");
					lblAuthorCheck.setFont(new Font("굴림", Font.PLAIN, 11));
					lblAuthorCheck.setBounds(95, 114, 279, 15);
					lblAuthorCheck.setForeground(Color.RED);
					panelMain.add(lblAuthorCheck);

					repaint();
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				panelMain.remove(lblAuthorCheck);
			}
		});

		// Publisher 공백 체크
		tfPublisher.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {
				if (tfPublisher.getText().matches(BlankExp)) {
					panelMain.remove(lblPublisherCheck);
					repaint();
				} else {
					tfPublisher.setText("");

					lblPublisherCheck = new JLabel("! 정보를 입력해주세요.");
					lblPublisherCheck.setFont(new Font("굴림", Font.PLAIN, 11));
					lblPublisherCheck.setBounds(95, 293, 279, 15);
					lblPublisherCheck.setForeground(Color.RED);
					panelMain.add(lblPublisherCheck);

					repaint();
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				panelMain.remove(lblPublisherCheck);
			}
		});

		// Category 공백 체크
		tfCategory.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {
				if (tfCategory.getText().matches(CategoryExp)) {
					panelMain.remove(lblCategoryCheck);
					repaint();
				} else {
					tfCategory.setText("");

					lblCategoryCheck = new JLabel("! 정보를 입력해주세요.");
					lblCategoryCheck.setFont(new Font("굴림", Font.PLAIN, 11));
					lblCategoryCheck.setBounds(95, 342, 279, 15);
					lblCategoryCheck.setForeground(Color.RED);
					panelMain.add(lblCategoryCheck);

					repaint();
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				panelMain.remove(lblCategoryCheck);
			}
		});

		// 홈돌아가기 버튼
		btnBackHome.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Admin();
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

		// 등록 버튼 눌렀을때
		btnInsert.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					if (tfBookID.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "책정보를 다시 입력하세요");
					} else if (tfPrice.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "책정보를 다시 입력하세요");
					} else if (tfISBN.getText().equals("") || tfName.getText().equals("")
							|| tfAuthor.getText().equals("") || tfPublicationDate.getText().equals("")
							|| tfPublisher.getText().equals("") || tfCategory.getText().equals("")
							|| taSummary_1.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "책정보를 다시 입력하세요");
					} else {
						int bookid = Integer.parseInt(tfBookID.getText());
						BookInfoDao bookInfoDao = BookInfoDao.getInstance();
						int result = bookInfoDao.searchIdCheck(bookid);
						System.out.println("res: "+result);
						if (result == 1) {
							BookInfo bookinfo = new BookInfo();

							bookinfo.setBookid(Integer.parseInt(tfBookID.getText().trim()));
							bookinfo.setBookname(tfName.getText().trim());
							bookinfo.setAuthor(tfAuthor.getText().trim());
							bookinfo.setPrice(Long.parseLong(tfPrice.getText().trim()));
							bookinfo.setPublicationDate(tfPublicationDate.getText().trim());
							bookinfo.setISBN(Long.parseLong(tfISBN.getText().trim()));
							bookinfo.setPublisher(tfPublisher.getText().trim());
							bookinfo.setCategory(tfCategory.getText().trim());
							bookinfo.setSummary(taSummary_1.getText().trim());
							BookInfoDao bookInfoDao2 = BookInfoDao.getInstance();
							int result2 = bookInfoDao2.save(bookinfo);

							if (result2 == 1) {
								JOptionPane.showMessageDialog(null, "등록 완료");
								//dispose();
								//new AdminInsert2();
								tfBookID.setText("");
								tfName.setText("");
								tfAuthor.setText("");
								tfPrice.setText("");
								tfPublicationDate.setText("");
								tfISBN.setText("");
								tfPublisher.setText("");
								tfCategory.setText("");
								taSummary_1.setText("");
							} else {
								JOptionPane.showMessageDialog(null,  "Bookid가 중복입니다.");
								// dispose();
							}
						} else {
							JOptionPane.showMessageDialog(null, "Bookid가 중복입니다.");
						}
					}
				} catch (Exception e2) {
					e2.printStackTrace();
					JOptionPane.showMessageDialog(null, "형식을 올바르게 입력하세요.");
				}
				
				
			}
			
		});
	}

	public BookParsing naverkey(String searchText) {
		String clientId = "a5p7SydDesqqzjmc8XFV"; // 애플리케이션 클라이언트 아이디값"
		String clientSecret = "M3MUWAWTd3"; // 애플리케이션 클라이언트 시크릿값"

		String text = null;
		try {
			text = URLEncoder.encode(searchText, "UTF-8");
			System.out.println(searchText);
			// System.out.println(text);

		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("검색어 인코딩 실패", e);
		}

		String apiURL = "https://openapi.naver.com/v1/search/book.json?query=" + text + "&display=1&start=1"; // json 결과
		// String apiURL = "https://openapi.naver.com/v1/search/blog.xml?query="+ text;
		// // xml 결과

		Map<String, String> requestHeaders = new HashMap<>();
		requestHeaders.put("X-Naver-Client-Id", clientId);
		requestHeaders.put("X-Naver-Client-Secret", clientSecret);
		String responseBody = get(apiURL, requestHeaders);

		System.out.println(responseBody);
		Gson gson = new Gson();
		BookParsing bookParsing = gson.fromJson(responseBody, BookParsing.class);

		return bookParsing;
	}

	private static String get(String apiUrl, Map<String, String> requestHeaders) {
		HttpURLConnection con = connect(apiUrl);
		try {
			con.setRequestMethod("GET");
			for (Map.Entry<String, String> header : requestHeaders.entrySet()) {
				con.setRequestProperty(header.getKey(), header.getValue());
			}

			int responseCode = con.getResponseCode();
			if (responseCode == HttpURLConnection.HTTP_OK) { // 정상 호출
				return readBody(con.getInputStream());
			} else { // 에러 발생
				return readBody(con.getErrorStream());
			}
		} catch (IOException e) {
			throw new RuntimeException("API 요청과 응답 실패", e);
		} finally {
			con.disconnect();
		}
	}

	private static HttpURLConnection connect(String apiUrl) {
		try {
			URL url = new URL(apiUrl);
			return (HttpURLConnection) url.openConnection();
		} catch (MalformedURLException e) {
			throw new RuntimeException("API URL이 잘못되었습니다. : " + apiUrl, e);
		} catch (IOException e) {
			throw new RuntimeException("연결이 실패했습니다. : " + apiUrl, e);
		}
	}

	private static String readBody(InputStream body) {
		InputStreamReader streamReader = null;
		try {
			streamReader = new InputStreamReader(body, "UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try (BufferedReader lineReader = new BufferedReader(streamReader)) {
			StringBuilder responseBody = new StringBuilder();

			String line;
			while ((line = lineReader.readLine()) != null) {
				responseBody.append(line);
			}

			return responseBody.toString();
		} catch (IOException e) {
			throw new RuntimeException("API 응답을 읽는데 실패했습니다.", e);
		}
	}

	class ImagePanel extends JPanel {

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(imageIcon.getImage(), 0, 20, 300, 450, null);
//				setOpaque(false);				
		}
	}
}
