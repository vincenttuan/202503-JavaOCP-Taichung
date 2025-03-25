package day03;

import java.util.Arrays;
import java.util.Scanner;

public class GuessNumber {
	public static void main(String[] args) {
		int[] ans = {3, 8, 5, 4};
		do {
			Scanner scanner = new Scanner(System.in);
			System.out.print("請輸入四位數:");
			int guess = scanner.nextInt();
			int[] guessArray = {guess/1000, guess/100%10, guess%100/10, guess%10};
			System.out.println(Arrays.toString(guessArray));
			// A
			int aCount = 0;
			for(int i=0;i<4;i++) {
				if(ans[i] == guessArray[i]) {
					aCount++;
				}
			}
			// B
			int bCount = 0;
			outer:
			for(int i=0;i<4;i++) {
				inner:
				for(int k=0;k<4;k++) {
					if(ans[i] == guessArray[k]) {
						bCount++;
						break inner;
					}
				}
			}
			bCount = bCount - aCount; // 減去數字與位置相同重複計算的部分
			System.out.printf("%dA %dB%n", aCount, bCount);
			if(aCount == 4) {
				System.out.println("答對 ! 遊戲結束~");
				break;
			}
			
		} while(true);
		
	}
}
