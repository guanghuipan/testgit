package testelevant;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 电梯门类使用线程模拟开门和关门动作
 * @author WIN7
 *
 */
public class Door {
	private ReentrantLock doorLock = new ReentrantLock();
	//表示开门和关门的状态，默认：关
	private DoorState doorState = DoorState.CLOSE;
	//表示电梯一次开门或者关门所需要的时间（单位：毫秒）
	private final int operationDuring = 3000;
	/**
	 * 关门
	 */
	public void close() {
		
		if(doorState==DoorState.OPEN) {
			try {
				doorLock.lockInterruptibly();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			
		}
	}
	/**
	 * 开门
	 */
	public void open() {
		
	}
}
