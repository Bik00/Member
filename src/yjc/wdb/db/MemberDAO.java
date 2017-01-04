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
		//db server Connection ��
		Connection con = DriverManager.getConnection(url, dbid, dbpw);
		try {
			//Statement ��ü �Ǵ� PreparedStatement ��ü �����ؼ�
			String sql = "insert into member values(?, ?, ?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, m.getId());
			pstmt.setString(2, m.getPasswd());
			pstmt.setString(3,  m.getPhone());
			//SQL�� �����ϰ�
			pstmt.executeUpdate();			
		} catch(Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			//Connection ����
			con.close();			
		}
		System.out.println("Insert ����!!");
	}
	
	public void deleteMember(Member m) throws Exception {
		//jdbc driver loading
		Class.forName("org.mariadb.jdbc.Driver");
		//db server Connection ��
		Connection con = DriverManager.getConnection(url, dbid, dbpw);
		try {
			//Statement ��ü �Ǵ� PreparedStatement ��ü �����ؼ�
			String sql = "delete from member where id=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, m.getId());
			//SQL�� �����ϰ�
			pstmt.executeUpdate();			
		} catch(Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			//Connection ����
			con.close();			
		}
		System.out.println("���� ����!!");
	}
	
	public void viewMember(Member m) throws Exception {
		//jdbc driver loading
		Class.forName("org.mariadb.jdbc.Driver");
		//db server Connection ��
		Connection con = DriverManager.getConnection(url, dbid, dbpw);
		try {
			//Statement ��ü �Ǵ� PreparedStatement ��ü �����ؼ�
			String sql = "delete from member where id=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, m.getId());
			//SQL�� �����ϰ�
			pstmt.executeUpdate();			
		} catch(Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			//Connection ����
			con.close();			
		}
		System.out.println("���� ����!!");
	}
	
	
	public int confirmMember(Member m) throws Exception {
		//jdbc driver loading
		Class.forName("org.mariadb.jdbc.Driver");
		//db server Connection ��
		Connection con = DriverManager.getConnection(url, dbid, dbpw);
		
		// ���̵� �ߺ� ���� ���� ����
		int x = -1;
		try {
			//Statement ��ü �Ǵ� PreparedStatement ��ü �����ؼ�
			String sql = "select * from member where id= ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, m.getId());
			//SQL�� �����ϰ�
			ResultSet rs = pstmt.executeQuery();		
			
			if(rs.next())
				x=-1; //���� ���̵� ����
			else
				x=1; //���� ���̵� ����
			
			
		} catch(Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			//Connection ����
			con.close();			
		}
		return x;
	}
	
	
	public int loginMember(Member m) throws Exception {
		//jdbc driver loading
		Class.forName("org.mariadb.jdbc.Driver");
		//db server Connection ��
		Connection con = DriverManager.getConnection(url, dbid, dbpw);
		
		// ���̵� �ߺ� ���� ���� ����
		int x = -1;
		
		String pass = m.getPasswd();
		
		try {
					
			//Statement ��ü �Ǵ� PreparedStatement ��ü �����ؼ�
			String sql = "select passwd from member where id = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, m.getId());
			//SQL�� �����ϰ�
			ResultSet rs = pstmt.executeQuery();		
			
			if(rs.next()){// �ش���̵� ������ ����
				String dbpasswd = rs.getString("passwd");
				if(pass.equals(dbpasswd)){
					x = 1; //��������
				}else{
					x = 0; //��й�ȣ Ʋ��
				}
			}else{//�ش� ���̵� ������ ����
				x = -1;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			//Connection ����
			con.close();			
		}
	return x;
	}
	
	private MemberDAO() {
		
	}
	
	// MemberDAO ��ü�� ��ȯ�ϴ� �޼ҵ带 ������.
	public static MemberDAO getInstance() {
		//
		if(dao == null)
			dao = new MemberDAO();
		
		return dao;
	}
	
}
