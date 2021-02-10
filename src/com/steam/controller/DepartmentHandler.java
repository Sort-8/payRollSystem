
package com.steam.controller;

import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截部门管理模块的请求
 * @author 庞海
 * time:2021/2/7
import com.steam.util.Constant;

/**
 * 拦截部门管理模块的请求
 * @author 庞海
 * 时间：2021/2/7
 * 
 */
public class DepartmentHandler extends HttpServlet{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		doGet(request, response);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response){
		try {
			request.setCharacterEncoding("utf-8");//设置请求格式
			response.setContentType("text/json;charset=utf-8"); //设置响应格式
		} catch (UnsupportedEncodingException e1) {
			System.out.println("请求和响应发生异常");
		}
		DepartController hand = new DepartController();
		String method = request.getParameter("method");          //请求使用的方法
		String name = request.getParameter("name");          //部门名称
		String changed_name = request.getParameter("changed_name");  //编辑后部门名称
		String operator = request.getParameter("operator");  //当前用户的帐号
		String data = request.getParameter("data");          //合并时选中的部门名称组成的JSON字符串
		if(method.equals("getAll")) {
			hand.ShowAllDepartment(response);
		}else if(method.equals("add")) {
			hand.AddDepartment(name, operator, response);
		}else if(method.equals("del")) {
			hand.DelDepartment(name, operator, response);
		}else if(method.equals("edit")) {
			hand.EditDepartment(name, changed_name, operator, response);
		}else if(method.equals("merge")) {
			hand.MergeDepartment(name, operator, data, response);
		}
	}
	
}
