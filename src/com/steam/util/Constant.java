package com.steam.util;

public class Constant {
	public static String RequestCharacterEncoding = "utf-8"; //请求编码格式
	public static String ResponseCharacterEncoding = "text/json;charset=utf-8"; //响应编码格式
	
	/**
	 * 数据库连接参数
	 */

	public static String DataBase ="db_test"; //数据库名称
	public static String DepartmentTable = "department";  //部门数据表
	public static String StaffTable = "userinfo";  //员工数据表
	public static String salaryStandardTable = "salaryStandardInfo";	//薪资标准表
	
	public static String JDBC_Driver = "com.mysql.jdbc.Driver";  //驱动
	public static String DBURL = "jdbc:mysql://localhost:3306/" + DataBase +"?useSSL=false&characterEncoding=UTF-8";//url
	public static String DBUSER = "root"; //帐号
	public static String DBPWD = ""; //密码

}
