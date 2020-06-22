package org.student.dao;

import java.util.List;
import java.util.Map;

import org.student.entity.Page;
import org.student.entity.Student;

public interface IStudentDao
{
	boolean isExist(String num);
	/**
	 * 查询所有学生
	 * @return
	 */
	List<Student> findAll();
	
	/**
	 * 查询某位学生
	*/
	Student findOne(String id);
	
	/**
	 * 更新学生信息
	 */
	boolean updateStudent(Student data);
	
	/**
	 * 查询多个学生
	 */
	List<Student> findSome(String cond);
	
	/**
	 * 特殊查询
	 */
	Map<String, Object> getCount();
	/**
	 * 查询总数
	 * @return
	 */
	Long getTotalCount();
	
	/**
	 * 按页码查询
	 */
	List<Student> findByPage(int pageNum, int pageSize);
	
	/**
	 * 添加学生
	 */
	int addStudent(Student student);
	
	boolean deleteStudentByNum(String num);
}
