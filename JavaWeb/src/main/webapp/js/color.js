function checkResult() {
	// 取得每一題的選項值
	const q1 = document.quertSelector('input[name="q1"]:checked');
	const q2 = document.quertSelector('input[name="q2"]:checked');
	const q3 = document.quertSelector('input[name="q3"]:checked');
	const q4 = document.quertSelector('input[name="q4"]:checked');
	const q5 = document.quertSelector('input[name="q5"]:checked');
	
	// 檢查是否每題都有選擇
	if(!(q1&&q2&&q3&&q4&&q5)) {
		alert('請完成所有題目!');
		return;
	}
	
	// 計分
	const scores = {'紅色':0, '藍色': 0, '綠色':0, '黃色':0};
	const colorMap = {'A':'紅色', 'B':'藍色', 'C':'綠色', 'D':'黃色'};
	
	[q1, q2, q3, q4, q5].forEach(q => {
		scores[colorMap[q.value]] += 1;
	});
	
	alert(scores);
		
	
}