package day02;

// 帽子設計
public class Hat {
	String name; // 帽子名
	int price; // 帽子價格
	
	public Hat(String name, int price) {
		this.name = name;
		this.price = price;
	}
	
	public void printInfo() {
		System.out.printf("%s $%d%n", name, price);
	}
	
}
