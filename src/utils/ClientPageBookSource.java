package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import datamodel.ClientPageBook;
import datamodel.DBConnection;

public class ClientPageBookSource {
	
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	ArrayList<ClientPageBook> cb_arrayBooks = new ArrayList<>();
	public String dbname;
	public String dbsummary;
	
	
	ClientPageBook getclientPageBook() {
		ClientPageBook clientPageBook = new ClientPageBook();
		try {
			clientPageBook.setName(rs.getString("bookname"));
			clientPageBook.setSummary(rs.getString("summary"));
			clientPageBook.getName();
			clientPageBook.getSummary();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return clientPageBook;
	}

	public void RecommendBookList() {
		String mainQuery = "select bookname,summary from bookinfo";

		try {
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(mainQuery);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				System.out.println(rs.getString("bookname"));
				cb_arrayBooks.add(getclientPageBook());
			}
			Collections.shuffle(cb_arrayBooks);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void RecommendBookList(String category) {
		String Query = "select bookname,summary from bookinfo where category='" + category + "'";
		try {
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(Query);
			rs = pstmt.executeQuery();

			cb_arrayBooks = new ArrayList<>();

			while (rs.next()) {

				System.out.println(rs.getString("bookname"));
				cb_arrayBooks.add(getclientPageBook());
			}
			Collections.shuffle(cb_arrayBooks);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public int randomindex() {
		int index=(int) (Math.random()*cb_arrayBooks.size());
		System.out.println(index);
		return index;
	}
	public String getdbname(int i) {
		dbname = cb_arrayBooks.get(i).name;
		System.out.println();
		return dbname;
	}

	public String getdbsummary(int i) {

		dbsummary = cb_arrayBooks.get(i).summary;

		return dbsummary;
	}

	public void printBook_obj_array() {
		for (ClientPageBook clientPageBook : cb_arrayBooks) {
			System.out.println(clientPageBook.name);

		}
	}

}
