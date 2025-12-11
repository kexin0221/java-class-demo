package myCode;

import java.util.concurrent.*;
import java.util.concurrent.locks.*;

public class demo30_8 {
    private static final Account account = new Account();

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.execute(new chapter30.ThreadCooperation.DepositTask());
        executor.execute(new chapter30.ThreadCooperation.WithdrawTask());
        executor.shutdown();

        System.out.println("Thread 1\t\tThread 2\t\tBalance");
    }

    public static class DepositTask implements Runnable {
        public void run() {
            try {
                while (true) {
                    account.deposit((int)(Math.random() * 10) + 1);
                    Thread.sleep(1000);
                }
            }
            catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static class WithdrawTask implements Runnable {
        public void run() {
            while (true) {
                account.withdraw((int)(Math.random() * 10) + 1);
            }
        }
    }

    private static class Account {
        private int balance = 0;

        public int getBalance() {
            return balance;
        }

        public synchronized void withdraw(int amount) {
            try {
                while (balance < amount) {
                    System.out.println("\t\t\tWait for a deposit");
                    wait();
                }
                balance -= amount;
                System.out.println("\t\t\tWithdraw " + amount + "\t\t" + getBalance());
            }
            catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }

        public synchronized void deposit(int amount) {
            try {
                balance += amount;
                System.out.println("Deposit " + amount + "\t\t\t\t\t" + getBalance());
                notifyAll();
            } finally {

            }
        }
    }
}

