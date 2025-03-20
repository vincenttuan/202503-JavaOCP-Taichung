package day02;

public class CoffeeShop2 {

	public static void main(String[] args) {
		// 建立一個咖啡實體同時也設定商品資訊
		Coffee c1 = new Coffee("拿鐵", '中', 65, true); 
		Coffee c2 = new Coffee("焦糖瑪奇朵", '大', 80, false); 
		Coffee c3 = new Coffee("美式", '大', 50, true); 
		Coffee c4 = new Coffee("摩卡", '中', 60, true); 
		Coffee c5 = new Coffee("義式濃縮", '小', 55, true); 
		Coffee c6 = new Coffee("巧克力脆片", '大', 120, false);
		
		// 建立一個咖啡陣列來存放咖啡
		Coffee[] coffees = {c1, c2, c3, c4, c5, c6};
		
		// 印出商品資訊
		
	}

}
