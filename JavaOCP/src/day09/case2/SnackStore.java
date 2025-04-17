package day09.case2;

public class SnackStore {
	public static void main(String[] args) {
		SaltedChicken saltedChicken = new SaltedChicken("鹽酥雞", 60);
		Tempura tempura = new Tempura("甜不辣", 30);
		Tofu tofu = new Tofu("百頁豆腐", 25);
		
		AbstractSnack[] abstractSnacks = {saltedChicken, tempura, tofu};
		for(AbstractSnack abstractSnack : abstractSnacks) {
			abstractSnack.makeSnack();
		}
		
		
		//Snack[] snacks = {saltedChicken, tempura, tofu};
		
	}
}
