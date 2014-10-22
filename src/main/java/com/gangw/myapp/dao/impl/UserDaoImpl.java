package com.gangw.myapp.dao.impl;

import java.util.List;

import com.gangw.myapp.dao.BaseDao;
import com.gangw.myapp.dao.UserDao;
import com.gangw.myapp.model.dto.UserDTO;
import com.gangw.myapp.model.vo.User;

public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao,BaseDao<User> {
	
	private static final String DEF_USER_BY_USERNAME_QUERY = "select * from User u where u.username = ?";
	
	@Override
	public UserDTO loadUserByUsername(String username) {
		List<UserDTO> users =  (List<UserDTO>) getHibernteTemplate().find(DEF_USER_BY_USERNAME_QUERY, username);
		if(users.size() == 0){
			return null;
		}
		
		return users.get(0);
	}

	@Override
	public List<UserDTO> queryUserByUserName(String userName) {
		return null;
	}

	public static void main(String[] args) {
		new UserDaoImpl();
	}
}
