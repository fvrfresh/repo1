package org.student.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.student.entity.Page;
import org.student.entity.Student;
import org.student.service.IStudentService;
import org.student.service.impl.StudentServiceImpl;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class QueryStudentsByPage
 */
public class QueryStudentsByPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		IStudentService studentService = new StudentServiceImpl();
		int pageSize = Integer.parseInt(request.getParameter("pageSize"));
		int curNum = Integer.parseInt(request.getParameter("curNum"));
		int totalCount = studentService.getTotalCount();
//		Page page = new Page();
//		page.setPageNum(curNum);
//		page.setTotalCount(totalCount);
//		page.setPageSize(pageSize);
		List<Student> students = studentService.findByPage(curNum, pageSize);
//		page.setStudents(students);
		PrintWriter out = response.getWriter();
		JSONObject json = new JSONObject();
		json.put("students", students);
		out.print(json);
		out.close();
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
