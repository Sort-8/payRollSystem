package com.steam.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

import com.steam.service.serviceimp.DepartmentImp;
import com.steam.util.JsonChange;

/**
 * 部门管理控制器
 * 根据请求的不同返回不同的响应数据
 * @author 庞海
 * 
 */
public class DepartController extends HttpServlet {
	DepartmentImp serviceimp = null;
	JsonChange print = null;
	
	
	/**
	 * 响应所有部门数据
	 * @author 庞海
	 * @param response 响应参数
	 * @return 无
	 */
	public void ShowAllDepartment(HttpServletResponse response){
		serviceimp = new DepartmentImp();
		print = new JsonChange();
		print.change(response, serviceimp.FindAllDepartment(), true);
	}
	
	
	/**
	 * 添加部门
	 * @author 庞海
	 * @param name 部门名称
	 * @param operator 操作者
	 * @param response 响应参数
	 * @return 无
	 * 
	 */
	public void AddDepartment( String name, String operator, HttpServletResponse response){
		serviceimp = new DepartmentImp(); 
		print = new JsonChange();
		print.change(response, "", serviceimp.AddOneDepartment(name, operator));
	}
	
	
	/**
	 * 删除部门
	 * @param name 部门名称
	 * @param operator 操作者
	 * @param response 响应参数
	 * @return 无
	 * 
	 */
	public void DelDepartment(String name, String operator, HttpServletResponse response){
		serviceimp = new DepartmentImp();
		print = new JsonChange();
		print.change(response, "", serviceimp.DelOneDepartment(name, operator));
	}
	
	
	/**
	 * 更名部门
	 * @param name 更名前部门名称
	 * @param changed_name 更名后部门名称
	 * @param operator 操作者
	 * @param response 响应参数
	 * @return 无
	 * 
	 */
	public void EditDepartment(String name, String changed_name, String operator, HttpServletResponse response){
		serviceimp = new DepartmentImp(); 
		print = new JsonChange();
		print.change(response, "",serviceimp.EditOneDepartment(name, changed_name, operator));
	}
	
	
	/**
	 * 合并部门
	 * @param name 部门名称
	 * @param operator 操作者
	 * @param data 合并选中的部门名称
	 * @param response 响应参数
	 * @return 无
	 * 
	 */
	public void MergeDepartment(String name, String operator, String data, HttpServletResponse response){
		serviceimp = new DepartmentImp(); 
		print = new JsonChange();
		List<String> list = new ArrayList<String>();
		list = serviceimp.JSONToString(data); 
		print.change(response, "", serviceimp.MergeDepartment(list, name, operator));
	}
}


