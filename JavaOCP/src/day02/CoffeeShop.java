package day02;

public class CoffeeShop {

	public static void main(String[] args) {
		Coffee latte = new Coffee(); // 建立一個咖啡實體
		latte.name = "拿鐵";
		latte.size = '中';
		latte.price = 65;
		latte.hot = true;
		latte.printInfo();
		
		Coffee macchiato = new Coffee();
		macchiato.name = "焦糖瑪奇朵";
		macchiato.size = '大';
		macchiato.price = 80;
		macchiato.hot = false;
		macchiato.printInfo();
	}

}
