package day13;

public enum Week3 {
	星期日("猴子去教堂"), 星期一("猴子穿新衣"), 星期二("猴子肚子餓"), 
	星期三("猴子去爬山"), 星期四("猴子去考試"), 星期五("猴子去跳舞"), 
	星期六("猴子去斗六");
	
	private String action;
	
	private Week3(String action) {
		this.action = action;
	}
	
	public String getAction() {
		return action;
	}
	
}
