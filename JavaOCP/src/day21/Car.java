package day21;

import lombok.Data;

@Data
public class Car {
	private String name;
	private String model;   // （隨機生成 ："Sports Car"、 "Sedan" 或 "SUV"
	private int horsepower; // 150~200 隨機生成 馬力
	private int boost;      // 0~3 隨機生成 加速劑
	
	// name: 接收賽車名稱作為參數，並在建構方法內呼叫 CarUtil 的靜態方法初始化 車款、馬力、加速劑。
	public Car(String name) {
		this.name = name;
		this.model = CarUtil.getRandomModel();
		this.horsepower = CarUtil.getRandomHorsePower();
		this.boost = CarUtil.getRandomBoost();
	}
	
	public int getFinalHorsePower() {
		return boost * 5 + horsepower;
	}
}
