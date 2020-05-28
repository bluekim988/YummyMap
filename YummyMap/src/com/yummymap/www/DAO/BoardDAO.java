package com.yummymap.www.DAO;
/**
 * @author	김소영, 김종형
 * @since	2020.05.27
 *  이 클래스는 게시판 데이터베이스 전달 (DAO) 입니다
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
				bVO.setCategory(rs.getString("category"));
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
	// VO객체는 제목, 작성자아이디, 카테고리번호, 본문을 필수로 포함해야합니다.
	// 반환값으로 Insert에 성공시 1을 반환, 실패시 0을 반환합니다.
	public int addBoard(BoardVO bvo) {
		int cnt = 0;
		con = db.getConnection();
		String sql = bSQL.getSQL(bSQL.ADD_BRD);
		pstmt = db.getPreparedStatement(con, sql);
		try {
			pstmt.setString(1, bvo.getTitle());
			pstmt.setString(2, bvo.getMid());
			pstmt.setInt(3, bvo.getCatno());
			pstmt.setString(4, bvo.getMtxt());
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
	// 해당리플을 삭제해주는 메소드입니다.
	// 매개변수로 리플의 키값을 받습니다.
	// 반환값은 성공시1을 실패시 0을 반환합니다.
	public int removeReply(int rno) {
		int cnt = 0;
		con = db.getConnection();
		String sql = bSQL.getSQL(bSQL.REMOVE_REPLY);
		pstmt = db.getPreparedStatement(con, sql);
		try {
			pstmt.setInt(1, rno);
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close(pstmt);
			db.close(con);
		}
		return cnt;
	}

	// 게시판 글 수정 전담 처리 함수
	// 매개변수로 리플데이터를 담은 VO를 받습니다.
	// VO객체는 제목, 본문, 키값을 필수로 포함해야합니다.
	// 반환값으로 Insert성공시 1을 실패시 0을 반환합니다.
	public int editBoard(BoardVO txtVo) {
		int cnt = 0;
		con = db.getConnection();
		String sql = bSQL.getSQL(bSQL.EDIT_CONT);
		pstmt = db.getPreparedStatement(con, sql);
		try {
			pstmt.setString(1, txtVo.getTitle());
			pstmt.setString(2, txtVo.getMtxt());
			pstmt.setInt(3, txtVo.getTxtno());
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
	
	// 해당게시글의 조회수를 +1 증가시켜주는 메소드입니다.
	// 매개변수로 글번호를 받습니다.
	// 반환값은 성공시 1, 실패시 0을 반환합니다.
	public int increaseTxtCount(int txtno) {
		int cnt = 0;
		con = db.getConnection();
		String sql = bSQL.getSQL(bSQL.EDIT_CLICK_BRD);
		pstmt = db.getPreparedStatement(con, sql);
		try {
			pstmt.setInt(1, txtno);
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close(pstmt);
			db.close(con);
		}
		return cnt;
	}

	// 게시글의 상세정보를 가져오는 메소드입니다.
	// 매개변수로 게시글의 키값을 받습니다.
	// 반환값은 게시글데이터를담은 VO를 반환합니다.
	public BoardVO getTextInfo(int txtno, String userID) {
		BoardVO boardVo = new BoardVO();
		con = db.getConnection();
		String sql = bSQL.getSQL(bSQL.SEL_CONT);
		pstmt = db.getPreparedStatement(con, sql);
		try {
			pstmt.setString(1, userID);
			pstmt.setInt(2, txtno);
			pstmt.setInt(3, txtno);
			rs = pstmt.executeQuery();
			rs.next();
			boardVo.setTxtno(rs.getInt("txtno"));
			boardVo.setTitle(rs.getString("title"));
			boardVo.setMid(rs.getString("mid"));
			boardVo.setcDate(rs.getDate("cdate"));
			boardVo.setBdate();
			boardVo.setCount(rs.getInt("count"));
			boardVo.setRnum(rs.getInt("rnum"));
			boardVo.setCatno(rs.getInt("catno"));
			boardVo.setMtxt(rs.getString("mtxt"));
			boardVo.setLv(rs.getInt("lv"));
			boardVo.setIsrec(rs.getString("isrec"));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		return boardVo;
	}
	// 해당 게시글의 모든 리플 리스트를 가져오는 메소드입니다.
	// 매개변수로 게시글의 키값을 받습니다.
	// 반환값은 reply VO를 담은 List입니다.
	public List<BoardVO> getAllReplyList(int txtno) {
		List<BoardVO> replyList = new ArrayList<BoardVO>();
		con = db.getConnection();
		String sql = bSQL.getSQL(bSQL.SEL_LIST_REPLY);
		pstmt = db.getPreparedStatement(con, sql);
		try {
			pstmt.setInt(1, txtno);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardVO replyVo = new BoardVO();
				replyVo.setRno(rs.getInt("rno"));
				replyVo.setRtxt(rs.getString("rtxt"));
				replyVo.setMid(rs.getString("mid"));
				replyVo.setcDate(rs.getDate("cdate"));
				replyVo.setTxtno(rs.getInt("txtno"));
				replyVo.setCount(rs.getInt("count"));
				replyList.add(replyVo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		return replyList;
	}
	// 해당 게시글의 추천수를 +1 증가해주는 메소드입니다.
	// 매개변수로 게시글의 키값을 받습니다.
	// 반환값은 성공시 1, 실패시0을 반환합니다.
	public int increaseTextRnum(int txtno) {
		int cnt = 0;
		con = db.getConnection();
		String sql = bSQL.getSQL(bSQL.EDIT_RNUM_BRD);
		pstmt = db.getPreparedStatement(con, sql);
		try {
			pstmt.setInt(1, txtno);
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close(pstmt);
			db.close(con);
		}
		return cnt;
	}
	// 게시글추천여부 기록의 데이터를 추가해주는 메소드입니다.
	// increaseTextRnum() 선행되어야합니다.
	// 매개변수로 사용자 아이디와, 해당글의 키값을 입력받습니다.
	public int addRecommendData(String userID, int txtno) {
		int cnt = 0;
		con = db.getConnection();
		String sql = bSQL.getSQL(bSQL.ADD_RECOMMEND);
		pstmt = db.getPreparedStatement(con, sql);
		try {
			pstmt.setString(1, userID);
			pstmt.setInt(2, txtno);
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close(pstmt);
			db.close(con);
		}
		return cnt;
	}
	
	// 해당 게시글의 추천수를 -1 감소해주는 메소드입니다.
	// 매개변수로 게시글의 키값을 받습니다.
	// 반환값은 성공시 1, 실패시0을 반환합니다.
	public int decreaseTextRnum(int txtno) {
		int cnt = 0;
		con = db.getConnection();
		String sql = bSQL.getSQL(bSQL.REMOVE_RNUM_BRD);
		pstmt = db.getPreparedStatement(con, sql);
		try {
			pstmt.setInt(1, txtno);
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close(pstmt);
			db.close(con);
		}
		return cnt;
	}
	// 게시글의 추천여부 기록 데이터를 삭제해주는 메소드입니다.
	// decreaseTextRnum() 선행되어야 합니다.
	// 매개변수로 해당글의 키값과 사용자 아이디를 입력받습니다.
	public int removeRecommendData(int txtno, String userID) {
		int cnt = 0;
		con = db.getConnection();
		String sql = bSQL.getSQL(bSQL.REMOVE_RECOMMEND);
		pstmt = db.getPreparedStatement(con, sql);
		try {
			pstmt.setInt(1, txtno);
			pstmt.setString(2, userID);
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close(pstmt);
			db.close(con);
		}
		return cnt;
	}
}
