package Test;

public class Test3011 {

	static final Object obj1 = new Object();
	static final Object obj2 = new Object();

	public static void main(String[] args) {
		Run1 r1 = new Run1();
		Run2 r2 = new Run2();
		new Thread(r1).start();
		new Thread(r2).start();

	}

	static class Run1 implements Runnable {
		public void run() {
			synchronized (obj1) {
				System.out.println("Run1 get obj1");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Run1 waits for getting obj2");
				synchronized (obj2) {
					try {
						System.out.println("Run1 get obj2");
						Thread.sleep(200);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("Run1 release obj2");
			}
			System.out.println("Run1 release obj1");
		}
	}

	static class Run2 implements Runnable {
		public void run() {
			synchronized (obj2) {
				try {
					System.out.println("Run2 get obj2");
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				System.out.println("Run2 waiting for obj1");
				synchronized (obj1) {
					try {
						System.out.println("Run2 get obj1");
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}

		}
	}
}
