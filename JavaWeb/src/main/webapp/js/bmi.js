function checkResult() {
	console.log('檢查資料');
	//const height = document.querySelector('input[name="height"]');
	//const weight = document.querySelector('input[name="weight"]');
	const height = document.getElementById('height');
	const weight = document.getElementById('weight');
	
	const h = height.value;
	const w = weight.value;
	console.log("身高", h, "體重", w);
	
	// 計算 bmi
	const bmi = w / ((h/100)*(h/100));
	console.log("bmi", bmi);
	
	// 判斷 bmi
	const result = (bmi > 23) ? '過重' : (bmi <= 18) ? '過輕' : "正常";
	const color = (result == '正常') ? 'black' : 'red';
	console.log(result, color);
	
	// 顯示資料
	document.getElementById('result').innerHTML = `BMI:${bmi.toFixed(2)} 診斷:<span style="color:${color}">${result}</span>`;
	
}