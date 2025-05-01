package day13;

public class WeekDemo {
	
	public static void main(String[] args) {
		
	}
	
	public static void monkeyDay(int w) {
		switch (w) {
			case Week.星期日:
				System.out.println("猴子去教堂");
				break;
			case Week.星期一:
				System.out.println("猴子穿新衣");
				break;
			case Week.星期二:
				System.out.println("猴子肚子餓");
				break;
			case Week.星期三:
				System.out.println("猴子去爬山");
				break;
			case Week.星期四:
				System.out.println("猴子去考試");
				break;
			case Week.星期五:
				System.out.println("猴子去跳舞");
				break;
			case Week.星期六:
				System.out.println("猴子去斗六");
				break;
			
		}
	}
}
