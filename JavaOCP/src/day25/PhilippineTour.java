package day25;

import java.util.concurrent.locks.ReentrantLock;

// 菲律賓遊學
public class PhilippineTour {
	
	private int availableSeats; // 可報名名額
	private ReentrantLock lock = new ReentrantLock();
	
	public PhilippineTour(int availableSeats) {
		this.availableSeats = availableSeats;
	}
	
	// 報名
	public boolean signup(String studentName) {
		lock.lock(); // 取得鎖
		try {
			if(availableSeats > 0) {
				System.out.printf("%s 成功報名菲律賓遊學團, ", studentName);
				availableSeats--;
				System.out.printf("剩餘名額:%d%n", availableSeats);
				return true;
			} else {
				System.out.printf("%s 報名失敗, 菲律賓遊學團人數已滿%n", studentName);
				return false;
			}
		} finally {
			lock.unlock(); // 釋放鎖
		}
	}
	
}
