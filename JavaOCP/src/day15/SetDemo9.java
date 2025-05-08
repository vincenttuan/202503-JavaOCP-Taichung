package day15;

import java.util.Set;

public class SetDemo9 {

	public static void main(String[] args) {
		Set<Soldier> soldiers = Set.of(
				new Soldier(Level.二等兵, 4500),
				new Soldier(Level.一等兵, 5000),
				new Soldier(Level.上兵, 6000),
				new Soldier(Level.下士, 9000)
		);
		System.out.println(soldiers);
		// 可以修改元素內的屬性資料
		// 將 上兵 加 800 元
		soldiers.forEach(soldier -> {
			if(soldier.getLevel().equals(Level.上兵)) {
				soldier.setSalary(soldier.getSalary() + 800);
			}
		});
		System.out.println(soldiers);
	}

}
