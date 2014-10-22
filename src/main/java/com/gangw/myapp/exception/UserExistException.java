package com.gangw.myapp.exception;

import org.springframework.security.core.userdetails.User;

/**
 * Thrown if an {@link UserService} implementation cannot locate a {@link User} by its username.
 * @author ggw
 *
 */
public class UserExistException extends Exception{
	private static final long serialVersionUID = 517970426738554880L;
	/**
	 * Constructor a {@code UserExistException} with specified message
	 * @param msg the detail message
	 */
	public UserExistException(String msg) {
		super(msg);
	}
	/**
	 * Constructor a {@code UserExistException} with the specified message and root cause
	 * @param msg the detail message
	 * @param t root cause
	 */
	public UserExistException(String msg,Throwable t){
		super(msg,t);
	}
	
}
