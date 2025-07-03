package model;

public class Beverage {
	private String name;
	private String size; // L, M, S
	
	public Beverage() {
		
	}
	
	public Beverage(String name, String size) {
		this.name = name;
		this.size = size;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}
	
	
	
	
}
