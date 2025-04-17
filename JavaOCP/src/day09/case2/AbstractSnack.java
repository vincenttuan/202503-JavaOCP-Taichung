package day09.case2;

// 小吃抽象類
// 用來實現 name 與 price
public abstract class AbstractSnack implements Snack {
	protected String name;
	protected int price;
	
	public AbstractSnack(String name, int price) {
		this.name = name;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}
	
	public int getPrice() {
		return price;
	}
	
	@Override
	public void serve() {
		System.out.printf("將 %s 灑上胡椒粉後裝入紙袋%n", name);
	}
}
