package yjc.wdb.db;

import java.sql.*;

import yjc.wdb.domain.Member;

public class MemberDAO {

	private static MemberDAO dao = null;
	
	private String url="jdbc:mariadb://localhost:33060/test";
	private String dbid = "root";
	private String dbpw = "1234";
	
	public void registerMember(Member m) throws Exception {
		//jdbc driver loading
		Class.forName("org.mariadb.jdbc.Driver");
		//db server Connection 얻어서
		Connection con = DriverManager.getConnection(url, dbid, dbpw);
		try {
			//Statement 객체 또는 PreparedStatement 객체 생성해서
			String sql = "insert into member values(?, ?, ?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, m.getId());
			pstmt.setString(2, m.getPasswd());
			pstmt.setString(3,  m.getPhone());
			//SQL문 실행하고
			pstmt.executeUpdate();			
		} catch(Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			//Connection 해제
			con.close();			
		}
		System.out.println("Insert 성공!!");
	}
	
	public void deleteMember(Member m) throws Exception {
		//jdbc driver loading
		Class.forName("org.mariadb.jdbc.Driver");
		//db server Connection 얻어서
		Connection con = DriverManager.getConnection(url, dbid, dbpw);
		try {
			//Statement 객체 또는 PreparedStatement 객체 생성해서
			String sql = "delete from member where id=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, m.getId());
			//SQL문 실행하고
			pstmt.executeUpdate();			
		} catch(Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			//Connection 해제
			con.close();			
		}
		System.out.println("삭제 성공!!");
	}
	
	public void viewMember(Member m) throws Exception {
		//jdbc driver loading
		Class.forName("org.mariadb.jdbc.Driver");
		//db server Connection 얻어서
		Connection con = DriverManager.getConnection(url, dbid, dbpw);
		try {
			//Statement 객체 또는 PreparedStatement 객체 생성해서
			String sql = "delete from member where id=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, m.getId());
			//SQL문 실행하고
			pstmt.executeUpdate();			
		} catch(Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			//Connection 해제
			con.close();			
		}
		System.out.println("삭제 성공!!");
	}
	
	
	public int confirmMember(Member m) throws Exception {
		//jdbc driver loading
		Class.forName("org.mariadb.jdbc.Driver");
		//db server Connection 얻어서
		Connection con = DriverManager.getConnection(url, dbid, dbpw);
		
		// 아이디 중복 여부 변수 생성
		int x = -1;
		try {
			//Statement 객체 또는 PreparedStatement 객체 생성해서
			String sql = "select * from member where id= ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, m.getId());
			//SQL문 실행하고
			ResultSet rs = pstmt.executeQuery();		
			
			if(rs.next())
				x=-1; //같은 아이디 있음
			else
				x=1; //같은 아이디 없음
			
			
		} catch(Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			//Connection 해제
			con.close();			
		}
		return x;
	}
	
	
	public int loginMember(Member m) throws Exception {
		//jdbc driver loading
		Class.forName("org.mariadb.jdbc.Driver");
		//db server Connection 얻어서
		Connection con = DriverManager.getConnection(url, dbid, dbpw);
		
		// 아이디 중복 여부 변수 생성
		int x = -1;
		
		String pass = m.getPasswd();
		
		try {
					
			//Statement 객체 또는 PreparedStatement 객체 생성해서
			String sql = "select passwd from member where id = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, m.getId());
			//SQL문 실행하고
			ResultSet rs = pstmt.executeQuery();		
			
			if(rs.next()){// 해당아이디가 있으면 수행
				String dbpasswd = rs.getString("passwd");
				if(pass.equals(dbpasswd)){
					x = 1; //인증성공
				}else{
					x = 0; //비밀번호 틀림
				}
			}else{//해당 아이디가 없으면 수행
				x = -1;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			//Connection 해제
			con.close();			
		}
	return x;
	}
	
	private MemberDAO() {
		
	}
	
	// MemberDAO 객체를 반환하는 메소드를 만들자.
	public static MemberDAO getInstance() {
		//
		if(dao == null)
			dao = new MemberDAO();
		
		return dao;
	}
	
}
