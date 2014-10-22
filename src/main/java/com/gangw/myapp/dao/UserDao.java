package com.gangw.myapp.dao;

import java.util.List;

import com.gangw.myapp.model.dto.UserDTO;

public interface UserDao {
	/**
	 * 加载指定用户名的UserDTO对象
	 * @param username 用户名称
	 * @return 返回对应用户名的UseDTO对象，如果用户不存在，则返回null。
	 */
	UserDTO loadUserByUsername(String username);
	
	/**
	 * 根据用户名为模糊查询条件，查询出所有前缀匹配的UserDTO对象
	 * @param userName 用户名查询条件
	 * @return 用户名前缀匹配的所有UserDTO对象
	 */
	public List<UserDTO> queryUserByUserName(String userName);
		
}
