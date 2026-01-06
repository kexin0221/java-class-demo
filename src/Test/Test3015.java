package Test;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class Test3015 {

	public static void main(String[] args) {
		final int N = 9000000;
		double[] list = new double[N];
		for (int i = 1; i <= N; i++) {
			list[i - 1] = Math.random() * N;
		}
		long startTime = System.currentTimeMillis();
		RecursiveTask<Double> task = new SumTask(list, 0, list.length);
		ForkJoinPool pool = new ForkJoinPool();
		System.out.println(pool.invoke(task));
		long endTime = System.currentTimeMillis();
		System.out.println("\nParallel time with " + Runtime.getRuntime().availableProcessors() +
				" processors is " + (endTime - startTime) + " milliseconds");

		startTime = System.currentTimeMillis();
		double sum = 0.0;
		for (int i = 0; i < N; i++) {
			sum += list[i];
		}
		endTime = System.currentTimeMillis();
		System.out.println(sum + " : " + (endTime - startTime) + " milliseconds");
	}

	private static class SumTask extends RecursiveTask<Double> {
        private final double[] list;
		private final int low;
		private final int high;

		SumTask(double[] list, int low, int high) {
			this.list = list;
			this.low = low;
			this.high = high;
		}

		public Double compute() {
            int THRESHOLD = 50000;
            if (high - low < THRESHOLD) {
				double sum = 0;
				for (int i = low; i < high; i++) {
					sum = sum + list[i];
				}
				return sum;
			} else {
				int mid = (low + high) / 2;
				RecursiveTask<Double> left = new SumTask(list, low, mid);
				RecursiveTask<Double> right = new SumTask(list, mid, high);
				left.fork();
				right.fork();
				return left.join() + right.join();
			}
		}
	}
}
