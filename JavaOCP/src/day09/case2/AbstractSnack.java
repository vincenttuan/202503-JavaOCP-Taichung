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
	
	// 加入一個製作流程與包裝方法 
	public void makeSnack() {
		System.out.printf("===== 開始製作:%s =====%n", name);
		prepare();
		cook();
		serve();
		System.out.printf("===== 售價:NT %d =====%n", price);
		System.out.printf("===== 製作完成:%s =====%n", name);
	}
	
}
