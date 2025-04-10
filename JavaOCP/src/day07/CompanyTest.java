package day07;

public class CompanyTest {

	public static void main(String[] args) {
		Employee employee = new Employee();
		System.out.println(employee.salary);
		
		Manager manager = new Manager();
		System.out.println(manager.salary);
		System.out.println(manager.budget);
		
		Supervisor supervisor = new Supervisor();
		System.out.println(supervisor.salary);
		System.out.println(supervisor.budget);
		System.out.println(supervisor.stock);
		
	}

}
