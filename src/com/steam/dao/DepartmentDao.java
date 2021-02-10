package com.steam.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.steam.bean.Department;
import com.steam.util.DBUtil;
import com.steam.util.SQLConstant;

/**
 * @author 庞海
 * 描述：对部门的增删查改
 * 操作的数据库是department
 * 时间：2021/2/7
 */
public class DepartmentDao {
	
	/**
	 * @author 庞海
	 * 添加一个部门
	 * @param name 部门名称
	 * @param operator 操作者
	 * @return int 执行添加操作影响的数据行数
	 * time:2021/2/7
	 */
	public int AddOneDepartment(String name, String operator) {
		PreparedStatement st = null;
		int rs = -1;
		String changedtime = DBUtil.getNowTime(); //获取当前时间
		String sql = SQLConstant.Insert_Department + "value(?,?,?);";
		st = DBUtil.getPreparedStatement(sql);
		try {
			st.setString(1, name);
			st.setString(2, changedtime);
			st.setString(3, operator);
			rs = st.executeUpdate();
		} catch (SQLException e) {
			System.out.println("部门管理模块：添加部门数据失败！！");
			e.printStackTrace();
		}
		return rs;
	}
	
	
	/**
	 * @author 庞海
	 * 删除一个部门
	 * @param 无
	 * @return int 执行删除操作影响的数据行数
	 * time:2021/2/7
	 */
	public int DelOneDepartment(String name) {
		int rs = 0;
		PreparedStatement st = null;
		String sql = SQLConstant.Delete_Department + "where name=?;";
		st = DBUtil.getPreparedStatement(sql);
		try {
			st.setString(1, name);
			rs = st.executeUpdate();
		} catch (SQLException e) {
			System.out.println("部门管理模块：数据库删除部门数据失败！！");
			e.printStackTrace();
		}
		return rs;	
	}
	
	
	/**
	 * @author 庞海
	 * 更改一个部门
	 * @param 无
	 * @return int 执行更改操作影响的数据行数
	 * time:2021/2/7
	 */
	public int EditOneDepartment(String name, String changed_name, String changed_operator) {
		int rs = -1;
		PreparedStatement st = null;
		String changedtime = DBUtil.getNowTime(); //获取当前时间
		String sql = SQLConstant.Update_Department + "set name='"+changed_name+"',changedtime='"+changedtime+"',operator='"+changed_operator+"' where name='"+name+"';";
		st = DBUtil.getPreparedStatement(sql);
		try {
			rs = st.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("部门管理模块：数据库更新部门数据失败！！");
			e.printStackTrace();
		}
		return rs;
	}
	
	
	/**
	 * @author 庞海
	 * 查询一个部门
	 * @param name 部门名称
	 * @return Department 查询成功返回部门实体类，否则返回它的默认值null
	 * time:2021/2/7
	 */
	public Department FindDepartmentByName(String name) {
		Department dep = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		String changedtime = DBUtil.getNowTime();
		String sql = SQLConstant.Select_Department + "where name=?";
		st = DBUtil.getPreparedStatement(sql);
		try {
			st.setString(1, name);
			rs = st.executeQuery();
			if(rs.next()) {
				dep = new Department();
				dep.setChangedtime(changedtime);
			}
		} catch (SQLException e) {
			System.out.println("部门管理模块：查询部门数据失败！！");
			e.printStackTrace();
		}
		return dep;
		
	}
	
	
	/**
	 * @author 庞海
	 * 查询所有部门
	 * @param 无
	 * @return List<Department> 部门名称数组
	 * time:2021/2/7
	 */
	public List<Department> FindAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		List<Department> list = new ArrayList<Department>();
		String sql = SQLConstant.Select_Department;
		st = DBUtil.getPreparedStatement(sql);
		try {
			rs = st.executeQuery();
			if(!rs.next()) { 
				System.out.println("部门管理模块：查询所有部门数据的结果集为空");
			}
			else { //结果集不为空，利用循环将实体类放在一个List中
				do {
					Department dep = new Department(); //实体类
					dep.setName(rs.getString("name"));
					dep.setChangedtime(rs.getString("changedtime"));
					dep.setOperator(rs.getString("operator"));
					list.add(dep);
				}while(rs.next());
			}
		} catch (SQLException e) {
			System.out.println("部门管理模块：查询所有部门数据失败！！");
			e.printStackTrace();
		}
		return list;
	}
	
	
	/**
	 * @author 庞海
	 * 通过部门名查询所有员工的id
	 * @param name 部门名称
	 * @return List<String> 特定部门员工的数组
	 */
	public List<String> FindAllStaffIdByName(String name) {
		List<String> list = new ArrayList<String>();
		PreparedStatement st = null;
		ResultSet rs = null;
		String sql = SQLConstant.Select_Userinfo + "where department=?";
		st = DBUtil.getPreparedStatement(sql);
		try {
			st.setString(1, name);
			rs = st.executeQuery();
			if(rs.next()) {
				do {
					list.add(rs.getString(1));
				}while(rs.next());
			}
			else { //结果集为空
				System.out.println("部门管理模块：查询所有员工的结果集为空");
			}
		} catch (SQLException e) {
			System.out.println("部门管理模块：查询所有员工的id失败");
			e.printStackTrace();
		}
		return list;
	}
	
	
	/**
	 * @author 庞海
	 * 通过员工工号更新特定部门员工的所属部门
	 * @param list 工号数组
	 * @param changed_name 部门名称
	 * @return int 执行更新操作影响的数据行数
	 */
	public int UpdateAllStaffDepartmentById(List<String> list, String changed_name) {
		int count = 0;
		int rs = -1;
		PreparedStatement st = null;
		for (Iterator<String> it = list.iterator(); it.hasNext();) {
			String sql = SQLConstant.Update_Userinfo + "set department=? where id=?";
			st = DBUtil.getPreparedStatement(sql);
			try {
				st.setString(1, changed_name);
				st.setString(2, it.next());
				rs = st.executeUpdate();
				count += rs;
			} catch (SQLException e) {
				System.out.println("更新员工部门出错 "+rs);
				e.printStackTrace();
			}
		}
		return count;
	}

}
