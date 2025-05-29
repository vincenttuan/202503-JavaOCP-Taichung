package day21;

import java.util.Random;

public class PokemonUtil {
	public static final int MAX_LEVEL = 20;
	public static final int MAX_CANDY = 100;
	
	// generateType()：回傳一個隨機的寶可夢屬性（String），屬性可以是「 Fire」、「 Water」、「 Grass」等。使用隨機數生成器來選擇屬性。
	public static String generateType() {
		Random random = new Random();
		String[] types = {"Fire", "Water", "Grass"};
		int idx = random.nextInt(types.length); // 0~2
		return types[idx];
	}
	
	// generateLevel()：回傳一個隨機等級（int），範圍從 1 到 MAX_LEVEL 之間的整數。
	public static int generateLevel() {
		Random random = new Random();
		return random.nextInt(MAX_LEVEL) + 1;
	}
	
	// generateCandy()：generateCandy()：回傳一個隨機的糖果數量（int），範圍從 0 到 MAX_CANDY 之間的整數。
	public static int generateCandy() {
		Random random = new Random();
		return random.nextInt(MAX_CANDY + 1);
	}
}
