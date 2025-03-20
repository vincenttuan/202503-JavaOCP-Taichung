package day02;

// 服飾店
public class OutfitStore {
	
	public static void main(String[] args) {
		// 單品
		Top top1 = new Top("T-shirt 簡約白", 500);
		Top top2 = new Top("Sweater 秋冬灰", 600);
		Top top3 = new Top("Shirt 紳士黑", 1000);
		
		Bottom bottom1 = new Bottom("Jeans 牛仔藍", 800);
		Bottom bottom2 = new Bottom("Shorts 運動灰", 400);
		Bottom bottom3 = new Bottom("Pants 正式黑", 1800);
		
		Hat hat1 = new Hat("Cap 運動帽", 300);
		Hat hat2 = new Hat("Hard Cap 安全帽", 900);
		Hat hat3 = new Hat("Fedora 紳士帽", 1300);
		
		// 組合品
		Outfit outfit1 = new Outfit("運動風", top1, bottom1, hat1);
		Outfit outfit2 = new Outfit("安全風", top2, bottom2, hat2);
		Outfit outfit3 = new Outfit("紳士風", top3, bottom3, hat3);
		Outfit outfit4 = new Outfit("自由風", top3, bottom1, hat2);
		
		// 購物車
		Outfit[] outfits = {outfit1, outfit2, outfit3, outfit4};
		int total = 0;
		for(int i=0;i<outfits.length;i++) {
			outfits[i].printInfo();
			total += outfits[i].price;
		}
		System.out.printf("總共需支付 $,d%n", total);
		
	}
	
}
