package com.steam.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.steam.service.serviceimp.StaffImp;
import com.steam.util.JsonChange;


/**
 * 员工模块管理控制器
 * 根据请求的不同返回不同的响应数据
 * @author 庞海 如果有写在这的请加上名字，加上时请删掉这段话
 * time:2021/2/7
 */
public class StaffController {
	JsonChange print = null;  //返回响应
	StaffImp staffimp = null; //员工实现类
	
	/**
	 * 获取所有员工的奖惩信息
	 * @author 庞海
	 * @param response 响应前端
	 * @return 无
	 * time:2021/2/7
	 */
	public void getAllStaff(HttpServletResponse response){
		print = new JsonChange();
		staffimp = new StaffImp();
		print.change(response, staffimp.ShowAllStaff(), true);
	}
	
	
	/**
	 * 录入奖惩信息
	 * @author 庞海
	 * @param request 请求后端
	 * @param response 响应前端
	 * @param id 用户的工号
	 * @return 无
	 * time:2021/2/7
	 */
	public void InputMeritAndPunish(HttpServletRequest request, HttpServletResponse response, 
			String id){
		print = new JsonChange();
		staffimp = new StaffImp();
		int weekendovertime = Integer.valueOf(request.getParameter("weekendovertime"));
		int festivalovertime = Integer.valueOf(request.getParameter("festivalovertime"));
		String temp = request.getParameter("saleCommission");
		int saleCommission;
		if(temp.equals("")) {
			saleCommission = 0;
		}else {
			saleCommission = Integer.valueOf(temp);
		}
		int festivalWages = Integer.valueOf(request.getParameter("festivalWages"));
		int yearendWages = Integer.valueOf(request.getParameter("yearendWages"));
		int lateCount = Integer.valueOf(request.getParameter("lateCount"));
		int leaveCount = Integer.valueOf(request.getParameter("leaveCount"));
		int absentCount = Integer.valueOf(request.getParameter("absentCount"));
		print.change(response, "", staffimp.InputMeritAndPunish(id, weekendovertime, 
				festivalovertime, saleCommission, festivalWages, yearendWages, 
				leaveCount, lateCount, absentCount));
	}
	
	
	/**
	 * 重置奖惩信息
	 * @author 庞海
	 * @param response 响应前端
	 * @param id 用户的工号
	 * @return 无
	 * time:2021/2/7
	 */
	public void ResetMeritAndPunish(HttpServletResponse response, String id) {
		print = new JsonChange();
		staffimp = new StaffImp();
		print.change(response, "", staffimp.ResetMeritAndPunish(id));
	}
	
	
	/**
	 * 根据工号搜索一名员工的奖惩信息
	 * @author 庞海
	 * @param response 响应前端
	 * @param id 用户工号
	 * @return 无
	 * time:2021/2/7
	 */
	public void SearchStaffById(HttpServletResponse response, String id){
		print = new JsonChange();
		staffimp = new StaffImp();
		print.change(response, staffimp.SearchStaffMeritAndPunishById(id), true);

	}
	
	
/**
 * 用户管理控制器
 * 根据请求的不同返回不同的响应数据
 * @author 杨宇
 * 时间：2021/2/7
 * 
 */

public class StaffController {
	StaffImp staffImp = new StaffImp();
	JsonChange print = new JsonChange();
	public void getAllData(HttpServletResponse response , String id , String operator) {
		print.change(response, staffImp.queryAll(id), true);
	}
	
	public void modifyBaseData(HttpServletRequest request , HttpServletResponse response , String id , String name , String sex , String department , String telephone , int age) {
		//将除了基本数据的值置为0，并且不做修改
		Staff data = new Staff(id,"0","0", name, sex, age, telephone , "0" , 0, 0, 0, 0,department, "0" , "0" , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0);
		print.change(response, staffImp.modifyBaseData(data), true);
	}
	
	public void deleteUserById(HttpServletResponse response , String id) {
		print.change(response, staffImp.deleteById(id), true);
	}
	
	public void modifyOne(HttpServletRequest request , HttpServletResponse response , String id , String data , String key) {
		print.change(response, staffImp.modifyOne(id, data, key), true);
	}
	
	/**
	 * 获取所有员工的奖惩信息
	 * @author 庞海
	 * @param response 响应前端
	 * @return 无
	 * time:2021/2/7
	 */
	public void getAllStaffMeritAndPunish(HttpServletResponse response){
		print = new JsonChange();
		staffImp = new StaffImp();
		print.change(response, staffImp.ShowAllStaff(), true);
	}
	
	
	/**
	 * 录入奖惩信息
	 * @author 庞海
	 * @param request 请求后端
	 * @param response 响应前端
	 * @param id 用户的工号
	 * @return 无
	 * time:2021/2/7
	 */
	public void InputMeritAndPunish(HttpServletRequest request, HttpServletResponse response, 
			String id){
		print = new JsonChange();
		staffImp = new StaffImp();
		int weekendovertime = Integer.valueOf(request.getParameter("weekendovertime"));
		int festivalovertime = Integer.valueOf(request.getParameter("festivalovertime"));
		String temp = request.getParameter("saleCommission");
		int saleCommission;
		if(temp.equals("")) {
			saleCommission = 0;
		}else {
			saleCommission = Integer.valueOf(temp);
		}
		int festivalWages = Integer.valueOf(request.getParameter("festivalWages"));
		int yearendWages = Integer.valueOf(request.getParameter("yearendWages"));
		int lateCount = Integer.valueOf(request.getParameter("lateCount"));
		int leaveCount = Integer.valueOf(request.getParameter("leaveCount"));
		int absentCount = Integer.valueOf(request.getParameter("absentCount"));
		print.change(response, "", staffImp.InputMeritAndPunish(id, weekendovertime, 
				festivalovertime, saleCommission, festivalWages, yearendWages, 
				leaveCount, lateCount, absentCount));
	}
	
	
	/**
	 * 重置奖惩信息
	 * @author 庞海
	 * @param response 响应前端
	 * @param id 用户的工号
	 * @return 无
	 * time:2021/2/7
	 */
	public void ResetMeritAndPunish(HttpServletResponse response, String id) {
		print = new JsonChange();
		staffImp = new StaffImp();
		print.change(response, "", staffImp.ResetMeritAndPunish(id));
	}
	
	
	/**
	 * 根据工号搜索一名员工的奖惩信息
	 * @author 庞海
	 * @param response 响应前端
	 * @param id 用户工号
	 * @return 无
	 * time:2021/2/7
	 */
	public void SearchStaffById(HttpServletResponse response, String id){
		print = new JsonChange();
		staffImp = new StaffImp();
		print.change(response, staffImp.SearchStaffMeritAndPunishById(id), true);
	}
}
