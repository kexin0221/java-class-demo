package Test;

import java.util.concurrent.ExecutorService;  // 线程池接口，用于管理线程
import java.util.concurrent.Executors;  // 线程池工厂类，用于创建不同类型的线程池
import java.util.concurrent.locks.Condition;  // 条件对象，用于线程间通信
import java.util.concurrent.locks.Lock;  // 锁接口，用于实现线程同步
import java.util.concurrent.locks.ReentrantLock;  // 可重入锁，Lock接口的实现类

public class Test3008 {
  // 创建一个共享的Account对象，用于演示多线程操作
  private static final Account account = new Account();

  // 主方法，程序入口
  public static void main(String[] args) {
    // 创建一个固定大小为2的线程池（最多同时运行2个线程）
    ExecutorService executor = Executors.newFixedThreadPool(2);
    // 向线程池提交一个存款任务
    executor.execute(new DepositTask());
    // 向线程池提交一个取款任务
    executor.execute(new WithdrawTask());
    // 关闭线程池，不再接受新任务，但会执行完已提交的任务
    executor.shutdown();

    // 打印输出表格标题，展示线程1、线程2的操作和账户余额
    System.out.println("Thread 1\t\tThread 2\t\tBalance");
  }

  // 存款任务类，实现Runnable接口
  public static class DepositTask implements Runnable {
    // 线程执行的方法
    public void run() {
      try {
        // 无限循环执行存款操作
        while (true) {
          // 随机生成1-10之间的存款金额，调用账户的deposit方法
          account.deposit((int) (Math.random() * 10) + 1);
          // 线程休眠1秒，模拟实际应用中的时间间隔
          Thread.sleep(1000);
        }
      } catch (InterruptedException ex) {  // 捕获中断异常
        ex.printStackTrace();  // 打印异常堆栈信息
      }
    }
  }

  // 取款任务类，实现Runnable接口
  public static class WithdrawTask implements Runnable {
    // 线程执行的方法
    public void run() {
      try {
        // 无限循环执行取款操作
        while (true) {
          // 随机生成1-10之间的取款金额，调用账户的withdraw方法
          account.withdraw((int) (Math.random() * 10) + 1);
          // 线程休眠1秒，模拟实际应用中的时间间隔
          Thread.sleep(1000);
        }
      } catch (InterruptedException ex) {  // 捕获中断异常
        ex.printStackTrace();  // 打印异常堆栈信息
      }
    }
  }

  private static class Account {

    private int balance = 0;

    public int getBalance() {
      return balance;
    }

    // 取款方法，使用synchronized关键字保证线程安全
    public synchronized void withdraw(int amount) {

      try {
        // 循环检查账户余额是否小于取款金额
        while (balance < amount) {
          // 如果余额不足，打印等待信息
          System.out.println("\t\t\tWait for a deposit");
          // 线程等待，释放对象锁，直到被其他线程唤醒
          this.wait();
        }
        // 余额足够时，执行取款操作
        balance -= amount;
        // 打印取款信息和当前余额
        System.out.println("\t\t\tWithdraw " + amount + "\t\t" + getBalance());
      } catch (InterruptedException ex) {  // 捕获中断异常
        ex.printStackTrace();  // 打印异常堆栈信息
      } finally {
      }
    }

    // 存款方法，使用synchronized关键字保证线程安全
    public synchronized void deposit(int amount) {
      try {
        // 执行存款操作
        balance += amount;
        // 打印存款信息和当前余额
        System.out.println("Deposit " + amount + "\t\t\t\t\t" + getBalance());
        this.notifyAll();
      } finally {
      }
    }
  }
}
