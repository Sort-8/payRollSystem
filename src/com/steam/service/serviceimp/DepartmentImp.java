package com.steam.service.serviceimp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.steam.bean.Department;
import com.steam.dao.DepartmentDao;
import com.steam.service.DepartmentService;

/**
 * 实现对部门增删查改的方法，并同时实现影响员工所属部门的方法
 * @author 庞海
 * 时间：2021/2/7
 * 
 */
public class DepartmentImp implements DepartmentService{
	DepartmentDao departmentdao = new DepartmentDao();
	
	/**
	 * 添加一个部门 
	 * 参数：
	 * @departmentName 部门名称
	 * @manager 经理帐号
	 * @operator 操作者
	 * @return 根据操作结果给出相应的字符串
	 * 
	 */
	@Override
	public boolean AddOneDepartment(String departmentName, String operator) {
		int rs = departmentdao.AddOneDepartment(departmentName, operator);
		if(rs!=-1) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * 删除部门
	 * 参数：
	 * @departmentName 部门名称
	 * @operator 删除操作员
	 * @return 根据操作结果给出相应的字符串
	 * 
	 */
	@Override
	public boolean DelOneDepartment(String departmentName, String operator) {
		if(departmentdao.DelOneDepartment(departmentName)!=0) { 
			DelStaffDepartment(departmentName);
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * 将指定部门的员工设为空
	 * 参数：
	 * @departmentName 部门名称
	 * @return：根据操作结果给出相应的字符串
	 * 
	 */
	private boolean DelStaffDepartment(String departmentName) {
		List<String> list = departmentdao.FindAllStaffIdByName(departmentName);
		int rs = departmentdao.UpdateAllStaffDepartmentById(list,"");
		if(rs!=-1) {
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * 更名部门
	 * 参数：
	 * @departmentName 原部门名称
	 * @changed_departmentName 新部门名称
	 * @operator 更名操作员
	 * @return 根据操作结果给出相应的字符串
	 * 
	 */
	@Override
	public boolean EditOneDepartment(String departmentName, String changed_departmentName, String changed_operator) {
		Department dep = departmentdao.FindDepartmentByName(changed_departmentName);
		if(dep==null) {
			int rs = departmentdao.EditOneDepartment(departmentName, changed_departmentName, changed_operator);
			if(rs!=-1) {
				UpdateStaffDepartment(departmentName,changed_departmentName);
				return true;
			}
		}
		return false;
	}

	
	/**
	 * 查询所有部门数据
	 * 无参数
	 * @return 包含实体类对象的List
	 * 
	 */
	@Override
	public List<Department> FindAllDepartment() {
		return departmentdao.FindAll();
	}
	
	/**
	 * 将员工的指定部门更改
	 * @参数：原部门名，更名后的部门名
	 * @返回值：根据操作结果给出相应的字符串
	 * 
	 */
	@Override
	public void UpdateStaffDepartment(String departmentName, String changed_departmentName) {
		List<String> list = departmentdao.FindAllStaffIdByName(departmentName);
		for (Iterator<String> it1 = list.iterator(); it1.hasNext();) {
			System.out.println(it1.next());
		}
		departmentdao.UpdateAllStaffDepartmentById(list,changed_departmentName);
	}
	
	
	/**
	 * 合并部门
	 * 参数：
	 * @list_name_by_before_department 包含部门名字的list
	 * @departmentName 合并后新部门名称
	 * @operator 合并操作者
	 * @return 根据操作结果给出相应的字符串
	 * 
	 */
	@Override
	public boolean MergeDepartment(List<String> list_name_by_before_department, String departmentName, String operator) { 
		int falg = 1;
		List<String> temp_list = new ArrayList<String>();
		List<String> list_id_by_before_department = new ArrayList<String>();
		
		
		/**
		 * 查询新部门是否与除合并外的现有部门相冲
		 */
		Department dep = departmentdao.FindDepartmentByName(departmentName);
		for (Iterator<String> it1 = list_name_by_before_department.iterator(); it1.hasNext();) {
			if(it1.next().equals(departmentName) || dep==null) { //可以查询到
				falg = 0;
			}
		}
		if(falg==1) {
			return false;
		}
			
		/**
		 * 找出合并前部门的员工id
		 */
		for (Iterator<String> it1 = list_name_by_before_department.iterator(); it1.hasNext();) {
			temp_list = departmentdao.FindAllStaffIdByName(it1.next()); 
			for (Iterator<String> it2 = temp_list.iterator(); it2.hasNext();) {  
				list_id_by_before_department.add(it2.next());
			}
		}
		
		/**
		 * 通过部门名称删除合并前部门
		 * 
		 */
		for (Iterator<String> it1 = list_name_by_before_department.iterator(); it1.hasNext();) {
			departmentdao.DelOneDepartment(it1.next());
		}
		
		/**
		 * 通过新部门名称添加新部门
		 * 
		 */
		departmentdao.AddOneDepartment(departmentName, operator);
		
		/**
		 * 将合并前部门员工的所属部门修改为新部门
		 * 
		 */
		departmentdao.UpdateAllStaffDepartmentById(list_id_by_before_department, departmentName);
		
		return true;
	}

	/**
	 * 将字符串中的字符提取出departmentName对应的值
	 * 参数：
	 * @data 字符串
	 * @return 字符数组
	 * 
	 * */
	@Override
	public List<String> JSONToString(String data) {
		List<String> res_list = new ArrayList<String>();
		String[] list = data.split(",");
		String[] list1;
		String str;
		for(int i=0;i<list.length;i++)
		{
			if((i+2)%3==0&&i!=0) {
				list1 = list[i].split(":");
				str = list1[1];
				str = str.replaceAll("\"", "");
				res_list.add(str);
			}	
		}
		return res_list;
	}

	
}