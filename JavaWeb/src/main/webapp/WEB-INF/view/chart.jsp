<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Chart</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css">
		<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
	    <script type="text/javascript">
	      google.charts.load('current', {'packages':['corechart']});
	      google.charts.setOnLoadCallback(drawChart);
	
	      function drawChart() {
	
	        var data = google.visualization.arrayToDataTable([
	          ['Task', 'Hours per Day'],
	          ['Work',     11],
	          ['Eat',      2],
	          ['Commute',  2],
	          ['Watch TV', 2],
	          ['Sleep',    7]
	        ]);
	
	        var options = {
	          title: 'My Daily Activities',
	          is3D: true
	        };
	
	        var chart = new google.visualization.PieChart(document.getElementById('piechart'));
	        //var chart = new google.visualization.LineChart(document.getElementById('piechart'));
	        //var chart = new google.visualization.BarChart(document.getElementById('piechart'));
	        //var chart = new google.visualization.ColumnChart(document.getElementById('piechart'));
	    	
	        chart.draw(data, options);
	      }
	    </script>
	</head>
	<body style="padding: 20px">
		<!-- menu -->
		<%@include file="/WEB-INF/view/menu.jspf" %>
		
		<!-- chart -->
		<div id="piechart" style="width: 900px; height: 500px;"></div>
		
	</body>
</html>