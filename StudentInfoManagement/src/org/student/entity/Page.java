package org.student.entity;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class Page
{
	private int pageNum;
	private int pageSize;
	private int totalCount;
	private int totalPage;
	private List<Student> students;
	public int getPageNum()
	{
		return pageNum;
	}
	public void setPageNum(int pageNum)
	{
		this.pageNum = pageNum;
	}
	public int getPageSize()
	{
		return pageSize;
	}
	public void setPageSize(int pageSize)
	{
		this.pageSize = pageSize;
		BigDecimal exactTotalCount = new BigDecimal(this.totalCount);
		BigDecimal exactPageSize = new BigDecimal(this.pageSize);
		int proxPage = exactTotalCount.divide(exactPageSize, RoundingMode.FLOOR).intValue();
		int extra = this.totalCount % this.pageSize;
		this.totalPage = extra == 0 ? proxPage : proxPage + 1;
	}
	public int getTotalCount()
	{
		return totalCount;
	}
	public void setTotalCount(int totalCount)
	{
		this.totalCount = totalCount;
	}
	public int getTotalPage()
	{
		return totalPage;
	}
	
	public List<Student> getStudents()
	{
		return students;
	}
	public void setStudents(List<Student> students)
	{
		this.students = students;
	}
	//	public void setTotalPage(int totalPage)
//	{
//		this.totalPage = totalPage;
//	}
	@Override
	public String toString()
	{
		return "Page [pageNum=" + pageNum + ", pageSize=" + pageSize + ", totalCount=" + totalCount + ", totalPage="
				+ totalPage + "]";
	}
	
}
