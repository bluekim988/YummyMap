package com.yummymap.www.DAO;
/**
 * @author 유태희
 * @since 2020.05.23
 *  이 클래스는 관리자 데이터베이스 전달 (DAO) 입니다
 */
import java.sql.*;
import java.util.*;
import com.yummymap.www.DB.*;
import com.yummymap.www.SQL.*;
import com.yummymap.www.vo.admin.*;


public class AdminDAO {
	WebDBCP db;
	Connection con;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	AdminSQL asql;
	
	public AdminDAO() {
		db = new WebDBCP();
		asql = new AdminSQL();
	}
	
	//관리자 계정 조회 전담 함수
	public int selAdmin(String id , String pw) {
		int cnt = 0;
		con = db.getConnection();
		
		String sql = asql.getSQL(asql.SEL_ADMIN);
		
		pstmt = db.getPreparedStatement(con, sql);
		
		try {
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
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
	
	//관리자 정보 조회 전담 함수
	public MemberInfoVO adminInfo(String id) {
		MemberInfoVO mvo = new MemberInfoVO();
		
		con = db.getConnection();
		
		String sql = asql.getSQL(asql.ADMIN_INFO);
		
		pstmt = db.getPreparedStatement(con, sql);
		
		try {
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			rs.next();
			mvo.setMname(rs.getString("mname"));
			mvo.setMid(rs.getString("mid"));
			mvo.setMtel(rs.getString("mtel"));
			String mail = rs.getString("memail");
			String idMail = mail.substring(0,mail.indexOf("@"));
			String domin = mail.substring(mail.indexOf("@")+1);
			mvo.setMemail(idMail);
			mvo.setMdomain(domin);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		
		
		return mvo;
	}
	
	//사용중인 유저 검색 전담 함수 
	public ArrayList<MemberInfoVO> allMember(){
		ArrayList<MemberInfoVO> list = new ArrayList<MemberInfoVO>();
		
		con = db.getConnection();
		
		String sql = asql.getSQL(asql.SEL_ALL_USER);
		
		stmt = db.getStatement(con);
		
		try {
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				MemberInfoVO mvo = new MemberInfoVO();
				mvo.setMno(rs.getInt("mno"));
				mvo.setMname(rs.getString("mname"));
				mvo.setMid(rs.getString("mid"));
				mvo.setMtel(rs.getString("mtel"));
				mvo.setMemail(rs.getString("memail"));
				mvo.setIssue(rs.getString("issue").equals("X") ? "O": "");
				list.add(mvo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			db.close(rs);
			db.close(stmt);
			db.close(con);
		}
		
		
		return list;
	}
	
	//회원 카운트 전담 함수 
	public int userCnt() {
		int cnt = 0;
		con = db.getConnection();
		String sql = asql.getSQL(asql.USER_CNT);
		stmt = db.getStatement(con);
		
		try {
			rs = stmt.executeQuery(sql);
			rs.next();
			cnt = rs.getInt("cnt");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			db.close(rs);
			db.close(stmt);
			db.close(con);
		}
		return cnt;
	}
	
	//유저 ID 검색 카운트 전담 함수
	public int userIdCnt(String id) {
		int cnt = 0;
		con = db.getConnection();
		String sql = asql.getSQL(asql.USER_ID_CNT);
		pstmt = db.getPreparedStatement(con, sql);
		
		try {
			pstmt.setString(1, id);
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
	
	//유저 NAME 검색 카운트 전담 함수
	public int userNameCnt(String name) {
		int cnt = 0;
		con = db.getConnection();
		String sql = asql.getSQL(asql.USER_NAME_CNT);
		pstmt = db.getPreparedStatement(con, sql);
		
		try {
			pstmt.setString(1, name);
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
	
	//페이징한 유저 목록 전담 함수 
	public  ArrayList<MemberInfoVO> pageUser(int start , int end){
		ArrayList<MemberInfoVO> list = new ArrayList<MemberInfoVO>();
		con = db.getConnection();
		String sql = asql.getSQL(asql.SEL_USER);
		pstmt = db.getPreparedStatement(con, sql);
		try {
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MemberInfoVO mvo = new MemberInfoVO();
				mvo.setMno(rs.getInt("mno"));
				mvo.setMname(rs.getString("mname"));
				mvo.setMid(rs.getString("mid"));
				mvo.setMtel(rs.getString("mtel"));
				mvo.setMemail(rs.getString("memail"));
				mvo.setIssue(rs.getString("issue").equals("X") ? "O": "");
				list.add(mvo);
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
	
	//아이디 검색 유저 목록 전담 함수 
	public  ArrayList<MemberInfoVO> idUser(int start , int end , String id){
		ArrayList<MemberInfoVO> list = new ArrayList<MemberInfoVO>();
		con = db.getConnection();
		String sql = asql.getSQL(asql.SEL_ID_USER);
		pstmt = db.getPreparedStatement(con, sql);
		try {
			pstmt.setString(1, id);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MemberInfoVO mvo = new MemberInfoVO();
				mvo.setMno(rs.getInt("mno"));
				mvo.setMname(rs.getString("mname"));
				mvo.setMid(rs.getString("mid"));
				mvo.setMtel(rs.getString("mtel"));
				mvo.setMemail(rs.getString("memail"));
				mvo.setIssue(rs.getString("issue").equals("X") ? "O": "");
				list.add(mvo);
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
	
	//이름 검색 유저 목록 전담 함수 
	public  ArrayList<MemberInfoVO> nameUser(int start , int end , String name){
		ArrayList<MemberInfoVO> list = new ArrayList<MemberInfoVO>();
		con = db.getConnection();
		String sql = asql.getSQL(asql.SEL_NAME_USER);
		pstmt = db.getPreparedStatement(con, sql);
		try {
			pstmt.setString(1, name);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MemberInfoVO mvo = new MemberInfoVO();
				mvo.setMno(rs.getInt("mno"));
				mvo.setMname(rs.getString("mname"));
				mvo.setMid(rs.getString("mid"));
				mvo.setMtel(rs.getString("mtel"));
				mvo.setMemail(rs.getString("memail"));
				list.add(mvo);
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
	
	//유저 수정 페이지 전담 함수 
	public MemberInfoVO reUser(int mno) {
		MemberInfoVO mvo = new MemberInfoVO();
		con = db.getConnection();
		
		String sql = asql.getSQL(asql.USER_INFO);
		
		pstmt = db.getPreparedStatement(con, sql);
		
		try {
			pstmt.setInt(1, mno);
			rs = pstmt.executeQuery();
			rs.next();
			mvo.setMid(rs.getString("mid"));
			mvo.setMname(rs.getString("mname"));
			mvo.setMtel(rs.getString("mtel"));
			String mail = rs.getString("memail");
			String idMail = mail.substring(0,mail.indexOf("@"));
			String domin = mail.substring(mail.indexOf("@")+1);
			mvo.setMemail(idMail);
			mvo.setMdomain(domin);
			mvo.setIssue(rs.getString("issue").equals("X") ? "O": "");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		return mvo;
	}
	
	//회원 수정 전담 함수(패스워드 포함)
	public void reMember(MemberInfoVO mvo) {
		con = db.getConnection();
		
		String sql = asql.getSQL(asql.UPDATE_USER);
		
		pstmt = db.getPreparedStatement(con, sql);
		
		try {
			pstmt.setString(1, mvo.getMname());
			pstmt.setString(2, mvo.getPass());
			pstmt.setString(3, mvo.getMtel());
			pstmt.setString(4, mvo.getMemail());
			pstmt.setString(5, mvo.getIssue());
			pstmt.setInt(6, mvo.getMno());
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			db.close(pstmt);
			db.close(con);
		}
		
	}
	//회원 수정 전담 함수(패스워드 미 수정)
	public void reMemberNopass(MemberInfoVO mvo) {
		con = db.getConnection();
		
		String sql = asql.getSQL(asql.UPDATE_USER_NOPASS);
		
		pstmt = db.getPreparedStatement(con, sql);
		
		try {
			pstmt.setString(1, mvo.getMname());
			pstmt.setString(2, mvo.getMtel());
			pstmt.setString(3, mvo.getMemail());
			pstmt.setString(4, mvo.getIssue());
			pstmt.setInt(5, mvo.getMno());
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			db.close(pstmt);
			db.close(con);
		}
		
	}
	//어드민 정보 수정(패스워드 포함)
	public void reAdmin(MemberInfoVO mvo) {
		con = db.getConnection();
		
		String sql = asql.getSQL(asql.UPDATE_ADMIN);
		
		pstmt = db.getPreparedStatement(con, sql);
		
		try {
			pstmt.setString(1, mvo.getMname());
			pstmt.setString(2, mvo.getPass());
			pstmt.setString(3, mvo.getMtel());
			pstmt.setString(4, mvo.getMemail());
			pstmt.setString(5, mvo.getMid());
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			db.close(pstmt);
			db.close(con);
		}
		
	}
	//어드민 수정 전담 함수(패스워드 미 수정)
	public void reAdminNopass(MemberInfoVO mvo) {
		con = db.getConnection();
		
		String sql = asql.getSQL(asql.UPDATE_ADMIN_NOPASS);
		
		pstmt = db.getPreparedStatement(con, sql);
		
		try {
			pstmt.setString(1, mvo.getMname());
			pstmt.setString(2, mvo.getMtel());
			pstmt.setString(3, mvo.getMemail());
			pstmt.setString(4, mvo.getMid());
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			db.close(pstmt);
			db.close(con);
		}
		
	}
	
	//계정 삭제 전담 함수 
	public void delUser(int mno) {
		con = db.getConnection();
		
		String sql = asql.getSQL(asql.DEL_UESR);
		
		pstmt = db.getPreparedStatement(con, sql);
		
		try {
			pstmt.setInt(1, mno);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			db.close(pstmt);
			db.close(con);
		}
	}
	
	//모든 게시글 카운트 함수
	public int boardCnt() {
		int cnt = 0;
		
		con = db.getConnection();
		
		String sql = asql.getSQL(asql.ALL_BOARD_CNT);
		
		stmt = db.getStatement(con);
		
		try {
			rs = stmt.executeQuery(sql);
			rs.next();
			cnt = rs.getInt("cnt");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			db.close(rs);
			db.close(stmt);
			db.close(con);
		}
		
		return cnt;
	}
	
	//제목검색 카운트 전담 함수 
	public int titlCnt(String titl)
	{
		int cnt =0;
		
		String title = "%"+titl+"%";
		con = db.getConnection();
		
		String sql = asql.getSQL(asql.TITLE_BOARD_CNT);
		
		pstmt = db.getPreparedStatement(con, sql);
		
		try {
			pstmt.setString(1, title);
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
	
	//작성자 검색 결과 카운터 함수 
	public int boardNameCnt(String name) {
		int cnt = 0;
		con = db.getConnection();
		
		String sql = asql.getSQL(asql.NAME_BOARD_CNT);
		
		pstmt = db.getPreparedStatement(con, sql);
		try {
			pstmt.setString(1, name);
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
	
	//게시판 리스트 출력 전담 함수
	public ArrayList<BoardInfoVO> boardList(int start , int end){
		ArrayList<BoardInfoVO> list = new ArrayList<BoardInfoVO>();
		
		con = db.getConnection();
		String sql = asql.getSQL(asql.PAGE_BOARD_LIST);
		
		pstmt = db.getPreparedStatement(con, sql);
		
		try {
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardInfoVO bvo = new BoardInfoVO();
				bvo.setTxtno(rs.getInt("txtno"));
				bvo.setTitle(rs.getString("title"));
				bvo.setMid(rs.getString("mid"));
				bvo.setCdate(rs.getDate("cdate"));
				bvo.setCtime(rs.getTime("cdate"));
				bvo.setSdate();
				
				list.add(bvo);
				
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
	
	//게시판 제목으로 검색 전담 함수
	public ArrayList<BoardInfoVO> boardTitl(String titl , int start , int end){
		ArrayList<BoardInfoVO> list = new ArrayList<BoardInfoVO>();
		String title = "%"+titl+"%";
		con = db.getConnection();
		String sql = asql.getSQL(asql.BOARD_TITL_SEL);
		
		pstmt = db.getPreparedStatement(con, sql);
		
		try {
			pstmt.setString(1, title);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardInfoVO bvo = new BoardInfoVO();
				bvo.setTxtno(rs.getInt("txtno"));
				bvo.setTitle(rs.getString("title"));
				bvo.setMid(rs.getString("mid"));
				bvo.setCdate(rs.getDate("cdate"));
				bvo.setCtime(rs.getTime("cdate"));
				bvo.setSdate();
				
				list.add(bvo);
				
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
	
	//게시판 작성자으로 검색 전담 함수
	public ArrayList<BoardInfoVO> boardId(String name , int start , int end){
		ArrayList<BoardInfoVO> list = new ArrayList<BoardInfoVO>();
		con = db.getConnection();
		String sql = asql.getSQL(asql.BOARD_NAME_SEL);
		
		pstmt = db.getPreparedStatement(con, sql);
		
		try {
			pstmt.setString(1, name);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardInfoVO bvo = new BoardInfoVO();
				bvo.setTxtno(rs.getInt("txtno"));
				bvo.setTitle(rs.getString("title"));
				bvo.setMid(rs.getString("mid"));
				bvo.setCdate(rs.getDate("cdate"));
				bvo.setCtime(rs.getTime("cdate"));
				bvo.setSdate();
				
				list.add(bvo);
				
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
	//게시판 삭제 전담 함수
	public void delBoard(int txtno) {
		con = db.getConnection();
		
		String sql = asql.getSQL(asql.BOARD_DEL);
		
		pstmt = db.getPreparedStatement(con, sql);
		
		try {
			pstmt.setInt(1, txtno);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			db.close(pstmt);
			db.close(con);
		}
	}
	
	//게시판 상세보기 전담 함수 
	public BoardInfoVO boardDetail(int txtno) {
		BoardInfoVO bvo = new BoardInfoVO();
		con = db.getConnection();
		
		String sql = asql.getSQL(asql.BOARD_DETAIL);
		
		pstmt = db.getPreparedStatement(con, sql);
		
		try {
			pstmt.setInt(1, txtno);
			rs = pstmt.executeQuery();
			rs.next();
			bvo.setTitle(rs.getString("title"));
			bvo.setMtxt(rs.getString("mtxt"));
			bvo.setMtxt();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		
		return bvo;
	}
}
