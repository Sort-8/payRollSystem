package com.steam.service;

import java.sql.SQLException;

import com.steam.bean.Staff;


/*
 * 作者：杨永国
 * 描述内容：创建业务逻辑的接口
 */

public interface LoginService {
	 public Staff selectALlAdmin2(String name,String password);
}
