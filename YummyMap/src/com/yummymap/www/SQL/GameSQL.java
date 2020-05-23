package com.yummymap.www.SQL;

public class GameSQL {
	public final int SEL_ALL_CATE_LIST = 1001;
	public final int SEL_MENU_IN_CATE = 1002;
	
	public String getSQL(int code) {
		StringBuffer buff = new StringBuffer();
		switch(code) {
		case SEL_ALL_CATE_LIST:
			buff.append("SELECT category FROM category ORDER BY catno ");
			break;
		case SEL_MENU_IN_CATE:
			buff.append("SELECT menu FROM menu WHERE mcatno = (SELECT catno FROM category WHERE category=?) ");
			break;
		}
		return buff.toString();
	}
}
