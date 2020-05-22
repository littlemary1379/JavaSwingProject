package loginpage;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import datamodel.Member;
import utils.MemberDao;
import utils.ResizeImage;


@SuppressWarnings("serial")
public class SignupMain extends JFrame {

	private JLabel jointext, id1, pwd1, age1, name1, email1, tel1,ErrorLabel1;
	private JPanel background,signupPanel;
	private JButton okbutton,homeButton;
	private JTextField idtext,pwdtext,agetext,nametext,emailtext,teltext;
	private ImageIcon icon,bicon;
	ResizeImage resizeImage=new ResizeImage();
	private String regAgeExp="^[0-9]+$";
	private String regEmailExp="^[a-zA-Z0-9_]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]+$";
	private String regTelExp="^[0-9]{3}-[0-9]{3,4}-[0-9]{4}$";

	public SignupMain() {
		initObject();
		initDesign();
		initListener();
	}
	
	void initObject() {
		icon = new ImageIcon("img/LoginBack2.jpg");
		bicon = new ImageIcon("img/home.png");
		signupPanel = new JPanel();
		jointext = new JLabel("회원가입");
		idtext = new JTextField();
		id1 = new JLabel("아이디");
		pwd1 = new JLabel("비밀번호");
		pwdtext = new JPasswordField();
		agetext = new JTextField();
		age1 = new JLabel("나이");
		nametext = new JTextField();
		name1 = new JLabel("이름");
		email1 = new JLabel("Email");
		tel1 = new JLabel("전화번호(000-0000-0000)");
		emailtext = new JTextField();
		teltext = new JTextField();
		okbutton = new JButton("회원가입");
		homeButton = new JButton(bicon);
		ErrorLabel1=new JLabel("호호홓");
	}
	
	void initDesign(){
		
		//design
		background = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(icon.getImage(), -50, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);
		setLocationRelativeTo(null);
		setContentPane(background);
		background.setLayout(null);
		setVisible(true);
		
		signupPanel.setForeground(Color.WHITE);
		signupPanel.setBackground(new Color(255,255,255,200));
		signupPanel.setBounds(47, 65, 248, 449);
		signupPanel.setLayout(null);
		
		jointext.setBounds(12, 20, 101, 20);
		jointext.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		
		idtext.setBounds(12, 83, 180, 20);
		idtext.setColumns(10);
		
		id1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		id1.setBounds(12, 56, 69, 20);
		
		pwd1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		pwd1.setBounds(12, 107, 69, 20);
		
		pwdtext.setBounds(12, 137, 180, 20);
		pwdtext.setColumns(10);
		
		agetext.setBounds(12, 193, 180, 20);
		agetext.setColumns(10);
		
		
		age1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		age1.setBounds(12, 167, 69, 20);
		
		nametext.setBounds(12, 253, 180, 20);
		signupPanel.add(nametext);
		nametext.setColumns(10);
		
		name1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		name1.setBounds(12, 223, 69, 20);
		
		emailtext.setBounds(12, 310, 180, 20);
		emailtext.setColumns(10);
		
		email1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		email1.setBounds(12, 283, 37, 20);
		
		tel1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		tel1.setBounds(12, 340, 200, 15);
		
		teltext.setColumns(10);
		teltext.setBounds(12, 365, 180, 20);
		
		okbutton.setForeground(Color.WHITE);
		okbutton.setBackground(new Color(51, 153, 153));
		okbutton.setFont(new Font("맑은 고딕", Font.PLAIN, 11));
		okbutton.setBounds(140, 407, 81, 20);
		
		homeButton.setBackground(new Color(255, 255, 255, 0));
		homeButton.setIcon(resizeImage.resizeIcon(bicon, 30, 30));
		homeButton.setBounds(12, 10, 30, 30);

		//add
		background.add(signupPanel);
		signupPanel.add(jointext);
		signupPanel.add(idtext);
		signupPanel.add(id1);
		signupPanel.add(name1);
		signupPanel.add(pwd1);
		signupPanel.add(pwdtext);
		signupPanel.add(agetext);
		signupPanel.add(age1);
		signupPanel.add(emailtext);
		signupPanel.add(email1);
		signupPanel.add(tel1);
		signupPanel.add(teltext);
		signupPanel.add(okbutton);
		background.add(homeButton);
		ErrorLabel1 = new JLabel("숫자값만 입력해주세요.");
		ErrorLabel1.setBounds(294, 258, 180, 15);
		//background.add(ErrorLabel1);
		
		ErrorLabel1.setFont(new Font("맑은 고딕", Font.BOLD, 9));
		ErrorLabel1.setForeground(Color.RED);
		
	}
	
	void initListener() {
		okbutton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MemberDao dao=MemberDao.getInstance();
				
				List<String>result3;
				result3=dao.select2();
				Member member=new Member();
				member.setUserid(idtext.getText());
				member.setPwd(pwdtext.getText());
				member.setAge(agetext.getText());
				member.setName(nametext.getText());
				member.setEmail(emailtext.getText());
				member.setTel(teltext.getText());
				int result = dao.save(member);
				System.out.println(result);
			
				if(result == 1&&!result3.contains(member.getUserid())) {
					JOptionPane.showMessageDialog(null, "회원가입이 완료되었습니다.");
					dispose();
					new Login();
				}else if(result3.contains(member.getUserid())) {
					JOptionPane.showMessageDialog(null, "동일한 ID가 존재합니다.");
				}else {
					JOptionPane.showMessageDialog(null, "회원가입이 실패하였습니다.");
				}	
			}
		});
		
		homeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Login();
			}
		});
		agetext.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {
				if(agetext.getText().matches(regAgeExp)||agetext.getText().equals("")) {
					System.out.println(agetext.getText().matches(regAgeExp));
				}else {
					agetext.setText("");
					JOptionPane.showMessageDialog(null, "숫자만 입력해주세요.");
					agetext.requestFocus(true);
					
				}
			}
			
			public void focusGained(FocusEvent e) {
				
			}
		});
		
		emailtext.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {
				if(emailtext.getText().matches(regEmailExp)||emailtext.getText().equals("")) {
					
				}else {
					emailtext.setText("");
					JOptionPane.showMessageDialog(null, "이메일 형식에 맞춰 입력해주세요.");
					emailtext.requestFocus(true);
				}
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				
			}
		});
		teltext.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				if(teltext.getText().matches(regTelExp)||teltext.getText().equals("")) {
					//System.out.println(teltext.getText().matches(regTelExp));
				}else {
					teltext.setText("");
					JOptionPane.showMessageDialog(null, "전화번호 형식에 맞춰 입력해주세요.\n(000-0000-0000)");
					agetext.requestFocus(true);
				}
				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}
}