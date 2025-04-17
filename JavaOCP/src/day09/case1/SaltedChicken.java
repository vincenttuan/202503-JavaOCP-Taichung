package day09.case1;

// 鹽酥雞
public class SaltedChicken implements Snack {
	
	private String name;
	private int price;
	
	public SaltedChicken(String name, int price) {
		this.name = name;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}
	
	public int getPrice() {
		return price;
	}
	
	// ----------------------------------------------------
	
	@Override
	public void prepare() {
		System.out.println("準備去骨雞腿肉, 蒜頭, 洋蔥, 九層塔");
	}

	@Override
	public void cook() {
		System.out.println("雞腿肉炸酥後再加入蒜頭, 洋蔥, 九層塔翻炒");
	}

	@Override
	public void serve() {
		System.out.printf("將 %s 灑上胡椒粉後裝入紙袋");
	}
	
}
