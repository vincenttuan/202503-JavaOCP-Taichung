package day08;

public class AnimalTest {

	public static void main(String[] args) {
		Animal a1 = new Animal();
		Animal a2 = new Dog();
		Animal a3 = new Cat();
		
		a1.voice();
		a2.voice();
		a3.voice();
		
		// ----------------------------
		// Java 11 可以利用 var 讓 java 自行判讀型別
		var b1 = new Animal();
		var b2 = new Dog(); // 相當於 Dog b2 = new Dog();
		var b3 = new Cat(); // 相當於 Cat b3 = new Cat();
		b1.voice();
		b2.voice();
		b3.voice();
		
	}

}
