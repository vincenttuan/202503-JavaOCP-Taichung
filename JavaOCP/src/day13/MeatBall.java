package day13;

import java.util.Objects;

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
	public int hashCode() {
		return Objects.hash(isFried, price, stuffing);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MeatBall other = (MeatBall) obj;
		return isFried == other.isFried && price == other.price && Objects.equals(stuffing, other.stuffing);
	}


	@Override
	public String toString() {
		return "MeatBall [stuffing=" + stuffing + ", isFried=" + isFried + ", price=" + price + "]";
	}
	
}
