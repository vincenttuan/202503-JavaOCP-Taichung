package day05;

// 早餐
public class Breakfast {
	private int price;
	
	public Breakfast(int price) {
		this.price = price;
	}
	
	public int getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "Breakfast [price=" + price + "]";
	}
	
}
