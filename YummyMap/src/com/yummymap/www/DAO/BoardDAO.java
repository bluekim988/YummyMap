package com.yummymap.www.DAO;
/**
 * @author	김소영
 * @since	2020.05.27
 *  이 클래스는 게시판 데이터베이스 전달 (DAO) 입니다
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.yummymap.www.DB.WebDBCP;
import com.yummymap.www.SQL.BoardSQL;
import com.yummymap.www.util.PageUtil;
import com.yummymap.www.vo.BoardVO;

public class BoardDAO {
	WebDBCP db;
	Connection con;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;

	BoardSQL bSQL;

	public BoardDAO() {
		db = new WebDBCP();
		bSQL = new BoardSQL();
	}
	// 토탈 게시글 수를 가져오는 메소드입니다.
	public int getTotal() {
		int cnt = 0;
		con = db.getConnection();
		String sql = bSQL.getSQL(bSQL.SEL_TOTAL_CNT);
		stmt = db.getStatement(con);
		try {
			rs = stmt.executeQuery(sql);
			rs.next();
			cnt = rs.getInt("cnt");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(stmt);
			db.close(con);
		}
		return cnt;
	}

	// 게시판 등록글 가져오기 전담 처리 함수
	// 매개변수로 죄하할 게시글번호의 시작값과 끝나는 값을 포함한 PageUtil 객체를 받습니다.
	// 반환값은 게시글VO를 담은 ListArrayList입니다.
	public ArrayList<BoardVO> getAllList(PageUtil page) {
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		// Connection
		con = db.getConnection();
		String sql = bSQL.getSQL(bSQL.SEL_ALL_LIST);
		pstmt = db.getPreparedStatement(con, sql);
		try {
			pstmt.setInt(1, page.getStartCont());
			pstmt.setInt(2, page.getEndCont());

			// 보내고 받고
			rs = pstmt.executeQuery();
			while (rs.next()) {
				BoardVO bVO = new BoardVO();
				// 데이터 뽑고 VO에 담고
				bVO.setRno(rs.getInt("rno"));
				bVO.setTxtno(rs.getInt("txtno"));
				bVO.setTitle(rs.getString("title"));
				bVO.setMid(rs.getString("mid"));
				bVO.setcDate(rs.getDate("cdate"));
				bVO.setBdate();
				bVO.setCount(rs.getInt("count"));
				bVO.setRnum(rs.getInt("rnum"));
				bVO.setCatno(rs.getInt("cntno"));
				bVO.setLv(rs.getInt("lv"));
				list.add(bVO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		return list;
	}

	// 게시판 테이블 글 등록 데이터베이스 작업 전담 처리 함수
	// 매개변수로 개시글 데이터를 담은 VO를 받습니다.
	// 반환값으로 Insert에 성공시 1을 반환, 실패시 0을 반환합니다.
	public int addBoard(BoardVO bvo) {
		int cnt = 0;
		con = db.getConnection();
		String sql = bSQL.getSQL(bSQL.ADD_BRD);
		pstmt = db.getPreparedStatement(con, sql);
		try {
			pstmt.setString(1, bvo.getMid());
			pstmt.setString(2, bvo.getTitle());
			pstmt.setString(3, bvo.getMtxt());
			pstmt.setInt(4, bvo.getCatno());
			pstmt.setInt(5, bvo.getLv());
			cnt = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.close(pstmt);
			db.close(con);
		}
		// 6. 결과 내보내고
		return cnt;
	}

	// 게시판 댓글 등록 데이터베이스 작업 전담 처리 함수
	// 매개변수로 리플데이터를 담은 VO를 받습니다.
	// VO객체는 본문, 작성자아이디, 상위글번호를 필수로 포함해야합니다.
	// 반환값으로 Insert성공시 1을 실패시 0을 반환합니다.
	public int addReply(BoardVO replyVo) {
		int cnt = 0;
		con = db.getConnection();
		String sql = bSQL.getSQL(bSQL.ADD_REPLY);
		pstmt = db.getPreparedStatement(con, sql);
		try {
			// 4. 질의명령 완성하고
			pstmt.setString(1, replyVo.getRtxt());
			pstmt.setString(2, replyVo.getMid());
			pstmt.setInt(3, replyVo.getTxtno());
			cnt = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.close(pstmt);
			db.close(con);
		}
		// 6. 결과 내보내고
		return cnt;
	}

	// 게시판 글 수정 전담 처리 함수
	// 매개변수로 리플데이터를 담은 VO를 받습니다.
	// VO객체는 제목, 본문, 키값을 필수로 포함해야합니다.
	// 반환값으로 Insert성공시 1을 실패시 0을 반환합니다.
	public int editBoard(BoardVO replyVo) {
		int cnt = 0;
		con = db.getConnection();
		String sql = bSQL.getSQL(bSQL.EDIT_CONT);
		pstmt = db.getPreparedStatement(con, sql);
		try {
			pstmt.setString(1, replyVo.getTitle());
			pstmt.setString(2, replyVo.getRtxt());
			pstmt.setInt(3, replyVo.getRno());
			cnt = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.close(pstmt);
			db.close(con);
		}
		return cnt;
	}

	// 게시판 글 삭제 전담 처리 함수
	public int delBoard(int txtno) {
		int cnt = 0;
		String sql = bSQL.getSQL(bSQL.REMOVE_CONT);
		con = db.getConnection();
		pstmt = db.getPreparedStatement(con, sql);
		try {
			pstmt.setInt(1, txtno);
			cnt = pstmt.executeUpdate();
		} catch (Exception e) {
			db.close(pstmt);
			db.close(con);
		}
		return cnt;
	}
/*
	// 글번호로 검색한 해당 글 가져오기 전담 처리 함수
	public BoardVO getConnect(int txtno) {
		BoardVO bVO = new BoardVO();
		con = db.getConnection();
		String sql = bSQL.getSQL(bSQL.EDIT_CLICK_BRD);
		pstmt = db.getPreparedStatement(con, sql);
		int cnt = 0;
		try {
			pstmt.setInt(1, txtno);
			cnt = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.close(pstmt);
		}
		if (cnt != 1) {
			System.out.println("클릭수 증가 실패 ㅜㅡㅜ");
		}

		sql = bSQL.getSQL(bSQL.SEL_CONT);
		pstmt = db.getPreparedStatement(con, sql);
		try {
			pstmt.setInt(1, txtno);
			rs = pstmt.executeQuery();
			rs.next();
			bVO.setTxtno(rs.getInt("txtno"));
			bVO.setTitle(rs.getString("title"));
			bVO.setMtxt(rs.getString("mtxt").replaceAll("\r\n", "<br>"));
			bVO.setcDate(rs.getDate("cdate"));
			bVO.setBdate();
			bVO.setMid(rs.getString("mid"));
			bVO.setLv(rs.getInt("lv"));
			bVO.setRnum(rs.getInt("rnum"));
			bVO.setCount(rs.getInt("catno"));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		return bVO;
	}

	public ArrayList<BoardVO> getReplyList(int txtno) {
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		// Connection
		con = db.getConnection();
		String sql = bSQL.getSQL(bSQL.SEL_LIST_REPLY);
		pstmt = db.getPreparedStatement(con, sql);
		try {
			pstmt.setInt(1, txtno);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				BoardVO bVO = new BoardVO();
				// 데이터 뽑고 VO에 담고
				bVO.setMid(rs.getString("rno"));
				bVO.setMid(rs.getString("mid"));
				bVO.setTxtno(rs.getInt("rtxt"));
				bVO.setTitle(rs.getString(""));
				bVO.setcDate(rs.getDate("cdate"));
				bVO.setBdate();
				list.add(bVO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		return list;
	}
	*/
}

