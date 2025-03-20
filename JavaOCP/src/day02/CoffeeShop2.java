package day02;

public class CoffeeShop2 {

	public static void main(String[] args) {
		// 建立一個咖啡實體同時也設定商品資訊
		Coffee latte = new Coffee("拿鐵", '中', 65, true); 
		
		latte.printInfo();
	}

}
