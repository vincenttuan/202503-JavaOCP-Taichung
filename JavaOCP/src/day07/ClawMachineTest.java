package day07;

public class ClawMachineTest {

	public static void main(String[] args) {
		//ClawMachine clawMachine = new ClawMachine();
		ClawMachine clawMachine = new DeluxeClawMachine();
		//--------------------------------------------------
		clawMachine.insertCoin();
		clawMachine.play();
		clawMachine.play();
		if(clawMachine instanceof DeluxeClawMachine) {
			((DeluxeClawMachine)clawMachine).playMusic(); // 透過轉型來呼叫 playMusic()
		}
		System.out.println("-------------------------");
		
		DeluxeClawMachine deluxeClawMachine = new DeluxeClawMachine();
		deluxeClawMachine.insertCoin();
		deluxeClawMachine.play();
		deluxeClawMachine.play();
		deluxeClawMachine.playMusic(); // DeluxeClawMachine 專屬方法
		
	}

}
