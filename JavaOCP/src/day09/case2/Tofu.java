package day09.case2;

// 百頁豆腐
public class Tofu extends AbstractSnack {

	public Tofu(String name, int price) {
		super(name, price);
	}
	
	@Override
	public void prepare() {
		System.out.println("準備百頁豆腐, 青蔥, 辣椒");
	}

	@Override
	public void cook() {
		System.out.println("炸到外酥內嫩, 撒上蔥花與辣椒");
	}

}
