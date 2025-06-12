package day25;

// 提款工作(進行提款作業用)
public class Withdraw implements Runnable {
	private Account account; // 帳號
	private Integer amount;  // 提款金額
	
	public Withdraw(Account account, Integer amount) {
		this.account = account;
		this.amount = amount;
	}
	
	@Override
	public void run() {
		// 執行提款工作
		account.widthdraw(amount);
	}

}
