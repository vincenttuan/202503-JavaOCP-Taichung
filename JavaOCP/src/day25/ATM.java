package day25;

public class ATM {
	public static void main(String[] args) throws InterruptedException {
		// 建立帳號
		Account account = new Account(10000);
		// 建立提款工作
		Withdraw w1 = new Withdraw(account, 5000);
		Withdraw w2 = new Withdraw(account, 4000);
		Withdraw w3 = new Withdraw(account, 3000);
		// 執行提款工作
		Thread t1 = new Thread(w1, "小明");
		Thread t2 = new Thread(w2, "小華");
		Thread t3 = new Thread(w3, "小英");
		t1.start();
		t2.start();
		t3.start();
		
		t1.join();
		t2.join();
		t3.join();
		System.out.println("提款完成");
	}
}
