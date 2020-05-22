package ClientPage;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import datamodel.BookInfo;
import datamodel.BookInfoDao;
import datamodel.UserModel;
import loginpage.Login;

public class UserSearchBook extends JFrame {
	private JTextField tfSearch;
	private JButton homeButton, orderPageButton,logoutButton, myPageButton, mapButton; 
	private String ComBoxName[] = { "이름", "저자", "출판사", "ISBN" };
	private String TableColumnName[] = { "Bookid", "이름", "저자", "가격", "출간일", "ISBN", "출판사", "카테고리", "줄거리" };

	private DefaultTableModel dt;

	private ImageIcon icon;
	private JTable table;
	private JScrollPane scrollPane;
	
	public UserSearchBook() {
		String getHomeComboBox = "33"; 
		String getHomeSearch = "33";
		new UserSearchBook(getHomeComboBox, getHomeSearch);
	}

	public UserSearchBook(String getHomeComboBox, String getHomeSearch) {
		System.out.println("실행");
		getContentPane().setBackground(new Color(192, 192, 192));

		setTitle("사용자 검색 페이지");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);

		//MyPanel panelMain = new MyPanel();
		 JPanel panelMain = new JPanel();
		panelMain.setBounds(0, 0, 794, 571);
		panelMain.setBackground(Color.WHITE);
		getContentPane().add(panelMain);
		panelMain.setLayout(null);

		tfSearch = new JTextField();
		tfSearch.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		tfSearch.setBounds(152, 53, 536, 26);
		panelMain.add(tfSearch);
		tfSearch.setColumns(10);

		JButton btnSearch = new JButton("검색");
		btnSearch.setFocusable(false);
		btnSearch.setBackground(new Color(2, 136, 209));
		btnSearch.setForeground(new Color(255, 255, 255));
		btnSearch.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		btnSearch.setBounds(687, 53, 79, 26);
		panelMain.add(btnSearch);

		JComboBox<String> comboBox = new JComboBox(ComBoxName);
		comboBox.setFocusable(false);
		comboBox.setFont(new Font("굴림", Font.PLAIN, 12));
		comboBox.setBackground(Color.WHITE);
		comboBox.setBounds(35, 53, 118, 26);
		panelMain.add(comboBox);
		
		homeButton = new JButton("HOME");
		myPageButton = new JButton("MYPAGE");
		orderPageButton = new JButton("주문페이지");
		logoutButton = new JButton("LOGOUT");
		mapButton = new JButton("주변 서점 찾기");
		
		homeButton.setBounds(12, 10, 71, 23);
		homeButton.setHorizontalAlignment(SwingConstants.LEFT);
		homeButton.setFont(new Font("맑은 고딕", Font.PLAIN, 10));
		homeButton.setBackground(Color.WHITE);
		homeButton.setBorderPainted(false);
		homeButton.setFocusPainted(false);

		myPageButton.setBounds(83, 10, 82, 23);
		myPageButton.setHorizontalAlignment(SwingConstants.LEFT);
		myPageButton.setFont(new Font("맑은 고딕", Font.PLAIN, 10));
		myPageButton.setBackground(Color.WHITE);
		myPageButton.setBorderPainted(false);
		myPageButton.setFocusPainted(false);

		orderPageButton.setBounds(165, 10, 90, 23);
		orderPageButton.setHorizontalAlignment(SwingConstants.LEFT);
		orderPageButton.setFont(new Font("맑은 고딕", Font.PLAIN, 10));
		orderPageButton.setBackground(Color.WHITE);
		orderPageButton.setBorderPainted(false);
		orderPageButton.setFocusPainted(false);

		logoutButton.setBounds(257, 10, 82, 23);
		logoutButton.setHorizontalAlignment(SwingConstants.LEFT);
		logoutButton.setFont(new Font("맑은 고딕", Font.PLAIN, 10));
		logoutButton.setBackground(Color.WHITE);
		logoutButton.setBorderPainted(false);
		logoutButton.setFocusPainted(false);
		
		mapButton.setBounds(330, 10, 110, 23);
		mapButton.setHorizontalAlignment(SwingConstants.LEFT);
		mapButton.setFont(new Font("맑은 고딕", Font.PLAIN, 10));
		mapButton.setBackground(Color.WHITE);
		mapButton.setBorderPainted(false);
		mapButton.setFocusPainted(false);

		getContentPane().add(homeButton);
		getContentPane().add(myPageButton);
		getContentPane().add(orderPageButton);
		getContentPane().add(logoutButton);
		getContentPane().add(mapButton);

		JPanel panelSub = new JPanel();
		panelSub.setFocusable(false);
		panelSub.setOpaque(false);
		panelSub.setBackground(new Color(255, 255, 255));
		panelSub.setBounds(35, 96, 731, 443);
		panelMain.add(panelSub);
		panelSub.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setFocusable(false);
		scrollPane.getViewport().setBackground(Color.WHITE);
		scrollPane.setBounds(0, 0, 731, 443);
		panelSub.add(scrollPane);

		dt = new DefaultTableModel(TableColumnName, 0) {
			// Jtable 내용 편집 안되게
			public boolean isCellEditable(int i, int c) {
				return false;
			}
		};

		table = new JTable(dt);
		table.setFocusable(false);
		table.setOpaque(false);
		table.setShowVerticalLines(false);
		table.setGridColor(new Color(0, 0, 0));
		table.setBackground(new Color(255, 255, 255));
		table.setUpdateSelectionOnSort(false);
		table.setSelectionBackground(new Color(255, 102, 102));
		table.setRowHeight(25);

