package day10;

public class Toner extends SkincareProduct {
 
	public Toner(String name, int price) {
		super(name, price);
	}
	 
	public void refreshSkin() {
		System.out.printf("💧%s幫助肌膚保濕與收斂毛孔~%n", name);
	}
	 
}
 
