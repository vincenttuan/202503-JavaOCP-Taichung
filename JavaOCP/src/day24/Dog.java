package day24;

// 賽狗
public class Dog implements Runnable {
	
	@Override
	public void run() {
		String horseName = Thread.currentThread().getName(); // 目前正在執行的執行緒名
		for(int i=1;i<=1000;i++) {
			System.out.printf("%s 跑了 %d 步%n", horseName, i);
		}
		// 跑完了, 修改 winner
		if(Horse.winner == null) {
			Horse.winner = horseName;
		}
	}
	
}
