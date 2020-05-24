package com.yummymap.www.SQL;

public class MainSQL {
	public final int SEL_RES = 1001;
	public final int SEL_RES_INFO = 1002;
	public final int SEL_RES_IMG = 1003;
	public final int SEL_RES_AVG = 1004;
	public final int SEL_RES_REVIEW = 1005;
	
	public String getSQL(int code) {
		StringBuffer buff = new StringBuffer();
		switch(code) {
		case SEL_RES:
			buff.append("SELECT ");
			buff.append(" resno, resname, address, catno, restel, subno, menu ");
			buff.append("FROM ");
			buff.append("res ");
			buff.append("WHERE ");
			buff.append("   isshow = 'Y' ");
			buff.append(" AND INSTR(menu, ?) > 0 ");
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
			buff.append(" AVG(starnum) avg ");
			buff.append("FROM ");
			buff.append("review ");
			buff.append("WHERE ");
			buff.append("resno = ?");
			break;
		case SEL_RES_REVIEW:
			buff.append("SELECT ");
			buff.append("mid, revtxt, starnum, crdate ");
			buff.append("FROM ");
			buff.append("review ");
			buff.append("WHERE ");
			buff.append("resno = ? ");
			buff.append("AND isshow = 'Y' ");
			break;
		}
		return buff.toString();
	}
}