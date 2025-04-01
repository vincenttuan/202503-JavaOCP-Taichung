package day05;

// 電池
public class Battery {
	private String type; // AAAA, AAA, AA, A
	private int price;
	
	public Battery(String type, int price) {
		this.type = type;
		this.price = price;
	}
	
	public String getType() {
		return type;
	}
	
	public int getPrice() {
		return price;
	}
	
	public String toString() {
		return String.format("Battery type:%s price:%d", type, price);
	}
	
}
