package day14;

import java.util.Objects;

public class Task {
	private String time; // 時間
	private String description; // 任務描述
	
	public Task(String time, String description) {
		this.time = time;
		this.description = description;
	}

	public String getTime() {
		return time;
	}

	public String getDescription() {
		return description;
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, time);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Task other = (Task) obj;
		return Objects.equals(description, other.description) && Objects.equals(time, other.time);
	}
	
	
	
}
