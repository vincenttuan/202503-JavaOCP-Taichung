package day10;

public abstract class SkincareProduct implements Product {
 
	protected String name;
	protected int price;
	 
	public SkincareProduct(String name, int price) {
		this.name = name;
		this.price = price;
	}
	 
	public String getName() {
		return name;
	}
	 
	public int getPrice() {
		return price;
	}
	 
}
 
