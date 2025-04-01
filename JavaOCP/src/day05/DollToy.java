package day05;

// 洋娃娃
public class DollToy {
	private String name;
	private int price;
	private Battery battery;
	
	public DollToy(String name, int price) {
		this.name = name;
		this.price = price;
	}
	
	public DollToy(String name, int price, Battery battery) {
		this.name = name;
		this.price = price + battery.getPrice();
		this.battery = battery;
	}
	
	public String getName() {
		return name;
	}
	
	public int getPrice() {
		return price;
	}
	
	public Battery getBattery() {
		return battery;
	}
	
	public String toString() {
		if(battery == null) {
			return String.format("DollToy name:%s price:%d", name, price);
		}
		return String.format("DollToy name:%s price:%d battery:%s", name, price, battery);
		
	}
	
}
