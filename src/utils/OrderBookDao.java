package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import datamodel.DBConnection;
import datamodel.UserModel;

public class OrderBookDao {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;


	public OrderBookDao(String bookname, int count) {
		String Query="select bookid, bookname, price,publisher from bookInfo where bookname='"+bookname+"'";
		try {
			conn=DBConnection.getConnection();

			pstmt=conn.prepareStatement(Query);
			rs=pstmt.executeQuery();

			System.out.println(count);
			rs.next();

			String dbbookname=rs.getString("bookname");
			Integer dbbookid=rs.getInt("bookid");
			Integer dbprice=rs.getInt("price");
			String dbpublisher = rs.getString("publisher");




			int totalPrice=dbprice*count;
			System.out.println("아이디: " +UserModel.getID());
			System.out.println("책 이름: "+dbbookname);
			System.out.println("책 번호: "+dbbookid);
			System.out.println("여기까지왓나?1");
			System.out.println("책 가격: "+dbprice);
			System.out.println("카운터 :" + count);
			System.out.println("총가격 : "+ totalPrice);
			System.out.println("출판사 :"+dbpublisher);
			pstmt=conn.prepareStatement("insert into orders values(orderid_SEQ.nextval,?,?,?,?,?,?,?)");
			System.out.println("여기까지왓나?1");
			pstmt.setString(1, UserModel.getID());
			pstmt.setInt(2, dbbookid);
			pstmt.setString(3,dbbookname);
			pstmt.setString(4, dbpublisher);
			pstmt.setInt(5,dbprice);
			pstmt.setInt(6,count);
			pstmt.setInt(7,totalPrice);
			pstmt.executeUpdate();





		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
