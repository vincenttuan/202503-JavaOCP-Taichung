package day18;

import java.util.Random;
import java.util.Scanner;

public class Test4 {

	public static void main(String[] args) {
		// 用 Scanner 來與電腦玩剪刀石頭布
		Scanner scanner = new Scanner(System.in);
		System.out.print("請輸入剪刀(0) 石頭(1) 布(2) => ");
		int user = scanner.nextInt();
		int pc = new Random().nextInt(3); // 0, 1, 2
		// 判定勝負
		int result = (user - pc + 3) % 3;
		// 誰贏(利用 ?:)
		String winner = 

	}

}
