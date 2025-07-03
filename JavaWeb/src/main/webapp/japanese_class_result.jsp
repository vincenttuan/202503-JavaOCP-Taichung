<%@ page import="java.util.List"%>
<%@ page import="model.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 接收 servlet 傳來的資料
	Student student = (Student)request.getAttribute("student");
	List<Student> students = (List)request.getAttribute("students");
%>    
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>日文分班檢定結果</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css">
	</head>
	<body style="padding: 20px">
		<div id="pure-form">
			<fieldset>
				<legend>新增學生</legend>
				姓名: <%=student.getName() %><p />
				國別: <%=student.getCountry() %><p />
				年齡: <%=student.getAge() %><p />
				程度: <%=student.getLevel() %><p />
			</fieldset>
		</div>
	</body>
</html>