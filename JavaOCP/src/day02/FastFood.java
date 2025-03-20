package day02;

// 速食設計圖
public class FastFood {
	String type; // 種類
	String name; // 品名
	int price; // 價格
	
	// 建構子
	public FastFood(String type, String name, int price) {
		this.type = type;
		this.name = name;
		this.price = price;
	}
	
	public void printInfo() {
		System.out.printf("%s %s $%d%n", type, name, price);
	}
	
}
