package com.steam.service;

import java.util.List;

import com.steam.bean.Staff;

/**
 * 负责员工管理的接口
 */
public interface StaffService {
	/**
	 * @author 庞海
	 * 员工奖惩模块的接口
	 */
	public List<Staff> ShowAllStaff();
	public boolean InputMeritAndPunish(String id, int weekendovertime, int festivalovertime, 
			int saleCommission, int festivalWages, int yearendWages, int leaveCount, int lateCount,
			int absentCount);
	public boolean ResetMeritAndPunish(String id);
	public List<Staff> SearchStaffMeritAndPunishById(String id);
	
	/**
	 * 实现用户删除、查询、修改的接口
	 * @author 杨宇
 	* 时间：2021/2/7
 	* 
 	*/
	//查询所有用户
	public List<Staff> queryAll(String id);
	//修改用户基本数据
	public boolean modifyBaseData(Staff staff);
	//通过Id删除用户信息
	public boolean deleteById(String id);
	//修改用户的某个值
	public boolean modifyOne(String id , String data ,String key);
	
	
	public List<Staff> queryAllStaffById(String id);
	public int countMeritWages(Staff staff);
	public int countPunishingWages(Staff staff);
	public int countTotalWages(Staff staff);
	public void updateAllSalary();
	public boolean modifyOneSalary(String id , int salary , String key);
}
