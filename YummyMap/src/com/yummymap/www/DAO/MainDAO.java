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
import com.yummymap.www.vo.ReviewVO;


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
	// 메뉴검색시 해당 식당 리스트를 가져오는 메소드입니다.
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
				int resno = rs.getInt("resno");
				vo.setResno(resno);
				vo.setResname(rs.getString("resname"));
				vo.setAddr(rs.getString("address"));
				vo.setTel(rs.getString("restel"));
				vo.setSubno(rs.getInt("subno"));
				vo.setMenu(rs.getString("menu"));
				vo.setMenuList();
				double avg = getResAVG(resno);
				vo.setAvg(avg);
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
	// 해당 식당의 상세정보를 가져오는 메소드입니다.
	public ResVO getResInfo(int resno) {
		ResVO vo = new ResVO();
		con = db.getConnection();
		String sql = msql.getSQL(msql.SEL_RES_INFO);
		pstmt = db.getPreparedStatement(con, sql);
		try {
			pstmt.setInt(1, resno);
			rs = pstmt.executeQuery();
			rs.next();
			vo.setResno(resno);
			vo.setResname(rs.getString("resname"));
			vo.setAddr(rs.getString("address"));
			vo.setTel(rs.getString("restel"));
			vo.setSubno(rs.getInt("subno"));
			vo.setMenu(rs.getString("menu"));
			vo.setMenuList();
			double avg = getResAVG(resno);
			vo.setAvg(avg);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		return vo;
	}
	// 해당 식당의 모든 이미지리스트를 가져오는 메소드입니다.
	public List<String> getResImg(int resno) {
		List<String> list = new ArrayList<String>();
		con = db.getConnection();
		String sql = msql.getSQL(msql.SEL_RES_IMG);
		pstmt = db.getPreparedStatement(con, sql);
		try {
			pstmt.setInt(1, resno);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(rs.getString("savename"));
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
	
	// 해당 식당의 리뷰평균점수를 가져오는 메소드입니다.
	public double getResAVG(int resno) {
		double cnt = 0;
		con = db.getConnection();
		String sql = msql.getSQL(msql.SEL_RES_AVG);
		pstmt = db.getPreparedStatement(con, sql);
		try {
			pstmt.setInt(1, resno);
			rs = pstmt.executeQuery();
			rs.next();
			cnt = rs.getDouble("avg");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		
		return cnt;
	}
	// 해당 식당의 모든 리뷰 정보를 가져오는 메소드입니다.
	public List<ReviewVO> getReviewList(int resno) {
		List<ReviewVO> list = new ArrayList<ReviewVO>();
		con = db.getConnection();
		String sql = msql.getSQL(msql.SEL_RES_REVIEW);
		pstmt = db.getPreparedStatement(con, sql);
		try {
			pstmt.setInt(1, resno);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ReviewVO vo = new ReviewVO();
				vo.setId(rs.getString("mid"));
				vo.setTxt(rs.getString("revtxt"));
				vo.setStarnum(rs.getInt("starnum"));
				vo.setCrdate(rs.getDate("crdate"));
				vo.setSdate();
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
