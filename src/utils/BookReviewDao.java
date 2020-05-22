package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.omg.CORBA.DATA_CONVERSION;

import datamodel.DBConnection;

public class BookReviewDao {

	private BookReviewDao() {
	}

	private static BookReviewDao instance = new BookReviewDao();

	public static BookReviewDao getInstance() {
		return instance;
	}

	private Connection conn; // DB 연결 객체
	private PreparedStatement pstmt; // Query 작성 객체
	private Statement st;
	private ResultSet rs; // Query 결과 커서
	JRadioButton star1;
	JRadioButton star2;
	JRadioButton star3;
	JRadioButton star4;
	JRadioButton star5;

	// 성공 1, 실패 -1, 없음 0

	public int bookReview(String bookname) {
		conn = DBConnection.getConnection();
		try {
			String sql = "SELECT userid,grade,ment FROM review WHERE bookname = ?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, bookname);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				String userid = rs.getString("userid");
				int grade = rs.getInt("grade");
				String ment = rs.getString("ment");

				// laname.setText(userid);
				// textAreaReveiw.setText(ment);

				// System.out.println(id + " " + ment);
			}

			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}

	}

	public int BookReviewWrite(String bookname, String userID, int Grade, String Ment) {
		conn = DBConnection.getConnection();
		try {
			String sql = "INSERT INTO REVIEW(reviewnum,bookname,userID,Grade,Ment) VALUES(REVIEW_SEQ.nextval,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);

			if (Grade == 0) {
				// JOptionPane.showMessageDialog(null, "별점은 비워둘 수 없습니다.");
				return -1;
			} else {

				pstmt.setString(1, bookname);
				pstmt.setString(2, userID);
				pstmt.setInt(3, Grade);
				pstmt.setString(4, Ment);

				int result = pstmt.executeUpdate();// 버퍼 입력 , COMMIT이 됨

				return result;
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "등록하는 도중 오류가 발생했습니다.");
			e.printStackTrace();
		}
		return -1;
	}

}
