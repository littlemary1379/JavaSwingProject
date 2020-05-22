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

	private Connection conn; //DB ���� ��ü
	private PreparedStatement pstmt; //Query �ۼ� ��ü
	private ResultSet rs; //Query ��� Ŀ��
	private Statement st;

	//���� 1, ���� -1, ���� 0
	public int findByUsernameAndPassword(String id, String password) {
		//1. DB ����
		conn = DBConnection.getConnection();

		try {
			//2. Query �ۼ�
			pstmt = conn.prepareStatement("select * from userinfo where userid = ? and pwd = ?");

			//3. Query ? �ϼ� (index 1�� ���� ����)
			//setString, setInt, setDouble, setTimeStamp ���� ����.
			pstmt.setString(1, id);
			pstmt.setString(2, password);

			//4. Query ����
			//(1) executeQuery() = select = ResultSet ����
			//(2) executeUpdate() = insert, update, delete = ���� ����.
			rs = pstmt.executeQuery();


			if(rs.next()) { //next()�Լ��� Ŀ���� ��ĭ �����鼭 �ش� �࿡ �����Ͱ� ������ true, ������ false ��ȯ
				//����� �ִٴ� ���� �ش� ���̵�� ����� ��Ī�Ǵ� ���� �ִٴ� ��.
				return 1; //�α��� ����
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}


		return -1; //�α��� ����
	}
	public boolean search3(DefaultTableModel dt,  String field, List<Integer> tableNum) {
		conn = DBConnection.getConnection();
		try {
			String sql = "select userid,bookname,price,publisher,count,totalcount,orderid from orders where userid= '"+field+"'";
System.out.println("�����������..");
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
	//���� 1, ���� -1,
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
			pstmt.setString(7,"�����");
			pstmt.executeUpdate(); //return���� ó���� ���ڵ��� ����

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

	//���� Vector<Member>, ���� null
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
		System.out.println("ordersdelete Ȯ�ο�");
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



