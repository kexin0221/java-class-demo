package myCode;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class demo30_12 {
    private static class AssignTask extends RecursiveAction {
        private static final int THRESHOLD = 1000;
        private final double[] list;
        private final int start;
        private final int end;
        private final Random random;

        public AssignTask(double[] list, int start, int end, Random random) {
            this.end = end;
            this.list = list;
            this.random = random;
            this.start = start;
        }

        @Override
        protected void compute() {
            if (end - start <= THRESHOLD) {
                for (int i = start; i < end; i++) {
                    list[i] = random.nextDouble();
                }
            } else {
                int mid = (start + end) / 2;
                AssignTask left = new AssignTask(list, start, mid, random);
                AssignTask right = new AssignTask(list, mid, end, random);
                invokeAll(left, right);
            }
        }
    }

    public static void parallelAssignValues(double[] list) {
        ForkJoinPool pool = new ForkJoinPool();
        Random random = new Random();
        pool.invoke(new AssignTask(list, 0, list.length, random));
        pool.shutdown();
    }

    public static void sequentialAssignValues(double[] list) {
        Random random = new Random();
        for (int i = 0; i < list.length; i++) {
            list[i] = random.nextDouble();
        }
    }

    public static void main(String[] args) {
        int size = 9000000;
        double[] list1 = new double[size];
        double[] list2 = new double[size];

        long startTime = System.currentTimeMillis();
        sequentialAssignValues(list1);
        System.out.println("Sequential time: " + (System.currentTimeMillis() - startTime) + "ms");

        startTime = System.currentTimeMillis();
        parallelAssignValues(list2);
        System.out.println("Parallel time: " + (System.currentTimeMillis() - startTime) + "ms");
    }
}
