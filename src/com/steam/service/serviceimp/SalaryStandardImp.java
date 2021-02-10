package com.steam.service.serviceimp;

import java.sql.PreparedStatement;

import com.steam.bean.SalaryStandard;
import com.steam.bean.Staff;
import com.steam.dao.SalaryStandardDao;
import com.steam.dao.StaffDao;
import com.steam.service.SalaryStandardService;
import com.steam.util.DBUtil;
import com.steam.util.SQLConstant;

public class SalaryStandardImp implements SalaryStandardService{
	SalaryStandardDao salaryStandardDao = new SalaryStandardDao();
	
	/**
	 * 查询薪资标准
	 * @return 返回薪资标准
	 */
	@Override
	public SalaryStandard getStandard() {
		return salaryStandardDao.getSalaryStandard();
	}
	
	/**
	 * 设置薪资标准
	 * 参数：
	 * @salaryStandard 各项薪资标准
	 * @return 操作是否成功
	 */
	@Override
	public boolean setStandard(SalaryStandard salaryStandard) {
		boolean flag = false;
		StaffImp staffImp = new StaffImp();
		//判断是否设置成功
		if(salaryStandardDao.setSalaryStandard(salaryStandard) != 0) {
			flag = true;
			staffImp.updateAllSalary();
		}
		return flag;
	}
}
