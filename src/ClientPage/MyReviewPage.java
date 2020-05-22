package ClientPage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import datamodel.Mypage;
import datamodel.UserModel;
import loginpage.Login;
import utils.MemberDao;

public class MyReviewPage extends JFrame {
	JScrollPane scrollpane;
	JPanel panel;
	JPanel panel_1;
	private JButton homeButton, orderPageButton,logoutButton, mapButton;
	private JPanel contentPane;

	public MyReviewPage() {

		MyReviewPageDefault();

	}

	private void MyReviewPageDefault() {
		

		setSize(800, 600);
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(Color.WHITE);

		scrollpane = new JScrollPane();
		scrollpane.setOpaque(false);
		scrollpane.setBackground(Color.WHITE);
		scrollpane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollpane.getVerticalScrollBar().setUnitIncrement(30);

		scrollpane.setBounds(13, 76, 770, 485);// 시작할떄 옆에간격,위에간격,안에창 옆으로,안에창 위아래
		getContentPane().add(scrollpane);
		
		homeButton = new JButton("HOME");
		homeButton.setBounds(12, 10, 82, 23);
		contentPane.add(homeButton);

		orderPageButton = new JButton("주문페이지");
		orderPageButton.setBounds(83, 10, 90, 23);
		contentPane.add(orderPageButton);

		logoutButton = new JButton("LOGOUT");
		logoutButton.setBounds(165, 10, 82, 23);
		contentPane.add(logoutButton);
		
		mapButton = new JButton("주변 서점 찾기");
		mapButton.setBounds(240, 10, 110, 23);
		mapButton.setHorizontalAlignment(SwingConstants.LEFT);
		mapButton.setFont(new Font("맑은 고딕", Font.PLAIN, 10));
		mapButton.setBackground(Color.WHITE);
		mapButton.setBorderPainted(false);
		mapButton.setFocusPainted(false);
		contentPane.add(mapButton);
		

		JButton changeButton = new JButton("회원정보수정");
		changeButton.setBounds(12, 43, 111, 23);
		contentPane.add(changeButton);

		JButton CommentButton = new JButton("덧글관리");
		CommentButton.setBounds(130, 43, 111, 23);
		contentPane.add(CommentButton);
		
		
		homeButton.setHorizontalAlignment(SwingConstants.LEFT);
		homeButton.setFont(new Font("맑은 고딕", Font.PLAIN, 10));
		homeButton.setBackground(Color.WHITE);
		homeButton.setBorderPainted(false);
		homeButton.setFocusPainted(false);

		orderPageButton.setHorizontalAlignment(SwingConstants.LEFT);
		orderPageButton.setFont(new Font("맑은 고딕", Font.PLAIN, 10));
		orderPageButton.setBackground(Color.WHITE);
		orderPageButton.setBorderPainted(false);
		orderPageButton.setFocusPainted(false);

		logoutButton.setHorizontalAlignment(SwingConstants.LEFT);
		logoutButton.setFont(new Font("맑은 고딕", Font.PLAIN, 10));
		logoutButton.setBackground(Color.WHITE);
		logoutButton.setBorderPainted(false);
		
		changeButton.setBackground(new Color(25, 106, 179));
		changeButton.setForeground(Color.WHITE);
		changeButton.setFont(new Font("맑은 고딕", Font.BOLD, 12));

		CommentButton.setBackground(new Color(25, 106, 179));
		CommentButton.setForeground(Color.WHITE);
		CommentButton.setFont(new Font("맑은 고딕", Font.BOLD, 12));

		panel = new JPanel();
		panel.setOpaque(false);

		scrollpane.setViewportView(panel);
		
		homeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new ClientHome();
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
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				new Map();
			}
		});
		changeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new UserInfoUpdate();
			}
		});
		CommentButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new MyReviewPage();
			}
		});
		

		// 사이즈 정보를 가지고 있는 객체를 이용해 패널의 사이즈 지정

		DeleteReview();

		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
	}

	private void DeleteReview() {
		Dimension size = new Dimension();// 사이즈를 지정하기 위한 객체 생성

		// 객체의 사이즈를 지정

		panel.setPreferredSize(size);
		panel.setLayout(null);

		List<Mypage> result;
		MemberDao memberdao = MemberDao.getInstance();
		result = memberdao.select();
		int k = result.size();
		for (int i = 0; i < k; i++) {
			int d = 10 + (148 * i);
			/*
			 * */

			JPanel panel2 = new JPanel();
			panel2.setBorder(new MatteBorder(1, 0, 1, 1, (Color) new Color(0, 0, 0)));
			panel2.setBackground(Color.WHITE);
			panel2.setBounds(0, d, 752, 147);
			panel.add(panel2);
			panel2.setLayout(null);

			JLabel lblBookName = new JLabel("책제목");
			lblBookName.setBounds(32, 21, 57, 15);
			panel2.add(lblBookName);
			lblBookName.setFont(new Font("맑은 고딕", Font.PLAIN, 12));

			JLabel lblGrade = new JLabel("평점");
			lblGrade.setBounds(320, 21, 40, 15);
			panel2.add(lblGrade);
			lblGrade.setFont(new Font("맑은 고딕", Font.PLAIN, 12));

			JLabel lblBookReview = new JLabel("서평");
			lblBookReview.setBounds(32, 61, 57, 15);
			panel2.add(lblBookReview);
			lblBookReview.setFont(new Font("맑은 고딕", Font.PLAIN, 12));

			JButton btnReviewDelete = new JButton("삭제");
			btnReviewDelete.setBounds(646, 10, 70, 25);
			panel2.add(btnReviewDelete);
			btnReviewDelete.setFont(new Font("맑은 고딕", Font.BOLD, 12));
			btnReviewDelete.setBackground(new Color(25, 106, 179));
			btnReviewDelete.setForeground(Color.WHITE);

			JTextField tfBookname = new JTextField();
			tfBookname.setEditable(false);
			tfBookname.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
			tfBookname.setForeground(new Color(0, 0, 0));
			tfBookname.setBounds(79, 18, 229, 21);
			panel2.add(tfBookname);
			tfBookname.setColumns(10);
			tfBookname.setText(result.get(i).getBookname());
			
			JLabel lblreviewNum = new JLabel();
			lblreviewNum.setBounds(0,0,0,0);
			panel2.add(lblreviewNum);
			lblreviewNum.setText(Integer.toString(result.get(i).getReviewnum()));

			JTextField tfGrade = new JTextField();
			tfGrade.setEditable(false);
			tfGrade.setBounds(360, 18, 156, 21);
			panel2.add(tfGrade);
			tfGrade.setColumns(10);
			tfGrade.setText(Integer.toString(result.get(i).getStar()));

			JScrollPane scrollPaneTA = new JScrollPane();
			scrollPaneTA.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPaneTA.getVerticalScrollBar().setUnitIncrement(20);
			scrollPaneTA.setBounds(79, 57, 639, 80);
			panel2.add(scrollPaneTA);

			JTextArea taBookReview = new JTextArea();
			taBookReview.setLineWrap(true);
			taBookReview.setEditable(false);
			scrollPaneTA.setViewportView(taBookReview);
			taBookReview.setText(result.get(i).getComments());
			size.setSize(1000, 60 + d + 100);

			btnReviewDelete.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					int lblreviewNumInfo = Integer.parseInt(lblreviewNum.getText());
					System.out.println(lblreviewNum.getText());
					MemberDao memberdao2 = MemberDao.getInstance();
					int result = memberdao2.reviewDelete(lblreviewNumInfo);
					if (result == 1) {
						System.out.println("삭제완료");

						panel2.removeAll();

					}
					// dispose();

					MyReviewPageDefault();

				}

			});
			


		}
		
		
	}


}