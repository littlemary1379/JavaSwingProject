package ClientPage;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import datamodel.DBConnection;
import datamodel.Member;
import datamodel.UserModel;
import loginpage.Login;
import utils.MemberDao;


@SuppressWarnings("serial")
public class UserInfoUpdate extends JFrame {

	private JPanel contentPane;
	private JTextField idText, pwdText, ageText, nameText, emailText, telText;
	private JButton homeButton, myPageButton, orderPageButton, logoutButton, updateButton,MyReviewButton,infoUpdateButton, mapButton;

	public UserInfoUpdate() {

		
		String Query = "select * from userinfo where userid=?";

		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(Query);
			pstmt.setString(1, UserModel.getID());
			ResultSet rs = pstmt.executeQuery();

			rs.next();

			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setBounds(100, 100, 800, 600);
			setLocationRelativeTo(null);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setBackground(Color.WHITE);
			contentPane.setLayout(null);
			setVisible(true);

			JPanel panel = new JPanel();
			panel.setBackground(Color.WHITE);
			panel.setBounds(169, 112, 380, 370);
			contentPane.add(panel);
			panel.setBorder(new LineBorder(new Color(216, 216, 216)));
			panel.setLayout(null);

			JLabel laID = new JLabel("아이디");
			laID.setBounds(45, 34, 57, 15);
			panel.add(laID);

			idText = new JTextField(rs.getString("userid"));// ()안에 로그인 한 사람의 아이디를넣으면 자동으로 기입되잇어요.
			idText.setEditable(false);
			idText.setBounds(101, 31, 197, 21);
			panel.add(idText);
			idText.setColumns(10);

			JLabel laPwd = new JLabel("비밀번호");
			laPwd.setBounds(45, 73, 57, 15);
			panel.add(laPwd);

			pwdText = new JPasswordField(rs.getString("pwd"));
			pwdText.setColumns(10);
			pwdText.setBounds(101, 70, 197, 21);
			panel.add(pwdText);

			JLabel laAge = new JLabel("나이");
			laAge.setBounds(45, 116, 57, 15);
			panel.add(laAge);

			ageText = new JTextField(rs.getString("age"));
			ageText.setColumns(10);
			ageText.setBounds(101, 114, 197, 21);
			panel.add(ageText);

			JLabel laName = new JLabel("이름");
			laName.setBounds(45, 159, 57, 15);
			panel.add(laName);

			nameText = new JTextField(rs.getString("name"));
			nameText.setColumns(10);
			nameText.setBounds(101, 156, 197, 21);
			panel.add(nameText);

			JLabel laEmail = new JLabel("이메일");
			laEmail.setBounds(45, 206, 57, 15);
			panel.add(laEmail);

			emailText = new JTextField(rs.getString("email"));
			emailText.setColumns(10);
			emailText.setBounds(101, 202, 197, 21);
			panel.add(emailText);

			JLabel laTel = new JLabel("전화번호");
			laTel.setBounds(45, 250, 57, 15);
			panel.add(laTel);

			telText = new JTextField(rs.getString("tel"));
			telText.setColumns(10);
			telText.setBounds(101, 247, 197, 21);
			panel.add(telText);

			updateButton = new JButton("수정");
			updateButton.setBounds(224, 315, 64, 25);
			panel.add(updateButton);

			homeButton = new JButton("HOME");
			homeButton.setBounds(12, 10, 71, 23);
			homeButton.setHorizontalAlignment(SwingConstants.LEFT);
			homeButton.setFont(new Font("맑은 고딕", Font.PLAIN, 10));
			homeButton.setBackground(Color.WHITE);
			homeButton.setBorderPainted(false);
			homeButton.setFocusPainted(false);
			
			contentPane.add(homeButton);

			orderPageButton = new JButton("주문페이지");
			orderPageButton.setBounds(165, 10, 92, 23);
			orderPageButton.setHorizontalAlignment(SwingConstants.LEFT);
			orderPageButton.setFont(new Font("맑은 고딕", Font.PLAIN, 10));
			orderPageButton.setBackground(Color.WHITE);
			orderPageButton.setBorderPainted(false);
			orderPageButton.setFocusPainted(false);
			contentPane.add(orderPageButton);

			logoutButton = new JButton("LOGOUT");
			logoutButton.setBounds(257, 10, 82, 23);
			logoutButton.setHorizontalAlignment(SwingConstants.LEFT);
			logoutButton.setFont(new Font("맑은 고딕", Font.PLAIN, 10));
			logoutButton.setBackground(Color.WHITE);
			logoutButton.setBorderPainted(false);
			logoutButton.setFocusPainted(false);
			contentPane.add(logoutButton);
			
			myPageButton = new JButton("MyPage");
			myPageButton.setBounds(83, 10, 82, 23);
			myPageButton.setHorizontalAlignment(SwingConstants.LEFT);
			myPageButton.setFont(new Font("맑은 고딕", Font.PLAIN, 10));
			myPageButton.setBackground(Color.WHITE);
			myPageButton.setBorderPainted(false);
			myPageButton.setFocusPainted(false);
			contentPane.add(myPageButton);
			
			infoUpdateButton = new JButton("회원정보 수정");
			infoUpdateButton.setBounds(12, 50, 122, 25);
			infoUpdateButton.setBackground(new Color(25, 106, 179));
			infoUpdateButton.setForeground(Color.WHITE);
			infoUpdateButton.setFont(new Font("맑은 고딕", Font.BOLD, 12));
			contentPane.add(infoUpdateButton);
			
			mapButton=new JButton("주변 서점 찾기");
			mapButton.setBounds(330, 10, 110, 23);
			mapButton.setHorizontalAlignment(SwingConstants.LEFT);
			mapButton.setFont(new Font("맑은 고딕", Font.PLAIN, 10));
			mapButton.setBackground(Color.WHITE);
			mapButton.setBorderPainted(false);
			mapButton.setFocusPainted(false);
			contentPane.add(mapButton);

			MyReviewButton = new JButton("서평관리");
			MyReviewButton.setBounds(135, 50, 122, 25);
			MyReviewButton.setBackground(new Color(25, 106, 179));
			MyReviewButton.setForeground(Color.WHITE);
			MyReviewButton.setFont(new Font("맑은 고딕", Font.BOLD, 12));
			contentPane.add(MyReviewButton);
			MyReviewButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					dispose();
					new MyReviewPage();
					
				}
			});

			updateButton.addActionListener(new ActionListener() {
				// 클릭시 반응

				@Override
				public void actionPerformed(ActionEvent e) {
					Member member = new Member();
					member.setUserid(idText.getText());
					member.setPwd(pwdText.getText());
					member.setAge(ageText.getText());
					member.setName(nameText.getText());
					member.setEmail(emailText.getText());
					member.setTel(telText.getText());

					MemberDao dao = MemberDao.getInstance();
					int result = dao.update(member);
					if (result == 1) {
						JOptionPane.showMessageDialog(null, "수정이 완료되었습니다.");
						// dispose(); 현재떠잇는 스윙을 지우는거
					} else if (result == 0) {
						JOptionPane.showMessageDialog(null, "수정이 실패하였습니다.");

					} else if (result == -1) {
						JOptionPane.showMessageDialog(null, "내용이 부적합합니다.");
					}
				}
			});

		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		initListener();
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

	}
}
