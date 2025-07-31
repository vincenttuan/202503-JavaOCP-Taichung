<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>結果頁面</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css">
	</head>
	<body style="padding: 20px">
		<!-- menu -->
		<%@include file="/WEB-INF/view/menu.jspf" %>
		
		<!-- 結果頁面 -->
		<div class="pure-form">
			<fieldset>
				<legend>結果頁面</legend>
				結果: <%=request.getAttribute("message") %><p />
			</fieldset>
		</div>
			
	</body>
</html>