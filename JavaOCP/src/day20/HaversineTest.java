package day20;

public class HaversineTest {

	public static void main(String[] args) {
		// 巨匠逢甲分校經緯度:(緯度)24.1761, (經度)120.6402
		// 大甲芋頭牛奶-文華路入口附近:(緯度)24.1788, (經度)120.6466
		double lat1=24.1761, lon1=120.6402;
		double lat2=24.1788, lon2=120.6466;
		
		double m = Haversine.distance(lat1, lon1, lat2, lon2);
		System.out.println(m);

	}

}
