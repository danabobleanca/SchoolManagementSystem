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
			<div id="contentSystem">
				<form action="/SchoolManagement/student" method="get">
				<div>
					<input type="submit" value="Add New Student" name="addStudent"/>
					<input type="submit" value="View All Students" name="viewStudents"/>
					<input type="submit" value="Student Grade" name="studentGrade"/>
				</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>