package day08;

public class NigntMarketActivityTest {

	public static void main(String[] args) {
		// 夜市活動
		NightMarketActivity activity1 = new EatBigWrapSmall();
		NightMarketActivity activity2 = new DrinkFrogEgg();
		NightMarketActivity activity3 = new PlayBalloonGame();
		NightMarketActivity activity4 = new SingStreetShow();
		
		// 我要參與那些活動
		NightMarketActivity[] activities = {activity1, activity2, activity3, activity4};
		// 列出所參與的活動
		for(NightMarketActivity activity : activities) {
			activity.doActivity();
			System.out.printf("\t費用 $%d%n", activity.getCost());
		}
		
		
	}

}
