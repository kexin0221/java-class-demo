package Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Generic19368 {

    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
//		ArrayList<E> newList=(ArrayList<E>)list.clone();
//		newList.clear();
        ArrayList<E> newList=new ArrayList<>();
//		E newList1=new E();

//		for(E temp:list)
//		{
//			if(!newList.contains(temp))newList.add(temp);
//		}

        for(Iterator<E> it=list.iterator();it.hasNext(); ) {
            E temp=it.next();
            if(!newList.contains(temp)) {
                newList.add(temp);
            }
        }
        return newList;

    }

    //	public static <E extends Comparable<? super E>> E max(E[][] list)
    public static <E extends Comparable<E>> E max(E[][] list) {
        E max=list[0][0];
        for(int i=0; i<list.length;i++) {
            for(int j=0;j<list[i].length;j++) {
                if(max.compareTo(list[i][j])<0) {
                    max=list[i][j];
                }
            }
        }
        return max;
    }

    public static <E> void shuffle(ArrayList<E> list) {
        Random random=new Random();
        for(int i=0;i<list.size();i++) {
            int index=random.nextInt(list.size());
            E temp=list.get(index);
            list.remove(index);
            list.add(temp);
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        //test removeDuplicates
        ArrayList<Integer> list=new ArrayList<Integer>();
        list.add(1);
        list.add(5);
        list.add(1);
        list.add(2);
        list.add(2);

        System.out.println(list);
        System.out.println(Generic19368.<Integer>removeDuplicates(list));
        System.out.println(removeDuplicates(list));

        //test max
        Double[][] matirx=new Double[6][7];
        for(int i=0; i<matirx.length;i++) {
            for(int j=0;j<matirx[i].length;j++) {
                matirx[i][j]=Math.random();
                System.out.print(matirx[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println(max(matirx));

//		test shuffle
        ArrayList<Integer> list1=new ArrayList<Integer>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);

        shuffle(list1);
        System.out.println(list1);
    }

}
