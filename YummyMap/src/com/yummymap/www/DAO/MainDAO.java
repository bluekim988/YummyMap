package com.yummymap.www.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import com.yummymap.www.DB.WebDBCP;
import com.yummymap.www.SQL.MainSQL;
import com.yummymap.www.vo.ResVO;


public class MainDAO {
	
	WebDBCP db;
	MainSQL msql;
	Connection con;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public MainDAO() {
		db = new WebDBCP();
		msql = new MainSQL();
	}
	
	public List<ResVO> getList(String str) {
		List<ResVO> list = new ArrayList<ResVO>();
		con = db.getConnection();
		String sql = msql.getSQL(msql.SEL_RES);
		pstmt = db.getPreparedStatement(con, sql);
		try {
			pstmt.setString(1, str);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ResVO vo = new ResVO();
				vo.setResno(rs.getInt("resno"));
				vo.setResname(rs.getString("resname"));
				vo.setAddr(rs.getString("address"));
				vo.setTel(rs.getString("restel"));
				vo.setSubno(rs.getInt("subno"));
				vo.setMenu(rs.getString("menu"));
				vo.setMenuList();
				list.add(vo);
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
