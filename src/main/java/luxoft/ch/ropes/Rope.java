package luxoft.ch.ropes;

import java.util.concurrent.atomic.AtomicInteger;

public class Rope implements Runnable {
	
	final int DURATION = 20;
	public AtomicInteger decrement = new AtomicInteger(1);

	public void run() {
		for (int i = DURATION; i > 0; i -= decrement.get()) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void setFireOnBothEnds() {
		decrement.set(2);
	}

}
