package com.yummymap.www.DAO;
/**
 * 이 클래스는 game페이지 구현시 필요한 모든 데이터베이스 작업을 전담하는 클래스이다.
 * 
 * @author	김종형
 * @since	2020/05/21
 *
 */

import java.sql.*;
import java.util.*;

import com.yummymap.www.DB.WebDBCP;
import com.yummymap.www.SQL.GameSQL;

public class GameDAO {
	WebDBCP db;
	GameSQL gsql;
	Connection con;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public GameDAO() {
		db = new WebDBCP();
		gsql = new GameSQL();
	}
	
	// 모든 카테고리 리스트를 가져오는 메소드입니다.
	public List<String> getAllCateList() {
		List<String> list = new ArrayList<String>();
		con = db.getConnection();
		String sql = gsql.getSQL(gsql.SEL_ALL_CATE_LIST);
		stmt = db.getStatement(con);
		try {
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				list.add(rs.getString("category"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(stmt);
			db.close(con);
		}
		return list;
	}
	
	// 해당 카테고리의 모든 메뉴를 가져오는 메소드입니다.
	public List<String> getAllMenuListInCate(String categoryName){
		List<String> list = new ArrayList<String>();
		con = db.getConnection();
		String sql = gsql.getSQL(gsql.SEL_MENU_IN_CATE);
		pstmt = db.getPreparedStatement(con, sql);
		try {
			pstmt.setString(1, categoryName);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(rs.getString("menu"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		return list;
	}
}
