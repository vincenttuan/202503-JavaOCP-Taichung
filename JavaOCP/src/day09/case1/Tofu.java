package day09.case1;

// 百頁豆腐
public class Tofu implements Snack {
	private String name;
	private int price;
	
	public Tofu(String name, int price) {
		this.name = name;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}
	
	public int getPrice() {
		return price;
	}
	
	// -------------------------------------
	
	@Override
	public void prepare() {
		System.out.println("準備百頁豆腐, 青蔥, 辣椒");
	}

	@Override
	public void cook() {
		System.out.println("炸到外酥內嫩, 撒上蔥花與辣椒");
	}

	@Override
	public void serve() {
		System.out.printf("將 %s 灑上胡椒粉後裝入紙袋%n", name);
	}
	
}
