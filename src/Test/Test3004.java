package Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test3004 {
	static Integer sum = 0;
	static Integer sum1=0;
	//	static String sum1=" ";
	static Lock lock = new ReentrantLock();
	static final Object ob = new Object();
	private static Semaphore sema = new Semaphore(1);
	public static void main(String[] args) {
		ExecutorService executor = Executors.newCachedThreadPool();

		for(int i = 0; i < 1000; i++) {
			executor.execute(Test3004::addSum);
		}
		executor.shutdown();
		while(true) {
			if(executor.isTerminated()) {
				System.out.println("sum:"+sum);
				break;
			}
		}
	}

	public static void addSum() {
		synchronized(ob) {
			sum = sum + 1;
			System.out.println(sum.hashCode());
		}
	}

    public static Semaphore getSema() {
        return sema;
    }

    public void setSema(Semaphore sema) {
        Test3004.sema = sema;
    }
}
