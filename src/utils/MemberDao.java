package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import datamodel.DBConnection;
import datamodel.Member;
import datamodel.Mypage;
import datamodel.UserModel;
import lombok.Data;



public class MemberDao {
	public MemberDao() {

	}
	private static MemberDao instance=new MemberDao();
	public static MemberDao getInstance() {
		return instance;
	}

	private Connection conn; //DB 연결 객체
	private PreparedStatement pstmt; //Query 작성 객체
	private ResultSet rs; //Query 결과 커서
	private Statement st;

	//성공 1, 실패 -1, 없음 0
	public int findByUsernameAndPassword(String id, String password) {
		//1. DB 연결
		conn = DBConnection.getConnection();

		try {
			//2. Query 작성
			pstmt = conn.prepareStatement("select * from userinfo where userid = ? and pwd = ?");

			//3. Query ? 완성 (index 1번 부터 시작)
			//setString, setInt, setDouble, setTimeStamp 등이 있음.
			pstmt.setString(1, id);
			pstmt.setString(2, password);

			//4. Query 실행
			//(1) executeQuery() = select = ResultSet 리턴
			//(2) executeUpdate() = insert, update, delete = 리턴 없음.
			rs = pstmt.executeQuery();


			if(rs.next()) { //next()함수는 커서를 한칸 내리면서 해당 행에 데이터가 있으면 true, 없으면 false 반환
				//결과가 있다는 것은 해당 아이디와 비번에 매칭되는 값이 있다는 뜻.
				return 1; //로그인 성공
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}


		return -1; //로그인 실패
	}
	public boolean search3(DefaultTableModel dt,  String field, List<Integer> tableNum) {
		conn = DBConnection.getConnection();
		try {
			String sql = "select userid,bookname,price,publisher,count,totalcount,orderid from orders where userid= '"+field+"'";
System.out.println("여긴들어갓을려나..");
			st = conn.createStatement();
			rs = st.executeQuery(sql);


			for (int i = 0; i < dt.getRowCount();) {
				dt.removeRow(0);
			}


			while (rs.next()) {
				Object data[] = { rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5),rs.getInt(6)
					
					 };

				dt.addRow(data);
				System.out.println(rs.getInt(7));
				tableNum.add(rs.getInt(7));
			
			}
			return true;

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return false;

	}
	//성공 1, 실패 -1,
	public int save(Member member) {
		conn = DBConnection.getConnection();

		try {
			System.out.println("12324524");
			pstmt = conn.prepareStatement("insert into userinfo values(usernum_seq.nextval,?,?,?,?,?,?,?)");
			pstmt.setString(1, member.getUserid());
			pstmt.setString(2, member.getPwd());
			pstmt.setString(3, member.getAge());
			pstmt.setString(4, member.getName());
			pstmt.setString(5, member.getEmail());
			pstmt.setString(6, member.getTel());
			pstmt.setString(7,"사용자");
			pstmt.executeUpdate(); //return값은 처리된 레코드의 개수

			return 1;
		} catch (Exception e) {
			e.printStackTrace();

		}
		return 0;

	}

	public int update(Member member) {
		conn = DBConnection.getConnection();

		try {
			pstmt = conn.prepareStatement("update userinfo set pwd=?, age=?, name=?, email=?, tel=? where userid=?");

			pstmt.setString(1, member.getPwd());
			pstmt.setString(2, member.getAge());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getEmail());
			pstmt.setString(5, member.getTel());
			pstmt.setString(6, member.getUserid());
			rs= pstmt.executeQuery();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	public List<Mypage> select() {
		List<Mypage> list = new ArrayList<>();
		conn = DBConnection.getConnection();
		String sql="select * from review where userid='"+UserModel.getID()+"' order by bookname";
		try {
			pstmt = conn.prepareStatement(sql);
			rs=pstmt.executeQuery(sql);
			while(rs.next()) {
				String id=rs.getString("userid");
				String bookname=rs.getString("bookname");
				int star = rs.getInt("grade");
				String comments = rs.getString("ment");
				int reviewnum = rs.getInt("reviewnum");

				Mypage my = new Mypage(id,bookname,star,comments,reviewnum);
				list.add(my);
			}


		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}
//////////////////////////////////////////////////////////////////
	public List<Mypage> select1(String bookname) {
		List<Mypage> list = new ArrayList<>();
		conn = DBConnection.getConnection();
		String sql="select * from review where bookname = ?" ;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,bookname);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				String id=rs.getString("userid");
				int star = rs.getInt("grade");
				String comments = rs.getString("ment");
				int reviewnum = rs.getInt("reviewnum");

				Mypage my = new Mypage(id,bookname,star,comments, reviewnum);
				list.add(my);
			}


		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	////////////////////////////////////////////////////////////////////
	public List<String> select2() {
		List<String> list3 = new ArrayList<>();
		conn = DBConnection.getConnection();
		String sql="select * from userinfo";
		try {
			pstmt = conn.prepareStatement(sql);
			rs=pstmt.executeQuery(sql);
			while(rs.next()) {
				String id=rs.getString("userid");
				list3.add(id);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list3;

	}

	//성공 Vector<Member>, 실패 null
	public Vector<Member> findByAll(){
		conn = DBConnection.getConnection();
		Vector<Member> members = new Vector<>();
		try {
			pstmt = conn.prepareStatement("select * from userinfo");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Member member = new Member();
				member.setUserid(rs.getString("userid"));
				member.setPwd(rs.getString("pwd"));
				member.setAge(rs.getString("age"));
				member.setName(rs.getString("name"));
				member.setEmail(rs.getString("email"));



				members.add(member);
			}
			return members;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	
	public int reviewDelete(int reviewnum) {
		conn = DBConnection.getConnection();

		try {
			pstmt = conn.prepareStatement("delete from review where reviewnum = ?");
			pstmt.setInt(1, reviewnum);
			pstmt.executeUpdate();
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public int ordersDelete(int seq) {
		System.out.println("ordersdelete 확인용");
		conn = DBConnection.getConnection();

		try {
			pstmt = conn.prepareStatement("delete from orders  where orderid =? ");
			pstmt.setInt(1, seq);
			pstmt.executeUpdate();
			System.out.println("seq : " + seq);
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}

}



