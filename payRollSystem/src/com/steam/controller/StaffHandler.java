package com.steam.controller;

<<<<<<< HEAD
import java.io.UnsupportedEncodingException;

=======
<<<<<<< HEAD
import java.io.UnsupportedEncodingException;

=======
<<<<<<< HEAD
import java.io.UnsupportedEncodingException;

=======
import java.io.IOException;

import javax.servlet.ServletException;
>>>>>>> 1b279ae (这是Staff模块部分代码的提交)
>>>>>>> 82a47b2 (这是一个Staff模块代码)
>>>>>>> a7dd32c (这是一个Staff模块代码的提交)
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.steam.util.Constant;

<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 82a47b2 (这是一个Staff模块代码)
>>>>>>> a7dd32c (这是一个Staff模块代码的提交)

/**
 * 拦截员工模块的请求
 * @author 庞海 如果有写在这的请加上名字，加上时请删掉这段话
 * time:2021/2/7
 */
public class StaffHandler extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding(Constant.RequestCharacterEncoding);//设置请求格式
			response.setContentType(Constant.ResponseCharacterEncoding); //设置响应格式
		} catch (UnsupportedEncodingException e) {
			System.out.println("请求和响应发生异常");
			e.printStackTrace();
		}
		StaffController controller = new StaffController(); //控制器
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
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		doGet(request, response);
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
=======
/**
 * 拦截用户模块的请求
 * @author 杨宇
 * 时间：2021/2/7
 * 
 */

public class StaffHandler extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding(Constant.RequestCharacterEncoding);
		
		StaffController staffController = new StaffController();
		String id = request.getParameter("id");	
		String method = request.getParameter("method");		//请求标识符
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
>>>>>>> 1b279ae (这是Staff模块部分代码的提交)
>>>>>>> 82a47b2 (这是一个Staff模块代码)
>>>>>>> a7dd32c (这是一个Staff模块代码的提交)
	}
}
