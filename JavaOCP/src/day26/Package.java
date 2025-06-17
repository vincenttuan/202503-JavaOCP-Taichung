package day26;

import lombok.AllArgsConstructor;
import lombok.Data;

// 包裹
@Data
@AllArgsConstructor
public class Package {
	private String id;
	private String address;
	private Boolean delivered; // 派送狀態
}
