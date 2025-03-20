package day02;

// 咖啡設計圖
public class Coffee {
	String name; // 品名
	char size; // 尺寸(S, L)
	int price; // 價格
	boolean hot; // true:熱 / false:冷
	// 列印出產品資訊
	void printInfo() {
		System.out.printf("%s $%d (%c) %s%n", name, price, size, (hot?"熱":"冷"));
	} 
}
