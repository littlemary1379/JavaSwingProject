package adminpage;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

@SuppressWarnings("serial")
public class Admin extends JFrame{
	public Admin() {
		setTitle("관리자 모드");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JButton btnInsert = new JButton("등록");
		btnInsert.setBackground(new Color(220, 241, 247));
		btnInsert.setFont(new Font("굴림", Font.BOLD, 30));
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnInsert.setBounds(0, 0, 382, 561);
		getContentPane().add(btnInsert);
		
		JButton btnSearch = new JButton("검색");
		btnSearch.setBackground(new Color(210, 239, 247));
		btnSearch.setFont(new Font("굴림", Font.BOLD, 30));
		btnSearch.setBounds(381, 0, 403, 561);
		getContentPane().add(btnSearch);
		setVisible(true);
		
		btnInsert.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new AdminInsert();
				
			}
		});
		
		btnSearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new AdminSearch();
				
			}
		});
		setLocationRelativeTo(null);
		setVisible(true);
	}

}
