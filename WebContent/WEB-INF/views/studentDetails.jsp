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
					<h2>Student Saved Successfully </h2><br/>
					<label for="registrationNo">Student Registration No. :</label>
					<span id="registrationNo">${student.registrationNo}</span>
					<hr/>
					
					<label for="name">Student Name :</label>
					<span id="name">${student.name}</span>
					<hr/>
					
					<label for="year">Student Year :</label>
					<span id="year">${student.studentYear}</span>
					<hr/>
					
					<label for="phone">Phone No. :</label>
					<span id="phone">${student.phoneNo}</span>
					<hr/>
					
					<label for="email">Email :</label>
					<span id="email">${student.email}</span>
					<hr/>
					
					<label for="specialization">Specialization :</label>
					<span id="specialization">${student.specialization}</span>
					
					<br/><br/><br/>
				</div>
			</div>
		</div>
	</div>
</body>
</html>