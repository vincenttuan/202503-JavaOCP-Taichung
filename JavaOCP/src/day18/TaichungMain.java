package day18;

public class TaichungMain {

	public static void main(String[] args) throws Exception {
		String content = ReadFile.read("src/day18/taichung.txt");
		//System.out.println(content);
		String[] rows = content.split("\r\n");
		for(int i=0;i<rows.length;i++) {
			System.out.printf("%d => %s%n", i, rows[i].trim());
		}
	}

}
