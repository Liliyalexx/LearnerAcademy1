package com.learnacad.controller;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.learnacad.model.Class;
import com.learnacad.model.Subject;
import com.learnacad.model.Teacher;
import com.learnacad.service.SubjectService;

/**
 * Servlet implementation class NewSubjectServlet
 */
public class RegisterSubjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String code = request.getParameter("code");
		int classId = Integer.valueOf(request.getParameter("classId"));
		int teacherId = Integer.valueOf(request.getParameter("teacherId"));
		
		if ( name == null || name.isEmpty() || code == null || code.isEmpty() ) {
			PrintWriter out = response.getWriter();
			
			RequestDispatcher rd = request.getRequestDispatcher("/newSubjectForm.jsp");	
	    	out.println("<center><span style = 'color: red'>All fields are required for a subject!</span></center>");
	    	rd.include(request, response);
		} else {
			SubjectService subjectService = new SubjectService();
			
			Class tempClass = new Class();
			tempClass.setId(classId);
			
			Teacher teacher = new Teacher();
			teacher.setId(teacherId);
			
			Subject subject = new Subject();
			subject.setName(name);
			subject.setCode(code);
			subject.setTeacher(teacher);
			subject.setAssignedClass(tempClass);
			subjectService.save(subject);
			
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
