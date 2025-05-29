package day21;

import java.util.Random;

/**
 * 提供以下靜態方法，隨機生成賽車屬性：
✓ getRandomModel()：隨機回傳 "Sports Car"、 "Sedan" 或 "SUV"。
✓ getRandomHorsePower()：隨機生成 150~200 之間的馬力。
✓ getRandomBoost()：隨機生成 0~3
 * */
public class CarUtil {
	public static String getRandomModel() {
		Random random = new Random();
		String[] models = {"Sports Car", "Sedan", "SUV"};
		int idx = random.nextInt(models.length); // 0~2
		return models[idx];
	}
	
	public static int getRandomHorsePower() {
		Random random = new Random();
		return random.nextInt(51) + 150;
	}
	
	public static int getRandomBoost() {
		Random random = new Random();
		return random.nextInt(4);
	}
}
