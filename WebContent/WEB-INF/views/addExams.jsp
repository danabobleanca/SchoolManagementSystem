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
				<form action="/SchoolManagement/addExams" method="get">
					<h4>SELECT NEW EXAM</h4>
					<div id="addData">
						<div id="examsAdded">
							Exams registered for course - <span><c:out value="${exam}"/></span>
							<table>
								<tr>
									<c:forEach items="${exams}" var="item">
										<td><c:out value="${item.examType}"/></td>
									</c:forEach>
								</tr>
								<tr>
									<c:forEach items="${exams}" var="item">
										<td><c:out value="${item.percent}"/></td>
									</c:forEach>
								</tr>
								
							</table>
						</div>
						<input type="submit" value="EVP Test" name="evp"/>
						<input type="submit" value="Session Exam" name="session"/>
						<input type="submit" value="Project" name="project"/>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>