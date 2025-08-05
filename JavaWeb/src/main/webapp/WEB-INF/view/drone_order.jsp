<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>無人機訂單頁面</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css">
	</head>
	<body style="padding: 20px">
		<!-- menu -->
		<%@include file="/WEB-INF/view/menu.jspf" %>
		
		<!-- 無人機訂單頁面 -->
		<div class="pure-form">
			<fieldset>
				<legend>無人機訂單</legend>
				<%=request.getAttribute("droneOrders") %>
				<hr />
				${ requestScope.droneOrders }
				<hr />
				${ droneOrders }
				<hr />
			</fieldset>
		</div>
			
	</body>
</html>