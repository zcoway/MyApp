package com.gangw.myapp.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;

import com.gangw.myapp.dao.BaseDao;
import com.gangw.myapp.dao.Page;
/**
 * DAO基类，其它DAO可以继承这个DAO。
 * 
 * @author 国威
 *
 * @param <T>
 */
public class BaseDaoImpl<T> implements BaseDao<T>{

	private Class<T> entity;

	@Autowired
	private HibernateTemplate hibernteTemplate;
	
	public BaseDaoImpl() {
		Type genType = getClass().getGenericSuperclass();
		Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
		entity = (Class<T>) params[0];
	}
	
	@Override
	public T load(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T get(Serializable id) {
		return null;
	}

	@Override
	public List<T> loadAll() {
		return null;
	}

	@Override
	public void save(T entity) {
		
	}

	@Override
	public void remove(T entity) {
		
	}

	@Override
	public void update(T entity) {
		
	}

	@Override
	public List find(String hql) {
		return null;
	}

	@Override
	public List find(String hql, Object... params) {
		return null;
	}

	@Override
	public Page pagedQuery(String hql, int pageNo, int pageSize,
			Object... values) {
		return null;
	}

	public HibernateTemplate getHibernteTemplate() {
		return hibernteTemplate;
	}
}
