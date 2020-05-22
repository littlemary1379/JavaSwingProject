package adminpage;

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
import javax.swing.table.DefaultTableModel;

import adminpage.AdminUpdate;
import datamodel.BookInfo;
import datamodel.BookInfoDao;
import datamodel.UserModel;
import loginpage.Login;

public class AdminSearch extends JFrame {
	private JTextField tfSearch;
	private String ComBoxName[] = { "Bookid", "이름", "저자", "가격", "ISBN", "출판사" };
	private String TableColumnName[] = { "Bookid", "이름", "저자", "가격", "출간일", "ISBN", "출판사", "카테고리", "줄거리" };

	private DefaultTableModel dt;

	private ImageIcon icon;
	private JTable table;
	private JScrollPane scrollPane;

	public AdminSearch() {
		getContentPane().setBackground(new Color(192, 192, 192));

		setTitle("관리자 검색 페이지");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		MyPanel panelMain = new MyPanel();
		// JPanel panelMain = new JPanel();
		panelMain.setBounds(0, 0, 794, 571);
		panelMain.setBackground(new Color(255, 250, 240));
		getContentPane().add(panelMain);
		panelMain.setLayout(null);
		
		tfSearch = new JTextField();
		tfSearch.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		tfSearch.setBounds(152, 53, 483, 33);
		panelMain.add(tfSearch);
		tfSearch.setColumns(10);

		JButton btnSearch = new JButton("검색");
		btnSearch.setFocusable(false);
		btnSearch.setBackground(new Color(25, 106, 179));
		btnSearch.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		btnSearch.setForeground(Color.WHITE);
		btnSearch.setBounds(632, 53, 79, 33);
		panelMain.add(btnSearch);

		JComboBox<String> comboBox = new JComboBox(ComBoxName);
		comboBox.setFocusable(false);
		comboBox.setFont(new Font("굴림", Font.PLAIN, 12));
		comboBox.setBounds(35, 53, 118, 33);
		panelMain.add(comboBox);

		JButton btnBackHome = new JButton("홈페이지 돌아가기");
		btnBackHome.setFocusable(false);
		btnBackHome.setBackground(new Color(25, 106, 179));
		btnBackHome.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		btnBackHome.setForeground(Color.WHITE);
		btnBackHome.setBounds(33, 10, 152, 33);
		panelMain.add(btnBackHome);

		JPanel panelSub = new JPanel();
		panelSub.setFocusable(false);
		panelSub.setOpaque(false);
		panelSub.setBackground(new Color(255, 255, 255));
		panelSub.setBounds(35, 96, 731, 443);
		panelMain.add(panelSub);
		panelSub.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setFocusable(false);
		scrollPane.setBackground(new Color(147, 112, 219));
		scrollPane.setBounds(0, 0, 731, 443);
		panelSub.add(scrollPane);

		// Jtable 내용 편집 안되게
		dt = new DefaultTableModel(TableColumnName, 0) {

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

		table.getTableHeader().setReorderingAllowed(false); // 컬럼들 이동 불가
		// table.getTableHeader().setResizingAllowed(false); //사이즈 조정 불가

		JButton btnSelectAll = new JButton("전체 검색");
		btnSelectAll.setFocusable(false);
		btnSelectAll.setBackground(new Color(25, 106, 179));
		btnSelectAll.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		btnSelectAll.setForeground(Color.WHITE);
		btnSelectAll.setBounds(191, 10, 118, 33);
		panelMain.add(btnSelectAll);
		
		JButton logoutButton = new JButton("LOGOUT");
		logoutButton.setFocusable(false);
		logoutButton.setBackground(new Color(25, 106, 179));
		logoutButton.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		logoutButton.setForeground(Color.WHITE);
		logoutButton.setBounds(315, 10, 118, 33);
		panelMain.add(logoutButton);

		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);

		// 홈페이지가기 버튼
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

		// 전체검색버튼
		btnSelectAll.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				BookInfoDao bookInfoDao = BookInfoDao.getInstance();
				bookInfoDao.searchAll(dt);

			}
		});

		// 검색버튼
		btnSearch.addActionListener(new ActionListener() {
			int result;

			@Override
			public void actionPerformed(ActionEvent e) {
				String getComboBox;

				BookInfo bookinfo = new BookInfo();
				getComboBox = comboBox.getSelectedItem().toString();

				if (tfSearch.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "검색어를 입력하세요.");
				} else {
					try {
						if (getComboBox.equals("Bookid")) {
							// System.out.println(getComboBox);
							String comBox = "Bookid";
							String field = tfSearch.getText();
							bookinfo.setBookid(Integer.parseInt(tfSearch.getText().trim()));

							BookInfoDao bookInfoDao = BookInfoDao.getInstance();
							result = bookInfoDao.search(dt, comBox, field);
							// System.out.println(result);
							if (result == -1) {
								JOptionPane.showMessageDialog(null, "검색결과 없습니다.");
								// dispose();
							}
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

						else if (getComboBox.equals("가격")) {
							System.out.println(getComboBox);
							bookinfo.setPrice(Long.parseLong(tfSearch.getText().trim()));
							String comBox = "Price";
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

					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, "검색결과 없습니다.");
					}
				} //end of else
			}

		});
		
		initListener(); // 테이블클릭시
	}

	class MyPanel extends JPanel {
		ImageIcon icon = new ImageIcon("imgbook//6.jpg");
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

				dispose();
				new AdminUpdate(OriBookId, bookId, name, author, price, PublicationDate, ISBN, publisher, category,
						summary);
			}
		});
	}

}
