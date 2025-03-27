package day04;

public class BookStore {

	public static void main(String[] args) {
		Book book1 = new Book();
		book1.name = "現代Java";
		book1.setPrice(450);
		book1.pages = 325;
		book1.printInfo();
		// 單獨可以印出價格
		System.out.println(book1.getPrice());
	}

}
