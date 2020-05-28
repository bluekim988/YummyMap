package com.yummymap.www.SQL;
/**
 * mypage에서 DB작업에 필요한 질의명령을 관리하는 클래스입니다.
 * @author	최두용
 *
 */
public class TxtSQL {
	public final int SEL_TXTTOTAL = 1001;
	public final int SEL_TXTLIST = 1002;
		
	public String getSQL(int code) {
		
	StringBuffer buff = new StringBuffer();
			
		switch(code) {
		//게시판 토탈 카운트
		case SEL_TXTTOTAL :
			buff.append("SELECT ");
			buff.append("	count(*) cnt ");
			buff.append("FROM ");
			buff.append("	txt ");
			buff.append("WHERE ");
			buff.append("	isshow = 'Y' ");
			buff.append("	and mid = ? ");
			break;
		//내가 쓴글 불러오기 SQL
		case SEL_TXTLIST :
			buff.append("SELECT ");
			buff.append(" rno, txtno, mid, title, cdate, count, rnum  ");
			buff.append(" FROM ");
			buff.append(" (SELECT ");
			buff.append(" 	ROWNUM rno, txtno, mid, title, cdate, count, rnum ");
			buff.append("  FROM ");
			buff.append("		(SELECT ");
			buff.append("     		txtno, mid, title,  cdate, count, rnum ");
			buff.append("		FROM ");
			buff.append("  			txt ");
			buff.append(" 		WHERE ");
			buff.append("			mid = ? ");
			buff.append("			AND isshow = 'Y' ");
			buff.append("		ORDER BY cdate DESC ) ) ");
			buff.append("WHERE ");
			buff.append("rno BETWEEN ? AND ? ");
			break;
		}
		return buff.toString();
		}		
	}



