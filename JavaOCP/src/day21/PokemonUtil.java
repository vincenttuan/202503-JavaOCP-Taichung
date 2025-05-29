package day21;

import java.util.Random;

public class PokemonUtil {
	public static final int MAX_LEVEL = 20;
	public static final int MAX_CANDY = 100;
	
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
}
