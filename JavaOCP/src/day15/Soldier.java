package day15;

import java.util.Objects;

public class Soldier {
	private Level level;   // 二等兵, 一等兵, 上兵, 下士, 中士, 上士, 三等士官長, 二等士官長, 一等士官長
	private Integer salary; // 4500  5000  6000  9000
	
	public Soldier() {
	
	}

	public Soldier(Level level, Integer salary) {
		this.level = level;
		this.salary = salary;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(level, salary);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Soldier other = (Soldier) obj;
		return level == other.level && Objects.equals(salary, other.salary);
	}

	@Override
	public String toString() {
		return "Soldier [level=" + level + ", salary=" + salary + "]";
	}
	
}
