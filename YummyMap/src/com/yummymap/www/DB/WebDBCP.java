package com.yummymap.www.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
			ds = (DataSource)context.lookup("java:/comp/env/jdbc/yummyDB");
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
	
	public <T extends AutoCloseable>void close(T o) {
		try {
			o.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
