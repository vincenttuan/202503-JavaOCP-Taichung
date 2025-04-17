package day09.case2;

// 小吃抽象類
// 用來實現 name 與 price
public abstract class AbstractSnack implements Snack {
	protected String name;
	protected int price;
	private final int fixedPrice; // 固定價, 用來計算 price 與 size 時的種子
	protected int size = 1; // 1:小份, 2:中份, 3:大份, 4:特大份, 5:全家福
	private final String[] sizeName = {"", "小", "中", "大", "特大", "全家福"};
	//                                 0    1     2    3     4       5    <- index
	
	public AbstractSnack(String name, int price) {
		this.name = name;
		this.price = price;
		fixedPrice = price;
	}
	
	public void setSize(int size) {
		// 變更 size
		this.size = size;
		// 影響價格
		this.price = this.fixedPrice * this.size;
	}
	
	public int getSize() {
		return size;
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
		System.out.printf("===== 開始製作:%s(%s份) =====%n", name, sizeName[size]);
		prepare();
		cook();
		serve();
		System.out.printf("===== 售價:NT %d =====%n", price);
		System.out.printf("===== 製作完成:%s =====%n", name);
	}
	
}
