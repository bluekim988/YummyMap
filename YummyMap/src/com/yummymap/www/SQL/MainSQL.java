package com.yummymap.www.SQL;

/**
 * 이 클래스는 main, index JSP페이지에서 데이터베이스 작업에 요구되는
 * 모든 SQL 질의명령을 전담하는 클래스이다.
 * 
 * @author	김종형
 * @since	2020/05/26
 *
 */

public class MainSQL {
	public final int SEL_RES = 1001;
	public final int SEL_RES_INFO = 1002;
	public final int SEL_RES_IMG = 1003;
	public final int SEL_RES_AVG = 1004;
	public final int SEL_RES_REVIEW = 1005;
	public final int ADD_REVIEW = 1006;
	public final int REMOVE_REVIEW = 1007;
	public final int ADD_MY_RES = 1008;
	public final int REMOVE_MY_RES = 1009;
	public final int IS_PICKED_MY_RES = 1010;
	public final int GET_MY_PICK_LIST = 1011;
	public final int ADD_RES = 1012;
	public final int SEL_AVGTOP_RES_LIST = 2001;
	public final int SEL_REVIEWTOP_RES_LIST = 2002;
	public final int SEL_RESLIST_WITH_CATEGORY = 2003;
	public final int SEL_RESLIST_USE_NAME = 3001;
	
