package com.kh.student;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/*
 * 학생 정보 등록
 * url : /student/register
 */

@WebServlet("/student/register")
public class StudentRegisterServlet extends HttpServlet{
	//http://localhost:8888/student/register?name=삼용자&firstScore=88&secondScore=77
	
	// 학생 정보 등록의 경우 post방식으로 요청해야함.
	// post방식 요청은 form태그를 통해서 밖에 되지 않으므로 
	// form 작성 필요
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Student> sList = new ArrayList<Student>();
		String name = request.getParameter("name");
		int firstScore = Integer.parseInt(request.getParameter("firstScore"));
		// 원인 : 문자열을 int로 변환할 수 없음.
		// 해결방법 : 문자열은 int로 변환해주면됨. 어떻게?
		// Integer.parseInt();
		int secondScore = Integer.parseInt(request.getParameter("secondScore"));
		
		sList.add(new Student("일용자",99, 88));
		sList.add(new Student("이용자",88, 77));
		RequestDispatcher view;
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		for(Student std : sList) {
			if(std.getName().equals(name)) {
				out.println("<h1>이미 존재하는 이름입니다.</h1>");
//				view = request.getRequestDispatcher("/WEB-INF/views/common/duplicate.html");
//				view.forward(request, response);
				return;			// 메소드를 종료하여 밑에 코드가 안돌아가도록 함.
			}
		}
		sList.add(new Student(name, firstScore, secondScore));
		out.println("<h1>학생 정보 추가 성공되었습니다.</h1>");
//		view = request.getRequestDispatcher("/WEB-INF/views/common/success.html");
//		view.forward(request, response);

			
		}
	}

