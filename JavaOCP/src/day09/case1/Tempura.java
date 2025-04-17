package day09.case1;

// 甜不辣
public class Tempura implements Snack {
	private String name;
	private int price;
	
	public Tempura(String name, int price) {
		this.name = name;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}
	
	public int getPrice() {
		return price;
	}
	
	// ---------------------------------------------
	
	@Override
	public void prepare() {
		System.out.println("將圓形甜不辣切條, 祖傳蜜醬汁");
	}

	@Override
	public void cook() {
		System.out.println("炸到蓬鬆(油溫180度約4分鐘)之後加入蜜醬汁");
	}

	@Override
	public void serve() {
		System.out.printf("將 %s 灑上胡椒粉後裝入紙袋%n", name);
	}
	
	
}