	public String getSQL(int code) {
		StringBuffer buff = new StringBuffer();
		switch(code) {
		case SEL_RES:
			buff.append("SELECT ");
			buff.append("  r.resno, resname, address, catno, restel, subno, menu , NVL(ispick, 'N') ispick ");
			buff.append("FROM ");
			buff.append("res  r, (SELECT resno, ispick FROM myres WHERE  ispick = 'Y' and mid = ?  ) p ");
			buff.append("WHERE ");
			buff.append("  r.resno = p.resno(+) ");
			buff.append(" AND isshow = 'Y'  ");
			buff.append("  AND INSTR(menu, ?) > 0  ");
			buff.append("ORDER BY ");
			buff.append("resname ");
			break;
		case SEL_RESLIST_USE_NAME:
			buff.append("SELECT ");
			buff.append("r.resno, resname, address, catno, restel, subno, menu , NVL(ispick, 'N') ispick ");
			buff.append("FROM ");
			buff.append("res  r,  ");
			buff.append("(SELECT resno, ispick FROM myres WHERE  ispick = 'Y' and mid = ?  ) p ");
			buff.append("WHERE ");
			buff.append(" r.resno = p.resno(+) ");
			buff.append("AND isshow = 'Y'  ");
			buff.append("AND INSTR(resname, ?) > 0 ");
			buff.append("ORDER BY ");
			buff.append("resname ");
			break;
		case SEL_RES_INFO:
			buff.append("SELECT ");
			buff.append("  r.resno resno, resname, address, catno, restel, subno, menu, NVL(ispick, 'N') ispick ,  NVL(isReview, 'N') isReview ");
			buff.append("FROM ");
			buff.append("res  r,  ");
			buff.append("(SELECT resno, ispick FROM myres WHERE  ispick = 'Y' and mid = ?  ) p,  ");
			buff.append("(SELECT resno, isshow isReview FROM review WHERE mid = ? AND isshow = 'Y' ) v  ");
			buff.append("WHERE ");
			buff.append("  r.isshow = 'Y' ");
			buff.append(" AND r.resno = p.resno(+) ");
			buff.append(" AND r.resno = v.resno(+) ");
			buff.append(" AND r.resno = ? ");
			break;
		case SEL_RES_IMG:
			buff.append("SELECT ");
			buff.append("savename ");
			buff.append("FROM ");
			buff.append("img ");
			buff.append("WHERE ");
			buff.append("resno = ? ");
			break;
		case SEL_RES_AVG:
			buff.append("SELECT ");
			buff.append(" TRUNC(AVG(starnum),1) avg ");
			buff.append("FROM ");
			buff.append("review ");
			buff.append("WHERE ");
			buff.append("resno = ? AND isshow = 'Y' ");
			break;
		case SEL_RES_REVIEW:
			buff.append("SELECT ");
			buff.append("revno, mid, revtxt, starnum, crdate, cnt ");
			buff.append("FROM ");
			buff.append("review,  (SELECT count(*) cnt  FROM review WHERE resno = ? and isshow = 'Y')  ");
			buff.append("WHERE ");
			buff.append("resno = ? ");
			buff.append("AND isshow = 'Y' ");
			buff.append("ORDER BY ");
			buff.append("crdate desc");
			break;
		case ADD_REVIEW:
			buff.append("INSERT INTO review VALUES (getRevno.nextval, ?, ?, ?, ? , sysdate, 'Y') ");
			break;
		case REMOVE_REVIEW:
			buff.append("UPDATE review ");
			buff.append("SET ");
			buff.append("isshow = 'N' ");
			buff.append("WHERE ");
			buff.append("revno = ? ");
			break;
		case ADD_MY_RES:
			buff.append("INSERT INTO myres (myresno, mid, resno) VALUES ( ");
			buff.append("getMyresno.nextval, ?, ? )");
			break;
		case REMOVE_MY_RES:
			buff.append("UPDATE myres ");
			buff.append("SET ispick = 'N' ");
			buff.append("WHERE mid = ? AND resno = ? ");
			break;
		case IS_PICKED_MY_RES:
			buff.append("SELECT ");
			buff.append("count(*) cnt ");
			buff.append("FROM ");
			buff.append("myres ");
			buff.append("WHERE ");
			buff.append("ispick = 'Y' AND mid = ? AND resno = ? ");
			break;
		case GET_MY_PICK_LIST:
			buff.append("SELECT ");
			buff.append("r.resno resno, resname, address, restel, subno, menu, NVL(ispick, 'N') ispick ");
			buff.append("FROM ");
			buff.append("res r, (SELECT resno, ispick FROM myres WHERE mid = ? and ispick='Y') m ");
			buff.append("WHERE ");
			buff.append("r.resno = m.resno ");
			break;
		case SEL_AVGTOP_RES_LIST:
			buff.append("SELECT ");
			buff.append("rw,   resno ,resname, address, catno, restel, subno, menu, count, TRUNC(avg, 1) avg, NVL(ispick, 'N') ispick  ");
			buff.append("FROM(  ");
			buff.append("	SELECT ");
			buff.append(" 		rw,  s.resno resno ,resname, address, catno, restel, subno, menu, count, TRUNC(avg, 1) avg, NVL(ispick, 'N') ispick ");
			buff.append(" 	FROM ( ");
			buff.append(" 		SELECT ");
			buff.append(" 		rownum rw,  resno,resname, address, catno, restel, subno, menu, count, avg ");
			buff.append("		FROM(  ");
			buff.append(" 			SELECT");
			buff.append("				r.resno resno,resname, address, catno, restel, subno, menu, count, avg ");
			buff.append("			FROM ");
			buff.append(" 				res r, ( SELECT resno, count(*) count, avg(starnum) avg FROM review WHERE    isshow = 'Y' GROUP BY    resno   ) d");
			buff.append("			WHERE ");
			buff.append("				r.resno = d.resno ");
			buff.append("			ORDER BY ");
			buff.append(" 				avg desc  )   ) s, (SELECT resno, ispick FROM myres WHERE  ispick = 'Y' and mid = ?  ) p ");
			buff.append(" 			WHERE");
			buff.append(" 			s.resno = p.resno(+) ");
			buff.append(" 			ORDER BY");
			buff.append(" 			avg desc    ) ");
			buff.append("WHERE ");
			buff.append("rw BETWEEN 1 and 3	 ");
			break;
		case SEL_REVIEWTOP_RES_LIST:
			buff.append("SELECT ");
			buff.append("	rw,  s.resno resno ,resname, address, catno, restel, subno, menu, count, TRUNC(avg, 1) avg, NVL(ispick, 'N') ispick  ");
			buff.append("FROM (  ");
			buff.append("	SELECT ");
			buff.append("		 rownum rw,  resno,resname, address, catno, restel, subno, menu, count, avg ");
			buff.append("	FROM( ");
			buff.append("		SELECT ");
			buff.append("			resno,resname, address, catno, restel, subno, menu, count, avg  ");
			buff.append("		FROM ( ");
			buff.append("			SELECT  ");
			buff.append("				r.resno resno,resname, address, catno, restel, subno, menu, count, avg  ");
			buff.append("			FROM ");
			buff.append("				res r, ( SELECT resno, count(*) count, avg(starnum) avg FROM review WHERE    isshow = 'Y' GROUP BY    resno   ) d  ");
			buff.append("			WHERE ");
			buff.append("				r.resno = d.resno ");
			buff.append("			ORDER BY ");
			buff.append("				count DESC  ) ");
			buff.append("		WHERE ");
			buff.append("			rownum BETWEEN 1 and 3 ");
			buff.append("		)   ) s, (SELECT resno, ispick FROM myres WHERE  ispick = 'Y' and mid = ?  ) p   ");
			buff.append("WHERE ");
			buff.append("	s.resno = p.resno(+) ");
			buff.append("ORDER BY ");
			buff.append("	count DESC ");
			break;               
		case SEL_RESLIST_WITH_CATEGORY:
			buff.append("SELECT ");
			buff.append(" r.resno resno,resname, address, catno, restel, subno, menu, NVL(count, 0) count, NVL( avg, 0) avg, NVL(ispick,'N') ispick ");
			buff.append("FROM ");
			buff.append("res r, ( SELECT resno, count(*) count, TRUNC(avg(starnum), 1) avg FROM review WHERE    isshow = 'Y' GROUP BY    resno   ) d ");
			buff.append(",     (SELECT resno, ispick FROM myres WHERE  ispick = 'Y' and mid = ?  ) p  ");
			buff.append("WHERE ");
			buff.append(" r.resno = p.resno(+) ");
			buff.append("AND r.resno = d.resno(+) ");
			buff.append("AND catno = (SELECT catno FROM category WHERE category = ? ) ");
			break;
		}
		return buff.toString();
	}
}
