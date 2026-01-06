package Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test3009 {
	private final List<Integer> list = Collections.synchronizedList(new ArrayList<>());
	public static void main(String[] args) {
		ExecutorService executor = Executors.newCachedThreadPool();
		Test3009 t = new Test3009();
		executor.execute(t.new AddTask());
		executor.execute(t.new IteratorTask());
		executor.shutdown();
	}

	class AddTask implements Runnable {
		public void run () {
			while (true) {
				list.add(new Random().nextInt(100));
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	class IteratorTask implements Runnable {
		public void run () {
			while (true) {
				itratorList();
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	void itratorList() {
//	for(Integer d:list)System.out.print(d+" ");
//	System.out.println();
		synchronized (list){
			for(Integer d : list) {
				System.out.print(d + " ");
			}
			System.out.println();
		}
	}
}
