package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import datamodel.DBConnection;

public class FindIDSourse {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public void FindingID(String name, String email) {
		try {
			String query="select userid,name,email from userinfo where name='"+name+"'and email='"+email+"'";
			
			conn=DBConnection.getConnection();
			pstmt=conn.prepareStatement(query);
			rs=pstmt.executeQuery();
			     
            if(rs.next()) {      
                String DBname=rs.getString("name");
                String DBemail=rs.getString("email");
                String DBsend=rs.getString("userID");
            	
            	SendMail sendMail=new SendMail();
            	sendMail.sendingMail("ID", DBemail, DBsend, DBname);

            }else{
	            JOptionPane.showMessageDialog(null, "���ϰ� �Է��Ͻ� ������ ��ġ�ϴ� ������ �����ϴ�.");
            }
			
		} catch (Exception e) {
			e.getStackTrace();
		}
	}	
}
