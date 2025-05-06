package day14;

import java.util.Objects;

public class Gift {
	private String name; // 名稱
	private String kind; // 代表
	private Integer price; // 價格
	private String message; // 感謝函
	
	public Gift(String name, String kind, Integer price, String message) {
		this.name = name;
		this.kind = kind;
		this.price = price;
		this.message = message;
	}

	public String getName() {
		return name;
	}

	public String getKind() {
		return kind;
	}

	public Integer getPrice() {
		return price;
	}

	public String getMessage() {
		return message;
	}

	@Override
	public int hashCode() {
		return Objects.hash(kind, message, name, price);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Gift other = (Gift) obj;
		return Objects.equals(kind, other.kind) && Objects.equals(message, other.message)
				&& Objects.equals(name, other.name) && Objects.equals(price, other.price);
	}
	
	
}
