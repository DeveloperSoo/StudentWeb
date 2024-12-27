<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생 리스트 조회</title>
</head>
<%
	// 자바코드를 안쓰고 JSP를 이용하는것이
	// 그것이 Model 2 방식

%>



<body>
	<h1>학생 리스트 조회</h1>
	<!-- 
	만약 출력하고자 하는 데이터가 List객체로 넘어온다면
	for문을 이용하여 하나씩 꺼내어 출력하면 됨.
	자바에서 사용했던 for문을 대체할 수 있는 라이브러리가 존재
	그것을 JSTL이라고 함.
	 -->
	 <ul>
	<li>학생 이름 : ${student.name }</li>
	<li>1차 점수 : ${student.firstScore }</li>
	<li>2차 점수 : ${student.secondScore }</li>
	</ul>
	 
	 ===================================
	 
	<c:forEach items="${sList }" var="std">
	<ul>
	<li>학생 이름 : ${std.name }</li>
	<li>1차 점수 : ${std.firstScore }</li>
	<li>2차 점수 : ${std.secondScore }</li>
	</ul>
	</c:forEach>
	
</body>
</html>