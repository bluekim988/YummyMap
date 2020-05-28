package com.yummymap.www.DAO;

/**
 *  이 클래스는 index화면의 모든 Dao작업을 전담하는 클래스입니다.
 *  
 *  @author	김종형
 *  @since	2020/05/25
 *  @see	com.yummymap.www.sql.MainSQL
 */

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
	// 파라미터로 키워드와, 유저아이디를 받습니다.
	// 유저가 비로그인시 기본값(no)을 전달합니다.
	// 반환값은 식당vo를 담은 List입니다.
	public List<ResVO> getList(String str, String userID) {
		List<ResVO> list = new ArrayList<ResVO>();
		con = db.getConnection();
		String sql = msql.getSQL(msql.SEL_RES);
		pstmt = db.getPreparedStatement(con, sql);
		try {
			pstmt.setString(1, userID);
			pstmt.setString(2, str);
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
				vo.setIspick(rs.getString("ispick"));
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
	// 식당검색시 해당 식당 리스트를 가져오는 메소드입니다.
	// 파라미터로 식당이름과, 유저아이디를 받습니다.
	// 유저가 비로그인시 기본값(no)을 전달합니다.
	// 반환값은 식당vo를 담은 List입니다.
	public List<ResVO> getListUseName(String resname, String userID) {
		List<ResVO> list = new ArrayList<ResVO>();
		con = db.getConnection();
		String sql = msql.getSQL(msql.SEL_RESLIST_USE_NAME);
		pstmt = db.getPreparedStatement(con, sql);
		try {
			pstmt.setString(1, userID);
			pstmt.setString(2, resname);
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
				vo.setIspick(rs.getString("ispick"));
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
	public ResVO getResInfo(int resno, String userID) {
		ResVO vo = new ResVO();
		con = db.getConnection();
		String sql = msql.getSQL(msql.SEL_RES_INFO);
		pstmt = db.getPreparedStatement(con, sql);
		try {
			pstmt.setString(1, userID);
			pstmt.setString(2, userID);
			pstmt.setInt(3, resno);
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
			vo.setIspick(rs.getString("ispick"));
			vo.setIsReview(rs.getString("isReview"));
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
		Connection con = db.getConnection();
		String sql = msql.getSQL(msql.SEL_RES_AVG);
		PreparedStatement pstmt = db.getPreparedStatement(con, sql);
		ResultSet rs = null;
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
			pstmt.setInt(2, resno);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ReviewVO vo = new ReviewVO();
				vo.setRevno(rs.getInt("revno"));
				vo.setId(rs.getString("mid"));
				vo.setTxt(rs.getString("revtxt"));
				vo.setStarnum(rs.getInt("starnum"));
				vo.setCrdate(rs.getDate("crdate"));
				vo.setSdate();
				vo.setReviewCount(rs.getInt("cnt"));
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
	// 리뷰작성 데이터베이스 작업해주는 메소드입니다.
	public int addReview(int resno, String userID, String txt, int starnum) {
		int cnt = 0;
		con = db.getConnection();
		String sql = msql.getSQL(msql.ADD_REVIEW);
		pstmt = db.getPreparedStatement(con, sql);
		try {
			pstmt.setString(1, userID);
			pstmt.setInt(2, resno);
			pstmt.setString(3, txt);
			pstmt.setInt(4, starnum);
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close(pstmt);
			db.close(con);
		}
		return cnt;
	}
	// 해당 리뷰를 데이터베이스에서 지우는 메소드입니다.
	public int removeReview(int revno) {
		int cnt = 0;
		con = db.getConnection();
		String sql = msql.getSQL(msql.REMOVE_REVIEW);
		pstmt = db.getPreparedStatement(con, sql);
		try {
			pstmt.setInt(1, revno);
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close(pstmt);
			db.close(con);
		}
		return cnt;
	}
	// 찜 추가해주는 메소드입니다.
	// 파라미터로 아이디, 식당키값을 받습니다.
	// 반환값은 성공0, 실패1을 반환합니다.
	public int addMyRes(String userID, int resno) {
		int cnt = 0;
		con = db.getConnection();
		String sql = msql.getSQL(msql.ADD_MY_RES);
		pstmt = db.getPreparedStatement(con, sql);
		try {
			pstmt.setString(1, userID);
			pstmt.setInt(2, resno);
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close(pstmt);
			db.close(con);
		}
		return cnt;
	}
	// 찜 삭제해주는 메소드입니다.
	// 파라미터로 아이디, 식당키값을 받습니다.
	// 반환값은 성공0, 실패1을 반환합니다.
	public int removeMyRes(String userID, int resno) {
		int cnt =0;
		con = db.getConnection();
		String sql = msql.getSQL(msql.REMOVE_MY_RES);
		pstmt = db.getPreparedStatement(con, sql);
		try {
			pstmt.setString(1, userID);
			pstmt.setInt(2, resno);
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close(pstmt);
			db.close(con);
		}
		return cnt;
	}
	// 유저가 해당 식당을 찜 했는지 여부를 확인해주는 메소드입니다.
	// 파라미터로 아이디, 식당키값을 받습니다.
	// 해당 식당을 이미 찜 했다면 반환값 1, 그렇지 않다면 0을 반환합니다.
	public int isPickedMyRes(String userID, int resno) {
		int cnt = 0;
		con = db.getConnection();
		String sql = msql.getSQL(msql.IS_PICKED_MY_RES);
		pstmt = db.getPreparedStatement(con, sql);
		try {
			pstmt.setString(1, userID);
			pstmt.setInt(2, resno);
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
	
	// 유저가 픽한 모든 식당키값을 가져오는 메소드입니다.
	// 파라미터로 유저ID를 받습니다.
	// 반환값은 식당vo를 담은 List입니다.
	public List<ResVO> getMyPickList(String userID) {
		List<ResVO> myPickList = new ArrayList<ResVO>();
		con = db.getConnection();
		String sql = msql.getSQL(msql.GET_MY_PICK_LIST);
		pstmt = db.getPreparedStatement(con, sql);
		try {
			pstmt.setString(1, userID);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ResVO resVo = new ResVO();
				int resNo = rs.getInt("resno");
				resVo.setResno(resNo);
				resVo.setResname(rs.getString("resname"));
				resVo.setAddr(rs.getString("address"));
				resVo.setTel(rs.getString("restel"));
				resVo.setSubno(rs.getInt("subno"));
				resVo.setMenu(rs.getString("menu"));
				resVo.setMenuList();
				double avg = getResAVG(resNo);
				resVo.setAvg(avg);
				resVo.setIspick(rs.getString("ispick"));
				myPickList.add(resVo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		return myPickList;
	}
	
	// 리뷰 평점 TOP3 에 해당하는 식당을 가져오는 메소드입니다.
	// 반환값은 식당VO를 담은 List입니다.
	public List<ResVO> getAvgTopResList(String userID){
		List<ResVO> topResList = new ArrayList<ResVO>();
		con = db.getConnection();
		String sql = msql.getSQL(msql.SEL_AVGTOP_RES_LIST);
		pstmt = db.getPreparedStatement(con, sql);
		try {
			pstmt.setString(1, userID);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ResVO resVo = new ResVO();
				resVo.setResno(rs.getInt("resno"));
				resVo.setResname(rs.getString("resname"));
				resVo.setAddr(rs.getString("address"));
				resVo.setCatno(rs.getInt("catno"));
				resVo.setTel(rs.getString("restel"));
				resVo.setSubno(rs.getInt("subno"));
				resVo.setMenu(rs.getString("menu"));
				resVo.setMenuList();
				resVo.setReviewCount(rs.getInt("count"));
				resVo.setAvg(rs.getDouble("avg"));
				resVo.setIspick(rs.getString("ispick"));
				topResList.add(resVo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		return topResList;
	}
	// 리뷰수 TOP3 에 해당하는 식당을 가져오는 메소드입니다.
	// 반환값은 식당VO를 담은 List입니다.
	public List<ResVO> getTopReviewResList(String userID){
		List<ResVO> resList = new ArrayList<ResVO>();
		con = db.getConnection();
		String sql = msql.getSQL(msql.SEL_REVIEWTOP_RES_LIST);
		pstmt = db.getPreparedStatement(con, sql);
		try {
			pstmt.setString(1, userID);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ResVO resVo = new ResVO();
				resVo.setResno(rs.getInt("resno"));
				resVo.setResname(rs.getString("resname"));
				resVo.setAddr(rs.getString("address"));
				resVo.setCatno(rs.getInt("catno"));
				resVo.setTel(rs.getString("restel"));
				resVo.setSubno(rs.getInt("subno"));
				resVo.setMenu(rs.getString("menu"));
				resVo.setMenuList();
				resVo.setReviewCount(rs.getInt("count"));
				resVo.setAvg(rs.getDouble("avg"));
				resVo.setIspick(rs.getString("ispick"));
				resList.add(resVo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		return resList;
	}
	// 카테고리에 해당하는 모든 식당 리스트를 가져옵니다
	// 매개변수로 카테고리이름을 받습니다.
	// 반환값은 식당VO를 담은 List입니다.
	public List<ResVO> getListWithCate(String category, String userID){
		List<ResVO> resList = new ArrayList<ResVO>();
		con = db.getConnection();
		String sql = msql.getSQL(msql.SEL_RESLIST_WITH_CATEGORY);
		pstmt = db.getPreparedStatement(con, sql);
		try {
			pstmt.setString(1, userID);
			pstmt.setString(2, category);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ResVO resVo = new ResVO();
				resVo.setResno(rs.getInt("resno"));
				resVo.setResname(rs.getString("resname"));
				resVo.setAddr(rs.getString("address"));
				resVo.setCatno(rs.getInt("catno"));
				resVo.setTel(rs.getString("restel"));
				resVo.setSubno(rs.getInt("subno"));
				resVo.setMenu(rs.getString("menu"));
				resVo.setMenuList();
				resVo.setReviewCount(rs.getInt("count"));
				resVo.setAvg(rs.getDouble("avg"));
				resVo.setIspick(rs.getString("ispick"));
				resList.add(resVo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		return resList;
	}
}
