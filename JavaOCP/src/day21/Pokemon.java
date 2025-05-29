package day21;

import lombok.Data;

@Data
public class Pokemon {
	private static int pokemonCount;
	private String name;
	private String type;
	private int level;
	private int candy;
	
	public Pokemon(String name) {
		this.name = name;
		this.type = PokemonUtil.generateType();
		this.level = PokemonUtil.generateLevel();
		this.candy = PokemonUtil.generateCandy();
	}
	
	public void displayInfo() {
		System.out.printf("名稱:%s 屬性:%s 等級:%d%n", name, type, level);
	}
}
