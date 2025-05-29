package day21;

/**
 * 使用者輸入兩輛賽車的名稱。
 * 程式自動生成這兩台賽車的車款、馬力與加速劑數量。
 * 使用 Track 進行比賽，並根據規則決定勝負。
 * 印出比賽結束後的勝者名稱、車款與最終馬力。
 * */
public class CarGame {
	public static void main(String[] args) {
		Car car1 = null;
		Car car2 = null;
		while (true) {
			car1 = new Car("Car1");
			car2 = new Car("Car2");
			break;
			/*
			if(car1.getFinalHorsePower() == car2.getFinalHorsePower()) {
				break;
			}
			*/
			/*
			if(car1.getFinalHorsePower() == car2.getFinalHorsePower() && car1.getModel().equals(car2.getModel())) {
				break;
			}
			*/
		}
		System.out.printf("參賽名稱:%s、車款:%s、最終馬力:%d%n", 
				car1.getName(), car1.getModel(), car1.getFinalHorsePower());
		System.out.printf("參賽名稱:%s、車款:%s、最終馬力:%d%n", 
				car2.getName(), car2.getModel(), car2.getFinalHorsePower());
		System.out.println("-----------------------------------------");
		Car winnerCar = Track.race(car1, car2);
		System.out.printf("勝者名稱:%s、車款:%s、最終馬力:%d%n", 
				winnerCar.getName(), winnerCar.getModel(), winnerCar.getFinalHorsePower());
	}
}
