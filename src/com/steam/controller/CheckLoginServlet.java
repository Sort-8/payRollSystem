package com.steam.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;
import com.steam.bean.Staff;
import com.steam.service.LoginService;
import com.steam.service.serviceimp.LoginServletImpl;
import com.steam.util.Constant;


/**
 * 作者：杨永国
 * 描述内容：获取前端的数据，通过调用service层进行返回一个实体admin，
 *         admin进行判断NULL，并通过json的格式返回数据到前端；
 *         进行账号登录！
 * 时间：2021.2.7
 *
 */
public class CheckLoginServlet extends HttpServlet {
    private LoginService loginService=new LoginServletImpl();//定义一个接口的实例变量
	protected void doGet(HttpServletRequest request, HttpServletResponse response)  {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)  {
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		HttpSession session=request.getSession();//通过session的方法进行前端数据的存储
		session.setAttribute("name", name);
			Staff admin;
			admin=loginService.selectALlAdmin2(name, password);
			if(admin!=null) {
				PrintWriter out = null;
				response.setContentType(Constant.ResponseCharacterEncoding);
				try {
					out=response.getWriter();
				} catch (IOException e) {
					e.printStackTrace();
				}
				String json=JSON.toJSONString(admin);
				out.write(json);
			}else {
				try {
					response.getWriter().write("fail");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		     
		
	}
}
	
