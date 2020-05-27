package com.yummymap.www.DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.yummymap.www.DB.WebDBCP;
import com.yummymap.www.SQL.TxtSQL;
import com.yummymap.www.util.PageUtil;
import com.yummymap.www.vo.member.*;
public class TxtDAO {

		WebDBCP db;
		Connection con;
		Statement stmt;
		PreparedStatement pstmt;
		ResultSet rs;
			TxtSQL tSQL;
			public TxtDAO() {
				db = new WebDBCP();
				tSQL = new TxtSQL();
			}
			public int getTotal(String id) {
				int cnt = 0;
				con = db.getConnection();
				String sql = tSQL.getSQL(tSQL.SEL_TXTTOTAL);
				pstmt = db.getPreparedStatement(con, sql);
				try {
					pstmt.setString(1, id);
					rs = pstmt.executeQuery();
					rs.next();
					cnt = rs.getInt("cnt");
				}catch(Exception e) {
					e.printStackTrace();
				}finally {
					db.close(rs);
					db.close(pstmt);
					db.close(con);
				}
				return cnt;
			}
			// 게시판 등록글 가져오기 전담 처리 함수 
			public ArrayList<TxtVO> getTXTLIST(PageUtil page, String userID) {
				ArrayList<TxtVO> list = new ArrayList<TxtVO>();
				con = db.getConnection();
				String sql = tSQL.getSQL(tSQL.SEL_TXTLIST);
				pstmt = db.getPreparedStatement(con, sql);
				try {
					pstmt.setString(1, userID);
					pstmt.setInt(2, page.getStartCont());
					pstmt.setInt(3, page.getEndCont());
					
					rs = pstmt.executeQuery();
					while(rs.next()) {
						TxtVO tVO = new TxtVO();
						tVO.setTxtno(rs.getInt("txtno"));
						tVO.setMid(rs.getString("mid"));
						tVO.setTitle(rs.getString("title"));
						tVO.setTtime(rs.getTime("cdate"));
						tVO.setTdate(rs.getDate("cdate"));
						tVO.setCdate();
						tVO.setCount(rs.getInt("count"));
						tVO.setRnum(rs.getInt("rnum"));
						list.add(tVO);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}finally {
					db.close(rs);
					db.close(pstmt);
					db.close(con);
				}
				return list;
			}
		
	}


