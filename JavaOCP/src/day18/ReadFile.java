package day18;

import java.nio.file.Files;
import java.nio.file.Path;

public class ReadFile {
	public static String read(String fileName) throws Exception {
		String content = Files.readString(Path.of(fileName));
		return content;
	}
}
