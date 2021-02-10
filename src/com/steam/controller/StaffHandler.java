package com.steam.controller;


import java.io.UnsupportedEncodingException;

import java.io.UnsupportedEncodingException;


import java.io.UnsupportedEncodingException;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.steam.util.Constant;


/**
 * 拦截员工模块的请求
 * time:2021/2/7
 */
public class StaffHandler extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		/**
		 * 设置请求格式和响应格式
		 */
		try {
			request.setCharacterEncoding(Constant.RequestCharacterEncoding);
			response.setContentType(Constant.ResponseCharacterEncoding); 
		} catch (UnsupportedEncodingException e) {
			System.out.println("请求和响应发生异常");
			e.printStackTrace();
		}
		StaffController controller = new StaffController(); //控制器
		
		/**
		 * 获取请求携带的参数
		 */
		String method = request.getParameter("method");
		String id = request.getParameter("id");  
		
		if(method.equals("getAllStaffMeritAndPunish")||( method.equals("searchStaffMeritAndPunishById")&&id.equals("") )) {
			controller.getAllStaff(response);
		}else if(method.equals("inputMeritAndPunish")) {
			controller.InputMeritAndPunish(request, response, id);
		}else if(method.equals("searchStaffMeritAndPunishById")) {
			controller.SearchStaffById(response, id);
		}else if(method.equals("resetMeritAndPunish")) {
			controller.ResetMeritAndPunish(response, id);
		}
		
		
		/*
		* 杨宇
		*
		*/
		StaffController staffController = new StaffController();
		String operator = request.getParameter("operator");		//操作人的id
		if(method.equals("showAll")) {	//展示所有数据
			staffController.getAllData(response, id , operator);
		}else if(method.equals("modifyBaseData")) {	//修改基本数据
			String name = request.getParameter("name");
			String sex = request.getParameter("sex");
			String department = request.getParameter("department");
			String telephone = request.getParameter("telephone");
			int age = Integer.parseInt(request.getParameter("age"));
			staffController.modifyBaseData(request, response, id, name, sex, department, telephone, age);
		}else if(method.equals("deleteUserById")) {	//通过id删除
			staffController.deleteUserById(response, id);
		}else if(method.equals("modifyOne")) {		//修改数据库中的某个字段
			String data = request.getParameter("data");
			String key = request.getParameter("key");
			staffController.modifyOne(request, response, id, data, key);
		}
		
		
		/**
		 * 刘行强
		 */
		try {
			request.setCharacterEncoding(Constant.RequestCharacterEncoding);
			if("showAllSalary".equals(method)) {
				staffController.showAllSalary(response);
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		/**
		 * 杨永国
		 */
		String Edit = request.getParameter("method");
		if(Edit.equals("Edit")) {
			controller.Edit(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		doGet(request, response);
		
	}
}
