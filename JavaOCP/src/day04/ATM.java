package day04;

public class ATM {

	public static void main(String[] args) {
		Account account1 = new Account();
		account1.printInfo();
		// 存款
		account1.deposit(5000);
		account1.printInfo();
		account1.deposit(-2000);
		account1.printInfo();
		

	}

}
