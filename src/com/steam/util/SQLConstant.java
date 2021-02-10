package com.steam.util;

public class SQLConstant {

	/**
	 * 对用户表增删查改的SQL语句
	 */
	public static String Select_Userinfo = "select * from " + Constant.StaffTable;
	public static String Insert_Userinfo = "insert into " + Constant.StaffTable;
	public static String Delect_Userinfo = "delete " + Constant.StaffTable;
	public static String Update_Userinfo = "update " + Constant.StaffTable;
	
	
	/**
	 * 对部门增删查改的SQL语句
	 */
	public static String Select_Department = "select * from " + Constant.DepartmentTable + " ";
	public static String Insert_Department = "insert into " + Constant.DepartmentTable+ " ";
	public static String Delete_Department = "delete from " + Constant.DepartmentTable+ " "; 
	public static String Update_Department = "update " + Constant.DepartmentTable+ " ";
	
	
	/**
	 * 对薪资标准表增删查改的SQL语句
	 */
	
	public static String Select_Standard = "select * from " + Constant.salaryStandardTable + " ";
	public static String Insert_Standard = "insert into " + Constant.salaryStandardTable+ " ";
	public static String Delete_Standard = "delete from " + Constant.salaryStandardTable+ " "; 
	public static String Update_Standard = "update " + Constant.salaryStandardTable+ " ";
}
