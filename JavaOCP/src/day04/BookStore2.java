package day04;

public class BookStore2 {

	public static void main(String[] args) {
		Book book1 = new Book("現代Java", 450, 325);
		Book book2 = new Book("唐詩300首", 300, 150);
		Book book3 = new Book("兒歌帶動唱", 700, 250);
		
		Book[] books = {book1, book2, book3};
		// 請問總共要付多少錢 ?
		int total = 0;
		for(Book book : books) {
			System.out.println(book.getPrice());
			total += book.getPrice();
		}
		System.out.println("------");
		System.out.println(total);

	}

}
