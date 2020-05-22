package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import ClientPage.ClientHome;
import adminpage.Admin;
import datamodel.DBConnection;
import datamodel.UserModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@SuppressWarnings("serial")

public class LoginConnection extends JFrame{
	
	private Connection conn=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;
	private int fr=1;
	
	public void Loginconnect(String ID,String PW) {
		try {
			String query="select userid,pwd,age,name,email,tel,class from userinfo where userid='"+ID+"' and pwd='"+PW+"'";
			conn=DBConnection.getConnection();
			pstmt=conn.prepareStatement(query);
			rs=pstmt.executeQuery();
			
			if(rs.next()) { 
                String DBid=rs.getString("userID");
                String DBpwd=rs.getString("pwd");
                int DBage=Integer.parseInt(rs.getString("age"));
                String DBname=rs.getString("NAME");
                String DBemail=rs.getString("email");
                String DBtel=rs.getString("tel");
                String DBclass=rs.getString("class");

             
                if(DBclass.equals("관리자")) {
                	UserModel userModel=new UserModel();
                	userModel.user(DBid, DBpwd, DBage, DBname, DBemail, DBtel, DBclass);
                	new Admin();
                	
                }else {
                	UserModel userModel=new UserModel();
                	userModel.user(DBid, DBpwd, DBage, DBname, DBemail, DBtel, DBclass);
                	new ClientHome();
                }
			}else {
	            JOptionPane.showMessageDialog(null, "정확한 정보를 입력해주세요.");
	            setFr(0);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
