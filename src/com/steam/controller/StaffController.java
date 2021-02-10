package com.steam.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.steam.bean.Staff;
import com.steam.dao.StaffDao;
import com.steam.service.serviceimp.StaffImp;
import com.steam.util.JsonChange;


/**
 * 员工模块管理控制器
 * 根据请求的不同返回不同的响应数据
 * time:2021/2/7
 */
public class StaffController {
	JsonChange print = new JsonChange();  //返回响应
	StaffImp staffImp = new StaffImp(); //员工实现类
	
	/**
	 * 获取所有员工的奖惩信息
	 * @author 庞海
	 * @param response 响应前端
	 * @return 无
	 * time:2021/2/7
	 */
	public void getAllStaff(HttpServletResponse response){
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


	/**
	 * 用户管理控制器
	 * 根据请求的不同返回不同的响应数据
	 * @author 杨宇
	 * 时间：2021/2/7
	 * 
	 */
	public void SearchStaffById(HttpServletResponse response, String id){
		print.change(response, staffImp.SearchStaffMeritAndPunishById(id), true);

	}
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
	 * 刘行强
	 * @param response
	 */
	public void showAllSalary(HttpServletResponse response) {
		print.change(response , staffImp.queryAllSalary() , true);
	}
	
	public void Edit(HttpServletRequest request, HttpServletResponse response) {
		String id=request.getParameter("id");
		String password=request.getParameter("password");
		String name=request.getParameter("name");
		String sex=request.getParameter("sex");
		String age=request.getParameter("age");
		String telephone=request.getParameter("telephone");
		 int tage=Integer.parseInt(age);
		Staff admin=new Staff();
		admin.setId(id);
		admin.setPassword(password);
		admin.setName(name);
		admin.setSex(sex);
		admin.setAge(tage);
		admin.setTelephone(telephone);
		StaffDao editDao=new StaffDao();
		if(editDao.Edit(admin)==1) {
			try {
				response.getWriter().write("success");
			} catch (IOException e) {
				e.printStackTrace();
				}
		}
	}
}
