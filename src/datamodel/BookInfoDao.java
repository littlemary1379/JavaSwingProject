package datamodel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;

public class BookInfoDao {
	private BookInfoDao() {
	}

	private static BookInfoDao instance = new BookInfoDao();

	public static BookInfoDao getInstance() {
		return instance;
	}

	private Connection conn; // DB 연결 객체
	private PreparedStatement pstmt; // Query 작성 객체
	private Statement st;
	private ResultSet rs; // Query 결과 커서

	// 성공 1, 실패 -1, 없음 0

	public int save(BookInfo bookinfo) {
		conn = DBConnection.getConnection();
		System.out.println(bookinfo.getBookid());
		try {
			String sql = "insert into bookinfo values(?,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			System.out.println(sql);
			pstmt.setInt(1, bookinfo.getBookid());
			pstmt.setString(2, bookinfo.getBookname());
			pstmt.setString(3, bookinfo.getAuthor());
			pstmt.setLong(4, bookinfo.getPrice());
			pstmt.setString(5, bookinfo.getPublicationDate());
			pstmt.setLong(6, bookinfo.getISBN());
			pstmt.setString(7, bookinfo.getPublisher());
			pstmt.setString(8, bookinfo.getCategory());
			pstmt.setString(9, bookinfo.getSummary());
			pstmt.executeUpdate(); // return값은 처리된 레코드의 개수
			return 1;
		} catch (Exception e) {
			//e.printStackTrace();
			return -1;
		}

	}

	
	public int delete(int bookId) {
		conn = DBConnection.getConnection();

		try {
			pstmt = conn.prepareStatement("delete from bookinfo  where bookid = ?");
			pstmt.setInt(1, bookId);
			pstmt.executeUpdate();
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}

	// LIKE 문을 사용하려면 PreparedStatement 사용할수없음
	public int search(DefaultTableModel dt, String comBox, String field) {
		conn = DBConnection.getConnection();
		
		try {
			System.out.println("트라이캐치시작");
			String sql = "select * from bookinfo where " + comBox.trim() + " LIKE '%" + field.trim() + "%'";
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			System.out.println(sql);
			
			
			for (int i = 0; i < dt.getRowCount();) {
				System.out.println("왜없애지?");
				dt.removeRow(0);
			}
			
			
			while (rs.next()) {
				Object data[] = { rs.getInt(1), rs.getString(2), rs.getString(3), rs.getLong(4), rs.getString(5),
						rs.getLong(6), rs.getString(7), rs.getString(8), rs.getString(9)};

				dt.addRow(data);
		System.out.println("확인용");
			}
			
			if(dt.getRowCount() == 0) {
				System.out.println("이걸리턴받앗나요?");
				return -1;
			}


		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return 1;

	}
	
	
	public void searchAll(DefaultTableModel dt) {
		conn = DBConnection.getConnection();
		
		try {
			String sql = "select * from bookinfo order by bookid";
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			BookInfo bookInfo2 = null;
			for (int i = 0; i < dt.getRowCount();) {
				dt.removeRow(0);
			}
			

			while (rs.next()) {
				Object data[] = { rs.getInt(1), rs.getString(2), rs.getString(3), rs.getLong(4), rs.getString(5),
						rs.getLong(6), rs.getString(7), rs.getString(8), rs.getString(9) };

				dt.addRow(data);
			}
			
			
			

		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		

	}
	
	public int searchIdCheck(int Bookid) {
		conn = DBConnection.getConnection();
		try {
			String sql = "select bookid from bookinfo where bookid =?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, Bookid);
				
			rs = pstmt.executeQuery(); 
			
			System.out.println("rs:"+rs);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
		return 1;
	}

	public int update(BookInfo bookinfo, int oriBookid) {
		conn = DBConnection.getConnection();
		try {
			String sql = "update bookinfo set bookid=? ,bookname=?, author=?, price=?, PublicationDate=?, ISBN=?, publisher=?, category=?, summary=? where bookid=?";
			pstmt = conn.prepareStatement(sql);
			// System.out.println(sql);
			// or author=? or price=? or ISBN=? or publisher=?
			// bookid=? or name =? or author=? or price=? or PublicationDate=? or ISBN=? or
			// publisher=? or category=? or summary=?

			pstmt.setInt(1, bookinfo.getBookid());
			pstmt.setString(2, bookinfo.getBookname());
			pstmt.setString(3, bookinfo.getAuthor());
			pstmt.setLong(4, bookinfo.getPrice());
			pstmt.setString(5, bookinfo.getPublicationDate());
			pstmt.setLong(6, bookinfo.getISBN());
			pstmt.setString(7, bookinfo.getPublisher());
			pstmt.setString(8, bookinfo.getCategory());
			pstmt.setString(9, bookinfo.getSummary());
			pstmt.setInt(10, oriBookid);

			pstmt.executeUpdate(); // return값은 처리된 레코드의 개수
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;

	}


}