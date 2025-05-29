package day21;

public class Charizard extends Pokemon {

	public Charizard(String name) {
		super(name);
		setType("Fire");
	}

	@Override
	public void displayInfo() {
		System.out.printf("名稱:%s 屬性:%s 等級:%d [%s]%n", 
				getName(), getType(), getLevel(), getClass().getSimpleName());
	}
	
}
