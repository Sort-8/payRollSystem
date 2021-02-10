package com.steam.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.steam.bean.SalaryStandard;
import com.steam.bean.Staff;
import com.steam.util.DBUtil;
import com.steam.util.SQLConstant;

/**
 * 对薪资标准的修改和查询
 * @author 刘行强
 * 时间：2021/2/9
 * 
 */

public class SalaryStandardDao {
	
	/**
	 * @author 刘行强
	 * 获取薪资标准
	 * @return SalaryStandard 存放各项薪资标准的实体类
	 */
	public SalaryStandard getSalaryStandard() {
		SalaryStandard salaryStandard = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = SQLConstant.Select_Standard;
			pstmt = DBUtil.getPreparedStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				salaryStandard = new SalaryStandard(0 , 0 , 0);
				salaryStandard.setAbsentStandard(rs.getInt("absentStandard"));
				salaryStandard.setLateStandard(rs.getInt("lateStandard"));
				salaryStandard.setOvertimeStandard(rs.getInt("overtimeStandard"));
			}
			rs.close();
			pstmt.close();
		} catch (Exception e) {
			System.out.println("薪资标准模块，查询数据失败");
			e.printStackTrace();
		}
		return salaryStandard;
	}
	
	/**
	 * @author 刘行强
	 * 设置各项薪资标准
	 * @salaryStandard 需要修改的各项薪资标准
	 * @return int 返回修改收到影响的行数
	 */
	public int setSalaryStandard(SalaryStandard salaryStandard) {
		int flag = 0;
		PreparedStatement pstmt = null;
		try {
			String sql = SQLConstant.Update_Standard + " SET overtimeStandard=? , absentStandard=? , lateStandard=?";
			pstmt = DBUtil.getPreparedStatement(sql);
			pstmt.setInt(1, salaryStandard.getOvertimeStandard());
			pstmt.setInt(2, salaryStandard.getAbsentStandard());
			pstmt.setInt(3, salaryStandard.getLateStandard());
			flag = pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e) {
		System.out.println("薪资标准模块，设置薪资标准失败");
		e.printStackTrace();
		}
		return flag;
	}
}
