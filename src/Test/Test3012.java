package Test;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class Test3012 {
	public static void main(String[] args) {
		final int N = 90000000;
		double[] list = new double[N];
		double[] list2 = new double[N];

		long startTime = System.currentTimeMillis();
		RecursiveAction task = new RadomTask(list,0, list.length);
		ForkJoinPool pool = new ForkJoinPool();
		pool.invoke(task);
		long endTime = System.currentTimeMillis();
		System.out.println("\nParallel time with " + Runtime.getRuntime().availableProcessors() +
				" processors is " + (endTime - startTime) + " milliseconds");
		startTime = System.currentTimeMillis();

		for(int i = 0; i < N; i++) {
			list2[i] = Math.random();
		}
		endTime = System.currentTimeMillis();
		System.out.println(list2[N-1] + " : " + (endTime - startTime) + " milliseconds");
	}

	private static class RadomTask extends RecursiveAction {
        private final double[] list;
		private final int low;
		private final int high;

		RadomTask(double[] list, int low, int high) {
			this.list = list;
			this.low = low;
			this.high = high;
		}

		protected void compute() {
            int THRESHOLD = 500;
            if (high - low < THRESHOLD) {
				Random random = new Random();
				for (int i = low; i < high; i++) {
					list[i] =  random.nextDouble();
				}
			} else {
				int mid = (low + high) / 2;
				RadomTask left = new RadomTask(list, low, mid);
				RadomTask right = new RadomTask(list, mid, high);
				invokeAll(left,right);
			}
		}
	}
}