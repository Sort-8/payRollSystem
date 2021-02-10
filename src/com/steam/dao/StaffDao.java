package com.steam.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.steam.bean.Staff;
import com.steam.util.DBUtil;
import com.steam.util.SQLConstant;



/**
 * 对用户表的增删查改， 对用户及其信息的删查改
 * time:2021/2/7
 */
public class StaffDao {
	
	/**
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
	}
	
	
	
	/**
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
			String sql = SQLConstant.Update_Userinfo + " where id = ?";
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
	}
	
	
	/*
	 * 作者：杨永国
	 * 描述内容：进行信息修改，通过密码进行数据库查找从而进行修改，返回1或0；
	 * 时间：2021.2.8
	 * 
	 * 
	 * 
	 */
	public int Edit(Staff admin) {
		DBUtil dbUtil=new DBUtil();
		String sql="update userinfo set  name=?,sex=?,age=?,telephone=? where password=?";
		PreparedStatement ps=(PreparedStatement) dbUtil.getPreparedStatement(sql);
		//ps.setString(1, admin.getPassword());
		try {
			ps.setString(1, admin.getName());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		try {
			ps.setString(2, admin.getSex());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			ps.setInt(3, admin.getAge());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			ps.setString(4, admin.getTelephone());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			ps.setString(5, admin.getPassword());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//ps.setString(6, admin.getId());
		int rs = 0;
		try {
			rs = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Admin admin=new Admin();
		while(rs==1) {
			
			return 1;
		}
		return 0;
	}
	
	
	/*
	 * 描述内容：接受MyselfinfoServlet传来的id进行数据库查找操作，并返回一个实体，用于个人信息的数据操作
	 * 
	 * 
	 */
	public Staff selectALlAdmin(String id) {
		DBUtil dbUtil=new DBUtil();
		String sql="select * from userinfo where id=?";
		PreparedStatement ps=(PreparedStatement) dbUtil.getPreparedStatement(sql);
		try {
			ps.setString(1, id);
			ResultSet rs=ps.executeQuery();
			Staff admin=new Staff();
			while(rs.next()) {
				admin.setId(rs.getString("id"));
				admin.setPassword(rs.getString("password"));
				admin.setName(rs.getString("name"));
				admin.setSex(rs.getString("sex"));
				admin.setAge(rs.getInt("age"));
				admin.setTelephone(rs.getString("telephone"));
				admin.setBaseWages(rs.getInt("baseWages"));
				admin.setMeritWages(rs.getInt("meritWages"));
				admin.setPunishingWages(rs.getInt("punishingWages"));
				admin.setTotalWages(rs.getInt("totalWages"));
				admin.setDepartment(rs.getString("department"));
				
				admin.setStatus(rs.getString("status"));
				
				admin.setSalaryAudit(rs.getString("salaryAudit"));
				admin.setWeekendovertime(rs.getInt("weekendovertime"));
				
				admin.setFestivalovertime(rs.getInt("festivalovertime"));
				admin.setSaleCommission(rs.getInt("saleCommission"));
				admin.setFestivalWages(rs.getInt("festivalWages"));
				admin.setYearendWages(rs.getInt("yearendWages"));
				admin.setLateCount(rs.getInt("lateCount"));
				admin.setLeaveCount(rs.getInt("leaveCount"));
				return admin;
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	/*
	 * 描述内容：接受LoginService层传来name,password进行数据库查找操作，并返回一个实体，用于登录的数据操作
	 * 
	 * 
	 */
	public Staff selectALlAdmin2(String name, String password)  {
		DBUtil dbUtil=new DBUtil();
		String sql="select * from userinfo where id=? and password=?";
		PreparedStatement ps=(PreparedStatement) dbUtil.getPreparedStatement(sql);
		try {
			ps.setString(1, name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			ps.setString(2, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet rs = null;
		try {
			rs = ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Staff admin=new Staff();
		try {
			while(rs.next()) {
				admin.setId(rs.getString("id"));
				admin.setPassword(rs.getString("password"));
				admin.setName(rs.getString("name"));
				admin.setSex(rs.getString("sex"));
				admin.setAge(rs.getInt("age"));
				admin.setTelephone(rs.getString("telephone"));
				admin.setBaseWages(rs.getInt("baseWages"));
				admin.setMeritWages(rs.getInt("meritWages"));
				admin.setPunishingWages(rs.getInt("punishingWages"));
				admin.setTotalWages(rs.getInt("totalWages"));
				admin.setDepartment(rs.getString("department"));
				admin.setStatus(rs.getString("status"));
				admin.setSalaryAudit(rs.getString("salaryAudit"));
				admin.setWeekendovertime(rs.getInt("weekendovertime"));
				admin.setFestivalovertime(rs.getInt("festivalovertime"));
				admin.setSaleCommission(rs.getInt("saleCommission"));
				admin.setFestivalWages(rs.getInt("festivalWages"));
				admin.setYearendWages(rs.getInt("yearendWages"));
				admin.setLateCount(rs.getInt("lateCount"));
				admin.setLeaveCount(rs.getInt("leaveCount"));
				return admin;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
		
	/**
	 * 对用户信息的查询和修改以及查询全公司各项薪资总额
	 * @author 刘行强
	 * 时间：2021/2/9
	 * 
	 */
	public List<Staff> queryAllStaffById(String id , String params){
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
	

	public int modifyOneSalary(String id , int data ,String key) {
		int flag = 0;
		PreparedStatement pstmt = null;
		try {
			String sql = SQLConstant.Update_Userinfo + " SET "+key+"=? WHERE id=?";
			pstmt = DBUtil.getPreparedStatement(sql);
			pstmt.setInt(1, data);
			pstmt.setString(2, id);
			flag = pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e) {
		System.out.println("用户模块，修改用户的某个薪资值失败");
		e.printStackTrace();
		}
		return flag;
	}
	
	public Staff queryAllSalary() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Staff staff = new Staff();
		try {
			String sql = SQLConstant.Select_Userinfo;
			pstmt = DBUtil.getPreparedStatement(sql);
			rs = pstmt.executeQuery();
			int baseWages = 0 ,meritWages = 0 ,punishingWages = 0 ,totalWages = 0 ,saleCommission = 0 ,festivalWages = 0 ,yearendWages = 0 ;
			while(rs.next()) {
				baseWages += rs.getInt("baseWages");
				meritWages += rs.getInt("meritWages");
				punishingWages += rs.getInt("punishingWages");
				totalWages += rs.getInt("totalWages");
				saleCommission += rs.getInt("saleCommission");
				festivalWages += rs.getInt("festivalWages");
				yearendWages += rs.getInt("yearendWages");
			}
			staff.setBaseWages(baseWages);
			staff.setMeritWages(meritWages);
			staff.setPunishingWages(punishingWages);
			staff.setTotalWages(totalWages);
			staff.setSaleCommission(saleCommission);
			staff.setFestivalWages(festivalWages);
			staff.setYearendWages(yearendWages);
			rs.close();
			pstmt.close();
		} catch (Exception e) {
		System.out.println("用户模块，修改用户的某个薪资值失败");
		e.printStackTrace();
		}
		return staff;
	}
}
