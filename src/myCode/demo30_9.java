package myCode;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class demo30_9 {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 5; i++) {
            set.add(i);
        }
        Thread t1 = new Thread(() -> {
            try {
                int count = 5;
                while (true) {
                    Thread.sleep(1000);
                    set.add(count++);
                }
            } catch (InterruptedException ignored) {

            }
        });
        Thread t2 = new Thread(() -> {
           try {
               while (true) {
                   Thread.sleep(1000);
                   Iterator<Integer> iterator = set.iterator();
                   while (iterator.hasNext()) {
                       System.out.print(iterator.next() + " ");
                   }
                   System.out.println();
               }
           } catch (InterruptedException e) {
           }
        });
        t1.start();
        t2.start();
    }
}
