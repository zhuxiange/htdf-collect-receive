
package com.htdf.cc.mongodb;

import java.io.Serializable;
import java.util.List;


/**
* @ClassName: MongoSearchEntity
* @Description: mongodb查询分页实体类
* @author Administrator
* @date 2017年12月10日
*
*/

public class MongoSearchEntity implements Serializable
{
	
	
	private static final long serialVersionUID = 1L;
	/** 第一页 */
	private int				page	= 1;
	/** 每页10条记录 */
	private int				size	= 10;
	private List<String>	sortname;
	/** asc 1  desc 2 */
	private Integer			sortorder;
	public int getPage()
	{
		return page;
	}
	public void setPage(int page)
	{
		this.page = page;
	}
	public int getSize()
	{
		return size;
	}
	public void setSize(int size)
	{
		this.size = size;
	}
	public List<String> getSortname()
	{
		return sortname;
	}
	public void setSortname(List<String> sortname)
	{
		this.sortname = sortname;
	}
	public Integer getSortorder()
	{
		return sortorder;
	}
	public void setSortorder(Integer sortorder)
	{
		this.sortorder = sortorder;
	}
	
	
}
