<%@page import="model.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	List<User> users = (List<User>)request.getAttribute("users");
%>  
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>使用者列表</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css">
	</head>
	<body style="padding: 20px">
		<h2>Hi <%=session.getAttribute("username") %> 您好 !</h2>
		<!-- 使用者列表 -->
		<div class="pure-form">
			<fieldset>
				<legend>使用者列表</legend>
				
				
			</fieldset>
		</div>
			
	</body>
</html>