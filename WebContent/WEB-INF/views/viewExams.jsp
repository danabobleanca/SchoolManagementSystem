<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style><%@ include file="style.css" %></style> 
</head>
<body>
<div id="container" class="viewContainer">
		<h3>University Management System</h3>
		<div id="systemContainer">
			<div id="menuSystem">
				<div id="student"><a href="/SchoolManagement/">STUDENT</a></div>
				<div id="teacher"><a href="/SchoolManagement/teacher">TEACHER</a></div>
				<div id="course"><a href="/SchoolManagement/course">COURSE</a></div>
				<div id="exam"><a href="/SchoolManagement/exam">EXAM</a></div>
			</div>
			<div id="addNewItem">
				<form action="/SchoolManagement/deleteOrUpdate" method="get">
					<h4>VIEW ALL EXAMS</h4>
					<div id="gradesData">
	
					<br/><br/>
					<c:forEach items="${courses}" var="course">
					<div id="examTables">
					<p id="examCourses">COURSE: <b>${course.course}</b> <br/> SPECIALIZATION:<b> ${course.specialization}</b></p>
					<table>
						<tr>
							<c:forEach items="${course.exams}" var="exam">
								<td>${exam.examType}</td>
						</c:forEach>
						</tr>
						<tr>
							<c:forEach items="${course.exams}" var="exam">
								<td>${exam.percent} %</td>
						</c:forEach>
						</tr>
					</table>
					</div>
					</c:forEach>				
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>