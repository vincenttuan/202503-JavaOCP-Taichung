<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>éå­¸æ¥æè½ååç­å¤§åéª</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css">
	</head>
	<body style="padding: 20px">
		
		<table>
			<td valign="top">
				<!-- æ¥æè½ååç­è¡¨å® -->
				<form method="post" action="/JavaWeb/japanese/class/level" class="pure-form">
					<fieldset>
						<legend>æ¥æè½ååç­è¡¨å®</legend>
						å§å:<input type="text" id="name" name="name" placeholder="è«è¼¸å¥åå­" required /><p />
						åå¥:<select id="country" name="country">
								<option value="">è«é¸æåå¥</option>
								<option value="TW">å°ç£(TW)</option>
								<option value="US">ç¾å(US)</option>
								<option value="CN">å¤§é¸(CN)</option>
								<option value="KR">éå(KR)</option>
								<option value="VN">è¶å(VN)</option>
								<option value="ID">å°å°¼(ID)</option>
							</select><p />
						å¹´é½¡:<input type="number" id="age" name="age" value="18" min="12" max="99" required /><p />	
						ç¨åº¦:
						<ol>
							<li><input type="radio" id="level" name="level" value="N5" /> åç´ç­(N5): è½å¤ ç°¡å®ç¨æ¥æèªæä»ç´¹</li>
							<li><input type="radio" id="level" name="level" value="N4" /> åä¸­ç´ç­(N4): çè§£åºæ¬å¥å, è½å¤ æºéæ¥å¸¸ä¸»é¡</li>
							<li><input type="radio" id="level" name="level" value="N3" /> ä¸­ç´ç­(N3): è½çè§£çæ´»ä¸­è¤éçå¥å­</li>
							<li><input type="radio" id="level" name="level" value="N2" /> é«ç´ç­(N2): è½å¤ çè§£æ°èå ±å°ç­è¼æ­£å¼çå§å®¹, è½æµæ¢è¡¨éæ³æ³</li>
							<li><input type="radio" id="level" name="level" value="N1" /> èè±ç­(N1): è½å¤ éæ´»æç¨æ¥æé²è¡å­¸è¡äº¤æµ, çè§£è¤éçæç« </li>
						</ol><p />
						<button type="submit">å³é</button>
					</fieldset>
				</form>
			</td>
			<td valign="top">
				<!-- æ¥æè½ååç­ç´é -->
				<div class="pure-form">
					<fieldset>
						<legend>æ¥æè½ååç­ç´é</legend>
						<table class="pure-table pure-table-bordered">
							<thead>
								<tr>
									<th>Id</th><th>å§å</th><th>åå¥</th><th>å¹´é½¡</th><th>ç¨åº¦</th>
								</tr>
							</thead>
							<tbody>
								
							</tbody>
						</table>
					</fieldset>
				</div>
			</td>
		</table>
		

		
	</body>
</html>