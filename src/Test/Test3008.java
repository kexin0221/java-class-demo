package Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test3008 {

  private static final Account account = new Account();

  public static void main(String[] args) {
    // Create a thread pool with two threads
    ExecutorService executor = Executors.newFixedThreadPool(2);
    executor.execute(new DepositTask());
    executor.execute(new WithdrawTask());
    executor.shutdown();

    System.out.println("Thread 1\t\tThread 2\t\tBalance");
  }

  // A task for adding an amount to the account
  public static class DepositTask implements Runnable {
    public void run() {
      try { // Purposely delay it to let the withdraw method proceed
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

  // A task for subtracting an amount from the account
  public static class WithdrawTask implements Runnable {
    public void run() {
      while (true) {
        account.withdraw((int)(Math.random() * 10) + 1);
      }
    }
  }

  // An inner class for account
  private static class Account {
    // Create a new lock
    private static final Lock lock = new ReentrantLock();

    // Create a condition
    private static Condition newDeposit = lock.newCondition();

    private int balance = 0;

    public static Condition getNewDeposit() {
      return newDeposit;
    }

    public static void setNewDeposit(Condition newDeposit) {
      Account.newDeposit = newDeposit;
    }

    public int getBalance() {
      return balance;
    }

    public synchronized void withdraw(int amount) {
//      lock.lock(); // Acquire the lock
      try {
        while (balance < amount) {
          System.out.println("\t\t\tWait for a deposit");
          this.wait();
        }
        balance -= amount;
        System.out.println("\t\t\tWithdraw " + amount +
                "\t\t" + getBalance());
      }
      catch (InterruptedException ex) {
        ex.printStackTrace();
      }
      finally {
//        lock.unlock(); // Release the lock
      }
    }

    public synchronized void deposit(int amount) {
//      lock.lock(); // Acquire the lock
      try {
        balance += amount;
        System.out.println("Deposit " + amount +
                "\t\t\t\t\t" + getBalance());

        // Signal thread waiting on the condition
//        newDeposit.signalAll();
        this.notifyAll();
      }
      finally {
//        lock.unlock(); // Release the lock
      }
    }

//    public  void withdraw(int amount) {
//    	synchronized (this)
//    	{
//	      try {
//					while (balance < amount) {
//					  System.out.println("\t\t\tWait for a deposit");
//					  this.wait();
//					  }
//
//					balance -= amount;
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//	     }
//	      System.out.println("\t\t\tWithdraw " + amount +
//        "\t\t" + getBalance());
//
//  }
//    public  void deposit(int amount) {
//    	synchronized (this)
//    	{
//	    	balance += amount;
//	    	this.notifyAll();
//    	}
//      System.out.println("Deposit " + amount +
//        "\t\t\t\t\t" + getBalance());
//    }
  }
}
