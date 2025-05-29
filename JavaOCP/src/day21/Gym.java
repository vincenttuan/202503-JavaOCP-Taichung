package day21;

import java.util.Map;
import java.util.Random;

import lombok.Data;

@Data
public class Gym {
	private String name;
	
	public static Pokemon fight(Pokemon pokemon1, Pokemon pokemon2) {
		// 如果 pokemon1 的等級高於 pokemon2，則 pokemon1 獲勝。
		// 如果 pokemon2 的等級高於 pokemon1，則 pokemon2 獲勝。
		if(pokemon1.getLevel() > pokemon2.getLevel()) {
			return pokemon1;
		} else if(pokemon1.getLevel() < pokemon2.getLevel()) {
			return pokemon2;
		}
		// 如果等級相同，則根據屬性決定勝者：
		// ◆ Fire 贏 Grass
		// ◆ Grass 贏 Water
		// ◆ Water 贏 Fire
		int pokemon1TypeInt = pokemon1.getType().equals("Grass") ? 0 : pokemon1.getType().equals("Fire") ? 1 : 2;
		int pokemon2TypeInt = pokemon2.getType().equals("Grass") ? 0 : pokemon2.getType().equals("Fire") ? 1 : 2;
		if(pokemon1TypeInt - pokemon2TypeInt == 1) {
			return pokemon1;
		} else if(pokemon1TypeInt - pokemon2TypeInt == -1) {
			return pokemon2;
		} else if(pokemon1TypeInt - pokemon2TypeInt == 2) {
			return pokemon2;
		} else if(pokemon1TypeInt - pokemon2TypeInt == -2) {
			return pokemon1;
		}
		// 如果屬性相同，則隨機選一位勝者。
		return new Random().nextBoolean() ? pokemon1 : pokemon2;
	}
}
