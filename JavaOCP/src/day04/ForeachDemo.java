package day04;

public class ForeachDemo {

	public static void main(String[] args) {
		String[] names = {"Bob", "Jack", "Rose", "Vincent", "Anita", "Howard", "Joanna", "Jo"};
		// 利用 For each 將每一個人名印出
		for(String name : names) {
			System.out.println(name);
		}
	}

}
