package day21;

public class Psyduck extends Pokemon {

	public Psyduck(String name) {
		super(name);
		setType("Water");
	}

	@Override
	public void displayInfo() {
		System.out.printf("名稱:%s 屬性:%s 等級:%d [%s]%n", 
				getName(), getType(), getLevel(), getClass().getSimpleName());
	}
	
}
