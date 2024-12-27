package com.kh.student;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/student/loginView")
public class StudentLoginViewServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request
			, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher view;
		view = request.getRequestDispatcher("/WEB-INF/views/common/login.jsp");
		view.forward(request, response);
		

	
	}
	
}
