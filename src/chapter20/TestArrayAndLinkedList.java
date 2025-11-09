package chapter20;

import java.util.*;

public class TestArrayAndLinkedList {
  public static void main(String[] args) {
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

    LinkedList<Object> linkedList = new LinkedList<Object>(arrayList);
    linkedList.add(1, "red");
    linkedList.removeLast();
    linkedList.addFirst("green");

    System.out.println("Display the linked list forward:");
    ListIterator<Object> listIterator=linkedList.listIterator();
    while(listIterator.hasNext())
    {
    	System.out.print(listIterator.next()+" ");
    }
    System.out.println();

    System.out.println("Display the linked list backward:");
    listIterator=linkedList.listIterator(linkedList.size());
    while(listIterator.hasPrevious())
    {
    	System.out.print(listIterator.previous()+" ");
    }

    System.out.println();
    long begin1=System.currentTimeMillis();
    for(int i=0;i<100000;i++)
    {
    	linkedList.add(0,5);
    }
    System.out.println("linkedList random add: "+(System.currentTimeMillis()-begin1));
    System.out.println(linkedList.size());

    long begin=System.currentTimeMillis();
    listIterator=linkedList.listIterator(linkedList.size());
    System.out.println("Display the linked list backward:");
    while(listIterator.hasPrevious())
    {
    	listIterator.previous();
//    	System.out.print(listIterator.previous()+" ");
    }
    System.out.println();
    System.out.println(System.currentTimeMillis()-begin);

    begin=System.currentTimeMillis();
    System.out.println("Display the linked list backward:");
    for (int i = linkedList.size() - 1; i >= 0; i--) {
    	linkedList.get(i);
//      System.out.print(linkedList.get(i) + " ");
    }
    System.out.println();
    System.out.println("LinkedList random accesss: "+(System.currentTimeMillis()-begin));

    ArrayList<Object> list3=new ArrayList<>(linkedList);
    System.out.println(list3.size());
    begin=System.currentTimeMillis();
    System.out.println("Display the ArrayList backward:");
    for (int i = list3.size() - 1; i >= 0; i--) {
    	list3.get(i);
//      System.out.print(linkedList.get(i) + " ");
    }
    System.out.println();
    System.out.println("ArrayList random accesss: "+(System.currentTimeMillis()-begin));

   begin1=System.currentTimeMillis();
    for(int i=0;i<100000;i++)
    {
    	list3.add(0,5);
    }
    System.out.println("arrayList random add: "+(System.currentTimeMillis()-begin1));
    System.out.println(list3.size());
  }
}
