package day05;

// 車輪
public class Wheel {
	private int size; // 3, 5, 7吋
	private int price;
	
	public Wheel(int size, int price) {
		this.size = size;
		this.price = price;
	}
	
	public int getSize() {
		return size;
	}
	
	public int getPrice() {
		return price;
	}
	
	public String toString() {
		return String.format("Wheel size:%d吋 price:%d", size, price);
	}
	
}
