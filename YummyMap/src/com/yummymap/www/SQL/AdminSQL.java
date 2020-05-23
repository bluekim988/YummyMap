package com.yummymap.www.SQL;

public class AdminSQL {
 public final int SEL_AD = 1001;
 public final int SEL_ALL_USER = 1002;
 public final int SEL_USER = 1003;
 public final int SEL_ID_USER = 1004;
 public final int SEL_NAME_USER = 1005;
 public final int USER_INFO = 1006;
 public final int ALL_BOARD_LIST = 1007;
 
 
 
 public final int USER_CNT = 2001;
 public final int USER_ID_CNT = 2002;
 public final int USER_NAME_CNT = 2003;
 
 public final int USER_RE = 3001;
 public final int USER_RE_NOPASS = 3002;
 public final int DEL_UESR = 3003;
 
 public String getSQL(int code) {
	 StringBuffer buff = new StringBuffer();
	 
	 switch(code) {
	 case SEL_AD : 
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
		 buff.append("  )  "); 
		 buff.append("WHERE "); 
		 buff.append("    rno BETWEEN ? and ? ");
		 buff.append("    and mid = ?  ");
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
		 buff.append("  )  "); 
		 buff.append("WHERE "); 
		 buff.append("    rno BETWEEN ? and ? ");
		 buff.append("    and mname = ? ");
		 break;
	 case USER_CNT: 
		 buff.append("SELECT  "); 
		 buff.append("   COUNT(*) cnt "); 
		 buff.append("FROM  "); 
		 buff.append("    member "); 
		 buff.append("WHERE "); 
		 buff.append("    grade = 'M' "); 
		 break;
	 case USER_ID_CNT: 
		 buff.append("SELECT  "); 
		 buff.append("   COUNT(*) cnt "); 
		 buff.append("FROM  "); 
		 buff.append("    member "); 
		 buff.append("WHERE "); 
		 buff.append("    grade = 'M' "); 
		 buff.append("    and mid = ? ");
		 break;
	 case USER_NAME_CNT: 
		 buff.append("SELECT  "); 
		 buff.append("   COUNT(*) cnt "); 
		 buff.append("FROM  "); 
		 buff.append("    member "); 
		 buff.append("WHERE "); 
		 buff.append("    grade = 'M' "); 
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
	 case USER_RE:
		 buff.append("UPDATE  "); 
		 buff.append("    member  "); 
		 buff.append("SET "); 
		 buff.append("    mname = ? , mpw= ? , mtel= ? , memail= ?, issue= ? ,isshow=? "); 
		 buff.append("WHERE "); 
		 buff.append("    mno= ? ");
		 break;
	 case USER_RE_NOPASS:
		 buff.append("UPDATE  "); 
		 buff.append("    member  "); 
		 buff.append("SET "); 
		 buff.append("    mname = ? , mtel= ? , memail= ?, issue= ? ,isshow=? "); 
		 buff.append("WHERE "); 
		 buff.append("    mno= ? ");
		 break;
	 case DEL_UESR:
		 buff.append("UPDATE  "); 
		 buff.append("    member  "); 
		 buff.append("SET "); 
		 buff.append("   isshow='N' "); 
		 buff.append("WHERE "); 
		 buff.append("    mno= ? ");
		 break;
	 case ALL_BOARD_LIST:
		 buff.append("SELECT  "); 
		 buff.append("    txtno , title , mid , cdate , mtxt "); 
		 buff.append("FROM "); 
		 buff.append("    txt "); 
		 buff.append("WHERE "); 
		 buff.append("    isshow='Y' "); 
		 break;
	 }
	 return buff.toString();
	 
 }
}
