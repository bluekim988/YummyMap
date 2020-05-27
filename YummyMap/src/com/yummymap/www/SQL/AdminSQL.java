/**
 * @author 유태희
 * @since 2020.05.23
 * 	이 클래스는 어드민계정이 사용하는 쿼리 생성 클래스 입니다
 */

package com.yummymap.www.SQL;

public class AdminSQL {
 public final int SEL_ADMIN = 1001;
 public final int SEL_ALL_USER = 1002;
 public final int SEL_USER = 1003;
 public final int SEL_ID_USER = 1004;
 public final int SEL_NAME_USER = 1005;
 public final int USER_INFO = 1006;
 
 public final int PAGE_BOARD_LIST = 1007;
 public final int BOARD_TITL_SEL = 1008;
 public final int BOARD_NAME_SEL = 1009;
 public final int BOARD_DEL = 1010;
 public final int ADMIN_INFO = 1011;
 public final int BOARD_DETAIL = 1012;
 
 
 public final int USER_CNT = 2001;
 public final int USER_ID_CNT = 2002;
 public final int USER_NAME_CNT = 2003;
 
 public final int ALL_BOARD_CNT = 2004;
 public final int TITLE_BOARD_CNT = 2005;
 public final int NAME_BOARD_CNT = 2006;
 
 public final int UPDATE_USER = 3001;
 public final int UPDATE_USER_NOPASS = 3002;
 public final int DEL_UESR = 3003;
 public final int UPDATE_ADMIN = 3004;
 public final int UPDATE_ADMIN_NOPASS = 3005;
 
