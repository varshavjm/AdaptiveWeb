<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.assignment1.FileUtility"%>
<%@ page import="com.assignment1.GlobalConstants"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome!!!</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
</head>
<body>
	<%
		String username = GlobalConstants.userName;
	%>
	<h1>
		Welcome,
		<%=username%></h1>
	<h2>
		<a href="LogoutServlet">Logout</a> | <a href="Profile.jsp">Click
			to Track Past Actions</a>
	</h2>
	<a
		href="https://stackoverflow.com/questions/tagged/java?sort=frequent&pageSize=15"
		target="#">Click on Stack overflow link</a>
	<%
		if (username.length() > 0) {
			ArrayList<String> result = FileUtility.readFromFile(GlobalConstants.directoryPrefix +username+ "History.txt");
	%>
	<table div="loginHistory">
		<h1>Login History</h1>
		<%
			for (String str : result) {
		%>
		<tr>
			<td><%=str%></td>
		</tr>
		<%
			}
			}
		
		%>
	</table>
	
	<h1>Below is the list of actions logged and their significance</h1>
	<table id="Actions">
	<th>Actions</th>
	<th>Significance</th>
	<tr>
	<td>Upvote</td>
	<td>Upvote action signifies that the user liked the question and has encountered such a question in the past</td>
	</tr>
	<tr>
	<td>Downvote</td>
	<td>Downvote action signifies that the user disliked the question due to duplicated question, incomplete information etc</td>
	</tr>
	<tr>
	<td>Favourite</td>
	<td>Favourite action signifies that the user wants to follow the question for new responses</td>
	</tr>
	<tr>
	<td>Post a question</td>
	<td>The change in search nox signifies that the user wants to post a question</td>
	</tr>
	<tr>
	<td>Comment</td>
	<td>Comment action signifies that the user wants to raise his opinion regarding a post</td>
	</tr>	
	</table>

</body>
</html>