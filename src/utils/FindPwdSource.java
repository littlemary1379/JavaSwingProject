package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import datamodel.DBConnection;


public class FindPwdSource {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public void FindingPW(String name,String ID,String email) {
		
		try {
			String Query="select userID, pwd, email,name from userinfo "
					+ "where userid='"+ID+"' and name='"+name+"' and email='"+email+"'";
			conn=DBConnection.getConnection();
			pstmt=conn.prepareStatement(Query);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				String DBsend=rs.getString("pwd");
				String DBemail=rs.getString("email");
				String DBname=rs.getString("name");
				
            	SendMail sendMail=new SendMail();
            	sendMail.sendingMail("비밀번호", DBemail, DBsend, DBname);
			}else {
				JOptionPane.showMessageDialog(null, "귀하가 입력하신 정보와 일치하는 정보가 없습니다.");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
