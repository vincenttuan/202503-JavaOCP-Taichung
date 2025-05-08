package day15;

import java.util.Set;

public class SetDemo9 {

	public static void main(String[] args) {
		Set<Soldier> soldiers = Set.of(
				new Soldier("二等兵", 4500),
				new Soldier("一等兵", 5000),
				new Soldier("上兵", 6000),
				new Soldier("下士", 9000)
		);
		System.out.println(soldiers);
		// 可以修改元素內的屬性資料
		// 將 上兵 加 800 元
		soldiers.forEach(soldier -> {
			if(soldier.getLevel().equals("上兵")) {
				soldier.setSalary(soldier.getSalary() + 800);
			}
		});
		System.out.println(soldiers);
	}

}
