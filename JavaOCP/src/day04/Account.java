package day04;

// 帳戶
public class Account {
	
	private int balance = 10000; // 帳戶餘額(含初始值)
	
	/*
	public Account() {
		balance = 10000;
	}
	*/
	
	// 存款
	public void deposit(int amount) {
		if(amount <= 0) {
			System.out.println("存款資料不正確: " + amount);
			return;
		}
		System.out.printf("存款: $%,d%n", amount);
		balance += amount;
	}
	
	// 提款
	public void withdraw(int amount) {
		if(amount <= 0) {
			System.out.printf("提款資料不正確: %,d%n", amount);
			return;
		}
		if(amount > balance) {
			System.out.printf("提款 $%,d 失敗 餘額不足! 餘額: %,d%n", amount, balance);
			return;
		}
		System.out.printf("提款: $%,d%n", amount);
		balance -= amount;
	}
	
	// 轉帳
	public void transfer(int amount, Account account2) {
		// 判斷 amount 是否夠轉 
		if(amount > balance) {
			System.out.printf("轉帳 $%,d 失敗 餘額不足! 餘額: %,d%n", amount, balance);
			return;
		}
		// 自己(提款)
		this.withdraw(amount);
		// 對方(存款)
		account2.deposit(amount);
	}
	
	// 列印帳戶資料
	public void printInfo() {
		System.out.printf("帳戶餘額: %,d%n", balance);
	}
	
}
