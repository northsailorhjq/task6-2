package com.jikexueyuan.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil {
	private static String DRIVER;
	private static String DBURL;
	private static String USER;
	private static String PASSWORD;
	private static Connection conn = null;

	static {
		Properties prop = new Properties();
		
			InputStream in = DBUtil.class.getClassLoader().getResourceAsStream("DBUtil.properties");
			try {
				prop.load(in);
			} catch (IOException e) {
				System.out.println("配置文件读取错误");
			}
			DRIVER=prop.getProperty("DRIVER");
			DBURL=prop.getProperty("DBURL");
			USER=prop.getProperty("USER");
			PASSWORD=prop.getProperty("PASSWORD");
	}
		public static Connection makeConnection(){
			try {
				Class.forName(DRIVER);
				conn = DriverManager.getConnection(DBURL, USER, PASSWORD);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return conn;
		}
	}


		

