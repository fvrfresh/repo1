package org.student.impl;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.student.dao.IStudentDao;
import org.student.entity.Student;
import org.student.utils.DBUtils;
import org.student.utils.JDBCUtils;

public class StudentDaoImpl extends DBUtils<Student> implements IStudentDao
{
	public boolean isExist(	String num)
	{
		return findOne(num) == null ? false : true;
	}
	@Override
	public List<Student> findAll()
	{
		List<Student> students = null;
		Connection conn = null;
		String sql = "select * from test.student_list";
		try
		{
			conn = JDBCUtils.getConnection();
			students = this.query(conn, sql, null);
			return students;
		}
		finally
		{
			JDBCUtils.closeResources(conn, null, null);
		}
	}
	
	@Override
	public Student findOne(String id)
	{
		Student student = null;
		Connection conn = null;
		String sql = "select * from test.student_list where stu_nu=?";
		try
		{
			conn = JDBCUtils.getConnection();
			student = this.queryOne(conn, sql, id);
			return student;
		}
		finally
		{
			JDBCUtils.closeResources(conn, null, null);
		}		
	}
	
	@Override
	public boolean updateStudent(Student data)
	{
		Connection conn = null;
		String sql = null;
		List<Object> params = null;
		try
		{
			conn = JDBCUtils.getConnection();
			params = new ArrayList<>();
			params.clear();
			Map<String, Object> realData = this.getData(data);
			String stu_nu = (String)realData.get("stu_nu");
			Set<String> keys = realData.keySet();
			Iterator<String> iterator = keys.iterator();
			ArrayList<String> objs = new ArrayList<>();
			objs.trimToSize();
			while(iterator.hasNext())
			{
				String key = iterator.next();
				if (key.equals("stu_nu"))
					continue;
				Object value = realData.get(key);
				objs.add(key);
				params.add(value);
			}
			params.add(stu_nu);
			objs.add("stu_nu");
			sql = prepareSql(objs);
			int count = update(conn, sql, params.toArray());
			return count == 1 ? true : false;
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public List<Student> findSome(String cond)
	{
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Map<String, Object> getCount()
	{
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Long getTotalCount()
	{
		Map<String, Object> results = null;
		Connection conn = null;
		String sql = "select count(stu_nu) as 学生总数 from test.student_list";
		try
		{
			conn = JDBCUtils.getConnection();
			results = count(conn, sql);
			Long count = (Long)results.get("学生总数");
			return count;
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1l;
		}
		finally
		{
			JDBCUtils.closeResources(conn, null, null);
		}
	}
	
	public int addStudent(Student student)
	{
		Connection conn = JDBCUtils.getConnection();
		String sql = "insert into student_list(stu_nu,name,gender,age,school,major,grade,contact,photo)"
				+ " values(?,?,?,?,?,?,?,?,?)";
		Object[] params = {
				student.getStu_nu(), student.getName(), student.getGender(), student.getAge(), student.getSchool(),student.getMajor(),student.getGrade(),student.getContact(),student.getPhoto()};
		return this.update(conn, sql, params);
	}
	@Override
	public List<Student> findByPage(int pageNum, int pageSize)
	{
		String sql = "select * from "
				+ "student_list "
				+ "order by stu_nu asc "
				+ "limit " + "?,?"; 
		Object[] params = {(pageNum - 1) * pageSize, pageSize};
		Connection conn = JDBCUtils.getConnection();
		List<Student> students = this.query(conn, sql, params);
		JDBCUtils.closeResources(conn, null, null);
		return students;
	}
	
	@Override
	public boolean deleteStudentByNum(String num)
	{
		Connection conn = JDBCUtils.getConnection();
		String sql = "delete from student_list where stu_nu=?";
		Object[] params = {num};
		return this.update(conn, sql, params) > 0 ? true : false;
	}
	
	//获取Student类封装的有效数据
	public Map<String, Object> getData(Student data) throws Exception
	{
		Map<String, Object> realData = new HashMap<>();
		String stu_nu = data.getStu_nu();
		String name = data.getName();
		String gender = data.getGender();
		Integer age = data.getAge();
		String school = data.getSchool();
		String major = data.getMajor();
		String grade = data.getGrade();
		String contact = data.getContact();
		String photo = data.getPhoto();
		if (null != stu_nu)
		{
			realData.put("stu_nu", stu_nu);
		}
		else
		{
			throw new Exception("信息不足，stu_num为null");
		}
		if (null != name)
			realData.put("name", name);
		if (null != gender)
			realData.put("gender", gender);
		if (null != age)
			realData.put("age", age);
		if (null != school)
			realData.put("school", school);
		if (null != major)
			realData.put("major", major);
		if (null != grade)
			realData.put("grade", grade);
		if (null != contact)
			realData.put("contact", contact);
		if (null != photo)
			realData.put("photo", photo);
		return realData.isEmpty() ? null : realData;
		
	}
	//根据参数设置sql语句
	public String prepareSql(ArrayList<String> params)
	{
		StringBuilder builder = new StringBuilder("update student_list set ");
		for (Object obj : params.toArray())
		{
			String str = (String)obj;
			if(str.equals("name"))
				builder.append("name=?,");
			if(str.equals("gender"))
				builder.append("gender=?,");
			if(str.equals("age"))
				builder.append("age=?,");
			if(str.equals("school"))
				builder.append("school=?,");
			if(str.equals("major"))
				builder.append("major=?,");
			if(str.equals("grade"))
				builder.append("grade=?,");
			if(str.equals("contact"))
				builder.append("contact=?,");
			if(str.equals("photo"))
				builder.append("photo=?,");
			if(str.equals("stu_nu"))
				builder.append(" where stu_nu=?;");
		}
		if (builder.lastIndexOf(",") != -1)
		{
			builder = builder.deleteCharAt(builder.lastIndexOf(","));
		}
		return builder.toString();
		
	}
//	public void updateRs(Connection conn, PreparedStatement ps, ResultSet rs)
//	{
//		try
//		{
//			conn.setAutoCommit(false);
//			rs.beforeFirst();
//			int i = 1;
//			while (rs.next())
//			{
//				rs.updateInt("序号", i);
//				rs.updateRow();
//				i++;
//			}
//			conn.commit();
//			conn.setAutoCommit(true);
//		} catch (SQLException e)
//		{
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		catch(Exception e)
//		{
//			e.printStackTrace();
//		}
//		finally
//		{
//			JDBCUtils.closeResources(ps, rs);
//		}
//	}


}
