package myCode;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class demo30_15 {
    static class SumTask extends RecursiveTask<Double> {

        private static final int THRESHOLD = 1000000;
        private final double[] list;
        private final int start;
        private final int end;

        public SumTask(double[] list, int start, int end) {
            this.list = list;
            this.start = start;
            this.end = end;
        }

        @Override
        protected Double compute() {
            if (end - start <= THRESHOLD) {
                double sum = 0;
                for (int i = start; i < end; i++) {
                    sum += list[i];
                }
                return sum;
            } else {
                int mid = (start + end) / 2;
                SumTask left = new SumTask(list, start, mid);
                SumTask right = new SumTask(list, mid, end);
                left.fork();
                return right.compute() + left.join();
            }
        }
    }

    public static double parallelSum(double[] list) {
        ForkJoinPool pool = new ForkJoinPool();
        return pool.invoke(new SumTask(list, 0, list.length));
    }

    public static void main(String[] args) {
        double[] list = new double[9000000];
        for (int i = 0; i < list.length; i++) {
            list[i] = Math.random() * 100;
        }
        long startTime = System.currentTimeMillis();
        System.out.println("Parallel result: " + parallelSum(list));
        System.out.println("Parallel time: " + (System.currentTimeMillis() - startTime) + "ms");
        startTime = System.currentTimeMillis();
        double seqSum = 0;
        for (double num : list) {
            seqSum += num;
        }
        System.out.println("sequence result: " + seqSum);
        System.out.println("sequence time: " + (System.currentTimeMillis() - startTime) + "ms");
    }
}
