package day25;

public class PhilippineTourDemo {

	public static void main(String[] args) {
		PhilippineTour tour = new PhilippineTour(3); // 3 個名額
		
		// 模擬 5 個學生去搶
		Student[] students = {
				new Student(tour, "小鄧"),new Student(tour, "小美"),
				new Student(tour, "小廖"),new Student(tour, "小陳"),
				new Student(tour, "小段")
		};
		
		

	}

}
