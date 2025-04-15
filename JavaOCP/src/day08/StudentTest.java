package day08;

public class StudentTest {

	public static void main(String[] args) {
		NightMarketActivity eatBigWrapSmall = new EatBigWrapSmall();
		NightMarketActivity drinkFrogEgg = new DrinkFrogEgg();
		NightMarketActivity playBalloonGame = new PlayBalloonGame();
		NightMarketActivity singStreetShow = new SingStreetShow();
		
		Student amy = new Student("Amy");
		amy.addActivity(eatBigWrapSmall);
		amy.addActivity(drinkFrogEgg);
		amy.addActivity(playBalloonGame);
		
		Student ben = new Student("Ben");
		ben.addActivity(new EatBigWrapSmall());
		ben.addActivity(new DrinkFrogEgg());
		ben.addActivity(new PlayBalloonGame());
		ben.addActivity(new SingStreetShow());
		ben.addActivity(new EatBigWrapSmall());
		
		System.out.println("夜市活動開始");
		amy.playNightMarketActivity();
		System.out.println();
		ben.playNightMarketActivity();
	}

}
