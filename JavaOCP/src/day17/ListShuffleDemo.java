package day17;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ListShuffleDemo {

	public static void main(String[] args) {
		// Shuffle: 洗牌 ♠♥♣♦
		List<String> card1 = List.of("♠A", "♠2", "♠3", "♠4", "♠5", "♠6", "♠7", "♠8", "♠9", "♠10", "♠J", "♠Q", "♠K"); 
		List<String> card2 = List.of("♥A", "♥2", "♥3", "♥4", "♥5", "♥6", "♥7", "♥8", "♥9", "♥10", "♥J", "♥Q", "♥K"); 
		List<String> card3 = List.of("♦A", "♦2", "♦3", "♦4", "♦5", "♦6", "♦7", "♦8", "♦9", "♦10", "♦J", "♦Q", "♦K"); 
		List<String> card4 = List.of("♣A", "♣2", "♣3", "♣4", "♣5", "♣6", "♣7", "♣8", "♣9", "♣10", "♣J", "♣Q", "♣K"); 
		// 將 card1 ~ card4 合併到一個 List 中
		List<String> allCards = new ArrayList<>();
		allCards.addAll(card1);
		allCards.addAll(card2);
		allCards.addAll(card3);
		allCards.addAll(card4);
		System.out.println(allCards);
		
		
	}

}
