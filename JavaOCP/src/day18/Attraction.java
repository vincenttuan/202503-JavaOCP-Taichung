package day18;

import java.util.List;

// 景點物件
public class Attraction {
	private String type;        // 類型
	private String name;        // 景點名稱
	private List<String> foods; // 推薦美食
	private List<String> trans;// 交通方式
	private Integer pop;        // 人氣指數
	private Integer cost;       // 平均每人消費
	private Double cp;          // CP 值
	
	public Attraction(String row) {
		// row => 自然|台中公園|珍珠奶茶,魷魚羹|公車,捷運|75|100
		String[] array = row.split("\\|");
		this.type = array[0];
		this.name = array[1];
		this.foods = List.of(array[2].split(","));
		this.trans = List.of(array[3].split(","));
		this.pop = Integer.parseInt(array[4]);
		this.cost = Integer.parseInt(array[5]);
		this.cp = (double) (this.pop/this.cost);
	}

	public String getType() {
		return type;
	}

	public String getName() {
		return name;
	}

	public List<String> getFoods() {
		return foods;
	}

	public List<String> getTrans() {
		return trans;
	}

	public Integer getPop() {
		return pop;
	}

	public Integer getCost() {
		return cost;
	}

	public Double getCp() {
		return cp;
	}

	@Override
	public String toString() {
		return "Attraction [type=" + type + ", name=" + name + ", foods=" + foods + ", trans=" + trans + ", pop="
				+ pop + ", cost=" + cost + ", cp=" + cp + "]";
	}
	
	
}
