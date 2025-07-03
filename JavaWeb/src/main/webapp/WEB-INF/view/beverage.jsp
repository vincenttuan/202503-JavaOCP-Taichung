<%@ page import="java.util.List"%>
<%@ page import="model.Beverage"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 接收 servlet 傳來的資料
	List<Beverage> beverages = (List<Beverage>)request.getAttribute("beverages");
%>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>10 商店-飲料訂購</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css">
	</head>
	<body style="padding: 20px">
		
		<table>
			<td valign="top">
				<!-- 飲料訂購表單 -->
				<form method="post" action="/JavaWeb/beverage" class="pure-form">
					<fieldset>
						<legend>10 元飲料訂購表單</legend>
						飲品:
						<ol>
							<li><input type="radio" id="name" name="name" value="紅茶" /> 紅茶</li>
							<li><input type="radio" id="name" name="name" value="綠茶" /> 綠茶</li>
							<li><input type="radio" id="name" name="name" value="奶茶" /> 奶茶</li>
							<li><input type="radio" id="name" name="name" value="咖啡" /> 咖啡</li>
						</ol><p />
						大小:
						<ol>
							<li><input type="radio" id="size" name="size" value="S" /> 小杯</li>
							<li><input type="radio" id="size" name="size" value="M" /> 中杯</li>
							<li><input type="radio" id="size" name="size" value="L" /> 大杯</li>
						</ol><p />
						<button type="submit">傳送</button>
					</fieldset>
				</form>
			</td>
			<td valign="top">
				<!-- 飲料訂購紀錄 -->
				<div class="pure-form">
					<fieldset>
						<legend>10 元飲料訂購紀錄</legend>
						<table class="pure-table pure-table-bordered">
							<thead>
								<tr>
									<th>Id</th><th>飲品</th><th>大小</th>
								</tr>
							</thead>
							<tbody>
								<% for(int i=0;i<beverages.size();i++) { 
									Beverage be = beverages.get(i);       %>
									<tr>
										<td><%=i %></td>
										<td><%=be.getName() %></td>
										<td><%=be.getSize() %></td>
									</tr>
								<% } %>
							</tbody>
							<tfoot>
								<tr style="background-color: #aaaaaa">
									<td colspan="2" align="right">小計</td>
									<td align="right"><%=beverages.size()*10 %></td>
								</tr>
							</tfoot>
						</table>
					</fieldset>
				</div>
			</td>
		</table>
	</body>
</html>