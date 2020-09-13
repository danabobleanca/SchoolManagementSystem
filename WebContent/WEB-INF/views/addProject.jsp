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
<div id="container">
		<h3>University Management System</h3>
		<div id="systemContainer">
			<div id="menuSystem">
				<div id="student"><a href="/SchoolManagement/">STUDENT</a></div>
				<div id="teacher"><a href="/SchoolManagement/teacher">TEACHER</a></div>
				<div id="course"><a href="/SchoolManagement/course">COURSE</a></div>
				<div id="exam"><a href="/SchoolManagement/exam">EXAM</a></div>
			</div>
			<div id="addNewItem">
				<form action="/SchoolManagement/saveProjectPercent" method="post">
					<h4>ADD PROJECT PERCENT</h4>
					<div id="addData">
						<label for="percent">Add Project Percent</label>
						<input type="text" id="percent" name="projectPercent" required="required"/>
						<label for="date">Date of Project</label>
						<input type="text" name="date" id="date" placeholder="dd/MM/yyy"/>
						<input type="submit" value="Save Project Percent"/>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>