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
 * 학생 리스트 조회
 * url : /student/list
 */
@WebServlet("/student/list")
public class StudentListServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		List<Student> sList = new ArrayList<Student>();
		sList.add(new Student("일용자", 99, 88));
		sList.add(new Student("이용자", 88, 77));
		sList.add(new Student("삼용자", 77, 66));
		sList.add(new Student("사용자", 66, 55));
		
		RequestDispatcher view;
		Student student = sList.get(0);
		request.setAttribute("student", student);
		request.setAttribute("sList", sList);

		
		// 이거는 지금 한명만 출력 가능함
//		request.setAttribute("name", sList.get(0).getName());
//		request.setAttribute("firstScore", sList.get(0).getFirstScore());
//		request.setAttribute("secondScore", sList.get(0).getSecondScore());
		view = request.getRequestDispatcher("/WEB-INF/views/student/list.jsp");
		view.forward(request, response);
		
		
		
//		response.setContentType("text/html;charset=utf-8");
//		PrintWriter out = response.getWriter();
//		out.println("<h1>학생 리스트 조회</h1>");
//		
//		for(int i = 0; i < sList.size(); i++) {
////			String name = sList.get(i).getName();
////			int fScore = sList.get(i).getFirstScore();
////			int sScore = sList.get(i).getSecondScore();
//			
//			out.println("<ul><li>학생 이름 : " + sList.get(i).getName() +"</li>");
//			out.println("<li>1차 점수 : "+ sList.get(i).getFirstScore() +"점</li>");
//			out.println("<li>2차 점수 : "+ sList.get(i).getSecondScore() +"점</li></ul>");
//		}
//		
//		out.println("<h1>학생 리스트 조회</h1>");
//		for(Student std : sList) {
//			out.println("<ul><li>학생 이름 : " + std.getName() +"</li>");
//			out.println("<li>1차 점수 : "+ std.getFirstScore() +"점</li>");
//			out.println("<li>2차 점수 : "+ std.getSecondScore() +"점</li></ul>");
//		}
//		
		
//		for(Student std : sList) {
//			System.out.println(std.toString());
//		}
		
	}
}
