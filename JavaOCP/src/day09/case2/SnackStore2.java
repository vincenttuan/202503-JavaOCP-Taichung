package day09.case2;

public class SnackStore2 {

	public static void main(String[] args) {
		SaltedChicken saltedChicken = new SaltedChicken("鹽酥雞", 50);
		saltedChicken.setSize(3);
		saltedChicken.setSize(2);
		saltedChicken.setSize(5);
		saltedChicken.setSize(4);
		saltedChicken.setSize(1);
		System.out.printf("%s 份量:%d 價格:%d%n", 
				saltedChicken.getName(), saltedChicken.getSize(), saltedChicken.getPrice());

	}

}
