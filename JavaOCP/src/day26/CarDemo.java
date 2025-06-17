package day26;

import java.util.concurrent.CyclicBarrier;

public class CarDemo {

	public static void main(String[] args) {
		int n = 4;
		Runnable eat = () -> {
			System.out.println("吃台中肉圓");
		};
		CyclicBarrier cb = new CyclicBarrier(n, eat);
		
		Car[] cars = {
				new Car(cb, "小鄧"),
				new Car(cb, "老邱"),
				new Car(cb, "小林"),
				new Car(cb, "小黃")
		};
		
		for(Car car : cars) {
			car.start();
		}
		

	}

}
