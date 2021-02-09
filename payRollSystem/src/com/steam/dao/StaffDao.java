package com.steam.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
<<<<<<< HEAD
import java.sql.SQLException;
=======
<<<<<<< HEAD
import java.sql.SQLException;
=======
<<<<<<< HEAD
import java.sql.SQLException;
=======
>>>>>>> 1b279ae (这是Staff模块部分代码的提交)
>>>>>>> 82a47b2 (这是一个Staff模块代码)
>>>>>>> a7dd32c (这是一个Staff模块代码的提交)
import java.util.ArrayList;
import java.util.List;

import com.steam.bean.Staff;
import com.steam.util.DBUtil;
import com.steam.util.SQLConstant;
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 82a47b2 (这是一个Staff模块代码)
>>>>>>> a7dd32c (这是一个Staff模块代码的提交)


/**
 * 对用户表的增删查改
 * @author 庞海 如果有写在这的请加上名字，加上时请删掉这段话
 * time:2021/2/7
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
=======
/**
 * @author 杨宇
 * 描述：对用户及其信息的删查改
 * 操作的数据库是userInfo
 * 时间：2021/2/7
>>>>>>> 1b279ae (这是Staff模块部分代码的提交)
>>>>>>> 82a47b2 (这是一个Staff模块代码)
>>>>>>> a7dd32c (这是一个Staff模块代码的提交)
 */
public class StaffDao {
	
	/**
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 82a47b2 (这是一个Staff模块代码)
>>>>>>> a7dd32c (这是一个Staff模块代码的提交)
	 * @author 庞海
	 * 获取所有员工的奖惩信息
	 * @param 无
	 * time:2021/2/7
	 * @return List<Staff> 存放员工奖惩信息的数组
	 */
	public List<Staff> findAllStaffMeritAndPunish(){
		List<Staff> list = new ArrayList<>();
		PreparedStatement st = null;
		ResultSet  rs = null;
		String sql = SQLConstant.Select_Userinfo;
		st = DBUtil.getPreparedStatement(sql);
		try {
			rs = st.executeQuery();
			if(rs.next()) {
				do {
					Staff staff = new Staff(); //实体类
					staff.setId(rs.getString("id"));
					staff.setName(rs.getString("name"));
					staff.setDepartment(rs.getString("department"));
					staff.setWeekendovertime(rs.getInt("weekendovertime"));
					staff.setFestivalovertime(rs.getInt("festivalovertime"));
					staff.setLeaveCount(rs.getInt("leaveCount"));
					staff.setLateCount(rs.getInt("lateCount"));
					staff.setAbsentCount(rs.getInt("absentCount"));
					staff.setSaleCommission(rs.getInt("saleCommission"));
					staff.setFestivalWages(rs.getInt("festivalWages"));
					staff.setYearendWages(rs.getInt("yearendWages"));
					list.add(staff);
				}while(rs.next());
			}
			else {
				System.out.println("奖惩录入模块：查询员工所有数据的结果集为空！");
			}
		} catch (SQLException e) {
			System.out.println("奖惩录入模块：查询员工数据失败！！");
			e.printStackTrace();
		}
		return list;
	}
	
	
	/**
	 * @author 庞海
	 * 搜索一名员工的奖惩信息
	 * @param id 员工工号
	 * @return List<Staff> 存放员工奖惩信息的数组
	 */
	public List<Staff> SearchStaffMeritAndPunishById(String id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		Staff staff = null;
		List<Staff> list = new ArrayList<Staff>();
		String sql = SQLConstant.Select_Userinfo + " where id=?";
		st = DBUtil.getPreparedStatement(sql);
		try {
			st.setString(1, id);
			rs = st.executeQuery();
			if(rs.next()) {
				staff = new Staff();
				staff.setId(rs.getString("id"));
				staff.setName(rs.getString("name"));
				staff.setDepartment(rs.getString("department"));
				staff.setWeekendovertime(rs.getInt("weekendovertime"));
				staff.setFestivalovertime(rs.getInt("festivalovertime"));
				staff.setLeaveCount(rs.getInt("leaveCount"));
				staff.setLateCount(rs.getInt("lateCount"));
				staff.setAbsentCount(rs.getInt("absentCount"));
				staff.setSaleCommission(rs.getInt("saleCommission"));
				staff.setFestivalWages(rs.getInt("festivalWages"));
				staff.setYearendWages(rs.getInt("yearendWages"));
				list.add(staff);
			}else {
				System.out.println("奖惩录入模块：查询一位员工数据的结果集为空！");
			}
		} catch (SQLException e) {
			System.out.println("奖惩录入搜索模块：查询数据失败");
			e.printStackTrace();
		}
		return list;
	}
	
	
	/**
	 * @author 庞海
	 * 添加一名员工的奖惩信息
	 * @param id 员工工号
	 * @param weekendovertime 周末加班时长
	 * @param festivalovertime 节日加班时长
	 * @param saleCommission 销售提成
	 * @param festivalWages 福利奖金
	 * @param yearendWages 年终奖金
	 * @param leaveCount 请假次数
	 * @param lateCount 迟到次数
	 * @param absentCount 旷工次数
	 * @return int 执行添加操作影响的行数
	 * time:2021/2/7
	 */
	public int InputMPById(String id, int weekendovertime, int festivalovertime, 
			int saleCommission, int festivalWages, int yearendWages, int leaveCount, 
			int lateCount, int absentCount) {
		int rs = -1;
		PreparedStatement st = null;
		String sql = SQLConstant.Update_Userinfo + " set weekendovertime="+weekendovertime+", "
				+ "festivalovertime="+festivalovertime+", saleCommission="+saleCommission+", "
						+ "festivalWages="+festivalWages+", yearendWages="+yearendWages+", "
								+ "lateCount="+lateCount+",leaveCount="+leaveCount+", "
										+ "absentCount="+absentCount+" where id='"+id+"';";
		st = DBUtil.getPreparedStatement(sql);
		try {
			rs = st.executeUpdate();
		} catch (SQLException e) {
			System.out.println("奖惩录入模块：更新用户奖惩记录失败！");
			e.printStackTrace();
		}
		return rs;
	}
	public int ResetMPById(String id) {
		int rs = -1;
		PreparedStatement st = null;
		String sql = SQLConstant.Update_Userinfo + " set weekendovertime=0, "
				+ "festivalovertime=0, saleCommission=0, festivalWages=0, "
				+ "yearendWages=0, lateCount=0, leaveCount=0, absentCount=0 where id=?";
		st = DBUtil.getPreparedStatement(sql);
		try {
			st.setString(1, id);
			rs = st.executeUpdate();
		} catch (SQLException e) {
			System.out.println("奖惩录入模块：重置用户奖惩记录失败！");
			e.printStackTrace();
		}
		return rs;
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
=======
	 * 查询所有员工
	 * 参数：
	 * 	id:员工的工号(若为"null"则代表所有员工)
	 * 	params:代表的字符串拼接字段
	 * 返回值：用户的信息
	 *
	 */
	public List<Staff> queryAll(String id , String params){
		
		List<Staff> result = new ArrayList<Staff>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = SQLConstant.Select_Userinfo + params;
			pstmt = DBUtil.getPreparedStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
					Staff user = new Staff(rs.getString("id"),rs.getString("password"),rs.getString("power"),
							rs.getString("name"),rs.getString("sex"),rs.getInt("age"),rs.getString("telephone"),
							rs.getString("position"),rs.getInt("baseWages"),rs.getInt("meritWages"),rs.getInt("punishingWages"),
							rs.getInt("totalWages"),rs.getString("department"),rs.getString("status"),rs.getString("salaryAudit"),
							rs.getInt("weekendovertime"),rs.getInt("festivalovertime"),rs.getInt("saleCommission"),rs.getInt("festivalWages"),
							rs.getInt("yearendWages"),rs.getInt("lateCount"),rs.getInt("leaveCount"),rs.getInt("absentCount"));
					result.add(user);
			}
			rs.close();
			pstmt.close();
		} catch (Exception e) {
			System.out.println("用户模块，查询数据失败");
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * 修改用户基本数据
	 * 参数：
	 * 	user：用户要修改的信息
	 * 	count:受影响的行数
	 * 返回值：受影响的行数
	 */
	public int modifyBaseData(Staff user) {
		int count = 0;
		PreparedStatement pstmt = null;
		try {
			String sql = SQLConstant.Update_Userinfo + " SET id=? , name=? , sex=? , age=? , telephone=? , department=? WHERE id=?";
			pstmt = DBUtil.getPreparedStatement(sql);
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getName());
			pstmt.setString(3, user.getSex());
			pstmt.setInt(4, user.getAge());
			pstmt.setString(5, user.getTelephone());
			pstmt.setString(6, user.getDepartment());
			pstmt.setString(7, user.getId());
			count = pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e) {
			System.out.println("用户模块，基本数据修改失败");
			e.printStackTrace();
		}
		
		return count;
	}
	
