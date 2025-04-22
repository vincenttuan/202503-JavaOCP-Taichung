package day10;

public class Serum extends SkincareProduct {
 
	public Serum(String name, int price) {
		super(name, price);
	}
	 
	public void repairSkin() {
		System.out.printf("🧪%s高效修護, 改善肌膚狀況%n", name);
	}
	 
}
 
