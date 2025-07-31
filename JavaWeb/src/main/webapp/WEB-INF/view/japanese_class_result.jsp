<%@ page import="java.util.List"%>
<%@ page import="model.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 接收 servlet 傳來的資料
	Student student = (Student)request.getAttribute("student");
	List<Student> students = (List<Student>)request.getAttribute("students");
%>    
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>日文分班檢定結果</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css">
	</head>
	<body style="padding: 20px">
		<!-- menu -->
		<%@include file="/WEB-INF/view/menu.jspf" %>
		
		<div class="pure-form">
			<fieldset>
				<legend>新增學生</legend>
				姓名: <%=student.getName() %><p />
				國別: <%=student.getCountry() %><p />
				年齡: <%=student.getAge() %><p />
				程度: <%=student.getLevel() %><p />
			</fieldset>
		</div>
		<div class="pure-form">
			<fieldset>
				<legend>所有學生資料</legend>
				<table class="pure-table pure-table-bordered">
					<thead>
						<tr>
							<th>Id</th><th>姓名</th><th>國別</th><th>年齡</th><th>程度</th>
						</tr>
					</thead>
					<tbody>
						<% for(int i=0;i<students.size();i++) { 
							Student st = students.get(i);       %>
							<tr>
								<td><%=i %></td>
								<td><%=st.getName() %></td>
								<td><%=st.getCountry() %></td>
								<td><%=st.getAge() %></td>
								<td><%=st.getLevel() %></td>
							</tr>
						<% } %>
					</tbody>
				</table>
			</fieldset>
		</div>
	</body>
</html>