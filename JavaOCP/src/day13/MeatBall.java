package day13;

public class MeatBall {
	private String stuffing; // 內餡
	private boolean isFried; // 是否是炸的
	private int price;
	
	public MeatBall(String stuffing, boolean isFried, int price) {
		this.stuffing = stuffing;
		this.isFried = isFried;
		this.price = price;
	}

	@Override
	public String toString() {
		return "MeatBall [stuffing=" + stuffing + ", isFried=" + isFried + ", price=" + price + "]";
	}
	
}
