package com.gangw.myapp.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<T> {
	/**
	 * 根据ID加载PO实例
	 * 
	 * @param id
	 * @return 返回相应的持久化PO实例
	 */
	T load(Serializable id);

	/**
	 * 根据ID获取PO实例
	 * 
	 * @param id
	 * @return 返回相应的持久化PO实例
	 */
	T get(Serializable id);

	/**
	 * 获取PO的所有对象
	 * 
	 * @return
	 */
	List<T> loadAll();

	/**
	 * 保存PO
	 * 
	 * @param entity
	 */
	void save(T entity);

	/**
	 * 删除PO
	 * 
	 * @param entity
	 */
	void remove(T entity);

	/**
	 * 更改PO
	 * 
	 * @param entity
	 */
	void update(T entity);

	/**
	 * 执行HQL查询
	 * 
	 * @param sql
	 * @return 查询结果
	 */
	List find(String hql);

	/**
	 * 执行带参的HQL查询
	 * 
	 * @param sql
	 * @param params
	 * @return 查询结果
	 */
	List find(String hql, Object... params);

	/**
	 * 分页查询函数，使用hql.
	 * 
	 * @param pageNo
	 *            页号,从1开始.
	 */
	Page pagedQuery(String hql, int pageNo, int pageSize, Object... values);

	/**
	 * 创建Query对象.
	 * 对于需要first,max,fetchsize,cache,cacheRegion等诸多设置的函数,可以在返回Query后自行设置.
	 * 留意可以连续设置,如下：
	 * 
	 * <pre>
	 * dao.getQuery(hql).setMaxResult(100).setCacheable(true).list();
	 * </pre>
	 * 
	 * 调用方式如下：
	 * 
	 * <pre>
	 *        dao.createQuery(hql)
	 *        dao.createQuery(hql,arg0);
	 *        dao.createQuery(hql,arg0,arg1);
	 *        dao.createQuery(hql,new Object[arg0,arg1,arg2])
	 * </pre>
	 * 
	 * @param values
	 *            可变参数.
	 */
	//Query createQuery(String hql, Object... values);

}
