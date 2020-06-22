package org.student.service;

import java.util.List;

import org.student.entity.Student;

//业务逻辑层：逻辑性的增删改查
public interface IStudentService
{
	//根据学号查询学生
	public Student findOne(String num);
	//查询全部学生
	public List<Student> findAll();
	public List<Student> findByPage(int pageNum, int pageSize);
	public int getTotalCount();
	public boolean updateStudent(Student student);
	public boolean deleteStudentByNum(String num);
	public boolean addStudent(Student student);
}
