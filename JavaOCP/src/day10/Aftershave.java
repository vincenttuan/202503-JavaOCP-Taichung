package day10;

public class Aftershave extends ManscareProduct {
 
	public Aftershave(String name, int price) {
		super(name, price);
	}
	 
	public void sootheskin() {
		System.out.printf("💦%s舒緩刮鬍後的肌,避免刺痛%n", name);
	}
	 
}
 
