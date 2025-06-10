package day24;

// 賽馬
public class Horse implements Runnable {

	@Override
	public void run() {
		String horseName = Thread.currentThread().getName(); // 目前正在執行的執行緒名
		for(int i=1;i<=1000;i++) {
			System.out.printf("%s 跑了 %d 步%n", horseName, i);
		}
	}
	
}
