package com.yummymap.www.DB;
/**
 * 이 클래스는 프로젝트의 DB작업을 수행하기위해
 * 기본적인 리소스자원을 전담하는 클래스입니다.
 * 
 * @author	김종형
 * @see		/YummyMap/META_INF/context.xml
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class WebDBCP {
	public DataSource ds;

	public WebDBCP() {
		try {
			InitialContext context = new InitialContext();
			ds = (DataSource) context.lookup("java:/comp/env/jdbc/yummyDB");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		Connection con = null;
		try {
			con = ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

	public Statement getStatement(Connection con) {
		Statement stmt = null;
		try {
			stmt = con.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return stmt;
	}

	public PreparedStatement getPreparedStatement(Connection con, String sql) {
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pstmt;
	}

	public void close(Object sqlResourceObj) {
		try {
			if (sqlResourceObj instanceof Connection) {
				((Connection) sqlResourceObj).close();
			} else if (sqlResourceObj instanceof Statement) {
				((Statement) sqlResourceObj).close();
			} else if (sqlResourceObj instanceof PreparedStatement) {
				((PreparedStatement) sqlResourceObj).close();
			} else if (sqlResourceObj instanceof ResultSet) {
				((ResultSet) sqlResourceObj).close();
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
