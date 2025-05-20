package day18;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Test4 {

	public static void main(String[] args) {
		// 遊戲
		Map<Integer, String> gameMap = Map.of(0, "剪刀", 1, "石頭", 2, "布");
		// 結果
		Map<Integer, String> winnerMap = Map.of(0, "平手", 1, "user贏", 2, "pc贏");
		// 用 Scanner 來與電腦玩剪刀石頭布
		Scanner scanner = new Scanner(System.in);
		System.out.print("請輸入剪刀(0) 石頭(1) 布(2) => ");
		int user = scanner.nextInt();
		int pc = new Random().nextInt(3); // 0, 1, 2
		System.out.printf("user => %s, pc => %s%n", gameMap.get(user), gameMap.get(pc));
		// 判定勝負
		int result = (user - pc + 3) % 3;
		// 誰贏
		System.out.println(winnerMap.get(result));

	}

}
