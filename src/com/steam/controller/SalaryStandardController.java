package com.steam.controller;

import javax.servlet.http.HttpServletResponse;

import com.steam.bean.SalaryStandard;
import com.steam.service.serviceimp.SalaryStandardImp;
import com.steam.util.JsonChange;
/**
 * 薪资标准控制器
 * 根据请求的不同返回不同的响应数据
 * @author 杨宇
 * 时间：2021/2/9
 * 
 */
public class SalaryStandardController {
	SalaryStandardImp salaryStandardImp = new SalaryStandardImp();
	JsonChange print = new JsonChange();
	public void showSalaryStandard(HttpServletResponse response) {
		print.change(response , salaryStandardImp.getStandard() , true);
	}
	
	public void setSalaryStandard(HttpServletResponse response , SalaryStandard salaryStandard) {
		print.change(response , salaryStandardImp.setStandard(salaryStandard) , true);
	}
}
