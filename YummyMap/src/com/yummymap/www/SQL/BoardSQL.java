package com.yummymap.www.SQL;

/**
 * @author	김소영
 * @since	2020.05.27
 *  이 클래스는 게시판 JSP페이지 데이터베이스 작업에 요구되는 SQL 질의 명령을 전담하는 클래스이다.
 * 
 */
public class BoardSQL {
	public final int SEL_TOTAL_CNT = 1001;
	public final int SEL_ALL_LIST = 1002;
	public final int SEL_CONT = 1003;
	public final int SEL_RECOM = 1004;
	public final int SEL_LIST_REPLY = 1005;
	public final int SEL_ISREC = 1006;
	
	public final int EDIT_CLICK_BRD = 2001;
	public final int EDIT_RNUM_BRD = 2002;
	public final int EDIT_CONT = 2003;
	public final int ADD_BRD = 2004;
	public final int ADD_REPLY = 2005;
	public final int ADD_RECOMMEND = 2006;

	public final int REMOVE_CONT = 3001;
	public final int REMOVE_RNUM_BRD = 3002;
	public final int REMOVE_REPLY = 3003;
	public final int REMOVE_RECOMMEND = 3004;

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
			buff.append("	t.txtno, title, mid, cdate, count, rnum, catno,  mtxt ,lv, NVL(isrec, 'N') isrec ");
			buff.append("FROM ");
			buff.append("	txt t,  (SELECT isrec, txtno  FROM recommend WHERE isrec = 'Y' AND	mid = ? AND txtno = ? ) e  ");
			buff.append("WHERE ");
			buff.append("  t.txtno = ? AND isshow ='Y' AND t.txtno = e.txtno(+) ");
			break;
		case SEL_ALL_LIST:
			buff.append("SELECT ");
			buff.append("	rno, txtno, title, mid, cdate, count, rnum, category, lv ");
			buff.append("FROM ");
			buff.append("	( ");
			buff.append("		SELECT ");
			buff.append("			ROWNUM rno, txtno, title, mid, cdate, count, rnum, category, lv ");
			buff.append("		FROM ");
			buff.append("			( ");
			buff.append("				SELECT ");
			buff.append("					txtno, title, mid, cdate, count, rnum, category, lv ");
			buff.append("				FROM ");
			buff.append("					txt t , category c ");
			buff.append("				WHERE ");
			buff.append("					isshow = 'Y' AND t.catno = c.catno ");
			buff.append("				ORDER BY ");
			buff.append("					txtno DESC ");
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
			buff.append("	txt  ");
			buff.append("SET ");
			buff.append("	rnum = rnum + 1 ");
			buff.append("WHERE ");
			buff.append("	txtno = ? ");
			break;
		case ADD_RECOMMEND:
			buff.append("INSERT INTO recommend (recomno, mid, txtno) ");
			buff.append("VALUES( ");
			buff.append("getRecomno.nextval, ?, ? ");
			buff.append(") ");
			break;
		case REMOVE_RNUM_BRD:
			buff.append("UPDATE ");
			buff.append("	txt  ");
			buff.append("SET ");
			buff.append("	rnum = rnum - 1 ");
			buff.append("WHERE ");
			buff.append("	txtno = ? ");
			break;
		case REMOVE_RECOMMEND:
			buff.append("UPDATE ");
			buff.append(" recommend ");
			buff.append("SET ");
			buff.append("	isrec='N' ");
			buff.append("WHERE ");
			buff.append("	txtno=? AND mid = ? ");
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
			buff.append("	mtxt = ?  ");
			buff.append("WHERE ");
			buff.append("	txtno = ? ");
			break;
		case ADD_BRD: 
			buff.append("INSERT INTO ");
			buff.append("	txt (txtno, title, mid, catno, mtxt ) ");
			buff.append("VALUES( ");
			buff.append("	getTxtno.nextval, ?, ?, ?, ? ");
			buff.append(") ");
			break;
		case ADD_REPLY: 
			buff.append("INSERT INTO reply (rno, rtxt, mid, txtno) ");
			buff.append("VALUES ( ");
			buff.append(" getrno.nextval, ?, ?, ? ");
			buff.append(") ");
			break;
		case SEL_LIST_REPLY:
			buff.append("SELECT ");
			buff.append("	rno, rtxt , mid, cdate, r.txtno txtno, count ");
			buff.append("FROM ");
			buff.append("	reply r, (SELECT txtno, count(*) count FROM reply WHERE isshow = 'Y' GROUP BY txtno) r2 ");
			buff.append("WHERE ");
			buff.append("	r.txtno = ? AND isshow = 'Y' AND r.txtno = r2.txtno ");
			break;
		case REMOVE_REPLY:
			buff.append("UPDATE reply ");
			buff.append("SET ");
			buff.append("	isshow = 'N' ");
			buff.append("WHERE ");
			buff.append(" rno = ? ");
			break;
		}
		return buff.toString();
	}
}