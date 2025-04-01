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
		
		
		
	}
}
