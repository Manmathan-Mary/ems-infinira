package com.infinira.ems.util;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.InputStream;
import java.io.IOException;
import java.util.Properties;
import java.text.MessageFormat;

public class DBUtil {
	private static String url = "";
	private static String username = "";
	private static String password= "";
	private static final String DB_CONFIG="dbconfig.properties";
	private static final String URL = "url";
	private static final String USERNAME = "username";
	private static final String PASSWORD = "password";
	
	private DBUtil() {
		Properties properties = new Properties();
		InputStream in = null;	
		try{
			in = Thread.currentThread().getContextClassLoader().getResourceAsStream(DB_CONFIG);
			if (in != null) {
				properties.load(in);
				url = properties.getProperty(URL).trim();
				username = properties.getProperty(USERNAME).trim();
				password = properties.getProperty(PASSWORD).trim();
			}
			else {
				throw new RuntimeException(MSG_0001);
			}
		} catch(IOException | IllegalArgumentException ex) {
			throw new RuntimeException(MSG_0001,ex);
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (IOException ex){
			}
		}
	}

    private static class DBUtilHelper {
        static final DBUtil dbUtil = new DBUtil();
    }

    public static DBUtil getInstance() {
        return DBUtilHelper.dbUtil;
    }
	
	public Connection getConnection () {
		try {
			Connection conn = DriverManager.getConnection(url,username,password);
			return conn;
		} catch (SQLException ex) {
			throw new RuntimeException(MessageFormat.format(MSG_0002,ex.getMessage()), ex);
		}
	}
	
	public static void close (ResultSet rs, Statement stmt, Connection conn) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
			}
		}
		if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
				}
			}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
			}
		}
	}
	
	private static final String MSG_0001 = DB_CONFIG + " file not found";
	private static final String MSG_0002 = "Error in creating database Connection {0}";
}