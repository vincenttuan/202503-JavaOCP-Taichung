package day11;

public class IKEAMain {

	public static void main(String[] args) {
		// 一般內部類別
		IKEAWardrobe ikeaWardrobe = new IKEAWardrobe("PAX 標準衣櫃");
		IKEAWardrobe.AssemblyGuide assemblyGuide = ikeaWardrobe.new AssemblyGuide();
		assemblyGuide.printSteps();
	}

}
