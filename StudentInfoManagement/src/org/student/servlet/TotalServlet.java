package org.student.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.student.dao.IStudentDao;
import org.student.impl.*;

import net.sf.json.JSONObject;


/**
 * Servlet implementation class TotalServlet
 */
public class TotalServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		IStudentDao studentDao = new StudentDaoImpl();
		Long count = studentDao.getTotalCount();
		PrintWriter out = response.getWriter();
		JSONObject json = new JSONObject();
		json.put("count", count.toString());
		out.print(json);
		out.close();
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
