package com.steam.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
	private static Connection conn = null;
	private static PreparedStatement st = null;
	private static ResultSet rs = null;
	/**
	 * 静态资源：创建DBUtuil对象时作为静态连接使用
	 */
	static {
			try {
				Class.forName(Constant.JDBC_Driver);
			} catch (ClassNotFoundException e) {
				System.out.println("载入数据库驱动失败！！！！");
				e.printStackTrace();
			}
			try {
				conn = DriverManager.getConnection(Constant.DBURL,Constant.DBUSER,Constant.DBPWD);
				if(conn==null) {
					System.out.println("连接为空！！！");
				}
			} catch (SQLException e) {
				System.out.println("连接数据库失败！！！");
				e.printStackTrace();
			}
	}
	/**
	 * 方法：初始化实例对象
	 * 参数：String类型的sql语句
	 * 该方法返回PreparedStatement类型的实例对象，注意该实例对象成功时不为空
	 * @param sql
	 * @return
	 */
	public static PreparedStatement getPreparedStatement(String sql) {
		try {
			st = conn.prepareStatement(sql);
		} catch (SQLException e) {
			System.out.println("初始化实例对象失败！！");
			e.printStackTrace();
		}
		if(st==null) {
			System.out.println("实例对象为空！！！！！");
		}
		return st;
	}
	/**
	 * 方法：关闭连接
	 * 无参数
	 * 无返回值
	 */
	public static void closeConnection() {
		try {
			conn.close();
		} catch (SQLException e) {
			System.out.println("连接关闭失败！");
			e.printStackTrace();
		}
	}
	/**
	 * 方法：连接数据库获取当前时间
	 * 无参数
	 * 返回值为当前时间的字符串
	 * @return
	 */
	public static String getNowTime() {
		String time = "";
		String sql = "select now();";
		st = getPreparedStatement(sql);
		try {
			rs = st.executeQuery();
			if(!rs.next()) {
				System.out.println("获取当前时间的结果集为空");
			}
			else {
				time = rs.getString(1);
			}
		} catch (SQLException e) {
			System.out.println("数据库查询当前时间失败！！");
			e.printStackTrace();
		}
		if(time=="") {
			System.out.println("获取当前时间失败");
		}
		return time;
	}
	
	
	private Statement stat;
	private PreparedStatement pstmt;
	
	private void openConnection() {
		try {
			conn = DriverManager.getConnection(Constant.DBURL,Constant.DBUSER,Constant.DBPWD);
			conn.setAutoCommit(true);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	

	public void connectionRollback() {
		try {
			conn.rollback();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	

	public void commit() {
		try {
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public Statement getStatement() {
		openConnection();
		try {
			stat = conn.createStatement();
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		return stat;
	}
	
}
