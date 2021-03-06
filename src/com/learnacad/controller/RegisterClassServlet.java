package com.learnacad.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.learnacad.model.Class;
import com.learnacad.service.ClassService;

/**
 * Servlet implementation class RegisterClassServlet
 */
public class RegisterClassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String code = request.getParameter("code");
		
		if ( name == null || name.isEmpty() || code == null || code.isEmpty() ) {
				PrintWriter out = response.getWriter();
				
				RequestDispatcher rd = request.getRequestDispatcher("/newClassForm.jsp");	
		    	out.println("<center><span style = 'color: red'>All fields are required for a class!</span></center>");
		    	rd.include(request, response);
		} else {
			Class newClass1 = new Class();
			newClass1.setName(name);
			newClass1.setCode(code);
			
			ClassService classService = new ClassService();
			classService.save(newClass1);
			
			RequestDispatcher rd = request.getRequestDispatcher("dashboard.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
