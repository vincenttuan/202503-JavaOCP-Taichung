package day25;

public class ATM {
	public static void main(String[] args) throws InterruptedException {
		// 建立帳號
		Account account = new Account(10000);
		// 建立提款工作
		Withdraw w1 = new Withdraw(account, 5000);
		// 執行提款工作
		Thread t1 = new Thread(w1, "小明");
		t1.start();
		
		t1.join();
		System.out.println("提款完成");
	}
}
