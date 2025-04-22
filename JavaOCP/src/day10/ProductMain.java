package day10;

import java.util.stream.Stream;

public class ProductMain {

	public static void main(String[] args) {
		Toner toner = new Toner("玫瑰保濕化妝水", 850);
		Lotion lotion = new Lotion("玻尿酸乳液", 1250);
		Serum serum = new Serum("維他命C精華液", 1680);
		
		// 專屬方法示範
		toner.refreshSkin();
		lotion.moisture();
		serum.repairSkin();
		
		// 價格
		/*
		System.out.printf("%s $%,d%n", toner.getName(), toner.getPrice());
		System.out.printf("%s $%,d%n", lotion.getName(), lotion.getPrice());
		System.out.printf("%s $%,d%n", serum.getName(), serum.getPrice());
		*/
		Product[] products = {toner, lotion, serum};
		Stream.of(products)
			  .forEach(p -> System.out.printf("%s $%,d%n", p.getName(), p.getPrice()));
		// 請計算 products 內容物總價 = ?
		int sum = Stream.of(products)                // [toner]->[lotion]->[serum] 
						.mapToInt(p -> p.getPrice()) // [850]->[1250]->[1680] 
						.sum();
		System.out.println(sum);
	}

}
