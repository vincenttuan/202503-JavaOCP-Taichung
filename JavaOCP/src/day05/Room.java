package day05;

// 房間
public class Room {
	private String style; // 風格
	private int size; // 人數
	private int price; // 基本價格
	private Breakfast breakfast; // 早餐
	private Transport transport; // 接送
	
	public Room(String style, int size, int price, Breakfast breakfast, Transport transport) {
		this.style = style;
		this.size = size;
		this.price = price + breakfast.getPrice() * size + transport.getPrice();
		this.breakfast = breakfast;
		this.transport = transport;
	}
	
	
	
	
	
	
	
}
