package com.steam.service.serviceimp;

import java.sql.SQLException;

import com.steam.bean.Staff;
import com.steam.dao.StaffDao;
import com.steam.service.LoginService;


/*
 * 作者：杨永国
 * 描述内容：对接口的实现，接受CheckLoginServlet的调用与参数。
 * 并调用dao层的实现类，返回一个实体到CheckLoginServlet中调用处
 * 
 * 
 */

public  class LoginServletImpl implements LoginService {
    private StaffDao userDao=new StaffDao();//定义一个userDao的接口实例变量
	@Override
	public Staff selectALlAdmin2(String name, String password)  {	
		return userDao.selectALlAdmin2(name, password);
	}
}
