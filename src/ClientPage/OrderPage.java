package ClientPage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import datamodel.BookInfoDao;
import datamodel.UserModel;
import loginpage.Login;
import utils.MemberDao;

import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;

public class OrderPage extends JFrame {
	private JTextField textField;
	private String ComBoxName[] = { "Bookid", "�̸�", "����", "����", "ISBN", "���ǻ�" };
	private JPanel contentPane;
	private String TableColumnName[] = { "������", "����", "����", "���ǻ�", "���űǼ�", "�ѱ��Ű���" };
	private JButton deleteButton;
	private JPanel panel;
	DefaultTableModel dt = new DefaultTableModel(TableColumnName, 0);
	List<Integer> tableNum = new ArrayList<>();

	private JTable table_1;

	/**
	 * Create the frame.
	 */
	@SuppressWarnings("serial")
	class newWindow extends JFrame {
		// ��ư�� �������� ��������� �� â�� ������ Ŭ����
		newWindow() {
			setTitle("����â�Դϴ�.");
			// ����, ���⼭ setDefaultCloseOperation() ���Ǹ� ���� ���ƾ� �Ѵ�
			// �����ϰ� �Ǹ� �� â�� ������ ��� â�� ���α׷��� ���ÿ� ������
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setLocationRelativeTo(null);
			setBounds(100, 100, 250, 176);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);

			JButton btnNewButton = new JButton("YES");
			btnNewButton.setBounds(35, 79, 78, 32);
			contentPane.add(btnNewButton);

			JButton btnNo = new JButton("NO");
			btnNo.setBounds(125, 79, 78, 32);
			contentPane.add(btnNo);

			JLayeredPane layeredPane = new JLayeredPane();
			layeredPane.setBounds(52, 10, 1, 1);
			contentPane.add(layeredPane);

			JLabel lblNewLabel = new JLabel("\uC8FC\uBB38 \uD558\uC2DC\uACA0\uC2B5\uB2C8\uAE4C?");
			lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
			lblNewLabel.setFont(new Font("����", Font.PLAIN, 17));
			lblNewLabel.setBounds(44, 17, 168, 37);
			contentPane.add(lblNewLabel);
			setVisible(true);
			setLocationRelativeTo(null);
			///////////////////////////////////

			btnNo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null, "�������");
					dispose();
					
				}
			});
btnNewButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					MemberDao memberdao2 = MemberDao.getInstance();
					
					int result1 = memberdao2.getInstance().ordersDelete(tableNum.get(table_1.getSelectedRow()));
					tableNum.remove(table_1.getSelectedRow());
					panel.removeAll();
				
					JOptionPane.showMessageDialog(null, "��������");
					OrderPage1();
					dispose();
				}
			});
			
		

		}

		//

	}

	public OrderPage() {
		OrderPage1();
	}

	public void OrderPage1() {
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton homeButton = new JButton("HOME");

		homeButton.setBounds(12, 10, 71, 23);
		homeButton.setHorizontalAlignment(SwingConstants.LEFT);
		homeButton.setFont(new Font("���� ���", Font.PLAIN, 10));
		homeButton.setBackground(Color.WHITE);
		homeButton.setBorderPainted(false);
		homeButton.setFocusPainted(false);
		contentPane.add(homeButton);
		
		JButton myPageButton = new JButton("MYPAGE");
		myPageButton.setBounds(83, 10, 82, 23);
		myPageButton.setHorizontalAlignment(SwingConstants.LEFT);
		myPageButton.setFont(new Font("���� ���", Font.PLAIN, 10));
		myPageButton.setBackground(Color.WHITE);
		myPageButton.setBorderPainted(false);
		myPageButton.setFocusPainted(false);
		contentPane.add(myPageButton);

		JButton orderPageButton = new JButton("�ֹ�������");
		orderPageButton.setBounds(165, 10, 92, 23);
		orderPageButton.setHorizontalAlignment(SwingConstants.LEFT);
		orderPageButton.setFont(new Font("���� ���", Font.PLAIN, 10));
		orderPageButton.setBackground(Color.WHITE);
		orderPageButton.setBorderPainted(false);
		orderPageButton.setFocusPainted(false);
		contentPane.add(orderPageButton);

		JButton logoutButton = new JButton("�α׾ƿ�");
		logoutButton.setBounds(257, 10, 82, 23);
		logoutButton.setHorizontalAlignment(SwingConstants.LEFT);
		logoutButton.setFont(new Font("���� ���", Font.PLAIN, 10));
		logoutButton.setBackground(Color.WHITE);
		logoutButton.setBorderPainted(false);
		logoutButton.setFocusPainted(false);
		contentPane.add(logoutButton);

		JButton orderButton = new JButton("����");
		orderButton.setBounds(650, 492, 70, 30);
		orderButton.setForeground(Color.WHITE);
		orderButton.setFont(new Font("���� ���", Font.BOLD, 12));
		orderButton.setBackground(new Color(25, 106, 179));
		contentPane.add(orderButton);

		panel = new JPanel();
		panel.setBounds(65, 64, 657, 418);
		contentPane.add(panel);
		panel.setLayout(null);
		dt = new DefaultTableModel(TableColumnName, 0) {

			public boolean isCellEditable(int i, int c) {
				return false;
			}
		};
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 657, 418);
		panel.add(scrollPane);

		table_1 = new JTable(dt);
		table_1.setRowHeight(25);
		scrollPane.setViewportView(table_1);

		deleteButton = new JButton("����");
		deleteButton.setBounds(570, 492, 70, 30);
		deleteButton.setForeground(Color.WHITE);
		deleteButton.setFont(new Font("���� ���", Font.BOLD, 12));
		deleteButton.setBackground(new Color(25, 106, 179));
		contentPane.add(deleteButton);

		// ����â
		orderButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				new newWindow();

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

		OrderPage2();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public void OrderPage2() {

		boolean result;

		System.out.println("�����");
		// System.out.println(getComboBox);

		String field = UserModel.getID();
		System.out.println(field + "<--�̳��� field");
		System.out.println(UserModel.getID() + "<--�̳��� UserModer.getID");
		MemberDao memberdao = MemberDao.getInstance();
		result = memberdao.search3(dt, field, tableNum);

		if (result == false) {
			JOptionPane.showMessageDialog(null, "���Ÿ���� �����ϴ�.");
			// dispose();
		}

		deleteButton.addActionListener(new ActionListener() {
			int result1;

			@Override
			public void actionPerformed(ActionEvent e) {
//				String userId = UserModel.getID();
//				System.out.println(userId + "<--�������̵�� �̰�");
				MemberDao memberdao2 = MemberDao.getInstance();
				result1 = memberdao2.getInstance().ordersDelete(tableNum.get(table_1.getSelectedRow()));
				tableNum.remove(table_1.getSelectedRow());
                System.out.println(result1);
				if (result1 == 1) {
					JOptionPane.showMessageDialog(null, "���� �Ϸ�");
					panel.removeAll();

//				new OrderPage();
//				dispose();

				} else {
					JOptionPane.showMessageDialog(null, "���� ����");

				}
				OrderPage1();

			}
		});

	}

}
