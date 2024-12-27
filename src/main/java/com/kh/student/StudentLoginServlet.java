package com.kh.student;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/student/login")
public class StudentLoginServlet extends HttpServlet{
	
	// doGet, doPost 메소드로 get요청과 post요청을 하나의 서블릿에서 처리 가능
	// -> StudentLoginViewServlet.java가 필요 없음.
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// 브라우저 주소표시줄에 http://localhost:8888/student/login 입력하고
	// 엔터를 쳐서 서버에 요청하는 것은 get방식 요청(기본값)
	
		RequestDispatcher view;
		view = request.getRequestDispatcher("/WEB-INF/views/common/login.jsp");
		view.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// form 태그를 사용하고 method에 post를 적어서 요청을 하면 POST방식 요청임.
		// 현재 post방식은 form태그로만 가능
		RequestDispatcher view;
		String studentId = request.getParameter("studentId");
		String studentPw = request.getParameter("studentPw");
		String message = "";
		
		if("admin".equals(studentId) && "admin".equals(studentPw)) {
			message = "관리자 입니다.";
			
		}else {
			message = "일반 사용자 입니다.";
		}
	
		request.setAttribute("message",message);
		
		view = request.getRequestDispatcher("/WEB-INF/views/common/result.jsp");
		view.forward(request, response);
		
	}
}
