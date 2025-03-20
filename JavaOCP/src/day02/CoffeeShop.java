package day02;

public class CoffeeShop {

	public static void main(String[] args) {
		Coffee latte = new Coffee(); // 建立一個咖啡實體
		latte.name = "拿鐵";
		latte.size = '中';
		latte.price = 65;
		latte.hot = true;
		latte.printInfo();
	}

}
