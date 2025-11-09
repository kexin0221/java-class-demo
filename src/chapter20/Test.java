package chapter20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		ArrayList<String> list1=new ArrayList<String>();
		ArrayList list1=new ArrayList();
		list1.add("red");
		list1.add("yellow");
		list1.add("green");

//		ArrayList<String> list2=new ArrayList<String>();
		ArrayList list2=new ArrayList();
		list2.add("red");
		list2.add("yellow");
		list2.add("blue");

//		list1.addAll(list2);
//		System.out.println("list1:"+list1);
//		System.out.println("list2:"+list2);

//		list1.add(list2);
//		System.out.println("list1:"+list1);
//		System.out.println("list2:"+list2);

//		list1.removeAll(list2);
//		System.out.println("list1:"+list1);
//		System.out.println("list2:"+list2);

//		list1.remove(list2);
//		System.out.println("list1:"+list1);
//		System.out.println("list2:"+list2);

//		list1.retainAll(list2);
//		System.out.println("list1:"+list1);
//		System.out.println("list2:"+list2);


//		Collections example
		List<Integer> arrayList = new ArrayList<Integer>();
    arrayList.add(1); // 1 is autoboxed to new Integer(1)
    arrayList.add(2);
    arrayList.add(3);
    arrayList.add(1);
    arrayList.add(4);
    arrayList.add(0, 10);
    arrayList.add(3, 30);

    System.out.println("A list of integers in the array list:");
    System.out.println(arrayList);
    Collections.sort(arrayList);
    System.out.println(arrayList);
//
//    System.out.println(Collections.binarySearch(arrayList, 10));
//
//    Collections.shuffle(arrayList);
//    System.out.println(arrayList);
//    List<Integer> list3 = new ArrayList<Integer>(arrayList);
//    List<Integer> list4 = new ArrayList<Integer>(arrayList);
//    Collections.shuffle(list3,new Random(20));
//    Collections.shuffle(list4,new Random(20));
//    System.out.println(list3);
//    System.out.println(list4);

//		copy
//		List<String> list5=Arrays.asList("y","r","g","b");
//		List<String> list6=Arrays.asList("w","black");
////	des.size()>src.size()
//		Collections.copy(list5,list6);
//		System.out.println(list5);
////  des.size()<src.size()
//		Collections.copy(list6,list5);
//		System.out.println(list6);

//		ncopies
//		List<String> list7=Collections.nCopies(5,"a");
//		System.out.println(list7);
//		System.out.println(list7.getClass());
//		list7.remove(0);
//		System.out.println(list7);

	}

}
