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
			System.out.println("提款資料不正確: " + amount);
		}
		System.out.printf("提款: $%,d%n", amount);
		balance -= amount;
	}
	
	// 列印帳戶資料
	public void printInfo() {
		System.out.printf("帳戶餘額: %,d%n", balance);
	}
	
}
