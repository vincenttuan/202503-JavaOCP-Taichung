package day07;

public class CompanyTest {

	public static void main(String[] args) {
		Employee employee = new Employee();
		System.out.println(employee.salary); // 50000
		
		Manager manager = new Manager();
		System.out.println(manager.salary); // 50000
		System.out.println(manager.budget); // 70000
		
		Supervisor supervisor = new Supervisor();
		System.out.println(supervisor.salary); // 50000
		System.out.println(supervisor.budget); // 70000
		System.out.println(supervisor.stock);  // 120000
		
	}

}
