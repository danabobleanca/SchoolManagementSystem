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
					<h2>Grade Saved Successfully </h2><br/>
					
					
					<hr/><b>Grade save for STUDENT:</b><br/><br/>
					<label for="registrationNo">Student Reg. No: </label>
					<span id="course">${student.registrationNo}</span><br/>
					<label for="name">Student name: </label>
					<span id="course">${student.name}</span>
					<hr/>
					
	
					<label for="course">Grade saved for COURSE: </label>
					<span id="course">${course.course}</span>
					<hr/>
					 
				
					<label for="examType">Grade save for exam :</label>
					<span id="examType">${exam.examType}</span>
					<hr/>
					
					<label for="grade">Grade added for ${exam.examType}: </label>
					<b><span id="grade">${grade}</span></b>
					
					<br/><br/><br/>
				</div>
			</div>
		</div>
	</div>
</body>
</html>