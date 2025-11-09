package chapter19;

import java.util.ArrayList;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		ArrayList<String> list1 =new ArrayList<>();
		ArrayList<String> list =new ArrayList<String>();
		list.add("Red");
		String s=list.get(0);
		
		ArrayList[] ll=new ArrayList[10];
		ArrayList<String>[] lll =new ArrayList<String>[10];
		
//		ArrayList<String>[] list1 =new ArrayList<String>[10];
//		ArrayList<int> intList =new ArrayList<int>();
		
		GenericStack<String> stack=new GenericStack<String>(); 
		stack.push("London");
		stack.push("paris");
//		stack.push(8);
		
		GenericStack<Integer> stack1=new GenericStack<Integer>();
		stack1.push(8);
//		stack1.push("beijing");
		
		
		Max.max("welcome", 23);
//		MaxUsingGenericType.max("welcome", 23);
		
		GenericStack s3=new GenericStack<String>();
		s3.push("hello");
		s3.push(3);
		
//		E[] e=new E();
//		E[] e=new E[10];
//		E[] e= (E[])new object[10]; 
	}

}
