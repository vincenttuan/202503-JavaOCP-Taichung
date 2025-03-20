package day02;

// 咖啡設計圖
public class Coffee {
	String name; // 品名
	char size; // 尺寸(S, L)
	int price; // 價格
	boolean hot; // true:熱 / false:冷
	
	// 建構子
	public Coffee() {
		
	}
	
	// 列印出產品資訊
	void printInfo() {
		System.out.printf("%s%s $%d (%c)%n", (hot?"熱":"冰"), name, price, size);
	} 
}
