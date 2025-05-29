package day21;

public class Bulbasaur extends Pokemon {

	public Bulbasaur(String name) {
		super(name);
		setType("Grass");
	}

	@Override
	public void displayInfo() {
		System.out.printf("名稱:%s 屬性:%s 等級:%d [%s]%n", 
				getName(), getType(), getLevel(), getClass().getSimpleName());
	}
	
}
