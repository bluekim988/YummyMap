package com.yummymap.www.SQL;
/**
 * 회원관리시 필요한 sql질의명령을 관리하는 클래스입니다.
 * 
 * @author	김종형
 * @see		com.yummymap.www.DAO.JoinDAO
 */
public class JoinSQL {
	public final int CHECK_LOGIN = 1001;
	public final int ADD_MEMB = 1002;
	public final int ID_CHECK = 1003;
	public final int ID_SEARCH = 1004;
	public final int PASS_SEARCH = 1005;
	
	public final int UPDATE_USER_TEMPPASS = 1006;
	public String getSQL(int code) {
		StringBuffer buff = new StringBuffer();
		switch(code) {
		case CHECK_LOGIN:
			buff.append("SELECT ");
			buff.append("	COUNT(*) cnt ");
			buff.append("FROM ");
			buff.append("	member ");
			buff.append("WHERE ");
			buff.append("	mid = ? ");
			buff.append("	AND mpw = ? ");
			buff.append("	AND isshow = 'Y' AND issue = 'N' ");
		break;
		case ADD_MEMB:
			buff.append("INSERT INTO ");
			buff.append("	member(mno, mname, mid, mpw, mtel, memail) ");
			buff.append("VALUES( " );
			buff.append("	getmno.nextval, ");
			buff.append("	?,?,?,?,?");
			buff.append(")");
			break;
		case ID_CHECK:
			buff.append("SELECT ");
			buff.append("count(*) cnt ");
			buff.append("FROM ");
			buff.append("member ");
			buff.append("WHERE ");
			buff.append("mid=? ");
			break;
		case ID_SEARCH:
			buff.append("SELECT "); 
			buff.append("    RPAD(substr(mid,1,3),length(mid),'*') mid "); 
			buff.append("FROM "); 
			buff.append("    member "); 
			buff.append("WHERE "); 
			buff.append("    mname = ? "); 
			buff.append("    and memail = ? "); 
			buff.append("    and grade = 'M' ");
			break;
		case PASS_SEARCH:
			buff.append("SELECT "); 
			buff.append("    COUNT(*) cnt "); 
			buff.append("FROM "); 
			buff.append("    member "); 
			buff.append("WHERE "); 
			buff.append("    mid = ? "); 
			buff.append("    and memail = ? "); 
			buff.append("    and grade = 'M' ");
			break;
		case UPDATE_USER_TEMPPASS:
			buff.append("UPDATE "); 
			buff.append("    member "); 
			buff.append("SET "); 
			buff.append("    mpw = ? "); 
			buff.append("WHERE "); 
			buff.append("    mid =? ");
			break;
		}
		return buff.toString();
	}
}
