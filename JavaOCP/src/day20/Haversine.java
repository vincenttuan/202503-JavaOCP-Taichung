package day20;

/**
 * 哈弗辛公式（Haversine Formula）原理
 * 地球是個近似球體，兩點間的最短路徑是「大圓距離」。哈弗辛公式可計算這個距離。
 * 巨匠逢甲分校經緯度
 * (緯度)24.1761, (經度)120.6402
 */
public class Haversine {
	/**
     * 計算兩個經緯度之間的距離（單位：公尺）
     * @param lat1 第一點緯度（度）
     * @param lon1 第一點經度（度）
     * @param lat2 第二點緯度（度）
     * @param lon2 第二點經度（度）
     * @return 距離（公尺）
     */
    public static double distance(double lat1, double lon1, double lat2, double lon2) {
        final double R = 6378137; // 地球半徑（公尺）

        // 1. 計算緯度、經度差值（弧度）
        double dLat = Math.toRadians(lat2 - lat1); // Δlat
        double dLon = Math.toRadians(lon2 - lon1); // Δlon

        // 2. 將原點的緯度轉為弧度
        double radLat1 = Math.toRadians(lat1);
        double radLat2 = Math.toRadians(lat2);

        // 3. 套用哈弗辛公式
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
                 + Math.cos(radLat1) * Math.cos(radLat2)
                 * Math.sin(dLon / 2) * Math.sin(dLon / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        // 4. 計算距離
        return R * c;
    }
}
