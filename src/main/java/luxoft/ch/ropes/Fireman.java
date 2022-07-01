package luxoft.ch.ropes;

public class Fireman {
	
	private final Rope ropeA;
	private final Rope ropeB;

	public Fireman() {
		ropeA = new Rope();
		ropeB = new Rope();
	}

	private void measure15sec() throws InterruptedException {
		Thread threadA = new Thread(ropeA);
		Thread threadB = new Thread(ropeB);
		
		ropeB.setFireOnBothEnds();
		threadB.start();
		
		threadA.start(); 
		
		threadB.join();
		
		ropeA.setFireOnBothEnds();
		threadA.join();
		
	}

	public static void main(String[] args) throws InterruptedException {
		Fireman fireman = new Fireman();

		final long measurementStart = System.currentTimeMillis();
		
		fireman.measure15sec();
		
		final long measurementTime = System.currentTimeMillis() - measurementStart;
		System.out.println("measured %d msec or %d sec".formatted(measurementTime, measurementTime/1000));
	}

}
