package com.yummymap.www.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.yummymap.www.DB.WebDBCP;
import com.yummymap.www.SQL.JoinSQL;
import com.yummymap.www.vo.MemberVO;

/**
 * 이 클래스는 로그인처리와 회원가입 처리시 필요한 DB작업을 전담한다.
 * 
 * @since	2020/05/22
 *
 */

public class JoinDAO {
	WebDBCP db;
	JoinSQL jsql;
	Connection con;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public JoinDAO() {
		db = new WebDBCP();
		jsql = new JoinSQL();
	}
	
	// 로그인처리시 일치하는 데이터가 있는지 확인해주는 메소드입니다.
	// 일치하면 1, 불일치하면 0을 반환해준다.
	public int checkLogin(String userId, String userPw) {
		int cnt = 0;
		con = db.getConnection();
		String sql = jsql.getSQL(jsql.CHECK_LOGIN);
		pstmt = db.getPreparedStatement(con, sql);
		try {
			pstmt.setString(1, userId);
			pstmt.setString(2, userPw);
			rs = pstmt.executeQuery();
			rs.next();
			cnt = rs.getInt("cnt");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		return cnt;
	}
	// 회원 1명의 회원가입 데이터베이스 작업을 처리해주는 메소드입니다.
	// 매개변수는 memverVO 인스턴스를 받습니다.
	public int joinNewMember(MemberVO vo) {
		int cnt = 0;
		con = db.getConnection();
		String sql = jsql.getSQL(jsql.ADD_MEMB);
		pstmt = db.getPreparedStatement(con, sql);
		try {
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getId());
			pstmt.setString(3, vo.getPw());
			pstmt.setString(4, vo.getTel());
			pstmt.setString(5, vo.getMail());
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close(pstmt);
			db.close(con);
		}
		return cnt;
	}
	
	//아이디 중복체크를 확인해주는 메소드입니다.
	public int idCheck(String id) {
		int cnt = 0;
		con = db.getConnection();
		String sql = jsql.getSQL(jsql.ID_CHECK);
		pstmt = db.getPreparedStatement(con, sql);
		try {
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			rs.next();
			cnt = rs.getInt("cnt");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		return cnt;
	}
	
	//아이디 찾기 전담 함수 
	public String searchId(String name , String mail) {
		String id = "";
		
		con = db.getConnection();
		
		String sql = jsql.getSQL(jsql.ID_SEARCH);
		
		pstmt = db.getPreparedStatement(con, sql);
		
		try {
			pstmt.setString(1, name);
			pstmt.setString(2, mail);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				id = rs.getString("mid");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		
		return id;
	}
	
	//비밀번호 찾기 전담 함수 
	public int searchPass(String id , String mail) {
		int cnt = 0;
		
		con = db.getConnection();
		
		String sql = jsql.getSQL(jsql.PASS_SEARCH);
		
		pstmt = db.getPreparedStatement(con, sql);
		
		try {
			pstmt.setString(1, id);
			pstmt.setString(2, mail);
			rs = pstmt.executeQuery();
			rs.next();
			cnt = rs.getInt("cnt");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		
		return cnt;
	}
	//임시 비밀번호 저장 함수
	public int getTmpPass(String pass , String id) {
		int cnt = 0;
		
		con = db.getConnection();
		
		String sql = jsql.getSQL(jsql.UPDATE_USER_TEMPPASS);
		
		pstmt = db.getPreparedStatement(con, sql);
		
		try {
			pstmt.setString(1, pass);
			pstmt.setString(2, id);
			cnt = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return cnt;
	}
}
