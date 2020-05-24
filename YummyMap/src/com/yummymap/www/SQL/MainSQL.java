package com.yummymap.www.SQL;

public class MainSQL {
	public final int SEL_RES = 1001;
	
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
		}
		return buff.toString();
	}
}
