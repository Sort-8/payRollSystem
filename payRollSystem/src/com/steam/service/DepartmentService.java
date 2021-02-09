package com.steam.service;

import java.util.List;

import com.steam.bean.Department;

/**
 * 实现部门管理的接口
 * @author 庞海
 * 时间：2021/2/7
 * 
 */
public interface DepartmentService {
	public boolean AddOneDepartment(String departmentName, String operator);
	public boolean DelOneDepartment(String departmentName, String operator);
	public boolean EditOneDepartment(String departmentName, String changed_departmentName, String changed_operator);
	public void UpdateStaffDepartment(String departmentName, String changed_departmentName);
	public boolean MergeDepartment(List<String> list,String departmentName, String operator);
	public List<Department> FindAllDepartment();
	public List<String> JSONToString(String data);
}