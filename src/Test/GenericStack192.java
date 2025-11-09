package Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class GenericStack192<E> extends ArrayList<E> {
	public int getSize() {
		return super.size();
	}

	public E peek() {
		return super.get(getSize() - 1);
	}

	public void push(E o) {
		super.add(o);
	}

	public E pop() {
		E o = super.get(getSize() - 1);
		super.remove(getSize() - 1);
		return o;
	}

	public boolean isEmpty() {
		return super.isEmpty();
	}

	@Override
	public String toString() {
		return "stack: " + super.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Please enter five strings");
		GenericStack192<String> stack=new GenericStack192<String>();
		Scanner scan=new Scanner(System.in);

		for(int i=0;i<5;i++)
		{
			stack.push(scan.nextLine());
		}
		System.out.println(stack);
		Collections.sort(stack);
		System.out.println(stack);
		Collections.reverse(stack);
		System.out.println(stack);
	}

}
