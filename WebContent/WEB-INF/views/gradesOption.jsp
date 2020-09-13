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
				<form action="/SchoolManagement/gradesOption" method="get">
					<h4>ADD GRADES</h4>
					<div id="gradesOption">
					<table>
					<tr id="headerViews"><td>Registration No.</td>
						<td>Student Name</td>
					</tr>
						<c:forEach items="${students}" var="item">
						<tr>
							<td><c:out value="${item.registrationNo}"/></td>
							<td><c:out value="${item.name}"/></td>
							<td><input type="submit" value="View Student Grades" name="${item.registrationNo}"/></td>
							<td><input type="submit" value="Add Grades" name="${item.registrationNo}"/></td>
							
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