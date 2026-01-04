package Test;

import java.util.Arrays;

public class GenericStack191<E> {

    private E[] list=(E[])new Object[100];
    private int size=0;

    public int getSize() {
        return size;
    }

    public int getArrayLength(){
        return list.length;
    }

    public E peek() {
        if(size == 0) {
            System.out.println("The stack is empty");
            return null;
        }
        return list[size-1];
    }

    public void push(E o) {
        if(size>=list.length) {
            E[] newList = (E[]) new Object[2*list.length];
            System.arraycopy(list, 0, newList, 0, list.length);
            newList[size]=o;
            list=newList;
        } else {
            list[size]=o;
        }
        size=size+1;
    }

    public E pop() {
        E o=list[size-1];
        size=size-1;
        return o;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public String toString() {
        return"stack: " + Arrays.toString(list);
    }

    public void print() {
        for(int i=0;i<size;i++) {
            System.out.println(list[i]);
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        GenericStack191<Integer> list1= new GenericStack191<>();

        for(int i=0;i<100;i++) {
            list1.push(i);
        }
        System.out.println(list1.getSize());
        System.out.println(list1.getArrayLength());
		list1.print();
		list1.pop();
        list1.push(100);
        System.out.println(list1.getSize());
        System.out.println(list1.getArrayLength());
		list1.print();
    }
}
