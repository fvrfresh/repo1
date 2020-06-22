package org.student.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.student.entity.Student;
import org.student.service.IStudentService;
import org.student.service.impl.StudentServiceImpl;

/**
 * Servlet implementation class AddServlet
 */
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		IStudentService studentService = new StudentServiceImpl();
		String stu_nu = request.getParameter("stu_nu");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String age = request.getParameter("age");
		String school = request.getParameter("school");
		String major = request.getParameter("major");
		String grade = request.getParameter("grade");
		String phone = request.getParameter("phone");
		String photo = request.getParameter("photo");
		Student student = new Student();
		student.setAge(Integer.parseInt(age));
		student.setContact(phone);
		student.setGender(gender);
		student.setGrade(grade);
		student.setMajor(major);
		student.setName(name);
		student.setStu_nu(stu_nu);
		student.setSchool(school);
		student.setPhoto(photo);
		Boolean result = studentService.addStudent(student);
		PrintWriter out = response.getWriter();
		out.print(result.toString());
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
