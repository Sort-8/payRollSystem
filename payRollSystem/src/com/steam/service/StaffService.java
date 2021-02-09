package com.steam.service;

import java.util.List;
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 82a47b2 (这是一个Staff模块代码)
>>>>>>> a7dd32c (这是一个Staff模块代码的提交)

import com.steam.bean.Staff;

/**
 * 负责员工管理的接口
 */
public interface StaffService {
	public List<Staff> ShowAllStaff();
	public boolean InputMeritAndPunish(String id, int weekendovertime, int festivalovertime, 
			int saleCommission, int festivalWages, int yearendWages, int leaveCount, int lateCount,
			int absentCount);
	public boolean ResetMeritAndPunish(String id);
	public List<Staff> SearchStaffMeritAndPunishById(String id);
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
=======
import com.steam.bean.Staff;

/**
 * 实现用户删除、查询、修改的接口
 * @author 杨宇
 * 时间：2021/2/7
 * 
 */
public interface StaffService {
	//查询所有用户
	public List<Staff> queryAll(String id);
	//修改用户基本数据
	public boolean modifyBaseData(Staff staff);
	//通过Id删除用户信息
	public boolean deleteById(String id);
	//修改用户的某个值
	public boolean modifyOne(String id , String data ,String key);
>>>>>>> 1b279ae (这是Staff模块部分代码的提交)
>>>>>>> 82a47b2 (这是一个Staff模块代码)
>>>>>>> a7dd32c (这是一个Staff模块代码的提交)
	
}
