package com.gangw.myapp.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

import com.gangw.myapp.dao.BaseDao;
import com.gangw.myapp.dao.UserDao;
import com.gangw.myapp.model.dto.UserDTO;
import com.gangw.myapp.model.vo.User;
@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao,BaseDao<User> {
	
	private static final String DEF_USER_BY_USERNAME_QUERY = "select email,password from common$user u where u.user_account = ?";
	@Autowired
	private LocalSessionFactoryBean localSessionFactoryBean;
	@Override
	public User loadUserByUsername(final String username) {
		return getHibernteTemplate().execute(new HibernateCallback<User>() {

			@Override
			public User doInHibernate(Session session)
					throws HibernateException {
				return (User) session.createSQLQuery(DEF_USER_BY_USERNAME_QUERY).setString(0, username).uniqueResult();
			}
		});
//		
//		List<UserDTO> users =  (List<UserDTO>) getHibernteTemplate().find(DEF_USER_BY_USERNAME_QUERY, username);
//		if(users.size() == 0){
//			return null;
//		}
//		
//		return users.get(0);
	}

	@Override
	public List<UserDTO> queryUserByUserName(String userName) {
		return null;
	}

}
