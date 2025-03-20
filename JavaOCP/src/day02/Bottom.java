package day02;

// 褲子/裙子設計
public class Bottom {
	String name; // 褲子/裙子名
	int price; // 褲子/裙子價格
	
	public Bottom(String name, int price) {
		this.name = name;
		this.price = price;
	}
	
	public void printInfo() {
		System.out.printf("%s $%d%n", name, price);
	}
	
}