 public String getSQL(int code) {
	 StringBuffer buff = new StringBuffer();
	 
	 switch(code) {
	 case SEL_ADMIN : 
		 buff.append("SELECT ");
		 buff.append(" count(*) cnt ");
		 buff.append("FROM ");
		 buff.append(" member ");
		 buff.append("WHERE ");
		 buff.append(" grade = 'A' ");
		 buff.append(" AND mid = ? ");
		 buff.append(" AND mpw = ? ");
		 break;
	 case SEL_ALL_USER : 
		 buff.append("SELECT  "); 
		 buff.append("    mno , mname , mid, mtel ,memail ,issue"); 
		 buff.append("FROM  "); 
		 buff.append("    member "); 
		 buff.append("WHERE "); 
		 buff.append("    grade = 'M' "); 
		 buff.append("    and isshow = 'Y' ");
		 break;
	 case SEL_USER : 
		 buff.append("select "); 
		 buff.append("    rno , mno , mid , mname, mtel , memail ,issue "); 
		 buff.append("from "); 
		 buff.append(" (SELECT  "); 
		 buff.append("        rownum rno , mno , mid , mname , mtel, memail, issue "); 
		 buff.append("    FROM  "); 
		 buff.append("        member "); 
		 buff.append("    WHERE "); 
		 buff.append("        grade = 'M' "); 
		 buff.append("        AND isshow = 'Y' "); 
		 buff.append("  )  "); 
		 buff.append("WHERE "); 
		 buff.append("    rno BETWEEN ? and ? ");
		 break;
	 case SEL_ID_USER : 
		 buff.append("select "); 
		 buff.append("    rno , mno , mid , mname, mtel , memail ,issue "); 
		 buff.append("from "); 
		 buff.append(" (SELECT  "); 
		 buff.append("        rownum rno , mno , mid , mname , mtel, memail,issue "); 
		 buff.append("    FROM  "); 
		 buff.append("        member "); 
		 buff.append("    WHERE "); 
		 buff.append("        grade = 'M' "); 
		 buff.append("        and isshow = 'Y' "); 
		 buff.append("    	  and mid = ?  ");
		 buff.append("  )  "); 
		 buff.append("WHERE "); 
		 buff.append("    rno BETWEEN ? and ? ");
		 break;
	 case SEL_NAME_USER : 
		 buff.append("select "); 
		 buff.append("    rno , mno , mid , mname, mtel , memail, issue  "); 
		 buff.append("from "); 
		 buff.append(" (SELECT  "); 
		 buff.append("        rownum rno , mno , mid , mname , mtel, memail, issue "); 
		 buff.append("    FROM  "); 
		 buff.append("        member "); 
		 buff.append("    WHERE "); 
		 buff.append("        grade = 'M' "); 
		 buff.append("        and isshow = 'Y' "); 
		 buff.append("        AND mname = ? "); 
		 buff.append("  )  "); 
		 buff.append("WHERE "); 
		 buff.append("    rno BETWEEN ? and ? ");
		 break;
	 case USER_CNT: 
		 buff.append("SELECT  "); 
		 buff.append("   COUNT(*) cnt "); 
		 buff.append("FROM  "); 
		 buff.append("    member "); 
		 buff.append("WHERE "); 
		 buff.append("    grade = 'M' "); 
		 buff.append("    AND isshow = 'Y' "); 
		 break;
	 case USER_ID_CNT: 
		 buff.append("SELECT  "); 
		 buff.append("   COUNT(*) cnt "); 
		 buff.append("FROM  "); 
		 buff.append("    member "); 
		 buff.append("WHERE "); 
		 buff.append("    grade = 'M' "); 
		 buff.append("    AND isshow = 'Y' "); 
		 buff.append("    and mid = ? ");
		 break;
	 case USER_NAME_CNT: 
		 buff.append("SELECT  "); 
		 buff.append("   COUNT(*) cnt "); 
		 buff.append("FROM  "); 
		 buff.append("    member "); 
		 buff.append("WHERE "); 
		 buff.append("    grade = 'M' "); 
		 buff.append("    AND isshow = 'Y' "); 
		 buff.append("    and mname = ? ");
		 break;
	 case USER_INFO : 
		 buff.append("SELECT  "); 
		 buff.append("    mno , mname , mid, mtel ,memail ,issue "); 
		 buff.append("FROM  "); 
		 buff.append("    member "); 
		 buff.append("WHERE "); 
		 buff.append("    grade = 'M' "); 
		 buff.append("    and mno = ? ");
		 break;	 
	 case ADMIN_INFO : 
		 buff.append("SELECT  "); 
		 buff.append("    mno , mname , mid, mtel ,memail "); 
		 buff.append("FROM  "); 
		 buff.append("    member "); 
		 buff.append("WHERE "); 
		 buff.append("    grade = 'A' "); 
		 buff.append("    and mid = ? ");
		 break;	 
	 case UPDATE_USER:
		 buff.append("UPDATE  "); 
		 buff.append("    member  "); 
		 buff.append("SET "); 
		 buff.append("    mname = ? , mpw= ? , mtel= ? , memail= ?, issue= ? "); 
		 buff.append("WHERE "); 
		 buff.append("	grade = 'M'   "); 
		 buff.append("  AND  mno= ? ");
		 break;
	 case UPDATE_USER_NOPASS:
		 buff.append("UPDATE  "); 
		 buff.append("    member  "); 
		 buff.append("SET "); 
		 buff.append("    mname = ? ,  mtel= ? , memail= ?, issue= ? "); 
		 buff.append("WHERE ");
		 buff.append("	grade = 'M' "); 
		 buff.append("  AND  mno = ? ");
		 break;
	 case UPDATE_ADMIN:
		 buff.append("UPDATE  "); 
		 buff.append("    member  "); 
		 buff.append("SET "); 
		 buff.append("    mname = ? , mpw= ? , mtel= ? , memail= ? "); 
		 buff.append("WHERE "); 
		 buff.append("	grade = 'A'   "); 
		 buff.append("  AND  mid= ? ");
		 break;
	 case UPDATE_ADMIN_NOPASS:
		 buff.append("UPDATE  "); 
		 buff.append("    member  "); 
		 buff.append("SET "); 
		 buff.append("    mname = ? , mtel= ? , memail= ? "); 
		 buff.append("WHERE "); 
		 buff.append("	grade = 'A'   "); 
		 buff.append("  AND mid= ? ");
		 break;
	 case DEL_UESR:
		 buff.append("UPDATE  "); 
		 buff.append("    member  "); 
		 buff.append("SET "); 
		 buff.append("   isshow='N' "); 
		 buff.append("WHERE "); 
		 buff.append("	grade = 'M' "); 
		 buff.append("  AND  mno= ? ");
		 break;
	 case PAGE_BOARD_LIST:
		 buff.append(" select  "); 
		 buff.append(" rno ,txtno , title , mid , cdate , mtxt   "); 
		 buff.append(" FROM  "); 
		 buff.append(" ( select  "); 
		 buff.append("    ROWNUM rno ,txtno , title , mid , cdate , mtxt "); 
		 buff.append("from  "); 
		 buff.append("    (SELECT   "); 
		 buff.append("       txtno , title , mid , cdate , mtxt "); 
		 buff.append("	   FROM   "); 
		 buff.append("		   txt "); 
		 buff.append("     WHERE  "); 
		 buff.append("        isshow = 'Y' "); 
		 buff.append("	   ORDER BY  "); 
		 buff.append("	      txtno DESC  "); 
		 buff.append("     ) )  "); 
		 buff.append("WHERE  "); 
		 buff.append("	rno BETWEEN ? and ? ");
		 break;
	 case ALL_BOARD_CNT:
		 buff.append("SELECT "); 
		 buff.append("    count(*) cnt  "); 
		 buff.append("FROM "); 
		 buff.append("    txt "); 
		 buff.append("WHERE "); 
		 buff.append("    isshow = 'Y' ");
		 break;
	 case TITLE_BOARD_CNT:
		 buff.append("SELECT "); 
		 buff.append("    count(*) cnt  "); 
		 buff.append("FROM "); 
		 buff.append("    txt "); 
		 buff.append("WHERE "); 
		 buff.append("    isshow = 'Y' ");
		 buff.append("    AND title LIKE ? ");
		 break;
	 case NAME_BOARD_CNT:
		 buff.append("SELECT "); 
		 buff.append("    count(*) cnt  "); 
		 buff.append("FROM "); 
		 buff.append("    txt "); 
		 buff.append("WHERE "); 
		 buff.append("    isshow = 'Y' ");
		 buff.append("    AND mid =  ? ");
		 break;
	 case BOARD_TITL_SEL:
		 buff.append(" select  "); 
		 buff.append(" rno ,txtno , title , mid , cdate , mtxt   "); 
		 buff.append(" FROM  "); 
		 buff.append(" ( select  "); 
		 buff.append("    ROWNUM rno ,txtno , title , mid , cdate , mtxt "); 
		 buff.append("from  "); 
		 buff.append("    (SELECT   "); 
		 buff.append("       txtno , title , mid , cdate , mtxt "); 
		 buff.append("	   FROM   "); 
		 buff.append("		   txt "); 
		 buff.append("     WHERE  "); 
		 buff.append("        isshow = 'Y' ");
		 buff.append("  	  AND title LIKE ? ");
		 buff.append("	   ORDER BY  "); 
		 buff.append("	      txtno DESC  "); 
		 buff.append("     ) )  "); 
		 buff.append("WHERE  "); 
		 buff.append("	rno BETWEEN ? and ? ");
		 break;
	 case BOARD_NAME_SEL:
		 buff.append(" select  "); 
		 buff.append(" rno ,txtno , title , mid , cdate , mtxt   "); 
		 buff.append(" FROM  "); 
		 buff.append(" ( select  "); 
		 buff.append("    ROWNUM rno ,txtno , title , mid , cdate , mtxt "); 
		 buff.append("from  "); 
		 buff.append("    (SELECT   "); 
		 buff.append("       txtno , title , mid , cdate , mtxt "); 
		 buff.append("	   FROM   "); 
		 buff.append("		   txt "); 
		 buff.append("     WHERE  "); 
		 buff.append("        isshow = 'Y' ");
		 buff.append("  	  AND mid =  ? ");
		 buff.append("	   ORDER BY  "); 
		 buff.append("	      txtno DESC  "); 
		 buff.append("     ) )  "); 
		 buff.append("WHERE  "); 
		 buff.append("	rno BETWEEN ? and ? ");
		 break;
	 case BOARD_DEL:
		 buff.append("UPDATE "); 
		 buff.append("    txt "); 
		 buff.append("SET "); 
		 buff.append("    isshow='N' "); 
		 buff.append("WHERE "); 
		 buff.append("    txtno = ?  ");
		 break;
	 case BOARD_DETAIL:
		 buff.append("SELECT  "); 
		 buff.append("    title , mtxt "); 
		 buff.append("FROM  "); 
		 buff.append("    txt "); 
		 buff.append("WHERE "); 
		 buff.append("    txtno = ? ");
		 break;
	 }
	 return buff.toString();
	 
 }
}
