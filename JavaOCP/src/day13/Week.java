package day13;

// 在介面屬性中 public static final 可以省略不寫, 因為編譯器會自動幫你加上
public interface Week {
	int 星期日 = 1; // public static final int 星期日 = 1; 
	int 星期一 = 2;
	int 星期二 = 3;
	int 星期三 = 4;
	int 星期四 = 5;
	int 星期五 = 6;
	int 星期六 = 7;
}
