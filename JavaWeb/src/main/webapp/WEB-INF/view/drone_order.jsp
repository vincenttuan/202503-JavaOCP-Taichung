<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri="jakarta.tags.core" %>
<%@ taglib prefix ="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>

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
				${fn:length(droneOrders)} 筆 <p />
				<!-- 
				<ol>
					<c:forEach var="droneOrder" items="${ droneOrders }">
						<li>${ droneOrder }</li>
					</c:forEach>
				</ol>
				<p />
				 -->
				<table class="pure-table pure-table-bordered">
					<thead>
						<tr>
							<th>訂單編號</th><th>客戶姓名</th><th>無人機型號</th>
							<th>飛行高度 (公尺)</th><th>飛行速度 (公里/小時)</th><th>數量</th>
							<th>價格</th><th>訂購日期</th><th>訂單狀態</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="droneOrder" items="${ droneOrders }">
							<tr>
								<td>${ droneOrder.orderId }</td>
								<td>${ droneOrder.customerName }</td>
								<td>${ droneOrder.droneModel }</td>
								<td>${ droneOrder.height }</td>
								<td>${ droneOrder.speed }</td>
								<td>${ droneOrder.quantity }</td>
								<td>${ droneOrder.price }</td>
								<td>${ droneOrder.orderDate }</td>
								<td>${ droneOrder.status }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				
			</fieldset>
		</div>
			
	</body>
</html>