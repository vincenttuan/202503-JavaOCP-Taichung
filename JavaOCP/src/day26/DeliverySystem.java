package day26;

import java.util.ArrayList;
import java.util.List;

// 派送公司系統
public class DeliverySystem {
	
	public static void main(String[] args) {
		// 建立包裹列表
		List<Package> packages = new ArrayList<>();
		packages.add(new Package("PKG-001", "台中市西屯區台灣大道三段99號", false));
		packages.add(new Package("PKG-002", "台中市北區健行路500號", false));
		packages.add(new Package("PKG-003", "台中市南區興大路145號", false));
		packages.add(new Package("PKG-004", "台中市中區中山路100號", false));
		packages.add(new Package("PKG-005", "台中市南屯區公益路二段51號", false));
	}
	
}
