package day09.case1;

// 甜不辣
public class Tempura implements Snack {
	private String name;
	private int price;
	
	public Tempura(String name, int price) {
		this.name = name;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}
	
	public int getPrice() {
		return price;
	}
	
	// ---------------------------------------------
	
	@Override
	public void prepare() {
		
	}

	@Override
	public void cook() {
		
	}

	@Override
	public void serve() {
		
	}
	
	
	
}
