package day25;

public class Student extends Thread {
	private PhilippineTour tour;
	private String name;
	
	public Student(PhilippineTour tour, String name) {
		this.tour = tour;
		this.name = name;
	}
	
	@Override
	public void run() {
		tour.signup(name);
	}
	
}
