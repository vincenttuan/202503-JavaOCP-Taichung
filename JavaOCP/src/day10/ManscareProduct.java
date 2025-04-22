package day10;

public class ManscareProduct implements Product {
 
	protected String name;
	protected int price;
	 
	public ManscareProduct(String  name, int price) {
		this.name = name;
	}
	 
	public String getName() {
		return name;
	}
	 
	public int getPrice() {
		return price;
	}
	 
}
 
