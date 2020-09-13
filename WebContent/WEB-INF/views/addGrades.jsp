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
				<form action="/SchoolManagement/gradeAdded" method="post">
					<h4>ADD GRADES</h4>
					<div id="gradesData">
						<p>Student Name: ${student.name}</p>
						<p>Student Registration No. : ${student.registrationNo}</p>
						<table>
							<tr id="headerViews"><td colspan="3">${course.course}</td></tr>
								<tr>
									<td><c:out value="${exam.examType}"/></td>
									<td><c:out value="${exam.percent} %"/></td>
									<td><input type="text" name="${exam.id}" placeholder="Add grade" required="required"/></td>
								</tr>
						</table>
						<input type="submit" value="SAVE GRADE" />
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>