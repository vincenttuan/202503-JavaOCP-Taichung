package day05;

// 接送
public class Transport {
	private String location; // 接送地點
	private int price;
	
	public Transport(String location, int price) {
		this.location = location;
		this.price = price;
	}

	public String getLocation() {
		return location;
	}

	public int getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "Transport [location=" + location + ", price=" + price + "]";
	}
	
}
