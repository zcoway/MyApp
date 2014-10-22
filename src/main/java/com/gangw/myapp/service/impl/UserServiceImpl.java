package com.gangw.myapp.service.impl;

import com.gangw.myapp.exception.UserExistException;
import com.gangw.myapp.model.vo.User;
import com.gangw.myapp.service.UserService;
/**
 * 用户管理服务器。负责查询用户、注册用户、锁定用户等操作
 * @author ggw
 *
 */
public class UserServiceImpl implements UserService{

	@Override
	public void register(User user) throws UserExistException {
		
	}

}
