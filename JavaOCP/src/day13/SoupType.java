package day13;

public enum SoupType {
	原味("傳統柴魚高湯, 鮮甜清爽"),
	辣味("加入辣油辣椒, 微辣開胃");
	
	private String description;
	
	// enum 的建構子一律是 private 權限
	private SoupType(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
	
}
