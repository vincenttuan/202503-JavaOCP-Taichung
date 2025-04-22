package day10;

public class HairGel extends ManscareProduct {
 
	public HairGel(String name, int price) {
		super(name, price);
	}
	 
	public void styleHair() {
		System.out.printf("💇‍♂️%s打造帥氣造型, 持久不坍塌%n", name);
	}
	 
}
 
