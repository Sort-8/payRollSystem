package com.steam.service.serviceimp;

import java.util.List;

import com.steam.bean.Staff;
import com.steam.dao.StaffDao;
import com.steam.service.StaffService;

/**
 * 实现每个用户的查询、修改、删除操作
 * @author 杨宇
 * 时间：2021/2/7
 * 
 */

public class StaffImp implements StaffService{
	StaffDao staffDao = new StaffDao();
	/**
	 * 查询员工的所有信息
	 * 参数：
	 * @id 查询用户的工号(若id的值为字符串"null"则表示查询所有人)
	 * @params 拼接的字段
	 * @return 员工所有的信息
	 * 
	 */
	@Override
	public List<Staff> queryAll(String id) {
		String params = "";
		if(!id.equals("null")) {
			params = " WHERE id='"+id+"'";
		}
		return staffDao.queryAll(id , params);
	}
	
	/**
	 * 通过员工id修改员工的基本信息
	 * 参数：
	 * @staff 一个实体类，存放用户修改后的基本信息
	 * @return 修改成功返回true，反之返回false
	 * 
	 */
	@Override
	public boolean modifyBaseData(Staff staff) {
		if(staffDao.modifyBaseData(staff) != 0) {
			return true;
		}
		return false;
	}
	
	/**
	 * 通过id删除员工
	 * 参数：
	 * @id 员工的工号
	 * @return 删除成功返回true，反之返回false
	 */
	@Override
	public boolean deleteById(String id) {
		if(staffDao.deleteById(id) != 0) {
			return true;
		}
		return false;
	}
	
	/**
	 * 通过id删除员工
	 * 参数：
	 * @id 员工的工号
	 * @key 要修改的数据
	 * @data 要修改数据的值
	 * @return 修改成功返回true，反之返回false
	 */
	@Override
	public boolean modifyOne(String id , String data ,String key) {
		if(staffDao.modifyOne(id, data, key) != 0) {
			return true;
		}
		return false;
	}
	
	/**
	 * @author 庞海
	 * 获取所有员工的奖惩信息
	 * @return List<Staff> 存放员工奖惩信息的数组
	 * @param 无
	 * time:2021/2/7
	 */
	@Override
	public List<Staff> ShowAllStaff() {
		return staffDao.findAllStaffMeritAndPunish();
	}

	
	/**
	 * @author 庞海
	 * 添加一名员工的奖惩信息
	 * @return boolean 是否添加成功，成功返回true，失败返回false
	 * @param id 员工工号
	 * @param weekendovertime 周末加班时长
	 * @param festivalovertime 节日加班时长
	 * @param saleCommission 销售提成
	 * @param festivalWages 福利奖金
	 * @param yearendWages 年终奖金
	 * @param leaveCount 请假次数
	 * @param lateCount 迟到次数
	 * @param absentCount 旷工次数
	 * time:2021/2/7
	 */
	@Override
	public boolean InputMeritAndPunish(String id, int weekendovertime, int festivalovertime, 
			int saleCommission, int festivalWages, int yearendWages, int leaveCount, int lateCount, 
			int absentCount) {
		staffDao = new StaffDao();
		int rs = staffDao.InputMPById(id, weekendovertime, festivalovertime, saleCommission,
				festivalWages, yearendWages, leaveCount, lateCount, absentCount);
		if( rs !=-1) {
			return true;
		}else {
			return false;
		}
	}
	
	
	/**
	 * @author 庞海
	 * 通过id搜索一名员工的奖惩信息
	 * @return List<Staff> 存放员工奖惩信息的数组
	 * @param id 员工工号
	 * time:2021/2/7
	 */
	@Override
	public List<Staff> SearchStaffMeritAndPunishById(String id) {
		staffDao = new StaffDao();
		return staffDao.SearchStaffMeritAndPunishById(id);
	}

	
	/**
	 * @author 庞海
	 * 重置一名员工的奖惩信息
	 * @return boolean 是否重置成功，成功返回true，失败返回false
	 * @param id 员工工号
	 * time:2021/2/7
	 */
	@Override
	public boolean ResetMeritAndPunish(String id) {
		int rs = staffDao.ResetMPById(id);
		if( rs != -1) {
			return true;
		}else {
			return false;
		}
	}
}
