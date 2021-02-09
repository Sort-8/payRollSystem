package com.steam.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

<<<<<<< HEAD

=======
<<<<<<< HEAD

=======
<<<<<<< HEAD

=======
/**
 * 将实体类转换为Json字符串并返回前端的工具类
 * @author 杨宇
 * 参数：
 * @response 返回的响应头
 * @obj 要返回到前端的数据
 * @flag 成功或失败的标志(若成功则填写true，反之为false)
 *时间：2021/2/7
 */
>>>>>>> 1b279ae (这是Staff模块部分代码的提交)
>>>>>>> 82a47b2 (这是一个Staff模块代码)
>>>>>>> a7dd32c (这是一个Staff模块代码的提交)
public class JsonChange {
	public void change(HttpServletResponse response , Object obj , boolean flag) {
		try {
			Map map = new HashMap();
			if(flag == true) {			//正确返回
				map.put("code","0");
				map.put("msg", "success");
				map.put("item", obj);
			}else {						//错误返回
				map.put("code","1");
				map.put("msg", "fail");
			}
			PrintWriter out;
<<<<<<< HEAD
			response.setContentType("application/json;charset=UTF-8");
=======
<<<<<<< HEAD
			response.setContentType("application/json;charset=UTF-8");
=======
<<<<<<< HEAD
			response.setContentType("application/json;charset=UTF-8");
=======
			response.setContentType(Constant.ResponseCharacterEncoding);
>>>>>>> 1b279ae (这是Staff模块部分代码的提交)
>>>>>>> 82a47b2 (这是一个Staff模块代码)
>>>>>>> a7dd32c (这是一个Staff模块代码的提交)
			out = response.getWriter();
			String json = JSON.toJSONString(map);
			out.write(json);
		} catch (IOException e) {
			System.out.println("json转换错误!");
			e.printStackTrace();
		}
<<<<<<< HEAD
		
=======
<<<<<<< HEAD
		
=======
<<<<<<< HEAD
		
=======
>>>>>>> 1b279ae (这是Staff模块部分代码的提交)
>>>>>>> 82a47b2 (这是一个Staff模块代码)
>>>>>>> a7dd32c (这是一个Staff模块代码的提交)
	}
}
