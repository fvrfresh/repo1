package org.student.service.impl;

import java.util.List;

import org.student.dao.IStudentDao;
import org.student.impl.*;
import org.student.entity.Student;
import org.student.service.IStudentService;

//业务逻辑层：逻辑性的增删改查
public class StudentServiceImpl implements IStudentService
{
	IStudentDao studentDao = new StudentDaoImpl();
	//根据学号查询学生
	@Override
	public Student findOne(String num)
	{
		return studentDao.findOne(num);
	}
	//查询全部学生
	@Override
	public List<Student> findAll()
	{
		return studentDao.findAll();
	}
	@Override
	public boolean updateStudent(Student student)
	{
		if(studentDao.isExist(student.getStu_nu()))
		{
			return studentDao.updateStudent(student);
		}
		return false;
	}
	public boolean deleteStudentByNum(String num)
	{
		if(studentDao.isExist(num))
		{
			return studentDao.deleteStudentByNum(num);
		}
		return false;
	}
	public boolean addStudent(Student student)
	{
		if(!studentDao.isExist(student.getStu_nu()))
		{
			int count = studentDao.addStudent(student);
			return count > 0 ? true : false;
		}
		else
		{
			System.out.println("此人已存在！");
			return false;
		}
	}
	@Override
	//查询当前页的数据集合
	public List<Student> findByPage(int pageNum, int pageSize)
	{
		return studentDao.findByPage(pageNum, pageSize);
	}
	@Override
	//查询数据总条数
	public int getTotalCount()
	{
		Long count = studentDao.getTotalCount();
		return Integer.parseInt(count.toString());
	}
}
