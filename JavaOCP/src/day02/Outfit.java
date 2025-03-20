package day02;

// 全套服裝設計 (組合)
public class Outfit {
	
	Top top; // 上衣
	Bottom bottom; // 褲子/裙子
	Hat hat; // 帽子
	
	public Outfit(Top top, Bottom bottom, Hat hat) {
		this.top = top;
		this.bottom = bottom;
		this.hat = hat;
	}
	
	public void printInfo() {
		top.printInfo();
		bottom.printInfo();
		hat.printInfo();
	}
	
}
