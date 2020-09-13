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
<div id="container" >
		<h3>University Management System</h3>
		<div id="systemContainer" >
			<div id="menuSystem">
				<div id="student"><a href="/SchoolManagement/">STUDENT</a></div>
				<div id="teacher"><a href="/SchoolManagement/teacher">TEACHER</a></div>
				<div id="course"><a href="/SchoolManagement/course">COURSE</a></div>
				<div id="exam"><a href="/SchoolManagement/exam">EXAM</a></div>
			</div>
			<div id="addNewItem">
				<form action="/SchoolManagement/addGrades" method="GET">
					<h4>ADD GRADES</h4>
					<div id="addData">
						<p>Student Name: ${student.name}</p>
						<p>Student Registration No. : ${student.registrationNo}</p><hr/>
						<p>Course Name: ${course.course}</p><hr/>
								<c:forEach items="${course.exams}" var="exam">
									<label for="${exam.examType}">${exam.examType} &nbsp  -  &nbsp<c:out value="${exam.percent}"/> %</label>
									
									&nbsp &nbsp<c:out value="${exam.dateOfExam}"/>
									<input type="radio"  value="${exam.id}" name="examSelected" id="${exam.examType}" required="required"/><br/>
								</c:forEach>			
						<input type="submit" value="ADD GRADES" />
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>