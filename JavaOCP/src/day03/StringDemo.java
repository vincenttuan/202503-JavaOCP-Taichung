package day03;

public class StringDemo {

	public static void main(String[] args) {
		// 字串 concat 的應用
		String s1 = "Java";
		s1 = s1.concat("8");
		System.out.println(s1);
		
		String s2 = "Java";
		//s2 = s2.concat("11");
		s2.concat("11");
		System.out.println(s2);
		
		// 字串 replace 的應用
		String s3 = "Java";
		//s3 = s3.replace('J', 'A');
		s3.replace('J', 'A');
		System.out.println(s3);
	}

}
