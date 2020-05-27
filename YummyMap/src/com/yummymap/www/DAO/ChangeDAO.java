package com.yummymap.www.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.yummymap.www.DB.WebDBCP;
import com.yummymap.www.SQL.ChangeSQL;
import com.yummymap.www.vo.member.*;;

public class ChangeDAO {

	WebDBCP db;
	Connection con;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;

	ChangeSQL bSQL;

	public ChangeDAO() {
		db = new WebDBCP();
		bSQL = new ChangeSQL();

	}

	public ChangeVO getMemberInfo(String mid) {
		ChangeVO vo = new ChangeVO();
		con = db.getConnection();

		String sql = bSQL.getSQL(bSQL.SEL_LIST);
		
		pstmt = db.getPreparedStatement(con, sql);

		try {
			pstmt.setString(1, mid);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				vo.setMno(rs.getString("mno"));
				vo.setMpw(rs.getString("mpw"));
				vo.setMname(rs.getString("mname"));
				vo.setMid(rs.getString("mid"));
				vo.setMtel(rs.getString("mtel"));
				vo.setMemail(rs.getString("memail"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		return vo;
	}
	
	
	// 회원의 비밀번호를 변경해주는 메소드입니다.
	// 매개변수로 변경될 비밀번호와 회원의 아이디를 입력받습니다.
	// 반환값은 성공시 1, 실패시0을 반환합니다.
	public int updateUserPW(String userPW, String userID) {
		int cnt = 0;
		con = db.getConnection();
		String sql = bSQL.getSQL(bSQL.UPDATE_PW);
		pstmt = db.getPreparedStatement(con, sql);
		try {
			pstmt.setString(1, userPW);
			pstmt.setString(2, userID);
			cnt = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.close(pstmt);
			db.close(con);
		}
		return cnt;
	}
	//회원의 비밀번호 꺼내와주는 메소드
	public int SEL_PW(String userPW, String userID) {
		int cnt =0;
		con = db.getConnection();
		String sql = bSQL.getSQL(bSQL.SEL_PW);
		pstmt = db.getPreparedStatement(con, sql);
		try {
			pstmt.setString(1, userPW);
			pstmt.setString(2, userID);
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
	//회원 탈퇴 해주는 메소드
	public int DropUser(String userID) {
		int cnt = 0;
		//커넥션 가져오고
		con = db.getConnection();
		//질의명령 가져오고
		String sql = bSQL.getSQL(bSQL.DROP_USER);
		System.out.println("*** dao sql : " + sql);
		System.out.println("*** dao id : " + userID);
		//pstmt 가져오고
		pstmt = db.getPreparedStatement(con, sql);
		try {
			pstmt.setString(1, userID);
			System.out.println("*** dao cnt1 : " + cnt);
			cnt = pstmt.executeUpdate();
			System.out.println("*** dao cnt2 : " + cnt);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			db.close(pstmt);
			db.close(con);
		}
		return cnt;
	}

}

