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
		
		<!-- 結果頁面 -->
		<div class="pure-form">
			<fieldset>
				<legend>結果頁面</legend>
				結果: <%=request.getAttribute("message") %><p />
				<a href="/JavaWeb/login" class="pure-button pure-button-primary">返回登入頁</a>
			</fieldset>
		</div>
			
	</body>
</html>