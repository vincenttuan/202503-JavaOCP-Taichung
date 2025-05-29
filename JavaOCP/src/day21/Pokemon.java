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
	
	public static int getPokemonCount() {
		return pokemonCount;
	}
	
	// evolve()：當寶可夢進化時，如果糖果數量大於或等於 10 顆，
	// 則將等級增加 1，並減少 10 顆糖果；如果糖果不足，則顯示提示訊息。
	public void evolve() {
		if(candy < 10) {
			System.out.println("進化失敗");
			return;
		}
		level++;
		candy -= 10;
		System.out.println("進化成功");
	}
}
