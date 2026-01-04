package Test;

import java.util.Iterator;
import java.util.LinkedList;

public class Test206 {

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();
		int sum = 0;
		for(int i = 0; i < 50000; i++)
			list.add(5);

		long begin = System.currentTimeMillis();
		for(Integer temp:list)
			sum = sum + temp; // 2
		System.out.println(System.currentTimeMillis() - begin);

		begin = System.currentTimeMillis();
		for(Iterator<Integer> it = list.iterator(); it.hasNext();)
			sum = sum + it.next(); // 1
		System.out.println(System.currentTimeMillis() - begin);

		begin = System.currentTimeMillis();
		for(int i = 0; i < list.size(); i++)
			sum = sum + list.get(i); // 805
		System.out.println(System.currentTimeMillis() - begin);
	}
}
