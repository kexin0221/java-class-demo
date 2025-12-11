package Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test3004 {
	static Integer sum=0;
//	static Long sum1=0l;
	static Integer sum1=0;
//	static String sum1=" ";
	static Lock lock = new ReentrantLock();
	static Object ob = new Object();
  private static Semaphore sema=new Semaphore(1);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService executor = Executors.newCachedThreadPool();

		for(int i=0;i<1000;i++)
		{
			executor.execute(()->{
				addSum();
			});
		}
//		executor.shutdownNow();
		executor.shutdown();
		while(true)
			if(executor.isTerminated()){System.out.println("sum:"+sum); break;}
//		System.out.println("sum:"+sum);
	}

//	public static void addSum()
//	{
//		sum++;
//	}

//	public synchronized static void addSum()
//	{
//		sum++;
//	}

	public  static void addSum()
	{
		//codes
//		synchronized(sum){
//			synchronized(sum1){
			synchronized(ob){
//		sum++;
//		sum1++;
//		sum1=sum1+"1";

			sum=sum+1;
			System.out.println(sum.hashCode());
//			System.out.println(sum1.hashCode());
		}
		//codes

	}

//	public static void addSum()
//	{
//		//codes
//		lock.lock();
//		sum++;
//		lock.unlock();
//		//codes
//	}

//public static void addSum()
//{
//	try {
//		sema.acquire();
//		sum++;
//	} catch (InterruptedException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	finally
//  {
//  	sema.release();
//  }
//}
}
