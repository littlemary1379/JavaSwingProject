package datamodel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnection {
	
	public static Connection getConnection() {
		Connection conn=null;
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String id="no24";
		String pw="no24";//bitc5600
		String driver="oracle.jdbc.driver.OracleDriver";
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url, id, pw);
			System.out.println("DB연결 완료");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("DB연결 실패");
		}
		return conn;
	}
	public static void close(Connection c, PreparedStatement p, 
			ResultSet r) {
		try {
			if(r!=null)r.close();
			if(p!=null)p.close();
			if(c!=null)c.close();
		}catch(Exception e) {}
	}
	public static void close(Connection c, PreparedStatement p) {
		try {
			if(p!=null)p.close();
			if(c!=null)c.close();
		}catch(Exception e) {}
	}

	public static void main(String[] args) {
		getConnection();
	}


}
