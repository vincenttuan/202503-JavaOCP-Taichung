function checkResult() {
	// 取得每一題的選項值
	const q1 = document.quertSelector('input[name="q1"]:checked');
	const q2 = document.quertSelector('input[name="q2"]:checked');
	const q3 = document.quertSelector('input[name="q3"]:checked');
	const q4 = document.quertSelector('input[name="q4"]:checked');
	const q5 = document.quertSelector('input[name="q5"]:checked');
	
	if(!(q1&&q2&&q3&&q4&&q5)) {
		alert('請完成所有題目!');
		return;
	}
		
	
}