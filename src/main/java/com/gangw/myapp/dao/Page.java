package com.gangw.myapp.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.Assert;

/**
 * 分页对象，包含了分页信息如总记录数
 * 
 * @author ggw
 * 
 * @param <T>
 *            the type of which the page consists.
 */
public class Page<T> {

	public static final int DEFAULT_PAGE_SIZE = 10; // 每页条数的默认值

	private int pageSize = DEFAULT_PAGE_SIZE; // 每页记录数

	private final long start; // 当前页第一条数据在List中的位置，从0开始

	private final List<T> data; // 当前页中存放的记录

	private final long total; // 总记录数

	/**
	 * Constructor of {@code Page}.
	 * 
	 * @param start
	 *            本页数据在数据库中的起始位置，从0开始。
	 * @param pageSize
	 *            the pageSize of the page to be returned.
	 * @param data
	 *            the data of this page
	 * @param total
	 *            the total amount of items available.
	 */
	public Page(long start, int pageSize, List<T> data, long total) {
		Assert.isTrue(
				(start > -1 && (total > 0 ? start < total : true)),
				"start index must not be zero or index is greater than or equal to the number of items in the list");
		Assert.isTrue(pageSize > 0,"page size must not be less than one");
		
		this.start = start;
		this.total = total;
		this.pageSize = pageSize;
		this.data = (null == data ? new ArrayList<T>() : data);
	}
	/**
	 * Constructor of {@code Page} with Default page size.
	 * 
	 * @see Page#Page(long, int, List, long)
	 */
	public Page(long start, List<T> data, long total){
		this(start,DEFAULT_PAGE_SIZE,data,total);
	}
	
	/**
	 * Constructor an empty {@code Page}.
	 */
	public Page(){
		this(0,DEFAULT_PAGE_SIZE,new ArrayList<T>(),0L);
	}

	/**
	 * 取得每页记录数
	 * 
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * 取得当前页的数据
	 * 
	 */
	public List<T> getData() {
		return data;
	}

	/**
	 * 取得总记录数
	 * 
	 */
	public Long getTotal() {
		return total;
	}

	/**
	 * 取得总页数
	 * 
	 */
	public int getTotalPages() {// (total + pageSize -1)/pageSize;
		return (int) Math.ceil((double) total / (double) pageSize);
	}
	
	/**
	 * 取得该页当前页码，从1开始。
	 */
	public int getCurrentPage(){
		return (int) (start / pageSize + 1);
	}
	
	/**
	 * 该页是否有上一页
	 */
	public boolean hasPrevious() {
		return getCurrentPage() > 1;
	}
	
	/**
	 * 该页是否有下一页
	 */
	public boolean hasNext() {
		return getCurrentPage() < getTotalPages();
	}
	
	/**
	 * 获取任一页第一条数据在数据集中的位置，从0开始
	 * @param pageNo 页码，从1开始
	 * @param pageSize 每页记录条数
	 * @return 该页第一条数据在数据库中的起始位置
	 */
	public static int getStartOfPage(int pageNo,int pageSize){
		return (pageNo - 1) * pageSize;
	}
	
	/**
	 * 获取任一页第一条数据在数据集中的位置，每页条数使用默认值。
	 * @see Page#getStartOfPage(int, int)
	 */
	public static int getStartOfPage(int pageNO){
		return (pageNO - 1) * DEFAULT_PAGE_SIZE;
	}
	
}
