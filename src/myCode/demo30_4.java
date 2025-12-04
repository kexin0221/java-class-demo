package myCode;

public class demo30_4 {
    private static Integer sum = 0;

    public static void main(String[] args) {
        System.out.println("======无同步测试======");
        testWithoutSync();
        System.out.println("\n======同步测试======");
        testWithSync();
    }

    private static void testWithSync() {
        sum = 0;
        Thread[] threads = new Thread[1000];
        Object lock = new Object();
        for (int i = 0; i < 1000; i++) {
            threads[i] = new Thread(() -> {
                synchronized (lock) {
                    int temp = sum;
                    sum = temp + 1;
                }
            });
            threads[i].start();
        }
        waitForThreads(threads);
        System.out.println("最终结果: " + sum);
    }

    private static void testWithoutSync() {
        sum = 0;
        Thread[] threads = new Thread[1000];
        for (int i = 0; i < 1000; i++) {
            threads[i] = new Thread(() -> {
                int temp = sum;
                sum = temp + 1;
            });
            threads[i].start();
        }
        waitForThreads(threads);
        System.out.println("最终结果: " + sum);
    }

    private static void waitForThreads(Thread[] threads) {
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
