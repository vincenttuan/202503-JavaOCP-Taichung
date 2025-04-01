package day05;

public class ToyStore {
	public static void main(String[] args) {
		// 零件
		Battery batteryA = new Battery("A", 50);
		Battery batteryAA = new Battery("AA", 30);
		Battery batteryAAA = new Battery("AAA", 20);
		Battery batteryAAAA = new Battery("AAAA", 10);
		Wheel wheelA = new Wheel(5, 10);
		Wheel wheelB = new Wheel(7, 25);
		Wheel wheelC = new Wheel(11, 40);
		// 輪子組合
		Wheel[] wheelsA = {wheelA, wheelA, wheelA, wheelA};
		Wheel[] wheelsB = {wheelB, wheelB, wheelB, wheelB};
		Wheel[] wheelsC = {wheelC, wheelC, wheelC, wheelC};
		Wheel[] wheelsF = {wheelA, wheelB, wheelC, wheelC};
		// 玩具組合
		CarToy carToy1 = new CarToy("藍寶堅尼", 250, wheelsC, batteryA);
		CarToy carToy2 = new CarToy("砲彈飛車", 100, wheelsA, batteryAAAA);
		DollToy dollToy1 = new DollToy("芭比娃娃", 750);
		DollToy dollToy2 = new DollToy("電動芭比", 800, batteryAAA);
		// 玩具展示(武力展示)
		System.out.println(carToy1);
		System.out.println(carToy2);
		System.out.println(dollToy1);
		System.out.println(dollToy2);
	}
}
