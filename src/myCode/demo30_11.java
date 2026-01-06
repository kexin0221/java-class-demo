package myCode;

public class demo30_11 {
    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (lock1) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {}
                synchronized (lock2) {
                    System.out.println("Thread1 acquired both locks");
                }
            }
        }).start();
        new Thread(() -> {
            synchronized (lock2) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {}
                synchronized (lock1) {
                    System.out.println("Thread2 acquired both locks");
                }
            }
        }).start();
    }
}
