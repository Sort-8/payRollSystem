package com.steam.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.steam.bean.SalaryStandard;
import com.steam.util.Constant;
/**
 * 拦截薪资标准模块的请求
 * @author 刘行强
 * 时间：2021/2/9
 * 
 */
public class SalaryStandardHandler extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response){
		doPost(request , response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response){
		try {
			request.setCharacterEncoding(Constant.RequestCharacterEncoding);
			String method = request.getParameter("method");
			SalaryStandardController salaryStandardController = new SalaryStandardController();
			if("showSalaryStandard".equals(method)) {
				salaryStandardController.showSalaryStandard(response);
			}else if("setSalaryStandard".equals(method)) {
				int lateStandard = Integer.parseInt(request.getParameter("lateStandard"));
				int absentStandard = Integer.parseInt(request.getParameter("absentStandard"));
				int overtimeStandard = Integer.parseInt(request.getParameter("overtimeStandard"));
				SalaryStandard salaryStandard = new SalaryStandard(lateStandard , absentStandard , overtimeStandard);
				salaryStandardController.setSalaryStandard(response , salaryStandard);
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}
