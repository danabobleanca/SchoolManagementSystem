<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style><%@ include file="style.css" %></style>
</head>
<body>
	<div id="container">
		<h3>University Management System</h3>
		<div id="systemContainer">
			<div id="menuSystem">
				<div id="student"><a href="/SchoolManagement/">STUDENT</a></div>
				<div id="teacher"><a href="/SchoolManagement/teacher">TEACHER</a></div>
				<div id="course"><a href="/SchoolManagement/course">COURSE</a></div>
				<div id="exam"><a href="/SchoolManagement/exam">EXAM</a></div>
			</div>
			<div id="detailsSaved">
				<div>
					<h2>Teacher Saved Successfully </h2><br/>
					<label for="registrationNo">Teacher Registration No. :</label>
					<span id="registrationNo">${teacher.registrationNo}</span>
					<hr/>
					
					<label for="name">Teacher Name :</label>
					<span id="name">${teacher.name}</span>
					<hr/>
					
					
					<label for="phone">Phone No. :</label>
					<span id="phone">${teacher.phoneNo}</span>
					<hr/>
					
					<label for="email">Email :</label>
					<span id="email">${teacher.email}</span>
					<hr/>
					
					Courses: 
					<c:forEach items="${courses}" var="course">
						<c:out value="${course}"/> /
					</c:forEach>
					
					<br/><br/><br/>
				</div>
			</div>
		</div>
	</div>
</body>
</html> 