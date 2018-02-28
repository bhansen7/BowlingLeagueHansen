<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form method = "post" action = "deleteTeamServlet">
		<table>
			<c:forEach items="${requestScope.allItems}" var="currentitem">
				<tr>
					<td><input type="radio" name="teamId" value="${currentitem.teamId}"></td>
					<td>${currentitem.teamName}</td>
					<td>${currentitem.teamType}</td>
					<td>${currentitem.preferredNight}</td> 
				</tr>
			</c:forEach>
		</table>   
		<input type="submit" value="Delete Selected Team" name="doThisToItem">
	</form> 
	
</body>
</html>