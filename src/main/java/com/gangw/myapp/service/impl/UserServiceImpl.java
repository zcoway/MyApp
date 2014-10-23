package com.gangw.myapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gangw.myapp.dao.UserDao;
import com.gangw.myapp.dao.impl.UserDaoImpl;
import com.gangw.myapp.exception.UserExistException;
import com.gangw.myapp.model.dto.UserDTO;
import com.gangw.myapp.model.vo.User;
import com.gangw.myapp.service.UserService;
/**
 * 用户管理服务器。负责查询用户、注册用户、锁定用户等操作
 * @author ggw
 *
 */
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	public User getUser(String username){
		return userDao.loadUserByUsername(username);
	}
	
	
	@Override
	public void register(User user) throws UserExistException {
		
	}

}
