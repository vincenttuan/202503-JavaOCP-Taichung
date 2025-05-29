package day21;

public class Main {

	public static void main(String[] args) {
		// 讀取使用者輸入的寶可夢類別名稱（如 Psyduck、Charizard、 Bulbasaur）。
		// 使用者輸入的寶可夢名稱（如北京烤鴨）。
		Pokemon pokemon1 = new Psyduck("北京烤鴨");
		Pokemon pokemon2 = new Charizard("東京燒烤");
		pokemon1.displayInfo();
		pokemon2.displayInfo();
		
		Pokemon winner = Gym.fight(pokemon1, pokemon2);
		winner.displayInfo();

	}

}
