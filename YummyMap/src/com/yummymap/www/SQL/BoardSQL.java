package com.yummymap.www.SQL;

/**
 * @author	김소영
 * @since	2020.05.27
 *  이 클래스는 게시판 JSP페이지 데이터베이스 작업에 요구되는 SQL 질의 명령을 전담하는 클래스이다.
 * 
 */
public class BoardSQL {
	public final int SEL_TOTAL_CNT = 1002;
	public final int SEL_ALL_LIST = 1001;
	public final int SEL_CONT = 1003;
	public final int SEL_RECOM = 1004;
	public final int SEL_LIST_REPLY = 1005;
	
	public final int EDIT_CLICK_BRD = 2001;
	public final int EDIT_RNUM_BRD = 2002;
	public final int EDIT_CONT = 2003;
	public final int ADD_BRD = 2004;
	public final int ADD_REPLY = 2005;

	public final int REMOVE_CONT = 3001;
	public final int REMOVE_RNUM_BRD = 3002;

	public String getSQL(int code) {
		StringBuffer buff = new StringBuffer();
		switch (code) {
		case SEL_TOTAL_CNT:
			buff.append("SELECT ");
			buff.append("	count(*) cnt ");
			buff.append("FROM ");
			buff.append("	txt ");
			buff.append("WHERE ");
			buff.append("	isshow = 'Y' ");
			break;
		case SEL_CONT:
			buff.append("SELECT ");
			buff.append("	txtno, title, txt.mid mid, cdate, count, rnum, catno,  mtxt ,lv ");
			buff.append("FROM ");
			buff.append("	txt, member ");
			buff.append("WHERE ");
			buff.append("	txt.mid = member.mid ");
			buff.append("	AND txtno = ? ");
			break;
		case SEL_ALL_LIST:
			buff.append("SELECT ");
			buff.append("	rno, txtno, title, mid, cdate, count, rnum, catno, lv ");
			buff.append("FROM ");
			buff.append("	( ");
			buff.append("		SELECT ");
			buff.append("			ROWNUM rno, txtno, title, mid, cdate, count, rnum, catno, lv ");
			buff.append("		FROM ");
			buff.append("			( ");
			buff.append("				SELECT ");
			buff.append("					txtno, title, mid, cdate, count, rnum, catno, lv ");
			buff.append("				FROM ");
			buff.append("					txt");
			buff.append("				WHERE ");
			buff.append("					isshow = 'Y' ");
			buff.append("				ORDER BY ");
			buff.append("					cdate DESC ");
			buff.append("			) ");
			buff.append("	) ");
			buff.append("WHERE ");
			buff.append("	rno BETWEEN ? AND ? ");
			break;
		case EDIT_CLICK_BRD:
			buff.append("UPDATE ");
			buff.append("	txt ");
			buff.append("SET ");
			buff.append("	count = count + 1 ");
			buff.append("WHERE ");
			buff.append("	txtno = ? ");
			break;
		case SEL_RECOM:
			buff.append("SELECT ");
			buff.append("	recomno, m.mid, txtno, isrec ");
			buff.append("FROM ");
			buff.append("	recommend r, member m, txt t ");
			buff.append("WHERE ");
			buff.append("	m.mid = r.mid");
			buff.append("	AND txtno = ? ");
			buff.append("	AND isrec = 'Y' ");
			break;
		case EDIT_RNUM_BRD:
			buff.append("UPDATE ");
			buff.append("	recommend r, txt t, member m ");
			buff.append("SET ");
			buff.append("	rnum = rnum + 1 ");
			buff.append("WHERE ");
			buff.append("	txtno = ? ");
			buff.append("	AND isrec = 'Y' ");
			buff.append("	AND r.mid = m.mid ");
			break;
		case REMOVE_RNUM_BRD:
			buff.append("UPDATE ");
			buff.append("	txt t, recommend r, member m ");
			buff.append("SET ");
			buff.append("	rnum = rnum - 1 ");
			buff.append("WHERE ");
			buff.append("	txtno = ? ");
			buff.append("	AND isshow = 'N' ");
			buff.append("	AND r.mid = m.mid ");
			break;
		case REMOVE_CONT:
			buff.append("UPDATE ");
			buff.append("	txt ");
			buff.append("SET ");
			buff.append("	isshow = 'N' ");
			buff.append("WHERE ");
			buff.append("	txtno = ? ");
			break;
		case EDIT_CONT:
			buff.append("UPDATE ");
			buff.append("	txt ");
			buff.append("SET ");
			buff.append("	title = ? , ");
			buff.append("	rtxt = ?  ");
			buff.append("WHERE ");
			buff.append("	rno = ? ");
			break;
		case ADD_BRD: 
			buff.append("INSERT INTO ");
			buff.append("	txt(txtno, mid, title, mtxt, catno ,lv) ");
			buff.append("VALUES( ");
			buff.append("	getTxtno.nextval, ?, ?, ?, ?, ? ");
			buff.append(") ");
			break;
		case ADD_REPLY: 
			buff.append("INSERT INTO reply (rno, rtxt, mid, txtno) ");
			buff.append("VALUSE ( ");
			buff.append(" getrno.nextval, ?, ?, ? ");
			buff.append(") ");
			break;
		case SEL_LIST_REPLY:
			buff.append(" ");
		}
		
		
		return buff.toString();
	}
}