package day03;

public class StringAndChar {

	public static void main(String[] args) {
		// 建立 char
		char c1 = 'A';
		char c2 = 'A';
		// 判斷是否相等 ?
		System.out.println(c1 == c2); // true (== 是用來比較 stack 內容)
		// 建立字串
		String s1 = new String("Java");
		String s2 = new String("Java");
		System.out.println(s1 == s2); // false (== 是用來比較 stack 內容)
		System.out.println(s1.equals(s2)); // 有分大小寫的比較 (equals 是用來比較實際內容值)
		System.out.println(s1.equalsIgnoreCase(s2)); // 無分大小寫的比較

	}

}
