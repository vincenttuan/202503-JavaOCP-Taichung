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
		<link rel="stylesheet" href="https://cdn.datatables.net/2.3.2/css/dataTables.dataTables.css">
		<link rel="stylesheet" href="https://cdn.datatables.net/buttons/3.2.4/css/buttons.dataTables.css">
		
		<script type="text/javascript" src="https://code.jquery.com/jquery-3.7.1.js"></script>
		<script type="text/javascript" src="https://cdn.datatables.net/2.3.2/js/dataTables.js"></script>
		<script type="text/javascript" src="https://cdn.datatables.net/buttons/3.2.4/js/dataTables.buttons.js"></script>
		<script type="text/javascript" src="https://cdn.datatables.net/buttons/3.2.4/js/buttons.dataTables.js"></script>
		<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.10.1/jszip.min.js"></script>
		<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.2.7/pdfmake.min.js"></script>
		<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.2.7/vfs_fonts.js"></script>
		<script type="text/javascript" src="https://cdn.datatables.net/buttons/3.2.4/js/buttons.html5.min.js"></script>
		<script type="text/javascript" src="https://cdn.datatables.net/buttons/3.2.4/js/buttons.print.min.js"></script>
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
				<table id="droneOrderTable" class="pure-table pure-table-bordered">
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
		
		<script type="text/javascript">
			new DataTable('#droneOrderTable', {
				pageLength: 5, // 每頁顯示 5 筆
			    layout: {
			        topStart: {
			            buttons: ['copy', 'csv', 'excel', 'pdf', 'print']
			        }
			    }
			});	
		
		</script>
			
	</body>
</html>