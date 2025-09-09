package com.example.demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GoldBruteForce {

    private static final String BASE_URL = "http://192.168.10.78:8080/gold/get?guess=";

    public static void main(String[] args) throws Exception {
        int guess = 1;

        while (true) {
            try {
                String apiUrl = BASE_URL + guess;
                HttpURLConnection connection = (HttpURLConnection) new URL(apiUrl).openConnection();
                connection.setRequestMethod("GET");
                connection.setConnectTimeout(3000);
                connection.setReadTimeout(3000);

                int responseCode = connection.getResponseCode();

                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(
                                responseCode == 200 ? connection.getInputStream() : connection.getErrorStream()
                        )
                );

                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();

                String result = response.toString();
                System.out.println("猜測 guess=" + guess + "，回應：" + result);
                // 若金幣 0 枚就結束程式
                if(result.contains("金幣剩下: 0 枚")) {
                	System.exit(0);
                }
                // 判斷回應是否成功取得金幣 (依照API回傳Json格式判斷true/false)
                if (result.contains("\"success\":true")) {
                    System.out.println("找到正確答案! guess = " + guess);
                    break;
                }

                // 從1~9迴圈猜
                guess++;
                if (guess > 9) {
                    guess = 1;
                }

                // 避免過快請求，可根據需要加入睡眠時間
                Thread.sleep(10);

            } catch (Exception e) {
                System.err.println("請求失敗: " + e.getMessage());
                Thread.sleep(10);
            }
        }
        main(null); // 遞迴
    }
}

