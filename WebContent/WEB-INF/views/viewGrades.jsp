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
					<h4>STUDENT GRADES</h4>
					<div id="gradesData">
					<hr/>
					<p>Student Name:<span style="color:red"> ${student.name}</span></p>
					<hr/>
					<p>Student Registration no. : <span style="color:red">${student.registrationNo}</span></p>
					<hr/>
					<br/><br/>
					<table>
					<c:forEach items="${student.grades}" var="grade">
						<tr>
							<td id="courses">
								<c:out value="${grade.exam.course.course}"/>
							</td>	
							<td id="exams">
								<c:out value="${grade.exam.examType}"/>
							</td>	
							<td id="examPercent">
								<c:out value="${grade.exam.percent}"/> %
							</td>
							<td id="grades">
								<c:out value="${grade.grade}"/>
							</td>
						</tr>
					</c:forEach>				
					</table>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>