		table.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		table.setFont(new Font("굴림", Font.PLAIN, 16));
		scrollPane.setViewportView(table);

		table.getTableHeader().setReorderingAllowed(false);

		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);

		if (getHomeComboBox.equals("이름")) {
			BookInfoDao bookInfoDao = BookInfoDao.getInstance();
			String comBox = "bookname";
			String field = getHomeSearch;
			int result = bookInfoDao.search(dt, comBox, field);
			// System.out.println(result);
			if (result == -1) {
				JOptionPane.showMessageDialog(null, "검색결과 없습니다.");
				// dispose();
			}
		} else if (getHomeComboBox.equals("저자")) {
			BookInfoDao bookInfoDao = BookInfoDao.getInstance();
			String comBox = "author";
			String field = getHomeSearch;
			int result = bookInfoDao.search(dt, comBox, field);
			// System.out.println(result);
			if (result == -1) {
				JOptionPane.showMessageDialog(null, "검색결과 없습니다.");
				// dispose();
			}
		} else if (getHomeComboBox.equals("출판사")) {
			BookInfoDao bookInfoDao = BookInfoDao.getInstance();
			String comBox = "publisher";
			String field = getHomeSearch;
			int result = bookInfoDao.search(dt, comBox, field);
			// System.out.println(result);
			if (result == -1) {
				JOptionPane.showMessageDialog(null, "검색결과 없습니다.");
				// dispose();
			}
		} else if (getHomeComboBox.equals("ISBN")) {
			BookInfoDao bookInfoDao = BookInfoDao.getInstance();
			String comBox = "ISBN";
			String field = getHomeSearch;
			int result = bookInfoDao.search(dt, comBox, field);
			// System.out.println(result);
			if (result == -1) {
				JOptionPane.showMessageDialog(null, "검색결과 없습니다.");
				// dispose();
			}
		}



		// 검색버튼
		btnSearch.addActionListener(new ActionListener() {
			
			int result;

			@Override
			public void actionPerformed(ActionEvent e) {
				String getComboBox;

				BookInfo bookinfo = new BookInfo();
				getComboBox = comboBox.getSelectedItem().toString();

				try {
					if (tfSearch.getText().trim().equals("")) {
						JOptionPane.showMessageDialog(null, "검색어를 입력하세요.");
					}

					else if (getComboBox.equals("이름")) {
						System.out.println(getComboBox);
						String comBox = "bookname";
						String field = tfSearch.getText();
						bookinfo.setBookname(tfSearch.getText().trim());

						BookInfoDao bookInfoDao = BookInfoDao.getInstance();
						result = bookInfoDao.search(dt, comBox, field);
						if (result == -1) {
							JOptionPane.showMessageDialog(null, "검색결과 없습니다.");
							// dispose();
						}
					} else if (getComboBox.equals("저자")) {
						System.out.println(getComboBox);
						bookinfo.setAuthor(tfSearch.getText().trim());
						String comBox = "Author";
						String field = tfSearch.getText();

						BookInfoDao bookInfoDao = BookInfoDao.getInstance();
						result = bookInfoDao.search(dt, comBox, field);
						if (result == -1) {
							JOptionPane.showMessageDialog(null, "검색결과 없습니다.");
							// dispose();
						}
					}

					else if (getComboBox.equals("출판사")) {
						System.out.println(getComboBox);
						bookinfo.setPublisher(tfSearch.getText().trim());
						String comBox = "Publisher";
						String field = tfSearch.getText();

						BookInfoDao bookInfoDao = BookInfoDao.getInstance();
						result = bookInfoDao.search(dt, comBox, field);

						if (result == -1) {
							JOptionPane.showMessageDialog(null, "검색결과 없습니다.");
							// dispose();
						}
					}

					else if (getComboBox.equals("ISBN")) {
						System.out.println(getComboBox);
						bookinfo.setISBN(Long.parseLong(tfSearch.getText().trim()));
						String comBox = "ISBN";
						String field = tfSearch.getText();

						BookInfoDao bookInfoDao = BookInfoDao.getInstance();
						result = bookInfoDao.search(dt, comBox, field);
						if (result == -1) {
							JOptionPane.showMessageDialog(null, "검색결과 없습니다.");
							// dispose();
						}
					}

				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "검색결과 없습니다.");
				}

			}

		});
		 initListener();
	}

	// 배경넣을려면
	class MyPanel extends JPanel {
		ImageIcon icon = new ImageIcon("img//5.jpg");
		Image img = icon.getImage();

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
		}
	}

	// 테이블클릭시 수정,삭제 페이지
	private void initListener() {
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int r = table.getSelectedRow();
				int OriBookId = (int) table.getValueAt(r, 0);

				int bookId = (int) table.getValueAt(r, 0);
				String name = (String) table.getValueAt(r, 1);
				String author = (String) table.getValueAt(r, 2);
				long price = (long) table.getValueAt(r, 3);
				String PublicationDate = (String) table.getValueAt(r, 4);
				long ISBN = (long) table.getValueAt(r, 5);
				String publisher = (String) table.getValueAt(r, 6);
				String category = (String) table.getValueAt(r, 7);
				String summary = (String) table.getValueAt(r, 8);

				new BookParsingApp(name);
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
				new Map();
			}
		});
	}

}
