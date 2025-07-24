<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>註冊頁面</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css">
	</head>
	<body style="padding: 20px">
		
		<!-- 註冊頁面表單 -->
		<form method="post" action="/JavaWeb/register" class="pure-form" onsubmit="return check()">
			<fieldset>
				<legend>📰 註冊頁面</legend>
				🤵 <input type="text" id="username" name="username" placeholder="請輸入帳號" required /><p />
				🔑 <input type="password" id="password" name="password" placeholder="請輸入密碼" required /><p />
				🔑 <input type="password" id="confirmPassword" placeholder="請再輸入一次密碼" required /><p />
				<p />
				<button type="submit" class="pure-button pure-button-primary">📝 註冊</button>
			</fieldset>
		</form>
			
	</body>
	<script>
		function check() {
			const password = document.getElementById('password').value;
			const confirmPassword = document.getElementById('confirmPassword').value;
			if(password !=== confirmPassword) {
				alert('二次密碼必須相同!')
				return false;
			}
			return true;
		}
	</script>
	
</html>