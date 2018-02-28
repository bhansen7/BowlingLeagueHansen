<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method = "post" action = "viewALlTeamServlet">
		<table>

			<c:forEach Team="${requestScope.allTeams}" var = "currentTeam">
				<tr>
					<td><input type = "radio" name = "id" value = "${currentTeam.teamId}">${currentTeam.teamId}</td>
					<td>${currentTeam.teamName}</td>
					<td>${currentTeam.teamType}</td>
					<td>${currentTeam.preferredNight}</td>
				</tr>
			</c:forEach>
		</table><br />
		<input type = "submit" value = "Delete Team and Players on Team" name = "doThisToTeam"><br /><br />
		<input type = "submit" value = "Add New Team" name = "doThisToTeam">
	</form><br />
	<a href = "BowlingIndex.html">Return Home</a><br />
	<a href = "viewPlayersServlet">View All Players</a>

</body>
</html>