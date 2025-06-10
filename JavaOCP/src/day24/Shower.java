package day24;

public class Shower {
	
	public static void main(String[] args) {
		// 建立爸爸執行緒
		Father father = new Father();
		// 執行
		father.start();
	}
	
}
