package com.yummymap.www.SQL;

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
		case SEL_RES_INFO:
			buff.append("SELECT ");
			buff.append(" resno, resname, address, catno, restel, subno, menu ");
			buff.append("FROM ");
			buff.append("res ");
			buff.append("WHERE ");
			buff.append("   isshow = 'Y' ");
			buff.append(" AND resno = ? ");
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
			buff.append("resno = ?");
			break;
		case SEL_RES_REVIEW:
			buff.append("SELECT ");
			buff.append("revno, mid, revtxt, starnum, crdate ");
			buff.append("FROM ");
			buff.append("review ");
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
		}
		return buff.toString();
	}
}
