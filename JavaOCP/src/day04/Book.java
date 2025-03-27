package day04;

// 書的設計
public class Book {
	String name; // 書名
	int price; // 價格
	int pages; // 頁數
	
	//若沒寫建構子則 Java 會自動產生, 所產生的建構子稱為預設建構子, 其結構如下所述:
	// 無參數建構子
	public Book() {
		System.out.println("呼叫 Book() 建構子");
	}
}
