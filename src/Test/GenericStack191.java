package Test;

public class GenericStack191<E> {

	private E[] list=(E[])new Object[100];
	private int size=0;

	public int getSize()
	{
		return size;
	}

	public int getArrayLength()
	{
		return list.length;
	}

	public E peek()
	{
		if(size==0)
		{
			System.out.println("The stack is empty");
			return null;
		}
		return list[size-1];
	}

	public void push(E o)
	{

		if(size>=list.length)
		{
			E[] newList=(E[])new Object[2*list.length];
			for(int i=0;i<list.length;i++)
			{
				newList[i]=list[i];
			}
			newList[size]=o;
			list=newList;
		}
		else
		{
			list[size]=o;
		}
		size=size+1;
	}

	public E pop()
	{
		E o=list[size-1];
		size=size-1;
		return o;
	}

	public boolean isEmpty()
	{
		if(size==0)return true;
		return false;
	}
	public String toString() {

		return"stack: " + list.toString();
	  }

	public void print()
	{
		for(int i=0;i<size;i++)
		{
			System.out.println(list[i]);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenericStack191<Integer> list1=new GenericStack191<Integer>();

		for(int i=0;i<100;i++)
		{
			list1.push(i);
		}
		System.out.println(list1.getSize());
		System.out.println(list1.getArrayLength());
//		list1.print();
//		list1.pop();
		list1.push(100);
		System.out.println(list1.getSize());
		System.out.println(list1.getArrayLength());
//		list1.print();
	}


}
