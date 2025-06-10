package day24;

public class Father extends Thread {

	@Override
	public void run() {
		System.out.println("爸爸下班回家");
		System.out.println("爸爸準備洗澡");
		System.out.println("爸爸發現沒有熱水");
		System.out.println("爸爸打電話請瓦斯工人送瓦斯");
		
		Worker worker = new Worker();
		worker.start();
		
		try {
			worker.join();
			//worker.join(10000);
			//Thread.sleep(20000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("爸爸開始洗熱水澡");
		System.out.println("爸爸洗完澡了");
		
	}
	
}
