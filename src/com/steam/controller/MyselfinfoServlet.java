package com.steam.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.ha.ClusterSession;

import com.alibaba.fastjson.JSON;
import com.steam.dao.StaffDao;
import com.steam.util.Constant;

/*
 * 
 *作者：杨永国
 *描述内容：通过session获取前端的数据，并通过json的格式返回数据到前端；并渲染到个人信息HTML中
 * 时间：2021.2.7
 * 
 */

public class MyselfinfoServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)  {
		HttpSession session=request.getSession(false);//获取前端登录的数据
		String id = null; 
		if(session!=null) {
			id=(String) session.getAttribute("name");
		}
		StaffDao user = new StaffDao();
		PrintWriter out = null;
		response.setContentType(Constant.ResponseCharacterEncoding);
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String json = JSON.toJSONString(user.selectALlAdmin(id));
		System.out.println(json);
		out.write(json);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)  {
		doGet(request, response);
	}

}
