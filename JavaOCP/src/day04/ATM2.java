package day04;

public class ATM2 {

	public static void main(String[] args) {
		Account account1 = new Account();
		Account account2 = new Account();
		
		// account1 轉 4000 給 account2
		account1.transfer(4000, account2);
		
		account1.printInfo();
		account2.printInfo();
		
	}

}
