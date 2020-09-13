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
					<h2>Exam Saved Successfully </h2><br/>
					<label for="course">Exam saved for course : </label>
					<span id="course">${course.course}</span>
					<hr/>
					 
					<label for="examType">Exam type saved :</label>
					<span id="examType">${examType}</span>
					<hr/>
					
					<label for="percent">Percent added for ${examType}: </label>
					<span id="percent">${percent} %</span>
					<hr/>
					
					<label for="percent">Date for ${examType}: </label>
					<span id="percent">${date}</span>
					<br/><br/><br/>
				</div>
			</div>
		</div>
	</div>
</body>
</html>