package day02;

// 全套服裝設計 (組合)
public class Outfit {
	
	String name; // 風格名
	Top top; // 上衣
	Bottom bottom; // 褲子/裙子
	Hat hat; // 帽子
	
	public Outfit(String name, Top top, Bottom bottom, Hat hat) {
		this.name = name;
		this.top = top;
		this.bottom = bottom;
		this.hat = hat;
	}
	
	public void printInfo() {
		int total = top.price + bottom.price + hat.price;
		System.out.printf("風格名稱:%s 總價:$%d%n", name, total);
		top.printInfo();
		bottom.printInfo();
		hat.printInfo();
		System.out.println("---------------------");
	}
	
}