	/**
	 * 删除该用户
	 * 参数：
	 * 	id：用户的id
	 * 返回值：受影响的行数
	 */
	public int deleteById(String id) {
		PreparedStatement pstmt = null;
		int flag = 0;
		try {
			String sql = SQLConstant.Delete_Userinfo + " where id = ?";
			pstmt = DBUtil.getPreparedStatement(sql);
			pstmt.setString(1, id);
			flag = pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e) {
			System.out.println("用户模块，删除用户失败");
			e.printStackTrace();
		}
		return flag;
	}
	
	/**
	 * 修改用户的某个信息
	 * 参数：
	 * 	key：需要修改的信息
	 * 	data:：修改信息的值
	 * 返回值：受影响的行数
	 */
	public int modifyOne(String id , String data ,String key) {
		int flag = 0;
		PreparedStatement pstmt = null;
		try {
			String sql = SQLConstant.Update_Userinfo + " SET "+key+"=? WHERE id=?";
			pstmt = DBUtil.getPreparedStatement(sql);
			pstmt.setString(1, data);
			pstmt.setString(2, id);
			flag = pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e) {
			System.out.println("用户模块，修改用户的某个值失败");
			e.printStackTrace();
		}
		return flag;
>>>>>>> 1b279ae (这是Staff模块部分代码的提交)
>>>>>>> 82a47b2 (这是一个Staff模块代码)
>>>>>>> a7dd32c (这是一个Staff模块代码的提交)
	}
}
