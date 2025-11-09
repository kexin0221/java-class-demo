package Test;

import java.util.Iterator;
import java.util.LinkedList;

public class Test206 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<Integer> list=new LinkedList<Integer>();
		int sum=0;
		for(int i=0;i<50000;i++)
			list.add(5);

		long begin=System.currentTimeMillis();
		for(Integer temp:list)
			sum=sum+temp;
		System.out.println(System.currentTimeMillis()-begin);

		begin=System.currentTimeMillis();
		for(Iterator<Integer>it=list.iterator();it.hasNext();)
			sum=sum+it.next();
		System.out.println(System.currentTimeMillis()-begin);

		begin=System.currentTimeMillis();
		for(int i=0;i<list.size();i++)
			sum=sum+list.get(i);
		System.out.println(System.currentTimeMillis()-begin);

	}


}
