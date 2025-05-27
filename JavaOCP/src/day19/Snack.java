package day19;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Snack { // 小吃
	private String name; // 名稱
	private String description; // 敘述
	private Integer price; // 價格
	private String location; // 地址
	private String type; // 類型
	private Double latitude; // 緯度
	private Double longitude; // 經度
}
