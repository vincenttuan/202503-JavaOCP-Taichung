package day10;

public class Lotion extends SkincareProduct {
 
	public Lotion(String name, int price) {
		super(name, price);
	}
	public void moisture() {
		System.out.printf("🧴%s鎖住水分防止乾燥%n", name);
	}
	 
}
 
