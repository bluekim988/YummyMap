package com.yummymap.www.SQL;
/**
 * 회원정보 변경 DB작업에 필요한 질의명령을 관리하는 클래스입니다.
 * @author	최두용
 *
 */
public class ChangeSQL {
	public final int SEL_LIST = 1001;
	public final int UPDATE_PW = 1002;
	public final int SEL_PW = 1003;
	public final int DROP_USER = 1004;
	
	public String getSQL(int code) {
		StringBuffer buff = new StringBuffer();
		switch(code) {
		//회원정보 뿌려주는 SQL
		case SEL_LIST:
			buff.append("SELECT ");
			buff.append(" mno, mname, mid, mtel, memail, mpw  ");
			buff.append("FROM member ");
			buff.append("where mid = ? ");
		    break;
		//비밀번호 변경 또는 회원 탈퇴 해주는 SQL
		case UPDATE_PW:
			buff.append("UPDATE member ");
			buff.append("SET ");
			buff.append("  mpw = ? ");
			buff.append("WHERE mid = ? ");
			break;
		//비밀번호 가져오는 SQL	
		case SEL_PW :
			buff.append("SELECT ");
			buff.append("count(*) cnt ");
			buff.append("FROM ");
			buff.append("member ");
			buff.append("WHERE ");
			buff.append("mpw = ? ");
			buff.append("AND mid = ? ");
			break;
		//회원탈퇴 SQL
		case DROP_USER :
			buff.append("UPDATE ");
			buff.append(" member ");
			buff.append("SET ");
			buff.append(" isshow = 'N' ");
			buff.append("where ");
			buff.append(" mid = ? ");
			break;
		}
		return buff.toString();
	}
}
