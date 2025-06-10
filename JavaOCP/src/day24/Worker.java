package day24;

public class Worker extends Thread {
	
	@Override
	public void run() {
		System.out.println("瓦斯工人開始送瓦斯");
		
		for(int i=1;i<=5000;i++) {
			try {
				System.out.printf("%d 秒鐘 ", i);
				Thread.sleep(1000); // 模擬運送途中的延遲
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
			System.out.println();
		}
		
		System.out.println("瓦斯工人將瓦斯送到家並裝設好");
	}
	
}
