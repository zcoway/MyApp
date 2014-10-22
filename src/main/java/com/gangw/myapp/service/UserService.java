package com.gangw.myapp.service;

import com.gangw.myapp.exception.UserExistException;
import com.gangw.myapp.model.vo.User;

public interface UserService {
	/**
	 * 注册一个新用户，保存用户时需要确保用户的唯一性。不能有相同的用户存在 。
	 * @param user 用户信息对象
	 * @throws UserExistException 如果用户已存在，则抛出UserExistException异常
	 */
	void register(User user) throws UserExistException;

}
